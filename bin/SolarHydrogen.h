#pragma once
/**
* @file SolarHydrogen.h
* @brief Solar hydrogen class information.
* @author Nathan Johnson, Briana Lucero
* @date 2015-09-04
* @version 0.0.1 - initial release
*/

#include <iostream>
#include <fstream>

#ifndef SOLARHYDROGEN_H
#define	SOLARHYDROGEN_H

struct SolarHydrogenInput {
	/**
	* @struct SolarHydrogenInput [SolarHydrogen.h]
	* @brief Solar hydrogen input data. Allows loading data from file using setters.
	* @author Nathan Johnson, Briana Lucero
	* @date 2015-09-04
	* @version 0.0.1 - initial release
	*/
public:
	/**
	* Default constructor
	*/
	SolarHydrogenInput() {
		// set by user (includes setters and getters)
		m_solarDNI = 0;
		m_transmissivity = 0;
		m_reductionTemp = 0;
		m_oxidationTemp = 0;
		m_emissivity = 0;
		m_reflectivity1 = 0;
		m_reflectivity2 = 0;
		m_effSolarElec = 0;
		m_effHeatElec = 0;
		m_latentHeat = 0;
		m_concentrationFactor = 0;

		// hard coded -- shown to user (includes getters)
		m_dirtFactor = 0.95;
		m_windowTransmission = 0.95;
		m_intercept = 0.95;
		m_molarMassFuel = 172.005;
		m_fuelPowerDensity = 1500.0;
		m_specHeatFuel = 80.0;
		m_specHeatO2 = 29.4;
		m_specHeatH2 = 28.8;

		// hard coded -- not showed to user (does not include setters or getters)
		m_gravity = 9.81;
		m_H2Concentration = 0.05051;
		m_molarMassWater = 18.015;
		m_pressureFP = 101000.0;
		m_stefanBoltzmann = 0.0000000567804;
		m_idealGasConstant = 8.314472;
		m_pressureAtm = 101325.0;
		m_tempAtmK = 298.15;
		m_tempAtmC = 25.0;
		m_numWindows = 1.0;
		m_areaHelio = 1.0;
		m_evapHeatH2O = 40650.0;
		m_H2LHV = 241807.0;
		m_H2HHV = 285830.0;
		m_steamEff1001 = 0.5;
		m_steamEff1000 = 0.95;
		m_pressureRecup = 202650.0;
		m_elevatorHeight = 15.0;
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
	}
	/**
	* Gets copy of input data.
	* @return copy of input data.
	*/
	inline SolarHydrogenInput GetSolarHydrogenInput() {
		SolarHydrogenInput myCopy;
		myCopy.m_solarDNI = m_solarDNI;
		myCopy.m_transmissivity = m_transmissivity;
		myCopy.m_reductionTemp = m_reductionTemp;
		myCopy.m_oxidationTemp = m_oxidationTemp;
		myCopy.m_emissivity = m_emissivity;
		myCopy.m_reflectivity1 = m_reflectivity1;
		myCopy.m_reflectivity2 = m_reflectivity2;
		myCopy.m_effSolarElec = m_effSolarElec;
		myCopy.m_effHeatElec = m_effHeatElec;
		myCopy.m_latentHeat = m_latentHeat;
		myCopy.m_concentrationFactor = m_concentrationFactor;
		myCopy.m_dirtFactor = m_dirtFactor;
		myCopy.m_windowTransmission = m_windowTransmission;
		myCopy.m_intercept = m_intercept;
		myCopy.m_molarMassFuel = m_molarMassFuel;
		myCopy.m_fuelPowerDensity = m_fuelPowerDensity;
		myCopy.m_specHeatFuel = m_specHeatFuel;
		myCopy.m_specHeatO2 = m_specHeatO2;
		myCopy.m_specHeatH2 = m_specHeatH2;
		myCopy.m_gravity = m_gravity;
		myCopy.m_H2Concentration = m_H2Concentration;		
		myCopy.m_molarMassWater = m_molarMassWater;
		myCopy.m_pressureFP = m_pressureFP;
		myCopy.m_stefanBoltzmann = m_stefanBoltzmann;
		myCopy.m_idealGasConstant = m_idealGasConstant;
		myCopy.m_pressureAtm = m_pressureAtm;
		myCopy.m_tempAtmK = m_tempAtmK;
		myCopy.m_tempAtmC = m_tempAtmC;
		myCopy.m_numWindows = m_numWindows;
		myCopy.m_areaHelio = m_areaHelio;
		myCopy.m_evapHeatH2O = m_evapHeatH2O;
		myCopy.m_H2LHV = m_H2LHV;
		myCopy.m_H2HHV = m_H2HHV;
		myCopy.m_steamEff1001 = m_steamEff1001;
		myCopy.m_steamEff1000 = m_steamEff1000;
		myCopy.m_pressureRecup = m_pressureRecup;
		myCopy.m_elevatorHeight = m_elevatorHeight;
		myCopy.m_specHeatFuel = m_specHeatFuel;
		myCopy.m_elevatorEff = m_elevatorEff;
		myCopy.m_workPumpIsen = m_workPumpIsen;
		myCopy.m_curveFitA0 = m_curveFitA0;
		myCopy.m_curveFitA1 = m_curveFitA1;
		myCopy.m_curveFitA2 = m_curveFitA2;
		myCopy.m_curveFitA3 = m_curveFitA3;
		myCopy.m_curveFitA4 = m_curveFitA4;
		myCopy.m_curveFitA5 = m_curveFitA5;
		myCopy.m_curveFitA6 = m_curveFitA6;
		myCopy.m_curveFitA7 = m_curveFitA7;
		myCopy.m_curveFitA8 = m_curveFitA8;
		myCopy.m_curveFitC0 = m_curveFitC0;
		myCopy.m_curveFitC1 = m_curveFitC1;
		myCopy.m_curveFitC2 = m_curveFitC2;
		myCopy.m_curveFitC3 = m_curveFitC3;
		myCopy.m_curveFitC4 = m_curveFitC4;
		myCopy.m_curveFitC5 = m_curveFitC5;
		myCopy.m_curveFitC6 = m_curveFitC6;
		myCopy.m_curveFitC7 = m_curveFitC7;
		myCopy.m_curveFitC8 = m_curveFitC8;
		myCopy.m_deltaHx0 = m_deltaHx0;
		myCopy.m_deltaHx1 = m_deltaHx1;
		myCopy.m_deltaHx2 = m_deltaHx2;
		myCopy.m_td2H2Op0 = m_td2H2Op0;
		myCopy.m_td2H2Op1 = m_td2H2Op1;
		myCopy.m_td2H2Op2 = m_td2H2Op2;
		myCopy.m_td2H2Op3 = m_td2H2Op3;
		myCopy.m_td2H2Op4 = m_td2H2Op4;
		myCopy.m_td2H2Op5 = m_td2H2Op5;
		myCopy.m_td2H2Op6 = m_td2H2Op6;
		myCopy.m_td2H2Op7 = m_td2H2Op7;
		myCopy.m_td2H2Op8 = m_td2H2Op8;
		myCopy.m_td2H2OK0 = m_td2H2OK0;
		myCopy.m_td2H2OK1 = m_td2H2OK1;
		myCopy.m_td2H2OK2 = m_td2H2OK2;
		myCopy.m_td2H2OK3 = m_td2H2OK3;
		myCopy.m_td2H2OK4 = m_td2H2OK4;
		myCopy.m_td2H2OK5 = m_td2H2OK5;
		myCopy.m_td2H2OK6 = m_td2H2OK6;
		myCopy.m_td2H2OK7 = m_td2H2OK7;
		myCopy.m_td2H2OK8 = m_td2H2OK8;
		return(myCopy);
	}
	/**
	* Sets input data.
	*/
	inline void SetSolarHydrogenInput(SolarHydrogenInput &data) {
		m_solarDNI = data.m_solarDNI;
		m_transmissivity = data.m_transmissivity;
		m_reductionTemp = data.m_reductionTemp;
		m_oxidationTemp = data.m_oxidationTemp;
		m_emissivity = data.m_emissivity;
		m_reflectivity1 = data.m_reflectivity1;
		m_reflectivity2 = data.m_reflectivity2;
		m_effSolarElec = data.m_effSolarElec;
		m_effHeatElec = data.m_effHeatElec;
		m_latentHeat = data.m_latentHeat;
		m_concentrationFactor = data.m_concentrationFactor;
		m_dirtFactor = data.m_dirtFactor;
		m_windowTransmission = data.m_windowTransmission;
		m_intercept = data.m_intercept;
		m_molarMassFuel = data.m_molarMassFuel;
		m_fuelPowerDensity = data.m_fuelPowerDensity;
		m_specHeatFuel = data.m_specHeatFuel;
		m_specHeatO2 = data.m_specHeatO2;
		m_specHeatH2 = data.m_specHeatH2;
		m_gravity = data.m_gravity;
		m_H2Concentration = data.m_H2Concentration;
		m_molarMassWater = data.m_molarMassWater;
		m_pressureFP = data.m_pressureFP;
		m_stefanBoltzmann = data.m_stefanBoltzmann;
		m_idealGasConstant = data.m_idealGasConstant;
		m_pressureAtm = data.m_pressureAtm;
		m_tempAtmK = data.m_tempAtmK;
		m_tempAtmC = data.m_tempAtmC;
		m_numWindows = data.m_numWindows;
		m_areaHelio = data.m_areaHelio;
		m_evapHeatH2O = data.m_evapHeatH2O;
		m_H2LHV = data.m_H2LHV;
		m_H2HHV = data.m_H2HHV;
		m_steamEff1001 = data.m_steamEff1001;
		m_steamEff1000 = data.m_steamEff1000;
		m_pressureRecup = data.m_pressureRecup;
		m_elevatorHeight = data.m_elevatorHeight;
		m_elevatorEff = data.m_elevatorEff;
		m_workPumpIsen = data.m_workPumpIsen;
		m_curveFitA0 = data.m_curveFitA0;
		m_curveFitA1 = data.m_curveFitA1;
		m_curveFitA2 = data.m_curveFitA2;
		m_curveFitA3 = data.m_curveFitA3;
		m_curveFitA4 = data.m_curveFitA4;
		m_curveFitA5 = data.m_curveFitA5;
		m_curveFitA6 = data.m_curveFitA6;
		m_curveFitA7 = data.m_curveFitA7;
		m_curveFitA8 = data.m_curveFitA8;
		m_curveFitC0 = data.m_curveFitC0;
		m_curveFitC1 = data.m_curveFitC1;
		m_curveFitC2 = data.m_curveFitC2;
		m_curveFitC3 = data.m_curveFitC3;
		m_curveFitC4 = data.m_curveFitC4;
		m_curveFitC5 = data.m_curveFitC5;
		m_curveFitC6 = data.m_curveFitC6;
		m_curveFitC7 = data.m_curveFitC7;
		m_curveFitC8 = data.m_curveFitC8;
		m_deltaHx0 = data.m_deltaHx0;
		m_deltaHx1 = data.m_deltaHx1;
		m_td2H2Op0 = data.m_td2H2Op0;
		m_td2H2Op1 = data.m_td2H2Op1;
		m_td2H2Op2 = data.m_td2H2Op2;
		m_td2H2Op3 = data.m_td2H2Op3;
		m_td2H2Op4 = data.m_td2H2Op4;
		m_td2H2Op5 = data.m_td2H2Op5;
		m_td2H2Op6 = data.m_td2H2Op6;
		m_td2H2Op7 = data.m_td2H2Op7;
		m_td2H2Op8 = data.m_td2H2Op8;
		m_td2H2OK0 = data.m_td2H2OK0;
		m_td2H2OK1 = data.m_td2H2OK1;
		m_td2H2OK2 = data.m_td2H2OK2;
		m_td2H2OK3 = data.m_td2H2OK3;
		m_td2H2OK4 = data.m_td2H2OK4;
		m_td2H2OK5 = data.m_td2H2OK5;
		m_td2H2OK6 = data.m_td2H2OK6;
		m_td2H2OK7 = data.m_td2H2OK7;
		m_td2H2OK8 = data.m_td2H2OK8;
}

