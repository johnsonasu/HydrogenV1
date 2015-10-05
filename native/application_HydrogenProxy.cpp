#include <jni.h>
#include <stdio.h>
#include <string>
#include <iostream>
#include <sstream>
#include <fstream>
#include <ctime>
#include "application_HydrogenProxy.h"
#include "SolarHydrogen.h"

using namespace std;

JNIEXPORT jstring JNICALL Java_application_HydrogenProxy_initInterface
(JNIEnv *env, jobject obj, jobjectArray jvalues){

	int stringCount = env->GetArrayLength(jvalues);

	SolarHydrogen *hydro = new SolarHydrogen();
	double values[stringCount];

	for (int x = 0; x < stringCount; x++){
		jstring string = (jstring)env->GetObjectArrayElement(jvalues, x);
		const char *raw = env->GetStringUTFChars(string, 0);
		std::string str(raw);

		values[x] = std::stod(str);

	}

	bool pass = false;
	pass = hydro->SetSolarDNI(values[0]);
	pass = hydro->SetConcentrationFactor(values[1]);
	pass = hydro->SetEmissivity(values[2]);
	pass = hydro->SetReflectivity1(values[3]);
	pass = hydro->SetEffSolarElec(values[4]);
	pass = hydro->SetEffHeatElec(values[5]);
	pass = hydro->SetEffLifting(values[6]);
	pass = hydro->SetEffElecPump(values[7]);
	pass = hydro->SetsolidRecup(values[8]);
	pass = hydro->SetsteamEff1000(values[9]);
	pass = hydro->SetsteamEff1001(values[10]);
	pass = hydro->SetReductionTemp(values[11]);
	pass = hydro->Setthemredpressure(values[12]);
	pass = hydro->SetOxidationTemp(values[13]);
	pass = hydro->SetoxidationTemp2(values[14]);
	pass = hydro->SetspecHeatFuel(values[15]);
	pass = hydro->Setheatingvalue(values[16]);

	if (pass){
		
		const char* filename = hydro->RunComputation();		
		jstring js = env->NewStringUTF(filename);
		return js;
		

	}
	else{
		jstring js = env->NewStringUTF("failed");
		return js;
	}
}