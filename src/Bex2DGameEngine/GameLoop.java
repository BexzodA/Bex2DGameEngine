package Bex2DGameEngine;

public class GameLoop implements Runnable{
	
	private Thread gameLoop;
	private boolean running = false;
	
	private static float deltaTime;
	
	private Game game;
	
	private int FPS_CAP;
	private boolean capped = false;
	
	public GameLoop(Game game) {
		gameLoop = new Thread(this, "Game-Loop");
		this.game = game;
		deltaTime = 0.0f;
	}
	
	public GameLoop(Game game, int cap) {
		gameLoop = new Thread(this, "Game-Loop");
		this.game = game;
		deltaTime = 0.0f;
		FPS_CAP = cap;
		capped = true;
	}
	
	@Override
	public void run() {
		float time = 0.0f;
		float difference = 0.0f;
		int fps = 0;
		do {
			long lastTime = System.nanoTime();
			game.update(deltaTime);
			game.draw();
			deltaTime = (System.nanoTime() - lastTime) / 1000000000.0f;
			time += deltaTime + difference;
			fps++;
			if(time >= 1.0f) {
				time -= 1.0f;
				game.updateFPS(fps);
				fps = 0;
			}
			if(capped) {
				float targetDT = 1.0f / FPS_CAP;
				difference = targetDT - deltaTime;
				if(difference > 0.0f) {
					try {
						Thread.sleep((long) (difference * 1000));
						deltaTime += difference;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} while(running);
	}
	
	public void go() {
		gameLoop.start();
		running = true;
	}
	
	public void stop() {
		try {
			gameLoop.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static float getDeltaTime() {
		return deltaTime;
	}
	
}