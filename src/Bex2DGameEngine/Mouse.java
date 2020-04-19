package Bex2DGameEngine;

import java.awt.MouseInfo;
import java.awt.Point;

import Bex2DGameEngine.GameUtils.Vec2;

public class Mouse {
	
	private static boolean leftPressed = false;
	private static boolean rightPressed = false;
	
	private static boolean initialized = false;
	
	private static int x = 0;
	private static int y = 0;
	
	public Mouse() throws IllegalStateException{
		if(!initialized)
			initialized = true;
		else 
			throw new IllegalStateException("A mouse object was already created");
	}
	
	public void setX(int x) {
		Mouse.x = x;
	}
	
	public void setY(int y) {
		Mouse.y = y;
	}
	
	public void pressLeft() {
		leftPressed = true;
	}
	
	public void pressRight() {
		rightPressed = true;
	}
	
	public void releaseLeft() {
		leftPressed = false;
	}
	
	public void releaseRight() {
		rightPressed = false;
	}
	
	public static int getX() {
		return x;
	}
	
	public static int getY() {
		return y;
	}
	
	public static Point getPoint() {
		return new Vec2(x, y);
	}
	
	public static boolean isLeftPressed() {
		return leftPressed;
	}
	
	public static boolean isRightPressed() {
		return rightPressed;
	}
}