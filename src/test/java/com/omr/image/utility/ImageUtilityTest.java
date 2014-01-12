package com.omr.image.utility;

import static org.junit.Assert.*;

import net.sourceforge.jiu.data.Gray8Image;
import net.sourceforge.jiu.data.PixelImage;

import org.junit.Test;

import com.omr.image.factories.ImageFactory;

public class ImageUtilityTest {

	@Test
	public void itShouldCreateAGray8Image() {
		//given
		String filePath = "data/fullatt.tif";
		//when
		PixelImage pixelImage = ImageFactory.createGray8Image(filePath);
		//then
		assertTrue(pixelImage instanceof Gray8Image);
	}

}
