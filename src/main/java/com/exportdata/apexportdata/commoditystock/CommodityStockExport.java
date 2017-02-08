package com.exportdata.apexportdata.commoditystock;

import java.util.ArrayList;
import java.util.List;

import com.exportdata.apexportdata.Export;
import com.exportdata.apexportdata.model.SourceMapper;

public abstract class CommodityStockExport extends Export {

	public abstract void exportStockCommdoityPop(String s1,String s2);
	public abstract void exportStockCommdoityPrePay(String s1,String s2);
	public abstract void exportStockCommdoityTax(String s1,String s2);
	public abstract void exportStockCommdoity(String s1,String s2);
	public List<SourceMapper> generateStockCommodityPopMapperList() {
		List<SourceMapper> sourceMapperList = new ArrayList<SourceMapper>();
		SourceMapper mapper1 = generateMapper(0,0,null,0);
		SourceMapper mapper2 = generateMapper(-1,1,"VLOOKUP(A2,匹配模板!A:B,2,0)",2);
		SourceMapper mapper3 = generateMapper(1,2,null,1);
		SourceMapper mapper4 = generateMapper(-1,3,"VLOOKUP(C2,匹配模板!I:J,2,0)",2);
		SourceMapper mapper5 = generateMapper(2,4,null,0);
		SourceMapper mapper6 = generateMapper(3,5,null,0);
		SourceMapper mapper7 = generateMapper(-1,6,"VLOOKUP(F2,匹配模板!D:F,3,0)",2);
		SourceMapper mapper8 = generateMapper(4,7,null,0);
		SourceMapper mapper9 = generateMapper(5,8,null,0);
		sourceMapperList.add(mapper1);
		sourceMapperList.add(mapper2);
		sourceMapperList.add(mapper3);
		sourceMapperList.add(mapper4);
		sourceMapperList.add(mapper5);
		sourceMapperList.add(mapper6);
		sourceMapperList.add(mapper7);
		sourceMapperList.add(mapper8);
		sourceMapperList.add(mapper9);
		return sourceMapperList;
	}
	public List<SourceMapper> generateStockCommodityPrePayMapperList() {
		List<SourceMapper> sourceMapperList = new ArrayList<SourceMapper>();
		SourceMapper mapper1 = generateMapper(0,0,null,0);
		SourceMapper mapper2 = generateMapper(-1,1,"VLOOKUP(A2,匹配模板!A:B,2,0)",2);
		SourceMapper mapper3 = generateMapper(1,2,null,1);
		SourceMapper mapper4 = generateMapper(-1,3,"VLOOKUP(C2,匹配模板!I:J,2,0)",2);
		SourceMapper mapper5 = generateMapper(2,4,null,0);
		SourceMapper mapper6 = generateMapper(3,5,null,1);
		SourceMapper mapper7 = generateMapper(4,6,null,0);
		sourceMapperList.add(mapper1);
		sourceMapperList.add(mapper2);
		sourceMapperList.add(mapper3);
		sourceMapperList.add(mapper4);
		sourceMapperList.add(mapper5);
		sourceMapperList.add(mapper6);
		sourceMapperList.add(mapper7);
		return sourceMapperList;
	}
	public List<SourceMapper> generateStockCommodityTaxMapperList() {
		List<SourceMapper> sourceMapperList = new ArrayList<SourceMapper>();
		SourceMapper mapper1 = generateMapper(0,0,null,0);
		SourceMapper mapper2 = generateMapper(-1,1,"VLOOKUP(A2,匹配模板!A:B,2,0)",2);
		SourceMapper mapper3 = generateMapper(1,2,null,1);
		SourceMapper mapper4 = generateMapper(-1,3,"VLOOKUP(C2,匹配模板!I:J,2,0)",2);
		SourceMapper mapper5 = generateMapper(2,4,null,0);
		SourceMapper mapper6 = generateMapper(-1,5,"VLOOKUP(E2,匹配模板!D:F,3,0)",2);
		SourceMapper mapper7 = generateMapper(3,6,null,0);
		sourceMapperList.add(mapper1);
		sourceMapperList.add(mapper2);
		sourceMapperList.add(mapper3);
		sourceMapperList.add(mapper4);
		sourceMapperList.add(mapper5);
		sourceMapperList.add(mapper6);
		sourceMapperList.add(mapper7);
		return sourceMapperList;
	}
	public List<SourceMapper> generateStockCommodityMapperList() {
		List<SourceMapper> sourceMapperList = new ArrayList<SourceMapper>();
		SourceMapper mapper1 = generateMapper(0,0,null,0);
		SourceMapper mapper2 = generateMapper(-1,1,"VLOOKUP(A2,匹配模板!A:B,2,0)",2);
		SourceMapper mapper3 = generateMapper(1,2,null,1);
		SourceMapper mapper4 = generateMapper(-1,3,"VLOOKUP(C2,匹配模板!I:J,2,0)",2);
		SourceMapper mapper5 = generateMapper(2,4,null,0);
		SourceMapper mapper6 = generateMapper(-1,5,"VLOOKUP(E2,匹配模板!D:F,3,0)",2);
		SourceMapper mapper7 = generateMapper(3,6,null,0);
		sourceMapperList.add(mapper1);
		sourceMapperList.add(mapper2);
		sourceMapperList.add(mapper3);
		sourceMapperList.add(mapper4);
		sourceMapperList.add(mapper5);
		sourceMapperList.add(mapper6);
		sourceMapperList.add(mapper7);
		return sourceMapperList;
	}

}