	/** Setters and getters */
	inline bool SetSolarDNI(double solarDNI) {
		if (solarDNI < 0.0 || solarDNI > 1500.0) {
			std::cout << "DNI data is outside allowable bounds: 0 < DNI < 1500.\n";
			return(false);
		}
		else {
			m_solarDNI = solarDNI;
			return(true);
		}
	}
	inline double GetSolarDNI() {
		return(m_solarDNI);
	}
	inline bool SetTransmissivity(double transmissivity) {
		if (transmissivity < 0.0 || transmissivity > 1.0) {
			std::cout << "Transmissivity data is outside allowable bounds: 0 < transmissivity < 1.\n";
			return(false);
		}
		else {
			m_transmissivity = transmissivity;
			return(true);
		}
	}
	inline double GetTransmissivity() {
		return(m_transmissivity);
	}
	inline bool SetReductionTemp(double reductionTemp) {
		if (reductionTemp < 1673.0 || reductionTemp > 1873.0) {
			std::cout << "Reduction Temperature value is outside allowable bounds: 1673 < reductionTemp < 1873.\n";
			return(false);
		}
		else {
			m_reductionTemp = reductionTemp;
			return(true);
		}
	}
	inline double GetReductionTemp() {
		return(m_reductionTemp);
	}
	inline bool SetOxidationTemp(double oxidationTemp) {
		if (oxidationTemp < 873.0 || oxidationTemp > 1673.0) {
			std::cout << "Oxidation Temperature value is outside allowable bounds: 873 < OxidationTemp < 1673.\n";
			return(false);
		}
		else {
			m_oxidationTemp = oxidationTemp;
			return(true);
		}
	}
	inline double GetOxidationTemp() {
		return(m_oxidationTemp);
	}
	inline bool SetEmissivity(double emissivity) {
		if (emissivity < 0.0 || emissivity > 1.0) {
			std::cout << "Emissivity is outside allowable bounds: 0 < emissivity < 1.\n";
			return(false);
		}
		else {
			m_emissivity = emissivity;
			return(true);
		}
	}
	inline double GetEmissivity() {
		return(m_emissivity);
	}
	inline bool SetReflectivity1(double reflectivity1) {
		if (reflectivity1 < 0.0 || reflectivity1 > 1.0) {
			std::cout << "Reflectivity1 is outside allowable bounds: 0 < reflectivity1 < 1.\n";
			return(false);
		}
		else {
			m_reflectivity1 = reflectivity1;
			return(true);
		}
	}
	inline double GetReflectivity1() {
		return(m_reflectivity1);
	}
	inline bool SetReflectivity2(double reflectivity2) {
		if (reflectivity2 < 0.0 || reflectivity2 > 1.0) {
			std::cout << "Reflectivity2 is outside allowable bounds: 0 < reflectivity2 < 1.\n";
			return(false);
		}
		else {
			m_reflectivity2 = reflectivity2;
			return(true);
		}
	}
	inline double GetReflectivity2() {
		return(m_reflectivity2);
	}
	inline bool SetEffSolarElec(double effSolarElec) {
		if (effSolarElec < 0.0 || effSolarElec > 1.0) {
			std::cout << "Solar to Electrical efficiency is outside allowable bounds: 0 < effSolarElec < 1.\n";
			return(false);
		}
		else {
			m_effSolarElec = effSolarElec;
			return(true);
		}
	}
	inline double GetEffSolarElec() {
		return(m_effSolarElec);
	}
	inline bool SetEffHeatElec(double effHeatElec) {
		if (effHeatElec < 0.0 || effHeatElec > 1.0) {
			std::cout << "Heat to Electrical efficiency is outside allowable bounds: 0 < effHeatElec < 1.\n";
			return(false);
		}
		else {
			m_effHeatElec = effHeatElec;
			return(true);
		}
	}
	inline double GetEffHeatElec() {
		return(m_effHeatElec);
	}
	inline bool SetLatentHeat(int latentHeat) {
		if (latentHeat == 0.0 || latentHeat == 1.0) {
			std::cout << "Latent heat inclusion is outside allowable bounds: 0 == latentHeat || latentHeat == 1.\n";
			return(false);
		}
		else {
			m_latentHeat = latentHeat;
			return(true);
		}
	}
	inline double GetLatentHeat() {
		return(m_latentHeat);
	}
	inline bool SetConcentrationFactor(double concentrationFactor) {
		if (concentrationFactor > 1800.0 || concentrationFactor < 3000.0) {
			std::cout << "Concentration factor is outside allowable bounds: 1800 < concentrationFactor < 3000.\n";
			return(false);
		}
		else {
			m_concentrationFactor = concentrationFactor;
			return(true);
		}
	}
	inline double GetConcentrationFactor() {
		return(m_concentrationFactor);
	}
	inline double GetDirtFactor() {
		return(m_dirtFactor);
	}
	inline double GetWindowTransmission() {
		return(m_windowTransmission);
	}
	inline double GetIntercept() {
		return(m_intercept);
	}
	inline double GetMolarMassFuel() {
		return(m_molarMassFuel);
	}
	inline double GetFuelPowerDensity() {
		return(m_fuelPowerDensity);
	}
	inline double GetSpecHeatFuel() {
		return(m_specHeatFuel);
	}
	inline double GetSpecHeatO2() {
		return(m_specHeatO2);
	}
	inline double GetSpecHeatH2() {
		return(m_specHeatH2);
	}


private:
	double m_solarDNI; /**< Solar DNI (Direct Normal Irradiance) [W/m2]. */
	double m_transmissivity; /**< Transmissivity of dirt on the receiver window [-]. */
	double m_reductionTemp; /**< Reduction temperature [K]. */
	double m_oxidationTemp; /**< Oxidation temperature [K]. */
	double m_emissivity; /**< Reflector re-radiation emissivity [-]. */
	double m_reflectivity1; /**< Primary mirror reflectivity [-]. */
	double m_reflectivity2; /**< Secondary mirror reflectivity [-]. */
	double m_effSolarElec; /**< Solar flux to electricity efficiency [%]. */
	double m_effHeatElec; /**< Heat energy to electricity efficiency [%]. */
	int m_latentHeat; /**< Latent heat inclusion in code (binary value, 1=yes, 0=no)[-]. */
	double m_concentrationFactor; /**< Solar concentration factor [-]. */
	double m_dirtFactor; /**< Dirt factor [-]. */
	double m_windowTransmission; /**< Window transmission [-]. */
	double m_intercept; /**< Receiver intercept [-]. */
	double m_molarMassFuel; /**< Molar mass of metal-oxide [g mol-1]. */
	double m_fuelPowerDensity; /**< CeO2 power density [kg m-3]. */
	double m_specHeatFuel; /**< Specific heat of metal-oxide, approximated as 15 R for ABO3 [J mol-1 K-1]. */
	double m_specHeatO2; /** < Specific heat of O2 [J mol-1 K-1]. */
	double m_specHeatH2; /** < Specific heat of H2 [J mol-1 K-1]. */
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
};

