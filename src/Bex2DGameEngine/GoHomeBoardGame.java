package Bex2DGameEngine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Bex2DGameEngine.GameObjects.Button;
import Bex2DGameEngine.GameObjects.GameObject;

public class GoHomeBoardGame {
	
	private int x = 400;
	private int y = 300;
	
	private float speed = 300.0f;
	private GameObject button;
	
	private ArrayList<GameObject> gameObjs;
	
	public GoHomeBoardGame() {
		gameObjs = new ArrayList<GameObject>();
		button = new Button(960 - 50, 540 - 50, 100, 100);
		gameObjs.add(button);
	}
	
	public void update(float dt) {
		if(Keyboard.keyIsPressed(KeyEvent.VK_D)) {
			x += speed * dt;
		}
		if(Keyboard.keyIsPressed(KeyEvent.VK_A)) {
			x -= speed * dt;
		}
		if(Keyboard.keyIsPressed(KeyEvent.VK_W)) {
			y -= speed * dt;
		}
		if(Keyboard.keyIsPressed(KeyEvent.VK_S)) {
			y += speed * dt;
		}
		if(Keyboard.keyIsPressed(KeyEvent.VK_ESCAPE)) {
			System.exit(0);
		}
		gameObjs.forEach(
			(GameObject obj)->{
				obj.update(dt);
			}
		);
	}
	
	public void draw(Graphics2D gfx) {
		gfx.drawString("test", x, y);
		gameObjs.forEach(
			(GameObject obj)->{
				obj.draw(gfx);
			}
		);
	}
	
	public void resizeObjects() {
		gameObjs.forEach(
				(GameObject obj)->{
					obj.resize();
				}
			);
	}
	
}