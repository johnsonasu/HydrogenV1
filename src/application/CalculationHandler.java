package application;

public class CalculationHandler {
	double m_solarDNI; /**< Solar DNI (Direct Normal Irradiance) [W/m2]. */
	double m_transmissivity; /**< Transmissivity of dirt on the receiver window [-]. */
	double m_reductionTemp; /**< Reduction temperature [K]. */
	double m_oxidationTemp; /**< Oxidation temperature [K]. */
	double m_emissivity; /**< Reflector re-radiation emissivity [-]. */
	double m_reflectivity1; /**< Primary mirror reflectivity [-]. */
	double m_reflectivity2; /**< Secondary mirror reflectivity [-]. */
	double m_effSolarElec; /**< Solar flux to electricity efficiency [%]. */
	double m_effHeatElec; /**< Heat energy to electricity efficiency [%]. */
	double m_effElecPump; /**< Electricity to pumping efficiency [%]. */
	double m_effLifting; /**< Particle lifiting efficiency [%]. */
	int m_latentHeat; /**< Latent heat inclusion in code (binary value, 1=yes, 0=no)[-]. */
	double m_apertureArea; /**< Aperture area [m2]. */
	double m_dirtFactor; /**< Dirt factor [-]. */
	double m_windowTransmission; /**< Window transmission [-]. */
	double m_intercept; /**< Receiver intercept [-]. */
	double m_molarMassFuel; /**< Molar mass of metal-oxide [g mol-1]. */
	double m_fuelPowerDensity; /**< CeO2 power density [kg m-3]. */
	double m_specHeatFuel; /**< Specific heat of metal-oxide, approximated as 15 R for ABO3 [J mol-1 K-1]. */
	double m_specHeatO2; /** < Specific heat of O2 [J mol-1 K-1]. */
	double m_specHeatH2; /** < Specific heat of H2 [J mol-1 K-1]. */
	double m_specHeatSteam;  /**< Specific heat of steam [J mol-1 K-1]. */
	double m_gravity; /**< Gravity [m/s2]. */
	double m_H2Concentration; /**< Hydrogen concentration exiting the FP reactor [-]. */
	double m_molarMassWater; /**< Molar mass of water [g mol-1]. */
	double m_pressureFP ; /**< Pressure in fuel production chamber [Pa]. */
	double m_stefanBoltzmann; /**< Stefan-Boltzmann constant [ W m-2 K-4]. */
	double m_idealGasConstant; /**< Ideal gas constant [ J mol-1 K-1]. */
	double m_pressureAtm; /**< Atmospheric pressure [Pa]. */
	double m_tempAtmK; /**< Atmospheric temperature in Kelvin[K]. */
	double m_tempAtmC; /**< Atmospheric temperature in Celsius [C]. */
	double m_numWindows; /**< Number of windows in receiver [-]. */
	double m_areaHelio; /**< Dish/heliostate area [m2]. */
	double m_evapHeatH2O; /**< Evaporation heat of H2O[J mol-1]. */
	double m_H2LHV; /**< H2 Lower Heating Value [J mol-1]. */
	double m_H2HHV; /**< H2 Higher Heating Value [J mol-1]. */
	double m_deltaTR; /**< Extent of reduction [-]. */
	double m_solidRecup; /** < Effectivenes of solid-solid recuperator [-]. */
	double m_steamEff1001; /**< Steam Hrxn > 1000 C efficiency [%]. */
	double m_steamEff1000; /**< Steam Hrxn < 1000 C efficiency [%]. */
	double m_pressureRecup; /**< Pressure of recuperator [Pa]. */
	double m_elevatorHeight; /**< Total elevator height [m]. */
	double m_elevatorEff; /**< Elevator efficiency [%]. */
	double m_workPumpIsen; /**< Isentropic pump work [ J]. */
	double m_curveFitA0; /** < Fit for Fit coefficient (Parameters O2) [-]. */
	double m_curveFitA1; /** < Fit for Fit coefficient (Parameters O3) [-]. */
	double m_curveFitA2; /** < Fit for Fit coefficient (Parameters O4) [-]. */
	double m_curveFitA3; /** < Fit for Fit coefficient (Parameters P2) [-]. */
	double m_curveFitA4; /** < Fit for Fit coefficient (Parameters P3) [-]. */
	double m_curveFitA5; /** < Fit for Fit coefficient (Parameters P4) [-]. */
	double m_curveFitA6; /** < Fit for Fit coefficient (Parameters Q2) [-]. */
	double m_curveFitA7; /** < Fit for Fit coefficient (Parameters Q3) [-]. */
	double m_curveFitA8; /** < Fit for Fit coefficient (Parameters Q4) [-]. */
	double m_curveFitC0; /** < Fit for Fit coefficient (Parameters O7) [-]. */
	double m_curveFitC1; /** < Fit for Fit coefficient (Parameters O8) [-]. */
	double m_curveFitC2; /** < Fit for Fit coefficient (Parameters O9) [-]. */
	double m_curveFitC3; /** < Fit for Fit coefficient (Parameters N7) [-]. */
	double m_curveFitC4; /** < Fit for Fit coefficient (Parameters N8) [-]. */
	double m_curveFitC5; /** < Fit for Fit coefficient (Parameters N9) [-]. */
	double m_curveFitC6; /** < Fit for Fit coefficient (Parameters P7) [-]. */
	double m_curveFitC7; /** < Fit for Fit coefficient (Parameters P8) [-]. */
	double m_curveFitC8; /** < Fit for Fit coefficient (Parameters P9) [-]. */
	double m_deltaHx0; /** < delta_H(x)_ZN_MA coefficient (Parameters F34) [-]. */
	double m_deltaHx1; /** < delta_H(x)_ZN_MA coefficient (Parameters F35) [-]. */
	double m_deltaHx2; /** < delta_H(x)_ZN_MA coefficient (Parameters F36) [-]. */
	double m_td2H2Op0; /** < Water dissassociation coefficient pO2 (TD2_H2O B2) [-]. */
	double m_td2H2Op1; /** < Water dissassociation coefficient pO2 (TD2_H2O B3) [-]. */
	double m_td2H2Op2; /** < Water dissassociation coefficient pO2 (TD2_H2O B4) [-]. */
	double m_td2H2Op3; /** < Water dissassociation coefficient pO2 (TD2_H2O B5) [-]. */
	double m_td2H2Op4; /** < Water dissassociation coefficient pO2 (TD2_H2O B6) [-]. */
	double m_td2H2Op5; /** < Water dissassociation coefficient pO2 (TD2_H2O B7) [-]. */
	double m_td2H2Op6; /** < Water dissassociation coefficient pO2 (TD2_H2O B8) [-]. */
	double m_td2H2Op7; /** < Water dissassociation coefficient pO2 (TD2_H2O B9) [-]. */
	double m_td2H2Op8; /** < Water dissassociation coefficient pO2 (TD2_H2O B10) [-]. */
	double m_td2H2OK0; /** < Water dissassociation coefficient pO2 (TD2_H2O B13) [-]. */
	double m_td2H2OK1; /** < Water dissassociation coefficient pO2 (TD2_H2O B14) [-]. */
	double m_td2H2OK2; /** < Water dissassociation coefficient pO2 (TD2_H2O B15) [-]. */
	double m_td2H2OK3; /** < Water dissassociation coefficient pO2 (TD2_H2O B16) [-]. */
	double m_td2H2OK4; /** < Water dissassociation coefficient pO2 (TD2_H2O B17) [-]. */
	double m_td2H2OK5; /** < Water dissassociation coefficient pO2 (TD2_H2O B18) [-]. */
	double m_td2H2OK6; /** < Water dissassociation coefficient pO2 (TD2_H2O B19) [-]. */
	double m_td2H2OK7; /** < Water dissassociation coefficient pO2 (TD2_H2O B20) [-]. */
	double m_td2H2OK8; /** < Water dissassociation coefficient pO2 (TD2_H2O B21) [-]. */
	double m_enthalpyReduction; /**< Reduction enthalpy per mol O2 [g mol-1]. */
	double m_areaAper; /**< Receiver aperture area [m2]. */
	double m_solarFieldEff; /**< Solar field efficiency [%]. */
	double m_reflectivity; /**< Total reflectivity [-]. */
	double m_incidentPowerPrimary; /**< Incident power on primary concentrator [W]. */
	double m_incidentPowerRef1; /**< Incident power after first reflection [W]. */
	double m_incidentPowerRef2; /**< Incident power after second reflection [W]. */
	double m_heatMirrorSecondary; /**< Heat on secondary mirror [W]. */
	double m_incidentPowerTrans; /**< Incident power through transmission window - into aperature [W]. */
	double m_incidentPowerAper; /**< Incident power into aperature window [W]. */
	double m_heatSpillAper; /**< Spill power around the aperature [W]. */
	double m_incidentPowerTotal; /**< Total net flux into the reactor [W]. */
	double m_tempStep; /**< Temperature steps [K]. */
	double m_tempFuelProd; /**< Fuel production temperature [K]. */
	double m_logPressureO2; /** < Log pressure of the fuel chamber with O2 [-]. */
	double m_partialPressureO2; /**< Partial pressure of O2 [-]. */
	double m_polyFit1; /**< Polynomial fit to Log[pO2/p0] and temperature [-]. */
	double m_polyFit2; /**< Polynomial fit to Log[pO2/p0] and temperature [-]. */
	double m_polyFit3; /**< Polynomial fit to Log[pO2/p0] and temperature [-]. */
	double m_deltaOx; /**< Extent of the oxidation reaction [-]. */
	double m_deltaDelta; /**< Extent of the redox reaction (inclusive of reduction + oxidation) [-]. */
	double m_enthalpyRedO2; /**< Reduction enthalpy TO given delta, per mol O2 [J mol-1]. */
	double m_enthalpyRedDelta; /**< Integrated reduction enthalpy TO given delta, per mol H2 (or mol O) [J mol-1]. */
	double m_enthalpyRedAvg; /**< Average reduction enthalpy [J mol-1]. */
	double m_ratioOxToH2; /**< Ratio of oxide to H2 [-]. */
	double m_polyFitFP1; /**< Polynomial fit for FP pressure [-]. */
	double m_polyFitFP2; /**< Polynomial fit for FP pressure [-]. */
	double m_polyFitFP3; /**< Polynomial fit for FP pressure [-]. */
	double m_pressureOxide; /**< Oxide pressure [Pa]. */
	double m_dissocConst; /**< Disassociation constant of water as calculated from the TD2_H20 tab [-]. */
	double m_ratioH2OToH2; /**< Ratio of H2O to H2 [-]. */
	double m_qLift; /**< Heat equivelent of oxide lifting work, per mol H2 [W]. */
	double m_qOxHt; /**< Q for oxide heating, per mol H2, at given recuperation effectiveness [W]. */
	double m_qRt; /**< Q for heating from room temperature to 100 C [W]. */
	double m_qPex; /**< Compression work + actual heat of not recovered from the recuperator [W]. */
	double m_qHeat1000; /**< Heat from 100 to 1000 C [W]. */
	double m_qHeat1001; /**< Heating steam from 1000 C to reoxidation temp [W]. */
	double m_qH2Ophase; /**< Total heat needed to change the water phases [W]. */
	double m_qPmp; /**< Heat equivalent of H2 pumping work, per mol H2 [W]. */
	double m_qPmpTotal; /**< Heat equivalent of total pumping work, per mol H2 [W]. */
	double m_qReox; /**< Heat released in reoxidation reaction, per mol H2 [W]. */
	double m_qAuxNt; /**< Net waste heat from hot oxide and reoxidation, after used for heat equivalents of all other reactor needs, per mol H2 [W]. */
	double m_qNeed; /**< Solar heat needed per mol H2. Sum of heat for oxide heating and thermal reduction (+ heat for mechanical components if not enough waste heat) [W]. */
	double m_molH2Output; /**< Thermochemical H2 output in mol/s [mol s-1]. */
	double m_wattH2Output; /**< Thermochemical H2 output in W [W]. */
	double m_reactorEffOut; /**< Thermal efficiency=H2 output/heat available after collection losses [%]. */
	double m_solartoFuelEff; /**< Solar efficiency=H2 output/primary solar power [%]. */
	double m_thermalEffOut; /**< Thermal efficieny: all the heat in the reactor, how much gets converted to H2 [%]. */
	double m_numberhelio;
	double m_specHeatH2O;
	double m_qPump;
	double m_qO2;
	double m_oxidationTempC;
	double m_LHRp;
	double m_pressureAtmatm;
	double m_tempVapor;
	int  m_heatingvalue;
	double m_H2HV=0;
	double m_concfactor;
	double m_themredpressure;
	double m_fitcoef1;
	double m_fitcoef2;
	double m_fitcoef3;
	double m_oxidationTemp2;
	double m_temp;
	String[] values;

