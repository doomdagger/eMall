package com.codeholic.business.util;

import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.codeholic.eao.UUIDGenerator;

public class GoodsBrandExtractor {
	private ArrayList<String> goodsNames;
	private ArrayList<String> goodsBrands;

	private int ADD_COLUMN_INDEX = 7;
	private int GOODS_NAME_COLUMN_INDEX = 2;
	private int CONTENT_START_ROW_INDEX = 2;
	private String fileName;
	
	
	public void configExtractor(int addColumnAt, int goodsNameColumn, int contentStartRow){
		this.ADD_COLUMN_INDEX = addColumnAt;
		this.GOODS_NAME_COLUMN_INDEX = goodsNameColumn;
		this.CONTENT_START_ROW_INDEX = contentStartRow;
	}
	
	
	
	public ArrayList<String> getGoodsNames() {
		return goodsNames;
	}

	public void setGoodsNames(ArrayList<String> goodsNames) {
		this.goodsNames = goodsNames;
	}

	public ArrayList<String> getGoodsBrands() {
		return goodsBrands;
	}

	public void setGoodsBrands(ArrayList<String> goodsBrands) {
		this.goodsBrands = goodsBrands;
	}

	public GoodsBrandExtractor(String fileName) {
		goodsNames = new ArrayList<String>();
		goodsBrands = new ArrayList<String>();
		this.fileName = fileName;
	}

	public boolean readExcel() {
		File file = new File(fileName);
		if (!file.exists()) {
			return false;
		}

		goodsNames.clear();

		Workbook workbook = null;

		try {
			workbook = Workbook.getWorkbook(file);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		if (workbook == null) {
			return false;
		}

		Sheet[] sheets = workbook.getSheets();

		if (sheets != null && sheets.length > 0) {
			for (int i = 0; i < sheets.length; i++) {
				Cell[] cells = sheets[i].getColumn(GOODS_NAME_COLUMN_INDEX);
				for (int j = CONTENT_START_ROW_INDEX; j < cells.length; j++) {
					goodsNames.add(cells[j].getContents());
				}
			}
		}

		return true;

	}

	private String alike(String str1, String str2) {
		int i;
		for (i = str1.length(); i > 1; i--) {
			if (str2.startsWith(str1.substring(0, i))) {
				break;
			}
		}

		if (i == 1) {
			return null;
		} else {
			return str1.substring(0, i);
		}
	}

	public void extractBrands() {
		goodsBrands.clear();

		ArrayList<String> cache = new ArrayList<String>();
		String currentCacheBrand = "";

		ListIterator<String> iterator = goodsNames.listIterator();
		while (iterator.hasNext()) {
			String string = iterator.next();
			if (cache.size() == 0) {
				cache.add(string);
				currentCacheBrand = string;
			} else {
				String result = alike(currentCacheBrand, string);
				if (result == null) {
					for (int i = 0; i < cache.size(); i++) {
						goodsBrands.add(currentCacheBrand);
					}
					cache.clear();
					cache.add(string);
					currentCacheBrand = string;
				} else {
					currentCacheBrand = result;
					cache.add(string);
				}
			}

		}
		for (int i = 0; i < cache.size(); i++) {
			goodsBrands.add(currentCacheBrand);
		}
	}

	public boolean writeToExcel() {
		try {
			File file = new File(fileName);
			Workbook wb = Workbook.getWorkbook(file);
			WritableWorkbook workbook = Workbook.createWorkbook(file, wb);
			
			WritableSheet sheet = workbook.getSheet(0);
			
			for (int i = 0; i < goodsBrands.size(); i++) {
				sheet.addCell(new Label(ADD_COLUMN_INDEX, i+CONTENT_START_ROW_INDEX, goodsBrands.get(i)));
				sheet.addCell(new Label(ADD_COLUMN_INDEX + 1, i+CONTENT_START_ROW_INDEX, UUIDGenerator
						.randomUUID()));
			}

			workbook.write();
			workbook.close();
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean execute(){
		if(this.readExcel()){
			this.extractBrands();
			if(this.writeToExcel())
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		GoodsBrandExtractor extractor = new GoodsBrandExtractor("D:\\Developer\\TDDOWNLOAD\\商品目录\\超市商品资料1.xls");
		
		extractor.configExtractor(7, 1, 2);
		extractor.execute();
		
		//
		// extractor.readExcel();
		// // for(String string : extractor.getGoodsNames()){
		// // System.out.println(string);
		// // }
		// extractor.extractBrands();
		// // for (String string : extractor.getGoodsBrands()) {
		// // System.out.println(string);
		// // }
		//
		// extractor.writeToExcel();
	}

}
