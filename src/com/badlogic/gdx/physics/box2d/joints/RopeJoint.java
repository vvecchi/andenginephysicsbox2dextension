package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;

public class RopeJoint extends Joint {
/*

	b2LimitState GetLimitState() const;

*/
	public RopeJoint (World world, long addr) {
		super(world, addr);
	}
	
	/**Get the maximum length of the rope.**/
	public float getMaxLength () {
		return jniGetMaxLength(addr);
	}

	private native float jniGetMaxLength (long addr);

	/*
	// we don't use it so we don't port it!
	enum b2LimitState
	{
		e_inactiveLimit,
		e_atLowerLimit,
		e_atUpperLimit,
		e_equalLimits
	};
	
	public b2LimitState getLimitState(){
		return jniGetLimitState(addr);
	}

	private native b2LimitState jniGetLimitState(addr);
	*/
	
	
}
