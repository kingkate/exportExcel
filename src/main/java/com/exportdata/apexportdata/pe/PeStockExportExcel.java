package com.exportdata.apexportdata.pe;

import java.util.List;

import com.exportdata.apexportdata.model.SchemaExcel;
import com.exportdata.apexportdata.model.SourceMapper;
import com.exportdata.apexportdata.util.ExcelUtils;

public class PeStockExportExcel extends PeStockExport {

	public void exportPeStockCommodity(String string, String string2) {
		SchemaExcel excel = new SchemaExcel();
		String[] titles = {"城市","","财务组织","","一级分类","","金额"};
		List<SourceMapper> mapList = generatePeStockCommodityMapperList();
		excel.setTitles(titles);
		excel.setSourceMapperList(mapList);
		ExcelUtils.readAndWrite(string, string2, "库存商品", excel);
		System.out.println("库存商品转化结束");
	}
	
	public void exportPeStockTax(String string, String string2) {
		SchemaExcel excel = new SchemaExcel();
		String[] titles = {"城市","","财务组织","","一级分类","","金额"};
		List<SourceMapper> mapList = generatePeStockTaxMapperList();
		excel.setTitles(titles);
		excel.setSourceMapperList(mapList);
		ExcelUtils.readAndWrite(string, string2, "税", excel);
		System.out.println("税转化结束");
	}
	
	public void exportPeStock(String string, String string2) {
		SchemaExcel excel = new SchemaExcel();
		String[] titles = {"城市","","财务组织","","供应商id","摘要","金额"};
		List<SourceMapper> mapList = generatePeStockMapperList();
		excel.setTitles(titles);
		excel.setSourceMapperList(mapList);
		ExcelUtils.readAndWrite(string, string2, "暂估入库", excel);
		System.out.println("暂估入库转化结束");
	}

}
