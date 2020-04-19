package Bex2DGameEngine;

import java.awt.DisplayMode;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class BexEngineMain {
	
	private volatile static Window window;
	private static Game game;
	
	private static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private static GraphicsDevice gd = ge.getDefaultScreenDevice();
	private static GraphicsConfiguration gc = gd.getDefaultConfiguration();
	private static DisplayMode dm = gd.getDisplayMode();
	
	private static boolean isFullScreen = false;
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(()->
			{
				createWindow();
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		startGame();
	}
	
	private static void createWindow() {
		Rectangle screen = ge.getMaximumWindowBounds();
		window = new Window("Bex2DGameEngine", gc,screen.x, screen.y, screen.width, screen.height);
		//setFullScreen(gd);
	}
	
	private static void startGame() {
		game = new Game(window);
		GameLoop gameLoop = new GameLoop(game, dm.getRefreshRate());
		gameLoop.go();
	}
	
	private static void setFullScreen(GraphicsDevice gd) {
		if(gd.isFullScreenSupported()) {
			gd.setFullScreenWindow(window);
			isFullScreen = true;
		}
	}
	
	public static boolean isFullSreen() {
		return isFullScreen;
	}
	
}