package Bex2DGameEngine.GameUtils;

public class EngineMath {
	
	public static float clamp(float value, float min, float max){
		if(value < min) {
			return min;
		}
		if(value > max) {
			return max;
		}
		return value;
	}
	
	public static float map(float value, float srcFrom, float srcTo, float destFrom, float destTo) {
		float percent = (value - srcFrom) / (srcTo - srcFrom);
		float result = destFrom + (destTo - destFrom) * percent;
		if(result > destTo) {
			return destTo;
		}
		if(result < destFrom) {
			return destFrom;
		}
		return result;
	}
		
}
