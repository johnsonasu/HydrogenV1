/**
* @file main.cpp
* @brief Main class for the solar-to-hydrogen conversion.
* @author Nathan Johnson, Briana Lucero
* @date 2015-09-04
* @version 0.0.1 - initial release
*/


#include <cstdlib>
#include <iostream>
#include <fstream>

#include "SolarHydrogen.h"

using namespace std;

/*
*
*/
int main(int argc, char** argv) {

	SolarHydrogen m_solarHydrogen;

	/* for testing purposes */
	bool runTest = true;
	if (runTest) {
	m_solarHydrogen.SetSolarDNI(900.0);
	m_solarHydrogen.SetEffLifting( 0.4 );
	m_solarHydrogen.RunComputation();
		
	}

	return 0;
}

