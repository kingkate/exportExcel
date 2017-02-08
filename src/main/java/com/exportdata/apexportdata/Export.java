package com.exportdata.apexportdata;

import java.util.List;

import com.exportdata.apexportdata.model.SchemaExcel;
import com.exportdata.apexportdata.model.SourceMapper;

public abstract class Export {
	
	
	
	public SourceMapper generateMapper(int i, int j, Object object, int type) {
		SourceMapper mapper = new SourceMapper();
		mapper.setSrcId(i);
		mapper.setDescId(j);
		mapper.setDefaltValue(object);
		mapper.setType(type);
		return mapper;
	}
	
	public SchemaExcel generatExcelSchema(String[] titles,List<SourceMapper> sourceMapperList){
		SchemaExcel excel = new SchemaExcel();
		excel.setSourceMapperList(sourceMapperList);
		excel.setTitles(titles);
		return excel;
	}
}
