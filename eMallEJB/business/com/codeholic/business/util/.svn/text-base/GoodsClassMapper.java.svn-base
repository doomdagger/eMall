package com.codeholic.business.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class GoodsClassMapper {

	private static Connection connection = null;
	static{
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emall?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;mysqlEncoding=utf8", "root", "911119");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private ArrayList<String> cacheClassTwoNames;
	private ArrayList<String> cacheClassTwoTypes;
	private ArrayList<GoodsClassMapper.ClassOne> classOnes;

	public static void main(String[] args) {
		GoodsClassMapper mapper = new GoodsClassMapper();
		// //
		// mapper.fillClassOnes("D:\\Developer\\TDDOWNLOAD\\商品目录\\超市商品分类表.xls");
		// // for(ClassOne classOne : mapper.classOnes){
		// //
		// System.out.println(classOne.getClassName()+"  "+classOne.getClassType());
		// // for(String string : classOne.getClassTwoNames()){
		// // System.out.println("\t"+string);
		// // }
		// // }
		// mapper.fillCacheClassTwoNames();
		// for(String string : mapper.cacheClassTwoNames){
		// System.out.println(string);
		// }
		
		mapper.analyse("D:\\Developer\\TDDOWNLOAD\\商品目录\\超市商品分类表.xls");
		for(int i = 0; i < mapper.cacheClassTwoNames.size(); i++){
			System.out.println(mapper.cacheClassTwoNames.get(i)+"\t"+mapper.cacheClassTwoTypes.get(i));
		}
		
		Set<String> set = new HashSet<String>();
		set.addAll(mapper.cacheClassTwoNames);
		
		System.out.println(set.size());
	}

	public void analyse(String fileName){
		this.fillCacheClassTwoNames();
		this.fillClassOnes(fileName);
		
		boolean isFind = false;
		
		for(String classTwoNameString : cacheClassTwoNames){
			for(ClassOne classOne : classOnes){
				for(String otherClassTwoNames : classOne.getClassTwoNames()){
					if(alike(classTwoNameString, otherClassTwoNames)){
						cacheClassTwoTypes.add(classOne.getClassName());
						isFind = true;
						break;
					}
				}
				if(isFind){
					break;
				}
			}
			if(isFind){
				isFind = false;
			}else{
				cacheClassTwoTypes.add("***NULL***");
			}
		}
	}
	
	
	public GoodsClassMapper() {
		this.cacheClassTwoNames = new ArrayList<String>();
		this.classOnes = new ArrayList<GoodsClassMapper.ClassOne>();
		this.cacheClassTwoTypes = new ArrayList<String>();
	}

	public boolean fillClassOnes(String fileName) {
		File file = new File(fileName);

		Workbook workbook = null;

		try {
			workbook = Workbook.getWorkbook(file);
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

		if (workbook != null) {
			Sheet[] sheets = workbook.getSheets();
			if (sheets != null && sheets.length > 0) {
				for (int i = 0; i < sheets.length; i++) {
					Sheet sheet = sheets[i];
					int rowNumer = sheet.getRows();
					String currentType = null;
					ClassOne currentClassOne = null;
					for(int j = 1; j < rowNumer; j++){
						Cell[] cells = sheet.getRow(j);
						if(cells[1]!=null&&!cells[1].getContents().equals("")){
							currentType = cells[1].getContents();
						}
						if(cells[3]!=null&&!cells[3].getContents().equals("")){
							currentClassOne = new ClassOne(cells[3].getContents());
							currentClassOne.setClassType(currentType);
							this.classOnes.add(currentClassOne);
						}
						currentClassOne.addClassTwoName(cells[5].getContents());
					}
				}
			}
			
			workbook.close();
		}
		
		return true;
	}

	public boolean fillCacheClassTwoNames() {
		if(connection==null)
			return false;
		
		PreparedStatement ps = null;
		String sql = "SELECT GCLASS2_NAME FROM goodsclass2";
		ResultSet resultSet = null;
		try{
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while(resultSet.next()){
				cacheClassTwoNames.add(resultSet.getString(1));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		return true;
	}

	private boolean alike(String str1, String str2){
		for(int i = 2; i <= str1.length(); i++){
			String snippet = str1.substring(i-2, i);
			if(str2.contains(snippet)){
				return true;
			}
		}
		return false;
	}
	
	class ClassOne {
		private String className;
		private ArrayList<String> classTwoNames;
		private String classType;
		public ClassOne(String className) {
			this.className = className;
			this.classTwoNames = new ArrayList<String>();
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public ArrayList<String> getClassTwoNames() {
			return classTwoNames;
		}

		public void addClassTwoName(String name) {
			classTwoNames.add(name);
		}

		public void addClassTwoNames(List<String> names) {
			classTwoNames.addAll(names);
		}

		public String getClassType() {
			return classType;
		}

		public void setClassType(String classType) {
			this.classType = classType;
		}
		
	}

}
