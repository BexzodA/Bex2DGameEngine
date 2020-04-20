package Bex2DGameEngine;

import java.awt.Graphics2D;
import java.util.ArrayList;
import Bex2DGameEngine.GameObjects.GameObject;

public class GameScreen {
	
	private ArrayList<GameObject> gameObjs;
	
	public GameScreen() {
		gameObjs = new ArrayList<GameObject>();
		gameObjs.add(new Bird());
	}
	
	public void update(float dt) {
		gameObjs.forEach(
			(GameObject obj)->{
				obj.update(dt);
			}
		);
	}
	
	public void draw(Graphics2D gfx) {
		gameObjs.forEach(
			(GameObject obj)->{
				obj.draw(gfx);
			}
		);
	}
	
	/**
	 * Called if the window gets resized,
	 * The method will call the resize method of GameObject,
	 * which will resize and relocate its self at a appropriate position.
	 * See {@link Bex2DGameEngine.GameObjects.GameObject #resize() GameObject.resize()}
	 * for how the GameObject is resized.
	 */
	public void resizeObjects() {
		gameObjs.forEach(
			(GameObject obj)->{
				obj.resize();
			}
		);
	}
	
}