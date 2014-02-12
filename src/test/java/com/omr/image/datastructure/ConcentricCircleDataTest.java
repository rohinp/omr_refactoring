package com.omr.image.datastructure;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConcentricCircleDataTest {

	ConcentricCircleData ccData;
	
	@Before
	public void setUp(){
		ccData = new ConcentricCircleData(1700, 2320);
	}
	
	@Test
	public void isShouldGiveXScaleForGivenHeightWdth() {
		//when
		double xScale = ccData.getXScale();
		//then
		assertEquals(80.95, xScale,2);
		
	}

}
