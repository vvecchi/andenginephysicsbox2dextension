#!/bin/bash

wget -r -k --tries 10 --reject=html -np -P jni/Box2D http://libgdx.googlecode.com/svn/trunk/gdx/jni/Box2D/
cp -r jni/Box2D/libgdx.googlecode.com/svn/trunk/gdx/jni/Box2D/. jni/Box2D
rm -rf jni/Box2D/libgdx.googlecode.com/

wget -r -k --tries 10 --reject=html -np -P src http://libgdx.googlecode.com/svn/trunk/gdx/src/com/badlogic/gdx/physics/box2d/
cp -r src/libgdx.googlecode.com/svn/trunk/gdx/src/com/badlogic/gdx/physics/. src/com/badlogic/gdx/physics
rm -rf src/libgdx.googlecode.com/
