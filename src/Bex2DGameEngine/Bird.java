package Bex2DGameEngine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import Bex2DGameEngine.GameUtils.EngineMath;
import Bex2DGameEngine.GameObjects.GameObject;

public class Bird extends GameObject {
	
	private float fallSpeed = 0.0f;
	private float acceleration = 250.0f;
	private float accelDueToGravity = 304f;
	
	public Bird() {
		super(200, 500, 32, 32);
	}
	
	@Override
	public void update(float dt) {
		if(Keyboard.keyTyped(KeyEvent.VK_SPACE)) {
			fallSpeed = -500.0f;
			acceleration -= 250.0f;
		}

		y += fallSpeed * dt;
		acceleration += accelDueToGravity * dt;
		fallSpeed += acceleration * dt;
	}

	@Override
	public void draw(Graphics2D gfx) {
		gfx.rotate(EngineMath.map(fallSpeed, -500, 500, -45, 45) * (Math.PI / 180), x + width / 2, y + height / 2);
		gfx.setColor(Color.YELLOW);
		gfx.fillOval(x, y, width, height);
		gfx.setColor(Color.GREEN);
		gfx.fillOval(x + width /2, y + height / 2 - height / 8, (int)(width / 1.5f), height / 4);
		gfx.setColor(Color.magenta);
		gfx.fillOval(x + width / 2 + width / 12, y + height / 6, width / 4, height / 4);
	}

}
