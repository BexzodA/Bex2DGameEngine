package Bex2DGameEngine;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Keyboard {
	
	private static HashMap<Integer, KeyEvent> keysPressed = new HashMap<Integer, KeyEvent>();
	private static boolean initialized = false;
	
	public static void init() {
		if(!initialized) {
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
	
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					if(e.getID() == KeyEvent.KEY_PRESSED) {
						if(e.getKeyCode() == KeyEvent.VK_F4 && e.isAltDown())
							System.exit(0);
						if(!keysPressed.containsKey(e.getKeyCode()))
							keysPressed.put(e.getKeyCode(), e);
					}
					if(e.getID() == KeyEvent.KEY_RELEASED) {
						keysPressed.remove(e.getKeyCode());
					}
					return true;
				}
				
			});
			initialized = true;
		}
	}
	
	public static boolean keyIsPressed(int key) {
		if(!initialized) {
			init();
		}
		return keysPressed.containsKey(key);
	}
	
	public static boolean keyTyped(int key) {
       	if(!initialized) {
			init();
		}
       	if(keysPressed.containsKey(key)) {
       		KeyEvent event = keysPressed.get(key);
       		long now = System.currentTimeMillis();
       		long when = event.getWhen();
       		return when > now - 8;
       	}
       	return false;
	}
	
}