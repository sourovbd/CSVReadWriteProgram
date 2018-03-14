package com.sv.model;

public class IndexVol {

	private String IndexVolA;
	private String IndexVolAX;
	private String IndexVolAW;
	
	public IndexVol(String indexVolA, String indexVolAX, String indexVolAW) {
		IndexVolA = indexVolA;
		IndexVolAX = indexVolAX;
		IndexVolAW = indexVolAW;
	}
	public String getIndexVolA() {
		return IndexVolA;
	}
	public void setIndexVolA(String indexVolA) {
		this.IndexVolA = indexVolA;
	}
	public String getindexVolAX() {
		return IndexVolAX;
	}
	public void setindexVolAX(String indexVolAX) {
		this.IndexVolAX = indexVolAX;
	}
	public String getIndexVolAW() {
		return IndexVolAW;
	}
	public void setIndexVolAW(String indexVolAW) {
		this.IndexVolAW = indexVolAW;
	}
	
}