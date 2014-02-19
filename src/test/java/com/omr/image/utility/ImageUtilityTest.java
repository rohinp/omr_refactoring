package com.omr.image.utility;

import static org.junit.Assert.assertTrue;

import java.io.File;

import net.sourceforge.jiu.data.PixelImage;

import org.junit.Test;

import com.omr.image.factories.ImageFactory;
import com.omr.image.testdoubles.Gray8ImageTestDouble;

public class ImageUtilityTest {

	@Test
	public void itShouldSaveFileAsPng() {
		// given
		String filePath = "data/MARBIBM.tif";
		String pngFilePath = "data/testcolor.png";
		PixelImage pixelImage = ImageFactory.createGray8Image(filePath);
		ImageUtility imageUtility = new ImageUtility();
		// when
		imageUtility.saveImageToPNG(pixelImage, pngFilePath);
		// then
		assertTrue(new File(pngFilePath).exists());
	}
	
	@Test(expected = ImageUtility.ImageUtilitySaveToPNGException.class)
	public void itShouldNotProcessToPNGForWrongPath(){
		//given
		String filePath = "data/main/fullatt.tif";
		String pngFilePath = "data/test.png";
		PixelImage pixelImage = ImageFactory.createGray8Image(filePath);
		ImageUtility imageUtility = new ImageUtility();
		// when
		imageUtility.saveImageToPNG(pixelImage, pngFilePath);
	}

	@Test
	public void itShouldSorroundAPixleWithWhitePixels() {
		// given
		Gray8ImageTestDouble gray8Image = new Gray8ImageTestDouble();
		int x = 2;
		int y = 3;
		
		// when
		ImageUtility imageUtility = new ImageUtility();
		imageUtility.putWhiteMark(gray8Image, x, y);
		
		// then
		assertTrue(gray8Image.isPixelSurroundedByWhite(x, y));
	}

	@Test
	public void itShouldSorroundAPixleWithBlackPixels() {
		// given
		Gray8ImageTestDouble gray8Image = new Gray8ImageTestDouble();
		int x = 5;
		int y = 9;
		// when
		ImageUtility imageUtility = new ImageUtility();
		imageUtility.putBlackMark(gray8Image, x, y);
		// then
		assertTrue(gray8Image.isPixelSurroundedByBlack(x, y));
	}

}
