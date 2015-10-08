/**
* @file SolarHydrogen.cpp
* @brief Solar hydrogen class information.
* @author Nathan Johnson
* @date 2015-09-04
* @version 0.0.1 - initial release
*/

#include <iostream>
#include <fstream>

#include "SolarHydrogen.h"

/**
* Default constructor.
*/
SolarHydrogen::SolarHydrogen() {
}

/**
* Runs computation.
* @return true if success
*/
const char* SolarHydrogen::RunComputation() {
	VerifyOutputData();

	if (m_heatingvalue == 1)
	{
		m_H2HV = m_H2HHV;
	}
	else if (m_heatingvalue == 0)
		m_H2HV = m_H2LHV;



	m_LHRp = m_steamEff1000;
	m_oxidationTempC = m_oxidationTemp;
	m_oxidationTemp = m_oxidationTemp + 273;
	m_oxidationTemp2 = m_oxidationTemp2 + 273;
	m_reductionTemp = m_reductionTemp + 273;

	int totalLoops = m_oxidationTemp2 - m_oxidationTemp;
	double solarToFuelList[totalLoops];
	int count = 0;

	while (m_oxidationTemp < m_oxidationTemp2){

		m_oxidationTempC = m_oxidationTemp - 273;

		m_areaAper = (m_numberhelio*m_areaHelio) / (m_concfactor*m_intercept);

		m_areaAper = floorf(m_areaAper * 10000) / 10000;

		m_incidentPowerPrimary = m_areaHelio*m_numberhelio*m_solarDNI;

		m_incidentPowerRef1 = m_incidentPowerPrimary*m_reflectivity1*m_dirtFactor;

		m_incidentPowerRef2 = m_incidentPowerRef1*m_reflectivity2;

		m_heatMirrorSecondary = m_incidentPowerRef1 - m_incidentPowerRef2;

		m_incidentPowerTrans = m_incidentPowerRef2*m_windowTransmission;

		m_incidentPowerAper = m_incidentPowerTrans*m_intercept;

		m_heatSpillAper = m_incidentPowerTrans - m_incidentPowerAper;

		m_incidentPowerTotal = (m_incidentPowerAper)-(m_areaAper*m_emissivity*m_stefanBoltzmann*(pow(m_reductionTemp, 4) - pow(m_tempAtmK, 4)));

		m_tempStep = m_reductionTemp - m_oxidationTemp;

		m_logPressureO2 = (m_td2H2Op0*pow(m_oxidationTempC, 0)) + (m_td2H2Op1*pow(m_oxidationTempC, 1)) + (m_td2H2Op2*pow(m_oxidationTempC, 2)) + (m_td2H2Op3*pow(m_oxidationTempC, 3)) + (m_td2H2Op4*pow(m_oxidationTempC, 4)) + (m_td2H2Op5*pow(m_oxidationTempC, 5)) + (m_td2H2Op6*pow(m_oxidationTempC, 6)) + (m_td2H2Op7*pow(m_oxidationTempC, 7)) + (m_td2H2Op8*pow(m_oxidationTempC, 8));

		m_partialPressureO2 = pow(10, m_logPressureO2);

		m_polyFit1 = m_curveFitA0 + (m_curveFitA1*m_oxidationTemp) + (m_curveFitA2*pow(m_oxidationTemp, 2));

		m_polyFit2 = m_curveFitA3 + (m_curveFitA4*m_oxidationTemp) + (m_curveFitA5*pow(m_oxidationTemp, 2));

		m_polyFit3 = m_curveFitA6 + (m_curveFitA7*m_oxidationTemp) + (m_curveFitA8*pow(m_oxidationTemp, 2));

		m_deltaOx = pow(10, (m_polyFit1 + (m_polyFit2*m_logPressureO2) + (m_polyFit3*pow(m_logPressureO2, 2))));

		m_enthalpyRedO2 = (m_deltaHx0 + (m_deltaHx1*m_deltaOx) + (m_deltaHx2*pow(m_deltaOx, 2))) * 1000;

		m_enthalpyRedDelta = 0.5*m_enthalpyRedO2;

		m_deltaTR = pow(10, (m_fitcoef1 + m_fitcoef2*log10(m_themredpressure) + m_fitcoef3*log10(pow(m_themredpressure, 2))));

		m_enthalpyReduction = (m_deltaHx0 + (m_deltaHx1*m_deltaTR) + (m_deltaHx2*pow(m_deltaTR, 2))) * 1000;


		if (m_deltaTR - m_deltaOx > 0)
		{
			m_deltaDelta = m_deltaTR - m_deltaOx;
		}
		else if (m_deltaTR - m_deltaOx > 0)
		{
			m_deltaDelta = 0.00001;
		}

		m_enthalpyRedAvg = ((m_enthalpyReduction)*0.5 + m_enthalpyRedDelta)*0.5;

		m_ratioOxToH2 = 1 / m_deltaDelta;

		m_polyFitFP1 = m_curveFitC0 + (m_curveFitC1*m_oxidationTemp) + (m_curveFitC2*pow(m_oxidationTemp, 2));

		m_polyFitFP2 = m_curveFitC3 + (m_curveFitC4*m_oxidationTemp) + (m_curveFitC5*pow(m_oxidationTemp, 2));

		m_polyFitFP3 = m_curveFitC6 + (m_curveFitC7*m_oxidationTemp) + (m_curveFitC8*pow(m_oxidationTemp, 2));

		m_pressureOxide = pow(10, (m_polyFitFP1 + (m_polyFitFP2*log10(m_deltaTR)) + (m_polyFitFP3*(pow(log10(m_deltaTR), 2))))) / m_pressureAtm;

		m_dissocConst = pow(10, ((m_td2H2OK0*pow(m_oxidationTempC, 0)) + (m_td2H2OK1*pow(m_oxidationTempC, 1)) + (m_td2H2OK2*pow(m_oxidationTempC, 2)) + (m_td2H2OK3*pow(m_oxidationTempC, 3)) + (m_td2H2OK4*pow(m_oxidationTempC, 4)) + (m_td2H2OK5*pow(m_oxidationTempC, 5)) + (m_td2H2OK6*pow(m_oxidationTempC, 6)) + (m_td2H2OK7*pow(m_oxidationTempC, 7)) + (m_td2H2OK8*pow(m_oxidationTempC, 8))));

		m_ratioH2OToH2 = (sqrt(m_pressureOxide)) / m_dissocConst;

		if (m_ratioH2OToH2 > 1)
		{
			m_ratioH2OToH2 = m_ratioH2OToH2;
		}
		else {
			m_ratioH2OToH2 = 1;
		}

		m_qLift = (m_ratioOxToH2*0.172*9.81*m_elevatorHeight) / (m_effLifting*m_effHeatElec);

		m_qOxHt = (m_tempStep)*(m_specHeatFuel)*(m_ratioOxToH2)*(1 - m_solidRecup);

		m_qRt = (m_ratioH2OToH2)*((100 - m_tempAtmC)*m_specHeatH2O)*(1 - m_steamEff1000);

		m_qPump = ((m_ratioH2OToH2)*(m_idealGasConstant)*(m_tempVapor)*log(m_pressureAtmatm)*(1)*(m_latentHeat)) / (m_effElecPump*m_effHeatElec);

		m_qPex = (m_ratioH2OToH2)*(m_evapHeatH2O)*((1 - m_steamEff1000))*(1)*(m_latentHeat);

		m_qHeat1000 = (m_ratioH2OToH2)*(900 * m_specHeatSteam)*(1 - m_steamEff1000);

		if (m_oxidationTemp > 1000)
		{
			m_qHeat1001 = (m_ratioH2OToH2)*(m_specHeatSteam)*(m_oxidationTempC - 1000)*(1 - m_steamEff1001);
		}
		else{
			m_qHeat1001 = 0;
		}

		m_qH2Ophase = 900 + m_qRt + m_qPump + m_qPex + m_qHeat1000 + m_qHeat1001;

		m_qPmp = 0.018*m_ratioH2OToH2*9.81*((m_pressureFP / m_pressureAtm) + 1) * 10 / (m_effLifting*m_effHeatElec);

		m_qPmpTotal = 142787 + m_qPmp;

		m_qReox = m_enthalpyRedAvg - m_H2HV;

		m_qAuxNt = (m_qOxHt * 1) + m_qReox + m_qO2 - m_qH2Ophase - m_qPmpTotal - m_qLift - 5978.081;

		if (m_qAuxNt < 0)
		{
			m_qNeed = m_enthalpyRedAvg + m_qOxHt - m_qAuxNt;
		}
		if (m_qAuxNt > 0)
		{
			m_qNeed = m_enthalpyRedAvg + m_qOxHt;
		}
		if (m_deltaDelta != 0.001)
		{
			m_molH2Output = (m_incidentPowerTotal / m_qNeed);
		}
		else {
			m_molH2Output = 0.0000000001;
		}

		m_wattH2Output = m_molH2Output*m_H2HV;

		m_reactorEffOut = (m_wattH2Output / m_incidentPowerAper) * 100;

		m_reactorEffOut = ceilf(m_reactorEffOut * 10) / 10;

		m_solartoFuelEff = (m_wattH2Output / m_incidentPowerPrimary) * 100;

		m_solartoFuelEff = ceilf(m_solartoFuelEff * 10) / 10;

		m_thermalEffOut = (m_wattH2Output / m_incidentPowerTotal) * 100;

		m_thermalEffOut = ceilf(m_thermalEffOut * 10) / 10;

		if (m_solartoFuelEff > m_temp)
		{
			m_solartoFuelEff = m_solartoFuelEff;
		}
		else {
			m_solartoFuelEff = m_temp;
		}
		
		m_temp = m_solartoFuelEff;
		
		m_oxidationTemp = m_oxidationTemp + 1;

		solarToFuelList[count] = m_solartoFuelEff;

		count++;

	}
	
	std::ofstream myfile;
	std::string filename = std::to_string(time(0));
	myfile.open(filename.c_str());

	double highValue = solarToFuelList[0];

	for (int x = 0; x < totalLoops; x++){
		if (solarToFuelList[x] > highValue){
			highValue = solarToFuelList[x];
		}
		myfile << solarToFuelList[x] << "\n";
	}
	myfile << highValue;
	myfile.close();

	return filename.c_str();


}

/**
* Verify that data is all set and within bounds
* @return true if success
*/
bool SolarHydrogen::VerifyOutputData() {
	// TODO
	double testVal = 10;
	/*
	if (testVal < 0) {
	std::cout << "Error in computation. testVal " << testVal << " is outside of allowable boundaries testVal > code 200.\n";
	return(false);
	}
	*/
}

