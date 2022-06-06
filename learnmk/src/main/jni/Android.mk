LOCAL_PATH :=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES :=hello.cpp
LOCAL_MODULE :=hello-jni
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_SRC_FILES :=Hello
LOCAL_MODULE :=Hello
include $(BUILD_STATIC_JAVA_LIBRARY)