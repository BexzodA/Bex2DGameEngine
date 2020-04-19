package Bex2DGameEngine.GameUtils;

import java.awt.Point;

public class Vec2 extends Point{
	
	private static final long serialVersionUID = 8792361242909452207L;

	public Vec2(int x, int y) {
		super(x, y);
	}
	
	public Vec2(Vec2 pos) {
		super(pos);
	}
	
}