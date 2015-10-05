#include <jni.h>
#include <stdio.h>
#include <string>
#include <iostream>
#include <sstream>
#include "application_HydrogenProxy.h"

using namespace std;

JNIEXPORT jstring JNICALL Java_application_HydrogenProxy_initInterface
		(JNIEnv *env, jobject obj, jobjectArray jvalues){
	
	int stringCount = env->GetArrayLength(jvalues);
	std::string values[stringCount];

	for (int x = 0; x < stringCount; x++){
		jstring string = (jstring)env->GetObjectArrayElement(jvalues, x);
		const char *raw = env->GetStringUTFChars(string,0);
		std::string str(raw);
		values[x] = str;

		cout << raw << endl;
	}
}