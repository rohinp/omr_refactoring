package com.omr.image.testdoubles;

import java.util.HashMap;
import java.util.Map;

import net.sourceforge.jiu.data.Gray8Image;
import net.sourceforge.jiu.data.PixelImage;

public class Gray8ImageTestDouble implements Gray8Image{

	private enum PixelColor {
		BLACK, WHITE
	};

	private final int cordinateValues[][] = { { 0, 0 }, { 1, 1 },
			{ -1, -1 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, -1 },
			{ -1, 1 }};

	public Map<String, PixelColor> pixelSurrounding;

	public Gray8ImageTestDouble() {
		pixelSurrounding = new HashMap<String, PixelColor>();
	}

	@Override
	public void putWhite(int x, int y) {
		pixelSurrounding.put(x + "," + y, PixelColor.WHITE);
	}

	@Override
	public void putBlack(int x, int y) {
		pixelSurrounding.put(x + "," + y, PixelColor.BLACK);
	}

	public boolean isPixelSurroundedByWhite(int x, int y) {
		for (int loop = 0; loop < cordinateValues.length; loop++) {
			if(!isWhite(x + cordinateValues[loop][0],y + cordinateValues[loop][1])){
				return false;
			}
		}
		return true;
	}

	public boolean isPixelSurroundedByBlack(int x, int y) {
		for (int loop = 0; loop < cordinateValues.length; loop++) {
			if(!isBlack(x + cordinateValues[loop][0],y + cordinateValues[loop][1])){
				return false;
			}
		}
		return true;
	}
		
	@Override
	public boolean isBlack(int arg0, int arg1) {
		String key = arg0 + "," + arg1;
		return pixelSurrounding.containsKey(key) && (pixelSurrounding.get(key) == PixelColor.BLACK);
	}

	@Override
	public boolean isWhite(int arg0, int arg1) {
		String key = arg0 + "," + arg1;
		return pixelSurrounding.containsKey(key) && (pixelSurrounding.get(key) == PixelColor.WHITE);
	}

	@Override
	public void clear(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMaxSample(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSample(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSample(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getSamples(int arg0, int arg1, int arg2, int arg3, int arg4,
			int[] arg5, int arg6) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putSample(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putSample(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putSamples(int arg0, int arg1, int arg2, int arg3, int arg4,
			int[] arg5, int arg6) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear(byte arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear(int arg0, byte arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte getByteSample(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte getByteSample(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getByteSamples(int arg0, int arg1, int arg2, int arg3,
			int arg4, byte[] arg5, int arg6) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putByteSample(int arg0, int arg1, byte arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putByteSample(int arg0, int arg1, int arg2, byte arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putByteSamples(int arg0, int arg1, int arg2, int arg3,
			int arg4, byte[] arg5, int arg6) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public PixelImage createCompatibleImage(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public PixelImage createCopy() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long getAllocatedMemory() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getBitsPerPixel() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Class getImageType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getNumChannels() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
