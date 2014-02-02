package com.omr.image.utility;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImageMathTest {

	@Test
	public void shouldCalculateWidthForMedianArea() {
		//when
		int actual = ImageMath.calculateMedianWidth(1700);		
		//then
		assertEquals(15, actual);
	}

}
