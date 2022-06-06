#include <jni.h>
#include <iostream>
#include "com_example_learnjni_Car.h"

JNIEXPORT jstring

JNICALL Java_com_example_learnjni_Car_init
        (JNIEnv *env, jobject, jstring name, jint leg) {
    return (env)->NewStringUTF("tom");
}


JNIEXPORT jint JNICALL Java_com_example_learnjni_Car_getAdd
        (JNIEnv *, jobject, jint a, jint b){
    return a+b;
}