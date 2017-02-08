package com.exportdata.apexportdata.model;

import java.util.List;

public class SchemaExcel {
	
	public String[] getTitles() {
		return titles;
	}
	public void setTitles(String[] titles) {
		this.titles = titles;
	}
	public List<SourceMapper> getSourceMapperList() {
		return sourceMapperList;
	}
	public void setSourceMapperList(List<SourceMapper> sourceMapperList) {
		this.sourceMapperList = sourceMapperList;
	}
	private String[] titles;
	private List<SourceMapper> sourceMapperList; 
}
