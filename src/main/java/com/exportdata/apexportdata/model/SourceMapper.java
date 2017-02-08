package com.exportdata.apexportdata.model;

public class SourceMapper {
	
	public int getSrcId() {
		return srcId;
	}
	public void setSrcId(int srcId) {
		this.srcId = srcId;
	}
	public int getDescId() {
		return descId;
	}
	public void setDescId(int descId) {
		this.descId = descId;
	}
	public Object getDefaltValue() {
		return defaltValue;
	}
	public void setDefaltValue(Object defaltValue) {
		this.defaltValue = defaltValue;
	}



	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}



	private int srcId;
	private int descId;
	private Object defaltValue;
	private int type;
}
