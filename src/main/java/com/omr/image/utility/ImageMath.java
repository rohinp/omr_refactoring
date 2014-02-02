package com.omr.image.utility;

public class ImageMath {

	public static int calculateMedianWidth(int width){
		return (int)((width / 1700 * 15) / 2) * 2 + 1;
	}
	
	public static int calculateMedianHeight(int height){
		return (int)(height / 2339 * 15 / 2) * 2 + 1;
	}
	
}
