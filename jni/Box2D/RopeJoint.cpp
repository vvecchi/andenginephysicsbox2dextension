

#include "RopeJoint.h"
#include "Box2d.h"


/*
 * Class:     com_badlogic_gdx_physics_box2d_joints_RopeJoint
 * Method:    jniGetMaxLength
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_badlogic_gdx_physics_box2d_joints_RopeJoint_jniGetMaxLength
  (JNIEnv *, jobject, jlong addr){
	b2RopeJoint* joint = (b2RopeJoint*)addr;
	return joint->GetMaxLength();
}

