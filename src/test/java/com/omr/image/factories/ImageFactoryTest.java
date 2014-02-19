package com.omr.image.factories;

import static org.junit.Assert.*;

import java.io.IOException;

import net.sourceforge.jiu.codecs.ImageLoader;
import net.sourceforge.jiu.codecs.InvalidFileStructureException;
import net.sourceforge.jiu.codecs.InvalidImageIndexException;
import net.sourceforge.jiu.codecs.UnsupportedTypeException;
import net.sourceforge.jiu.data.Gray8Image;
import net.sourceforge.jiu.data.PixelImage;
import net.sourceforge.jiu.gui.awt.ToolkitLoader;

import org.junit.Test;

public class ImageFactoryTest {

	@Test
	public void itShouldConvertImageToGray8() throws InvalidFileStructureException, InvalidImageIndexException, UnsupportedTypeException, IOException {
		//when
		Gray8Image img = ImageFactory.createGray8Image("data/MARBIBM.tif");
		PixelImage pimg = ToolkitLoader.loadAsRgb24Image("data/MARBIBM.tif");
		// then
		assertNotNull(ImageLoader.load("data/MARBIBM.tif"));

	}

}
