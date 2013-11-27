package com.codeholic.business.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.codeholic.pojos.jpa.StoreInfo;

public class ExcelHandler<T> {

	private Class<T> cls;
	//字段名
	private String[] fields;
	//字段对象
	private Field[] fieldsObj;
	//不要求excel文档按照字段声明顺序填写，程序负责获取对应的字段下标
	private int[] currentIndex;

	//字段名所在行号
	private final int FIELD_NAME_ROW_INDEX = 0;
	//记录内容开始所在行号
	private final int CONTENT_START_ROW_INDEX = 2;
	//setter 方法的前缀
	private final String SETTER_METHOD_PREFIX = "set";

	public ExcelHandler(Class<T> cls) {
		this.cls = cls;
		analyseFields();
	}

	private void analyseFields() {
		Field[] tempFields = cls.getDeclaredFields();
		ArrayList<Field> fieldlist = new ArrayList<Field>();
		for(Field field : tempFields){
			if(!field.getName().equals("serialVersionUID")){
				fieldlist.add(field);
			}
		}
		fieldsObj = fieldlist.toArray(new Field[0]);
		fields = new String[fieldsObj.length];
		for (int i = 0; i < fieldsObj.length; i++) {
			fields[i] = fieldsObj[i].getName();
			
		}
		System.out.println(Arrays.toString(fields));
	}

	/*
	 * 获取一个demo excel文件，程序根据泛型class构建sheet
	 */
	public boolean writeExcel(String fileName) {
		WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(new File(fileName));
		} catch (IOException exception) {
			exception.printStackTrace();
			return false;
		}

		if (workbook != null) {
			WritableSheet writableSheet = workbook
					.createSheet(cls.getSimpleName(), 0);
			for (int i = 0; i < fields.length; i++) {
				Label label = new Label(i, 0, fields[i]);
				try {
					writableSheet.addCell(label);
				} catch (Exception exception) {
					exception.printStackTrace();
					return false;
				}
			}
			try {
				workbook.write();
				workbook.close();
			} catch (Exception exception) {
				exception.printStackTrace();
				return false;
			}
		}

		return true;
	}

	/*
	 * 读取excel文件，并生成对象的list
	 */
	public List<T> readExcel(File file) throws IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			InstantiationException, ParseException {
		Workbook wb = null;

		try {
			wb = Workbook.getWorkbook(file);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		if (wb == null) {
			return null;
		}

		Sheet[] sheets = wb.getSheets();

		List<T> list = new ArrayList<T>();

		if (sheets != null && sheets.length > 0) {
			for (int i = 0; i < sheets.length; i++) {

				Cell[] headerCells = sheets[i].getRow(FIELD_NAME_ROW_INDEX);
				currentIndex = new int[sheets[i].getColumns()];
				for (int j = 0; j < headerCells.length; j++) {
					currentIndex[j] = -1;
					for (int k = 0; k < fields.length; k++) {
						if (headerCells[j].getContents().equals(fields[k])) {
							currentIndex[j] = k;
							break;
						}
					}
				}
				
				System.out.println(Arrays.toString(currentIndex));

				int rowNum = sheets[i].getRows();

				for (int j = CONTENT_START_ROW_INDEX; j < rowNum; j++) {
					T t = cls.newInstance();
					Cell[] cells = sheets[i].getRow(j);
					if (cells != null && cells.length > 0) {
						for (int k = 0; k < cells.length; k++) {
							if (currentIndex[k] == -1) {
								continue;
							}

							String fieldName = fields[currentIndex[k]];

							Field currentField = fieldsObj[currentIndex[k]];
							Object currentContent = typeParser(cells[k].getContents(), currentField.getType().getName());
							
							if(currentContent==null){
								continue;
							}
							
							cls.getMethod(
									SETTER_METHOD_PREFIX
											+ Character.toUpperCase(fieldName
													.charAt(0))
											+ fieldName.substring(1),
									currentField.getType())
									.invoke(t, currentContent);

						}
					}
					list.add(t);
				}
			}
		}
		wb.close();
		return list;
	}
	
	private Object typeParser(String cellContent, String typeName) throws ParseException{
		Object currentContent;
		
		if(typeName.equals("int")){
			currentContent = Integer.valueOf(cellContent);
		}else if(typeName.equals("double")){
			currentContent = Double.valueOf(cellContent);
		}else if(typeName.equals("byte")){
			currentContent = Byte.valueOf(cellContent);
		}else if(typeName.equals("char")){
			currentContent = cellContent.charAt(0);
		}else if(typeName.equals("boolean")){
			currentContent = Boolean.valueOf(cellContent);
		}else if(typeName.equals("long")){
			currentContent = Long.valueOf(cellContent);
		}else if(typeName.equals("short")){
			currentContent = Short.valueOf(cellContent);
		}else if(typeName.equals("float")){
			currentContent = Float.valueOf(cellContent);
		}else if(typeName.equals("java.util.Date")){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			currentContent = format.parse(cellContent);
		}else if(typeName.equals("java.lang.String")){
			currentContent = cellContent;
		}else {
			try{
				@SuppressWarnings("rawtypes")
				Class clazz = Class.forName(typeName);
				Object object = clazz.newInstance();
				for(Method method : clazz.getMethods()){
					if(method.getName().endsWith("Id")&&method.getName().startsWith("set")){
						method.invoke(object, cellContent);
					}
				}
				currentContent = object;
			}catch(Exception exception){
				System.out.println(typeName+"：未识别的类型");
				currentContent = null;
			}
			
			
		}
		
		return currentContent;
	}
	
	public static void main(String[] args) {
		ExcelHandler<StoreInfo> handler = new ExcelHandler<StoreInfo>(StoreInfo.class);
		//handler.writeExcel("C:\\Users\\赫\\Desktop\\test.xls");
		File file = new File("C:\\Users\\赫\\Desktop\\test.xls");
		
		try {
			List<StoreInfo> list = handler.readExcel(file);
			for(StoreInfo good : list){
				System.out.println(good.toString());
			}
		} catch(Exception exception){
			exception.printStackTrace();
		}
		
	}


}
