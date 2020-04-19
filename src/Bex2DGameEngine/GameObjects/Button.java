package Bex2DGameEngine.GameObjects;

import java.awt.Graphics2D;
import Bex2DGameEngine.Mouse;
import Bex2DGameEngine.GameObjects.GameObject;

public class Button extends GameObject{
	
	private boolean hoveringOver = false;
	private boolean lpressed = false;
	private boolean rpressed = false;
	
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(float dt) {
		if(bounds.contains(Mouse.getPoint())) {
			hoveringOver = true;
			if(Mouse.isLeftPressed()) {
				lpressed = true;
			} else {
				lpressed = false;
			}
			if(Mouse.isRightPressed()){
				rpressed = true;
			} else {
				rpressed = false;
			}
		} else {
			hoveringOver = false;
		}
	}

	@Override
	public void draw(Graphics2D gfx) {
		gfx.drawRect(x, y, width, height);
		if(hoveringOver) {
			gfx.drawRect(x + 2, y + 2, width - 4, height - 4);
			if(lpressed && rpressed) {
				gfx.drawString("Both Clicked!", x + width / 2 - 20, y + height / 2);
			} else if(lpressed) {
				gfx.drawString("Left Clicked!", x + width / 2 - 20, y + height / 2);
			} else if (rpressed) {
				gfx.drawString("Right Clicked!", x + width / 2 - 20, y + height / 2);
			} 
		}
	}
	
}