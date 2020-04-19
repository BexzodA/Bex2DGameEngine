package Bex2DGameEngine;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class Keyboard {
	
	private static Set<Integer> keysPressed = new HashSet<Integer>();
	private static boolean initialized = false;
	
	public static void init() {
		if(!initialized) {
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
	
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					if(e.getID() == KeyEvent.KEY_PRESSED) {
						keysPressed.add(e.getKeyCode());
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
		return keysPressed.contains(key);
	}
	
}