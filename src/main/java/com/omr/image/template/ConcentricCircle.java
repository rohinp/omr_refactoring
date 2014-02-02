package com.omr.image.template;

import net.sourceforge.jiu.data.MemoryGray8Image;

import com.omr.image.datastructure.ConcentricCircleData;

public class ConcentricCircle {

	private ConcentricCircleData concentricCircleData;
	private MemoryGray8Image inmemoryConcentricCircle;
	private int centerX;
	private int centerY;
	private double outerrad;
	private double innerrad;

	public ConcentricCircle(ConcentricCircleData concentricCircleData) {
		this.concentricCircleData = concentricCircleData;
		init();
	}

	private void init() {
		inmemoryConcentricCircle = new MemoryGray8Image(
				(int) (concentricCircleData.getCircleOutterX() * 1.15) + 1,
				(int) (concentricCircleData.getCircleOutterX()
						/ concentricCircleData.getAspectScale() * 1.15) + 1);

		centerX = inmemoryConcentricCircle.getWidth() / 2;
		centerY = inmemoryConcentricCircle.getHeight() / 2;
		outerrad = concentricCircleData.getCircleOutterX() / 2;
		innerrad = concentricCircleData.getCircleInnerX() / 2;
	}

	/**
	 * fillTemplate function in old code
	 * */
	public MemoryGray8Image createInmemoryConcentricCircle() {
		for (int xPixelCount = 0; xPixelCount < inmemoryConcentricCircle
				.getWidth(); xPixelCount++) {
			for (int yPixelCount = 0; yPixelCount < inmemoryConcentricCircle
					.getHeight(); yPixelCount++) {
				putBlackWhitePixel(xPixelCount, yPixelCount);
			}
		}
		return inmemoryConcentricCircle;
	}

	private void putBlackWhitePixel(int xPixelCount, int yPixelCount) {
		double dist = calculateDistance(xPixelCount, yPixelCount);
		if (dist <= outerrad && dist > innerrad) {
			inmemoryConcentricCircle.putBlack(xPixelCount, yPixelCount);
		} else {
			inmemoryConcentricCircle.putWhite(xPixelCount, yPixelCount);
		}
	}

	private double calculateDistance(int xPixelCount, int yPixelCount) {
		return Math.sqrt((xPixelCount - centerX) * (xPixelCount - centerX)
				+ (yPixelCount - centerY)
				/ concentricCircleData.getAspectScale()
				* (yPixelCount - centerY)
				/ concentricCircleData.getAspectScale());
	}
}
