LOCAL_PATH :=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES :=HelloJNI.cpp
LOCAL_MODULE :=hellojni
include $(BUILD_SHARED_LIBRARY)

#LOCAL_PATH :=$(call my-dir)
#include $(CLEAR_VARS)
#LOCAL_SRC_FILES :=MyTest.c
#LOCAL_MODULE :=mytest
#include $(BUILD_SHARED_LIBRARY)
#
#LOCAL_PATH :=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES :=ControlSwitch.c
LOCAL_MODULE :=switch
include $(BUILD_SHARED_LIBRARY)