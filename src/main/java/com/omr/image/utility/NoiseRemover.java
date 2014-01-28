package com.omr.image.utility;

import net.sourceforge.jiu.data.Gray8Image;
import net.sourceforge.jiu.filters.MedianFilter;
import net.sourceforge.jiu.ops.MissingParameterException;
import net.sourceforge.jiu.ops.WrongParameterException;

public class NoiseRemover {

	private MedianFilter medianFilter;
	private Gray8Image gray8Image;
	private int areaLeft;
	private int areaRight;
	
	public NoiseRemover(Gray8Image gray8Image,int areaLeft, int areaRight){
		this.gray8Image = gray8Image;
		this.medianFilter = new MedianFilter();
		this.areaLeft = areaLeft;
		this.areaRight = areaRight;
	}
	
	public void removeNoise(){
		try {
			medianFilter.setArea(this.areaLeft, this.areaRight);
			medianFilter.setInputImage(gray8Image);
			medianFilter.process();
		} catch (MissingParameterException | WrongParameterException e) {
			throw new NoiseRemoverWrongParamException();
		}
	}
	
	public Gray8Image getNoiseRemovedImage(){
		return (Gray8Image)(medianFilter.getOutputImage());
	}
	
	public class NoiseRemoverWrongParamException extends RuntimeException {
		private static final long serialVersionUID = -5794721809769621494L;
	}

}
