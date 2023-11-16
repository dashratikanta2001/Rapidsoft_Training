package com.springcore.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {

	@Value("#{22+11}")
	private int x;
	
	@Value("#{1+2+3+4+5}")
	private int y;
	
	@Value("#{ T(java.lang.Math).sqrt(144) }")
	private double z;
	
	@Value("#{ T(java.lang.Math).E}")
	private double E;
	
	@Value("#{ new java.lang.String('Ratikanta')}")
	private String name;
	
	@Value("#{ 8<3}")
	private boolean isActive;

	@Override
	public String toString() {
		return "Demo [x=" + x + ", y=" + y + ", z=" + z + ", E=" + E + ", name=" + name + ", isActive=" + isActive
				+ "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getE() {
		return E;
	}

	public void setE(double e) {
		E = e;
	}
}