	public CalculationHandler(String[] values){
		m_dirtFactor = 0.95;
		m_windowTransmission = 0.95;
		m_intercept = 0.95;
		m_molarMassFuel = 172.005;
		m_fuelPowerDensity = 1500.0;
		m_specHeatFuel = 0;
		m_specHeatO2 = 29.4;
		m_specHeatH2 = 28.8;
		m_specHeatSteam = 37.47;
		m_gravity = 9.81;
		m_H2Concentration = 0.05051;
		m_molarMassWater = 18.015;
		m_pressureFP = 101325.0;
		m_stefanBoltzmann = 0.0000000567804;
		m_idealGasConstant = 8.314472;
		m_pressureAtm = 101325.0;
		m_tempAtmK = 298.15;
		m_tempAtmC = 25.0;
		m_numWindows = 1.0;
		m_areaHelio = 1;
		m_evapHeatH2O = 40650.0;
		m_H2LHV = 241807.0;
		m_H2HHV = 285830.0;
		m_deltaTR = 0;
		m_solidRecup = 0;
		m_steamEff1001 = 0;
		m_steamEff1000 = 0;
		m_pressureRecup = 202650.0;
		m_elevatorHeight = 75.0;
		m_elevatorEff = 0.25;
		m_workPumpIsen = 0.25;
		m_curveFitA0 = -12.00607246;
		m_curveFitA1 = 0.008977086;
		m_curveFitA2 = -1.65655e-06;
		m_curveFitA3 = -0.106062393;
		m_curveFitA4 = 2.1444e-06;
		m_curveFitA5 = -3.58732e-08;
		m_curveFitA6 = -0.017371085;
		m_curveFitA7 = 2.41114e-05;
		m_curveFitA8 = -6.5537e-09;
		m_curveFitC0 = -86.67975141;
		m_curveFitC1 = 0.082114514;
		m_curveFitC2 = -2.03403e-05;
		m_curveFitC3 = -19.62011997;
		m_curveFitC4 = 0.022140746;
		m_curveFitC5 = -7.22337e-06;
		m_curveFitC6 = -3.90018215;
		m_curveFitC7 = 0.005652854;
		m_curveFitC8 = -1.75398e-06;
		m_deltaHx0 = 942.311781;
		m_deltaHx1 = -1762.8391;
		m_deltaHx2 = 5321.82376;
		m_td2H2Op0 = -2.0853839459e+1;
		m_td2H2Op1 = 6.67565303e-2;
		m_td2H2Op2 = -1.1467065e-4;
		m_td2H2Op3 = 1.3651572275e-7;
		m_td2H2Op4 = -1.11055339465965e-10;
		m_td2H2Op5 = 6.03823570168911e-14;
		m_td2H2Op6 = -2.09426422250173e-17;
		m_td2H2Op7 = 4.18386227678604e-21;
		m_td2H2Op8 = -3.66022242100771e-25;
		m_td2H2OK0 = -3.8488310375e+01;
		m_td2H2OK1 = 1.0013547614e-01;
		m_td2H2OK2 = -1.7205001746e-04;
		m_td2H2OK3 = 2.0493588597e-07;
		m_td2H2OK4 = -1.6684456707e-10;
		m_td2H2OK5 = 9.0801529248e-14;
		m_td2H2OK6 = -3.1526311494e-17;
		m_td2H2OK7 = 6.3053883700e-21;
		m_td2H2OK8 = -5.5223956624e-25;
		m_specHeatH2O= 75.32;
		m_qO2= 21683;
		m_solartoFuelEff= 0;
		m_emissivity= 0;
		m_areaAper= 0.0002;
		m_effLifting=0;
		m_effElecPump=0;
		m_latentHeat=1;
		m_LHRp=0;
		m_pressureAtmatm=2;
		m_tempVapor=383;
		m_heatingvalue=0;
		m_numberhelio=0.63;
		m_H2HV=0;
		m_concfactor=0;
		m_reflectivity2=1;
		m_fitcoef1= -1.296631;
		m_fitcoef2= -0.215048;
		m_fitcoef3= 0.004777;
		try{
			m_solarDNI = Double.parseDouble(values[0]);
			m_concfactor = Double.parseDouble(values[1]);
			m_emissivity = Double.parseDouble(values[2]);
			m_reflectivity1 = Double.parseDouble(values[3]);
			m_effSolarElec = Double.parseDouble(values[4]);
			m_effHeatElec = Double.parseDouble(values[5]);
			m_effLifting = Double.parseDouble(values[6]);
			m_effElecPump = Double.parseDouble(values[7]);
			m_solidRecup = Double.parseDouble(values[8]);
			m_steamEff1000 = Double.parseDouble(values[9]);
			m_steamEff1001 = Double.parseDouble(values[10]);
			m_reductionTemp = Double.parseDouble(values[11]);
			m_themredpressure = Double.parseDouble(values[12]);
			m_oxidationTemp = Double.parseDouble(values[13]);
			m_oxidationTemp2 = Double.parseDouble(values[14]);
			m_specHeatFuel = Double.parseDouble(values[15]);
			m_heatingvalue = Integer.parseInt(values[16]);
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public double[] runCalculations(){

		if (m_heatingvalue==1)
		{
			m_H2HV=m_H2HHV;
		}
		else if (m_heatingvalue==0){
			m_H2HV=m_H2LHV;
		}

		m_LHRp = m_steamEff1000;
		m_oxidationTempC = m_oxidationTemp;
		m_oxidationTemp = m_oxidationTemp + 273;
		m_oxidationTemp2 = m_oxidationTemp2 + 273;
		m_reductionTemp = m_reductionTemp + 273;

		int totalLoops = (int)(m_oxidationTemp2 - m_oxidationTemp)+1;
		double[] solarToFuelList = new double[totalLoops];
		int count = 0;

		while (m_oxidationTemp<=m_oxidationTemp2)
		{

			m_oxidationTempC=m_oxidationTemp-273;

			m_areaAper = (m_numberhelio*m_areaHelio)/(m_concfactor*m_intercept);
			// System.out.println("aperArea = " + m_areaAper);
			m_areaAper = Math.floor(m_areaAper*10000)/10000;
			m_incidentPowerPrimary = m_areaHelio*m_numberhelio*m_solarDNI;
			// // System.out.println("incidentP = " + m_incidentPowerPrimary);
			m_incidentPowerRef1 = m_incidentPowerPrimary*m_reflectivity1*m_dirtFactor;
			// // System.out.println("inciPowRef1 = " + m_incidentPowerRef1);
			m_incidentPowerRef2=m_incidentPowerRef1*m_reflectivity2;
			// // System.out.println("inciPowRef2 = " + m_incidentPowerRef2);
			m_heatMirrorSecondary=m_incidentPowerRef1-m_incidentPowerRef2;
			// System.out.println("heatMirrorSecondary = " + m_heatMirrorSecondary);
			m_incidentPowerTrans=m_incidentPowerRef2*m_windowTransmission;
			// System.out.println("m_incidentPowerTrans = " + m_incidentPowerTrans);
			m_incidentPowerAper=m_incidentPowerTrans*m_intercept;
			// System.out.println("m_incidentPowerAper = " + m_incidentPowerAper);
			m_heatSpillAper=m_incidentPowerTrans-m_incidentPowerAper;
			// System.out.println("m_heatSpillAper = " + m_heatSpillAper);
			// System.out.println("m_reductionTemp = " + m_reductionTemp);
			// System.out.println("(Math.pow(m_reductionTemp,4) = " + Math.pow(m_reductionTemp,4));
			m_incidentPowerTotal=(m_incidentPowerAper)-(m_areaAper*m_emissivity*m_stefanBoltzmann*(Math.pow(m_reductionTemp,4)-Math.pow(m_tempAtmK,4)));
			// System.out.println("m_incidentPowerTotal = " + m_incidentPowerTotal);
			m_tempStep=m_reductionTemp-m_oxidationTemp;
			// System.out.println("m_tempStep = " + m_tempStep);
			m_logPressureO2=(m_td2H2Op0*Math.pow(m_oxidationTempC,0))+(m_td2H2Op1*Math.pow(m_oxidationTempC,1))+(m_td2H2Op2*Math.pow(m_oxidationTempC,2))+(m_td2H2Op3*
					Math.pow(m_oxidationTempC,3))+(m_td2H2Op4*Math.pow(m_oxidationTempC,4))+(m_td2H2Op5*Math.pow(m_oxidationTempC,5))+(m_td2H2Op6*Math.pow(m_oxidationTempC,6))+
					(m_td2H2Op7*Math.pow(m_oxidationTempC,7))+(m_td2H2Op8*Math.pow(m_oxidationTempC,8));
			// System.out.println("m_logPressureO2 = " + m_logPressureO2);
			m_partialPressureO2=Math.pow(10,m_logPressureO2);
			// System.out.println("m_partialPressureO2 = " + m_partialPressureO2);
			m_polyFit1=m_curveFitA0+(m_curveFitA1*m_oxidationTemp)+(m_curveFitA2*Math.pow(m_oxidationTemp,2));
			// System.out.println("m_polyFit1 = " + m_polyFit1);
			m_polyFit2=m_curveFitA3+(m_curveFitA4*m_oxidationTemp)+(m_curveFitA5*Math.pow(m_oxidationTemp,2));
			// System.out.println("m_polyFit2 = " + m_polyFit2);
			m_polyFit3=m_curveFitA6+(m_curveFitA7*m_oxidationTemp)+(m_curveFitA8*Math.pow(m_oxidationTemp,2));
			// System.out.println("m_polyFit3 = " + m_polyFit3);
			m_deltaOx= Math.pow(10,(m_polyFit1+(m_polyFit2*m_logPressureO2)+(m_polyFit3*Math.pow(m_logPressureO2,2))));
			// System.out.println("m_deltaOx = " + m_deltaOx);
			m_enthalpyRedO2=(m_deltaHx0+(m_deltaHx1*m_deltaOx)+(m_deltaHx2*Math.pow(m_deltaOx,2)))*1000;
			// System.out.println("m_enthalpyRedO2 = " + m_enthalpyRedO2);
			m_enthalpyRedDelta=0.5*m_enthalpyRedO2;
			// System.out.println("m_enthalpyRedDelta = " + m_enthalpyRedDelta);
			m_deltaTR= Math.pow(10,(m_fitcoef1+m_fitcoef2*Math.log10(m_themredpressure)+m_fitcoef3*Math.log10(Math.pow(m_themredpressure,2))));
			// System.out.println("m_deltaTR = " + m_deltaTR);
			m_enthalpyReduction= (m_deltaHx0+(m_deltaHx1*m_deltaTR)+(m_deltaHx2*Math.pow(m_deltaTR,2)))*1000;
			// System.out.println("m_enthalpyReduction = " + m_enthalpyReduction);

			if (m_deltaTR-m_deltaOx>0)
			{
				m_deltaDelta=m_deltaTR-m_deltaOx;
			}
			else if (m_deltaTR-m_deltaOx>0)
			{
				m_deltaDelta= 0.00001;
			}	
			// System.out.println("m_deltaDelta = " + m_deltaDelta);
			m_enthalpyRedAvg=((m_enthalpyReduction)*0.5+m_enthalpyRedDelta)*0.5;
			// System.out.println("m_enthalpyRedAvg = " + m_enthalpyRedAvg);
			m_ratioOxToH2=1/m_deltaDelta;
			// System.out.println("m_ratioOxToH2 = " + m_ratioOxToH2);
			m_polyFitFP1=m_curveFitC0+(m_curveFitC1*m_oxidationTemp)+(m_curveFitC2*Math.pow(m_oxidationTemp,2));
			// System.out.println("m_polyFitFP1 = " + m_polyFitFP1);
			m_polyFitFP2=m_curveFitC3+(m_curveFitC4*m_oxidationTemp)+(m_curveFitC5*Math.pow(m_oxidationTemp,2));
			// System.out.println("m_polyFitFP2 = " + m_polyFitFP2);
			m_polyFitFP3=m_curveFitC6+(m_curveFitC7*m_oxidationTemp)+(m_curveFitC8*Math.pow(m_oxidationTemp,2));
			// System.out.println("m_polyFitFP3 = " + m_polyFitFP3);
			m_pressureOxide=Math.pow(10,(m_polyFitFP1+(m_polyFitFP2*Math.log10(m_deltaTR))+(m_polyFitFP3*(Math.pow(Math.log10(m_deltaTR),2)))))/m_pressureAtm;
			// System.out.println("m_pressureOxide = " + m_pressureOxide);
			m_dissocConst=Math.pow(10,((m_td2H2OK0*Math.pow(m_oxidationTempC,0))+(m_td2H2OK1*Math.pow(m_oxidationTempC,1))+(m_td2H2OK2*Math.pow(m_oxidationTempC,2))+
					(m_td2H2OK3*Math.pow(m_oxidationTempC,3))+(m_td2H2OK4*Math.pow(m_oxidationTempC,4))+(m_td2H2OK5*Math.pow(m_oxidationTempC,5))+
					(m_td2H2OK6*Math.pow(m_oxidationTempC,6))+(m_td2H2OK7*Math.pow(m_oxidationTempC,7))+(m_td2H2OK8*Math.pow(m_oxidationTempC,8))));
			// System.out.println("m_dissocConst = " + m_dissocConst);
			m_ratioH2OToH2=(Math.sqrt(m_pressureOxide))/m_dissocConst;

			if (m_ratioH2OToH2>1)
			{
				m_ratioH2OToH2=m_ratioH2OToH2;
			}
			else m_ratioH2OToH2=1;
			// System.out.println("m_ratioH2OToH2 = " + m_ratioH2OToH2);
			m_qLift=(m_ratioOxToH2*0.172*9.81*m_elevatorHeight)/(m_effLifting*m_effHeatElec); 
			// System.out.println("m_qLift = " + m_qLift);
			m_qOxHt=(m_tempStep)*(m_specHeatFuel)*(m_ratioOxToH2)*(1-m_solidRecup);
			// System.out.println("m_qOxHt = " + m_qOxHt);

			m_qRt=(m_ratioH2OToH2)*((100-m_tempAtmC)*m_specHeatH2O)*(1-m_steamEff1000);  
			// System.out.println("m_qRt = " + m_qRt);
			m_qPump=((m_ratioH2OToH2)*(m_idealGasConstant)*(m_tempVapor)*Math.log(m_pressureAtmatm)*(1)*(m_latentHeat))/(m_effElecPump*m_effHeatElec);
			// System.out.println("m_qPump = " + m_qPump);
			m_qPex=(m_ratioH2OToH2)*(m_evapHeatH2O)*((1-m_steamEff1000))*(1)*(m_latentHeat);    
			// System.out.println("m_qPex = " + m_qPex);
			m_qHeat1000=(m_ratioH2OToH2)*(900*m_specHeatSteam)*(1-m_steamEff1000);
			// System.out.println("m_qHeat1000 = " + m_qHeat1000);
			if (m_oxidationTemp>1000)
			{
				m_qHeat1001=(m_ratioH2OToH2)*(m_specHeatSteam)*(m_oxidationTempC-1000)*(1-m_steamEff1001);
			}
			else  m_qHeat1001=0;
			// System.out.println("m_qHeat1001 = " + m_qHeat1001);
			m_qH2Ophase=900+m_qRt+m_qPump+m_qPex+m_qHeat1000+m_qHeat1001;
			// System.out.println("m_qH2Ophase = " + m_qH2Ophase);
			m_qPmp=0.018*m_ratioH2OToH2*9.81*((m_pressureFP/m_pressureAtm)+1)*10/(m_effLifting*m_effHeatElec);    
			// System.out.println("m_qPmp = " + m_qPmp);
			m_qPmpTotal=142787+m_qPmp;
			// System.out.println("m_qPmpTotal = " + m_qPmpTotal);
			m_qReox=m_enthalpyRedAvg-m_H2HV;
			// System.out.println("m_qReox = " + m_qReox);
			m_qAuxNt=(m_qOxHt*1)+m_qReox+m_qO2-m_qH2Ophase-m_qPmpTotal-m_qLift-5978.081;
			// System.out.println("m_qAuxNt = " + m_qAuxNt);
			if (m_qAuxNt<0)
			{
				m_qNeed=m_enthalpyRedAvg+m_qOxHt-m_qAuxNt;
			}
			if (m_qAuxNt>0)
			{
				m_qNeed=m_enthalpyRedAvg+m_qOxHt;		
			}
			// System.out.println("m_qNeed = " + m_qNeed);
			if (m_deltaDelta!= 0.001)
			{
				m_molH2Output= (m_incidentPowerTotal/m_qNeed);
			}
			else m_molH2Output= 0.0000000001;
			// System.out.println("m_molH2Output = " + m_molH2Output);
			m_wattH2Output=m_molH2Output*m_H2HV;
			// System.out.println("m_wattH2Output = " + m_wattH2Output);
			m_reactorEffOut=(m_wattH2Output/m_incidentPowerAper)*100;
			m_reactorEffOut= Math.ceil(m_reactorEffOut*10)/10;
			// System.out.println("m_reactorEffOut = " + m_reactorEffOut);
			m_solartoFuelEff=(m_wattH2Output/m_incidentPowerPrimary)*100;
			m_solartoFuelEff= Math.ceil(m_solartoFuelEff*10)/10;
			m_thermalEffOut=(m_wattH2Output/m_incidentPowerTotal)*100;
			m_thermalEffOut= Math.ceil(m_thermalEffOut*10)/10;
			// System.out.println("m_thermalEffOut = " + m_thermalEffOut);

			if(count > 0){
				if(m_solartoFuelEff > solarToFuelList[count-1]){
					if (m_solartoFuelEff>m_temp)
					{
						m_solartoFuelEff=m_solartoFuelEff;	
					}
					else m_solartoFuelEff=m_temp;
					m_temp=m_solartoFuelEff;
				}
			}

			m_oxidationTemp+=1;

			solarToFuelList[count] = m_solartoFuelEff;

			count++;
		}
		return solarToFuelList;
	}
}
