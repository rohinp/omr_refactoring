package com.omr.image.utility;

import static org.junit.Assert.*;

import net.sourceforge.jiu.data.Gray8Image;
import net.sourceforge.jiu.data.MemoryGray8Image;
import net.sourceforge.jiu.data.PixelImage;

import org.junit.Before;
import org.junit.Test;

import com.omr.image.factories.ImageFactory;

public class NoiseRemoverTest {

	Gray8Image image;
	int height;
	int width;
	int[] topleft;
	
	@Before
	public void setUp() {
		image = ImageFactory.createGray8Image("data/fullatttemplate.tif");
	}

	@Test
	public void itShouldRemoveNoiseFromConcentricCircle() {
		// given
		NoiseRemover noiseRemover = new NoiseRemover(image, 101,101);
		// when
		noiseRemover.removeNoise();
		Gray8Image resultImage = noiseRemover.getNoiseRemovedImage();
		// then
		System.out.println(resultImage.getSample(1, 1));
		}

}
