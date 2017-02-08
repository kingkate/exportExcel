package com.exportdata.apexportdata.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.exportdata.apexportdata.model.SchemaExcel;
import com.exportdata.apexportdata.model.SourceMapper;

public class ExcelUtils {
	public static void readAndWriteByCsv(String srcPath,String descPath,String sheetName,SchemaExcel schema){
		try {
			FileInputStream in = new FileInputStream(new File(srcPath));
			FileOutputStream out = new FileOutputStream(new File(descPath),true);
			XSSFWorkbook writeWb = new XSSFWorkbook(descPath);
			Sheet writeSheet = writeWb.createSheet(sheetName);
			//填充标题行
			writeSheet = addTitles(writeSheet,schema.getTitles());
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = "";
			int i=0;
			while((line=reader.readLine())!=null){
				line = line.replaceAll("\"", "");
				Row writeRow = writeSheet.createRow(++i);
				writeRow = writeData(line,writeRow,schema.getSourceMapperList());
			}
			out.flush();
			writeWb.write(out);
//			wb.close();
//			writeWb.close();
			out.close();
			in.close();
			writeWb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Row writeData(String line, Row writeRow,
			List<SourceMapper> sourceMapperList) {
		String lineEle[] = line.split(",");
		for(SourceMapper mapper : sourceMapperList){
			if(mapper.getSrcId()<0){
				Cell writeCell = writeRow.createCell(mapper.getDescId());
				if(mapper.getType() == CellType.FORMULA.getCode()){
					//设置公式
					writeCell.setCellType(CellType.FORMULA);
//					writeCell.setCellValue((String)mapper.getDefaltValue());
					writeCell.setCellFormula((String)mapper.getDefaltValue());
				}else {
					writeCell.setCellType(CellType.STRING);
					writeCell.setCellValue((String)mapper.getDefaltValue());
				}
				continue;
			}
			String value = lineEle[mapper.getSrcId()];
			if(mapper.getType() == CellType.NUMERIC.getCode()){
				Double defaultValue = null == mapper.getDefaltValue()?0:Double.valueOf(mapper.getDefaltValue().toString());
				writeRow.createCell(mapper.getDescId()).setCellValue(null == value ? defaultValue:Double.valueOf(value));
			}else {
				String defaultValue = null == mapper.getDefaltValue()?"":mapper.getDefaltValue().toString();
				writeRow.createCell(mapper.getDescId()).setCellValue(null == value ? defaultValue:value);
			}
		}
		return writeRow;
	}

	public static void readAndWrite(String srcPath,String descPath,String sheetName,SchemaExcel schema){
		try {
			FileInputStream in = new FileInputStream(new File(srcPath));
			XSSFWorkbook wb = new XSSFWorkbook(in);
			Sheet sheet = wb.getSheetAt(0);
			
			FileOutputStream out = new FileOutputStream(new File(descPath),true);
			XSSFWorkbook writeWb = new XSSFWorkbook(descPath);
			Sheet writeSheet = writeWb.createSheet(sheetName);
			//填充标题行
			writeSheet = addTitles(writeSheet,schema.getTitles());
//			Map<Integer, SourceMapper> map = toMap(schema.getSourceMapperList());
			for(int i=1;i<=sheet.getLastRowNum()+1;i++){
				Row row = sheet.getRow(i-1);
				Row writeRow = writeSheet.createRow(i);
				writeRow = writeData(row,writeRow,schema.getSourceMapperList());
			}
			out.flush();
			writeWb.write(out);
//			wb.close();
//			writeWb.close();
			out.close();
			in.close();
			writeWb.close();
			wb.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件找不到");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO异常");
			e.printStackTrace();
		}finally{
			//清理资源
		}
	}

	private static Row writeData(Row row, Row writeRow,
			List<SourceMapper> sourceMapperList) {
		for(SourceMapper mapper : sourceMapperList){
			if(mapper.getSrcId()<0){
				Cell writeCell = writeRow.createCell(mapper.getDescId());
				if(mapper.getType() == CellType.FORMULA.getCode()){
					//设置公式
					writeCell.setCellType(CellType.FORMULA);
//					writeCell.setCellValue((String)mapper.getDefaltValue());
					writeCell.setCellFormula((String)mapper.getDefaltValue());
				}else {
					writeCell.setCellType(CellType.STRING);
					writeCell.setCellValue((String)mapper.getDefaltValue());
				}
				continue;
			}
			Cell cell = row.getCell(mapper.getSrcId());
			if(null == cell){
//				String value = cell.getStringCellValue();
				String defaultValue = null == mapper.getDefaltValue()?"":mapper.getDefaltValue().toString();
				writeRow.createCell(mapper.getDescId()).setCellValue(defaultValue);
				continue;
			}
			if(cell.getCellType() == 0){
				Double value = cell.getNumericCellValue();
				writeRow.createCell(mapper.getDescId()).setCellValue(null == value?(Double) mapper.getDefaltValue(): value );
			}else {
				String value = cell.getStringCellValue();
				writeRow.createCell(mapper.getDescId()).setCellValue(null == value? (String) mapper.getDefaltValue():value );
			}
		}
		return writeRow;
	}

	private static Sheet addTitles(Sheet sheet, String[] titles) {
		Row firstRow = sheet.createRow(0); 
		for(int i =0;i<titles.length;i++){
			firstRow.createCell(i).setCellValue(titles[i]);
		}
		return sheet;
	}
}
