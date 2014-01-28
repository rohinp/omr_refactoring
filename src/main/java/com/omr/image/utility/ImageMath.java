package com.omr.image.utility;

public class ImageMath {

	public static int calculateWidthArea(int width){
		return (int)((width / 1700 * 15) / 2) * 2 + 1;
	}
	
	public static int calculateHeightArea(int height){
		return (int)(height / 2339 * 15 / 2) * 2 + 1;
	}
	
}
