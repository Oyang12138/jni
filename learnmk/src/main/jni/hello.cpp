/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_example_jnipackage_hello */

#ifndef _Included_com_example_jnipackage_hello
#define _Included_com_example_jnipackage_hello
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_example_jnipackage_hello
 * Method:    getString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_example_jnipackage_hello_getString
        (JNIEnv *env, jobject instance){
    return (env)->NewStringUTF("I am from c");
}


#ifdef __cplusplus
}
#endif
#endif
