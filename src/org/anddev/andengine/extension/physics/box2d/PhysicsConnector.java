package org.anddev.andengine.extension.physics.box2d;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.shape.IShape;
import org.anddev.andengine.extension.physics.box2d.util.constants.PhysicsConstants;
import org.anddev.andengine.util.MathUtils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * @author Nicolas Gramlich
 * @since 18:51:22 - 05.07.2010
 */
public class PhysicsConnector implements IUpdateHandler, PhysicsConstants {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected final IShape mShape;
	protected final Body mBody;

	protected final float mShapeHalfBaseWidth;
	protected final float mShapeHalfBaseHeight;

	protected boolean mUpdatePosition;
	protected boolean mUpdateRotation;
	protected final float mPixelToMeterRatio;

	// ===========================================================
	// Constructors
	// ===========================================================

	public PhysicsConnector(final IShape pShape, final Body pBody) {
		this(pShape, pBody, true, true);
	}

	public PhysicsConnector(final IShape pShape, final Body pBody, final float pPixelToMeterRatio) {
		this(pShape, pBody, true, true, pPixelToMeterRatio);
	}

	public PhysicsConnector(final IShape pShape, final Body pBody, final boolean pUdatePosition, final boolean pUpdateRotation) {
		this(pShape, pBody, pUdatePosition, pUpdateRotation, PIXEL_TO_METER_RATIO_DEFAULT);
	}

	public PhysicsConnector(final IShape pShape, final Body pBody, final boolean pUdatePosition, final boolean pUpdateRotation, final float pPixelToMeterRatio) {
		this.mShape = pShape;
		this.mBody = pBody;

		this.mUpdatePosition = pUdatePosition;
		this.mUpdateRotation = pUpdateRotation;
		this.mPixelToMeterRatio = pPixelToMeterRatio;

		this.mShapeHalfBaseWidth = pShape.getBaseWidth() * 0.5f;
		this.mShapeHalfBaseHeight = pShape.getBaseHeight() * 0.5f;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public IShape getShape() {
		return this.mShape;
	}

	public Body getBody() {
		return this.mBody;
	}

	public boolean isUpdatePosition() {
		return this.mUpdatePosition;
	}

	public boolean isUpdateRotation() {
		return this.mUpdateRotation;
	}

	public void setUpdatePosition(final boolean pUpdatePosition) {
		this.mUpdatePosition = pUpdatePosition;
	}

	public void setUpdateRotation(final boolean pUpdateRotation) {
		this.mUpdateRotation = pUpdateRotation;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public void onUpdate(final float pSecondsElapsed) {
		final IShape shape = this.mShape;
		final Body body = this.mBody;

		if(this.mUpdatePosition) {
			final Vector2 position = body.getPosition();
			final float pixelToMeterRatio = this.mPixelToMeterRatio;
			shape.setPosition(position.x * pixelToMeterRatio - this.mShapeHalfBaseWidth, position.y * pixelToMeterRatio - this.mShapeHalfBaseHeight);
		}

		if(this.mUpdateRotation) {
			final float angle = body.getAngle();
			shape.setRotation(MathUtils.radToDeg(angle));
		}
	}

	@Override
	public void reset() {

	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
