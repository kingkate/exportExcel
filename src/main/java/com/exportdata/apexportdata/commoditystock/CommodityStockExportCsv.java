package com.exportdata.apexportdata.commoditystock;

import java.util.List;

import com.exportdata.apexportdata.model.SchemaExcel;
import com.exportdata.apexportdata.model.SourceMapper;
import com.exportdata.apexportdata.util.ExcelUtils;

public class CommodityStockExportCsv extends CommodityStockExport{	
	
	public void exportStockCommdoityPop(String string, String string2) {
		SchemaExcel excel = new SchemaExcel();
		String[] titles = {"城市","","财务组织","","供应商ID","一级分类","","库存商品","税"};
		List<SourceMapper> mapList = generateStockCommodityPopMapperList();
		excel.setTitles(titles);
		excel.setSourceMapperList(mapList);
		ExcelUtils.readAndWriteByCsv(string, string2, "POP", excel);
		System.out.println("POP转化结束");
	}
	
	

	public void exportStockCommdoityPrePay(String string, String string2) {
		SchemaExcel excel = new SchemaExcel();
		String[] titles = {"城市","","财务组织","","供应商id","摘要","金额"};
		List<SourceMapper> mapList = generateStockCommodityPrePayMapperList();
		excel.setTitles(titles);
		excel.setSourceMapperList(mapList);
		ExcelUtils.readAndWriteByCsv(string, string2, "预付账款", excel);
		System.out.println("预付账款转化结束");
	}
	
	

	public void exportStockCommdoityTax(String string, String string2) {
		String[] titles = {"城市","","财务组织","","一级分类","","金额"};
		SchemaExcel excel = generatExcelSchema(titles, generateStockCommodityTaxMapperList());
		ExcelUtils.readAndWriteByCsv(string, string2, "税", excel);
		System.out.println("税转化结束");
	}
	
	

	public void exportStockCommdoity(String string, String string2) {
		String[] titles = {"城市","","财务组织","","一级分类","","金额"};
		SchemaExcel excel = generatExcelSchema(titles, generateStockCommodityMapperList());
		ExcelUtils.readAndWriteByCsv(string, string2, "库存商品", excel);
		System.out.println("库存商品转化结束");
	}

	
	
}
