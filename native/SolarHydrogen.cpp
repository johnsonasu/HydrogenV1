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
	;
}

/**
* Runs computation.
* @return true if success
*/
bool SolarHydrogen::RunComputation() {
	VerifyData();

	// TODO -- add computations

	// 
	double testVal = -10;

	if (testVal < 0) {
		std::cout << "Error in computation. testVal " << testVal << " is outside of allowable boundaries testVal > code 100.\n";
		return(false);
	}
}

/**
* Verify that data is all set and within bounds
* @return true if success
*/
bool SolarHydrogen::VerifyData() {
	// TODO
	double testVal = 10;

	if (testVal < 0) {
		std::cout << "Error in computation. testVal " << testVal << " is outside of allowable boundaries testVal > code 200.\n";
		return(false);
	}
}

