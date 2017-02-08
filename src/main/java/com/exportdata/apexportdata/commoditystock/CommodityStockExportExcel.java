package com.exportdata.apexportdata.commoditystock;

import com.exportdata.apexportdata.model.SchemaExcel;
import com.exportdata.apexportdata.util.ExcelUtils;


public class CommodityStockExportExcel extends CommodityStockExport {

	@Override
	public void exportStockCommdoityPop(String string, String string2) {
		String[] titles = {"城市","","财务组织","","供应商ID","一级分类","","库存商品","税"};
		SchemaExcel excel = generatExcelSchema(titles, generateStockCommodityPopMapperList());
		ExcelUtils.readAndWrite(string, string2, "POP", excel);
		System.out.println("POP转化结束");
	}
	
	
	@Override
	public void exportStockCommdoityPrePay(String string, String string2) {
		String[] titles = {"城市","","财务组织","","供应商id","摘要","金额"};
		SchemaExcel excel = generatExcelSchema(titles, generateStockCommodityPrePayMapperList());
		ExcelUtils.readAndWrite(string, string2, "预付账款", excel);
		System.out.println("预付账款转化结束");
	}
	
	public void exportStockCommdoityTax(String string, String string2) {
		String[] titles = {"城市","","财务组织","","一级分类","","金额"};
		SchemaExcel excel = generatExcelSchema(titles, generateStockCommodityTaxMapperList());
		ExcelUtils.readAndWrite(string, string2, "税", excel);
		System.out.println("税转化结束");
	}
	
	

	public void exportStockCommdoity(String string, String string2) {
		String[] titles = {"城市","","财务组织","","一级分类","","金额"};
		SchemaExcel excel = generatExcelSchema(titles, generateStockCommodityMapperList());
		ExcelUtils.readAndWrite(string, string2, "库存商品", excel);
		System.out.println("库存商品转化结束");
	}

}
