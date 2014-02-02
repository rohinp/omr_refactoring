package com.omr.image.datastructure;

import com.omr.image.template.TemplateParam;

public class ConcentricCircleData {

	private int templateWidth;
	private int templateHeight;

	public ConcentricCircleData(int actualImageWidth, int actualImageHeight) {
		this.templateWidth = actualImageWidth;
		this.templateHeight = actualImageHeight;
	}
	
	public double getXScale() {
		return this.templateWidth / TemplateParam.A4WIDTH.getValue();
	}

	public double getYScale() {
		return this.templateHeight
				/ TemplateParam.A4HEIGHT.getValue();
	}

	public double getAspectScale() {
		return getXScale() / getYScale();
	}

	public double getCircleOutterX() {
		return TemplateParam.CIRCLE_OUTER.getValue() * getXScale();
	}

	public double getCircleInnerX() {
		return TemplateParam.CIRCLE_INNER.getValue() * getXScale();
	}
}
