package com.sv.model;

public class TDivisor {

	private String tDivisorAV;
	private String tDivisorAW;
	public TDivisor(String tDivisorAV, String tDivisorAW) {
		super();
		this.tDivisorAV = tDivisorAV;
		this.tDivisorAW = tDivisorAW;
	}
	public String gettDivisorAV() {
		return tDivisorAV;
	}
	public void settDivisorAV(String tDivisorAV) {
		this.tDivisorAV = tDivisorAV;
	}
	public String gettDivisorAW() {
		return tDivisorAW;
	}
	public void settDivisorAW(String tDivisorAW) {
		this.tDivisorAW = tDivisorAW;
	}
}
