package com.badlogic.gdx.physics.box2d;

public class Rope {
	protected long addr;
	
	///
	private native void jniStep(long addr,float timeStep, int iterations);
	
	void step(float timeStep,int iteractions){
		jniStep(addr,timeStep,iteractions);
	}

	///
	private native int jniGetVertexCount(long addr);

	///
//	private native void jniGetVertices(long addr);

	///
	private native void jniSetAngle(long addr,float angle);



}
