package Bex2DGameEngine.GameObjects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Bex2DGameEngine.Window;
import Bex2DGameEngine.GameUtils.Vec2;

public abstract class GameObject {
	
	protected int x = 0;
	protected int y = 0;
	protected int width = 0;
	protected int height = 0;
	
	protected Rectangle bounds;
	protected Vec2 pos;
	
	private float xRatio;
	private float yRatio;
	private float widthRatio;
	private float heightRatio;
	
	protected GameObject() {}

	protected GameObject(int x, int y) {
		this(new Vec2(x, y));
	}
	
	protected GameObject(Vec2 pos) {
		this.x = pos.x;
		this.y = pos.y;

		this.pos = pos;
		
		xRatio = (float)pos.x / Window.getScreenWidth();
		yRatio = (float)pos.y / Window.getScreenHeight();
	}
	
	protected GameObject(int x, int y, int width, int height) {
		this(new Rectangle(x, y, width, height));
	}
	
	protected GameObject(Vec2 pos, int width, int height) {
		this(new Rectangle(pos.x, pos.y, width, height));
	}
	
	protected GameObject(Rectangle bounds) {
		this.x = bounds.x;
		this.y = bounds.y;
		this.width = bounds.width;
		this.height = bounds.height;
		
		this.pos = new Vec2(x, y);
		this.bounds = bounds;
		
		xRatio = (float)pos.x / Window.getScreenWidth();
		yRatio = (float)pos.y / Window.getScreenHeight();
		
		widthRatio = (float)width / Window.getScreenWidth();
		heightRatio = (float)height / Window.getScreenHeight();
	}
	
	public abstract void update(float dt);
	public abstract void draw(Graphics2D gfx);
	
	/**
	 * Resizes this object to fit the current screen ratio
	 */
	public void resize() {
		x = (int)(xRatio * Window.getScreenWidth());
		y = (int)(yRatio * Window.getScreenHeight());
		width = (int)(widthRatio * Window.getScreenWidth());
		height = (int)(heightRatio * Window.getScreenHeight());		
		
		pos = new Vec2(x, y);
		bounds = new Rectangle(x, y, width, height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle getBounds() {
		return new Rectangle(bounds);
	}

	public Vec2 getPos() {
		return new Vec2(pos);
	}
	
}