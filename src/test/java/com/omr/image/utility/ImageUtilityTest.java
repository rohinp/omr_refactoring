package com.omr.image.utility;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.jiu.data.Gray8Image;
import net.sourceforge.jiu.data.PixelImage;

import org.junit.Test;

import com.omr.image.factories.ImageFactory;
import com.omr.image.testdoubles.Gray8ImageTestDouble;

public class ImageUtilityTest {

	@Test
	public void itShouldCreateAGray8Image() {
		// given
		String filePath = "data/fullatt.tif";
		// when
		PixelImage pixelImage = ImageFactory.createGray8Image(filePath);
		// then
		assertTrue(pixelImage instanceof Gray8Image);

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
