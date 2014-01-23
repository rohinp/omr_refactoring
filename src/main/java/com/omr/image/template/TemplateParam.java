package com.omr.image.template;

public enum TemplateParam {
	a4width(21.0), a4height(29.7), circleOuter(1.5),
    circleInner(0.6),vertDist(23.1), horizDist(16.8),
    diagDist(28.5), markDiam(0.3);
	
	private Double value;
	
	private TemplateParam(Double value){
		this.value = value;
	}
	
	public Double getTemplateParam(){
		return this.value;
	}
}
