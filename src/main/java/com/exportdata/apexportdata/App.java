package com.exportdata.apexportdata;

import com.exportdata.apexportdata.commoditystock.CommodityStockExportCsv;
import com.exportdata.apexportdata.commoditystock.CommodityStockExportExcel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "开始执行转化" );
        args = new String[5];
//        args[0] = "C:\\Users\\lx\\Desktop\\work\\exportApData\\sourcedata\\stockCommodity.xlsx";
//        args[1] = "C:\\Users\\lx\\Desktop\\work\\exportApData\\sourcedata\\stockCommodityTax.xlsx";
//        args[2] = "C:\\Users\\lx\\Desktop\\work\\exportApData\\sourcedata\\stockCommodityPrePay.xlsx";
//        args[3] = "C:\\Users\\lx\\Desktop\\work\\exportApData\\sourcedata\\stockCommodityPop.xlsx";
//        args[4] = "D:/test.xlsx";
        args[0] = "C:\\Users\\lx\\Pictures\\t_ai_entry_1701.csv";
        args[1] = "C:\\Users\\lx\\Pictures\\t_ai_entry_1701(1).csv";
        args[2] = "C:\\Users\\lx\\Pictures\\t_ai_entry_1701(2).csv";
        args[3] = "C:\\Users\\lx\\Pictures\\t_fi_ap_line(5).csv";
        args[4] = "D:/test_csv.xlsx";
//        doConvert(args);
        doCsvConvert(args);
    }

	private static void doCsvConvert(String[] args) {
		CommodityStockExportCsv export = new CommodityStockExportCsv();
		//库存商品
		System.out.println("开始转化库存商品");
		export.exportStockCommdoity(args[0],args[4]);
		//税
		export.exportStockCommdoityTax(args[1],args[4]);
		//预付账款
		System.out.println("开始转化预付账款");
		export.exportStockCommdoityPrePay(args[2],args[4]);
		//pop
		System.out.println("开始转化POP");
		export.exportStockCommdoityPop(args[3],args[4]);
	}

	private static void doConvert(String[] args) {
		CommodityStockExportExcel export = new CommodityStockExportExcel();
		//库存商品
		System.out.println("开始转化库存商品");
		export.exportStockCommdoity(args[0],args[4]);
		//税
		export.exportStockCommdoityTax(args[1],args[4]);
		//预付账款
		System.out.println("开始转化预付账款");
		export.exportStockCommdoityPrePay(args[2],args[4]);
		//pop
		System.out.println("开始转化POP");
		export.exportStockCommdoityPop(args[3],args[4]);
//		//暂估入库
//		peExport.exportPeStock(args[3],args[4]);
	}
}
