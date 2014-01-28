package com.omr.image.template;

public enum TemplateParam {
	A4WIDTH(21.0), A4HEIGHT(29.7), CIRCLE_OUTER(1.5),
    CIRCLE_INNER(0.6),VERT_DIST(23.1), HORIZ_DIST(16.8),
    DIAG_DIST(28.5), MARK_DIAM(0.3);
	
	private double value;
	
	private TemplateParam(double value){
		this.value = value;
	}
	
	public double getTemplateParam(){
		return this.value;
	}
}
