package Bex2DGameEngine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.VolatileImage;

public class Game {
	
	private Window window;
	private GoHomeBoardGame goHome;
	private BufferStrategy bs;
	
	private VolatileImage frame;
	
	private String windowTitle;
	private static boolean resized = false;
	
	public Game(Window window) {
		this.window = window; 
		goHome = new GoHomeBoardGame();
		frame = window.getVolatileImage();
		windowTitle = window.getTitle();
	}
	
	public void update(float dt) {
		goHome.update(dt);
	}
	
	public void draw() {
		if(bs == null || bs.contentsLost()) {
			bs = window.getBufferStrat();
		}
		
		if(resized) {
			goHome.resizeObjects();
			frame = window.getVolatileImage();
			resized = false;
		}
		
		if(frame.contentsLost()) {
			int code = frame.validate(window.getGraphicsConfig());
			System.out.println("lost");
			switch(code) {
				case VolatileImage.IMAGE_RESTORED:
					System.out.println("restore");
					break;
				case VolatileImage.IMAGE_INCOMPATIBLE:
					System.out.println("incomp");
					frame = window.getVolatileImage();
					break;
			}
		}
		
		Graphics2D gfx = frame.createGraphics();
		
		gfx.setColor(Color.BLACK);
		gfx.fillRect(0, 0, Window.getScreenWidth(), Window.getScreenHeight());
		gfx.setColor(Color.WHITE);
		/////////////////
		goHome.draw(gfx);
		/////////////////
	
		bs.getDrawGraphics().drawImage(frame, 0, 0, Window.getScreenWidth(), Window.getScreenHeight(), null);
		bs.show();
		
		gfx.clearRect(0, 0, Window.getScreenWidth(), Window.getScreenWidth());
		gfx.dispose();
	}
	
	public void updateFPS(int FPS) {
		window.setTitle(windowTitle + " FPS: " + FPS); 
	}
	
	public static void resize() {
		resized = true;
	}
	
}