struct SolarHydrogenOutput {
	/**
	* @struct SolarHydrogenOutput [SolarHydrogen.h]
	* @brief Solar hydrogen output data. Allows loading data from file using setters.
	* @author Nathan Johnson
	* @date 2015-09-04
	* @version 0.0.1 - initial release
	*/
public:
	/**
	* Default constructor
	*/
	SolarHydrogenOutput() {
		m_solarToFuelEfficiency = 0;
	}

	/**
	* Gets copy of output data.
	* @return copy of output data.
	*/
	inline SolarHydrogenOutput GetSolarHydrogenOutput() {
		SolarHydrogenOutput myCopy;
		myCopy.m_solarToFuelEfficiency = m_solarToFuelEfficiency;
		return(myCopy);
	}
	/**
	* Sets output data.
	*/
	inline void SetSolarHydrogenOutput(SolarHydrogenOutput &data) {
		m_solarToFuelEfficiency = data.m_solarToFuelEfficiency;
	}

	/** Setters and getters */
	inline void SetSolarToFuelEfficiency(double solarToFuelEfficiency) {
		m_solarToFuelEfficiency = solarToFuelEfficiency;
	}
	inline double GetSolarToFuelEfficiency() {
		return(m_solarToFuelEfficiency);
	}

private:
	double m_solarToFuelEfficiency; /**< Solar to fuel efficiency [%]. */
};

