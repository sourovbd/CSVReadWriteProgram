package com.sv.model;

public class InputCalculation {

	private String ShareNumberAW;
	private String MultiplierAW;
	
	public InputCalculation(String shareNumberAW, String multiplierAW) {
		super();
		ShareNumberAW = shareNumberAW;
		MultiplierAW = multiplierAW;
	}
	public InputCalculation(String shareNumberAW) {
		super();
		ShareNumberAW = shareNumberAW;
	}
	public InputCalculation() {
		super();
	}
	public String getShareNumberAW() {
		return ShareNumberAW;
	}
	public void setShareNumberAW(String shareNumberAW) {
		ShareNumberAW = shareNumberAW;
	}
	public String getMultiplierAW() {
		return MultiplierAW;
	}
	public void setMultiplierAW(String multiplierAW) {
		MultiplierAW = multiplierAW;
	}
	
	
}
