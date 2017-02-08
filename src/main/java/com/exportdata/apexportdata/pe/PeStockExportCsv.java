package com.exportdata.apexportdata.pe;

import com.exportdata.apexportdata.model.SchemaExcel;
import com.exportdata.apexportdata.util.ExcelUtils;

public class PeStockExportCsv extends PeStockExport {
	
	public void exportPeStockCommodity(String string, String string2) {
		String[] titles = {"城市","","财务组织","","一级分类","","金额"};
		SchemaExcel excel = generatExcelSchema(titles, generatePeStockCommodityMapperList());
		ExcelUtils.readAndWriteByCsv(string, string2, "库存商品", excel);
		System.out.println("库存商品转化结束");
	}
	
	public void exportPeStockTax(String string, String string2) {
		String[] titles = {"城市","","财务组织","","一级分类","","金额"};
		SchemaExcel excel = generatExcelSchema(titles, generatePeStockTaxMapperList());
		ExcelUtils.readAndWriteByCsv(string, string2, "税", excel);
		System.out.println("税转化结束");
	}
	
	public void exportPeStock(String string, String string2) {
		String[] titles = {"城市","","财务组织","","供应商id","摘要","金额"};
		SchemaExcel excel = generatExcelSchema(titles, generatePeStockMapperList());
		ExcelUtils.readAndWriteByCsv(string, string2, "暂估入库", excel);
		System.out.println("暂估入库转化结束");
	}
}