struct SolarHydrogenIntermediate {
	/**
	* @struct SolarHydrogenIntermediate [SolarHydrogen.h]
	* @brief Solar hydrogen intermediate data. This data is not stored upon save or load.
	* @author Nathan Johnson
	* @date 2015-09-04
	* @version 0.0.1 - initial release
	*/
public:
	/**
	* Default constructor
	*/
	SolarHydrogenIntermediate() {
		m_enthalpyReduction = 0;
		m_areaAper = 0;
		m_solarFieldEff = 0;
		m_reflectivity = 0;
		m_incidentPowerPrimary = 0;
		m_incidentPowerRef1 = 0;
		m_incidentPowerRef2 = 0;
		m_heatMirrorSecondary = 0;
		m_incidentPowerTrans = 0;
		m_incidentPowerAper = 0;
		m_heatSpillAper = 0;
		m_incidentPowerTotal = 0;
		m_tempStep = 0;
		m_tempFuelProd = 0;
		m_polyFit1 = 0;
		m_polyFit2 = 0;
		m_polyFit3 = 0;
		m_enthalpyRedO2 = 0;
		m_enthalpyRedDelta = 0;
		m_enthalpyRedAvg = 0;
		m_ratioOxToH2 = 0;
		m_polyFitFP1 = 0;
		m_polyFitFP2 = 0;
		m_polyFitFP3 = 0;
		m_pressureOxide = 0;
		m_dissocConst = 0;
		m_ratioH2OToH2 = 0;
		m_qLift = 0;
		m_qOxHt = 0;
		m_qRt = 0;
		m_qPex = 0;
		m_qHeat1000 = 0;
		m_qHeat1001 = 0;
		m_qH2Ophase = 0;
		m_qPmp = 0;
		m_qPmpTotal = 0;
		m_qReox = 0;
		m_qAuxNt = 0;
		m_qNeed = 0;
		m_molH2Output = 0;
		m_wattH2Output = 0;
		m_reactorEffOut = 0;
		m_solarEffOut = 0;
		m_thermalEffOut = 0;
	}

private:
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
	double m_polyFit1; /**< Polynomial fit to Log[pO2/p0] and temperature [-]. */
	double m_polyFit2; /**< Polynomial fit to Log[pO2/p0] and temperature [-]. */
	double m_polyFit3; /**< Polynomial fit to Log[pO2/p0] and temperature [-]. */
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
	double m_solarEffOut; /**< Solar efficiency=H2 output/primary solar power [%]. */
	double m_thermalEffOut; /**< Thermal efficieny: all the heat in the reactor, how much gets converted to H2 [%]. */
};

class SolarHydrogen : public SolarHydrogenInput, public SolarHydrogenOutput, public SolarHydrogenIntermediate {
	/**
	* @struct SolarHydrogen [SolarHydrogen.h]
	* @brief Data objects and functions for solar-to-hydrogen conversion.
	* @author Nathan Johnson, Briana Lucero
	* @date 2015-09-04
	* @version 0.0.1 - initial release
	*/

public:
	SolarHydrogen();
	bool RunComputation();

private:
	bool VerifyData();
	// TODO -- function calls to any sub-computations

};


#endif	/* SOLARHYDROGEN_H */

