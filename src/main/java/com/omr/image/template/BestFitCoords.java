package com.omr.image.template;


import net.sourceforge.jiu.data.Gray8Image;

import com.omr.image.datastructure.ConcentricCircleData;

public class BestFitCoords {
	private ConcentricCircleData concentricCircleData;
	private int x,y;
	private Gray8Image template;
	private double maxsim;
	double approxCircleOuterX, approxCircleInnerX, aspectScale;
	
	public BestFitCoords(ConcentricCircleTemplate concentricCircle ){
		this.concentricCircleData = concentricCircle.getConcentriCircleData();
		this.template = concentricCircle.createInmemoryConcentricCircle();
		init();
	}

	private void init() {
		x = -1;
		y = -1;
		maxsim = -1;
		this.approxCircleInnerX = this.concentricCircleData.getCircleInnerX();
		this.approxCircleOuterX = this.concentricCircleData.getCircleOutterX();
		this.aspectScale = this.concentricCircleData.getAspectScale();
	}
	
	public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Gray8Image getTemplate() {
        return template;
    }

    public double getApproxCircleOuterX() {
        return approxCircleOuterX;
    }

    public double getApproxCircleInnerX() {
        return approxCircleInnerX;
    }

    public double getAspectScale() {
        return aspectScale;
    }

    public double getSim() {
        return maxsim;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setApproxCircleOuterX(double approxCircleOuterX) {
        this.approxCircleOuterX = approxCircleOuterX;
    }

    public void setApproxCircleInnerX(double approxCircleInnerX) {
        this.approxCircleInnerX = approxCircleInnerX;
    }

    public void setAspectScale(double aspectscale) {
        this.aspectScale = aspectscale;
    }

    public void setTemplate(Gray8Image template) {
        this.template = template;
    }

    public void setSim(double maxsim) {
        this.maxsim = maxsim;
    }
	
}
