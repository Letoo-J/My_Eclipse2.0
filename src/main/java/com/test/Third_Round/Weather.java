package com.test.Third_Round;
import java.util.Arrays;
import java.util.List;
 
/***Excel需要的:
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
***/

 

public class Weather {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*从Excel中读取idCity~~~~(全部城市):
		File file = new File("D:\\AMap_adcode_citycode.xlsx");
		InputStream is = new FileInputStream(file);
		Workbook excel = WorkbookFactory.create(is);
		Sheet sheet = excel.getSheetAt(0);
		//遍历所有行
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                continue;
            }
       
            Cell cell1 = row.getCell(1);           
            Cell cell2 = row.getCell(2);
            if(cell2!=null) {
            	String idCity=cell1.getStringCellValue();
        		identityCheck(idCity);
            }
            
        } ****/
		
		
		//创建省会、直辖市的字符串list：（27个，台北市没有，用台湾省代替）
		List<String> city = Arrays.asList("石家庄市","沈阳市","哈尔滨市","杭州市","福州市","济南市","广州市","武汉市",
				"成都市","昆明市","兰州市","台湾省","太原市","长春市","南京市","合肥市","南昌市","郑州市","长沙市",
				"海口市","贵阳市","西安市","西宁市","北京市","天津市","上海市","重庆市");
		
		del(city);  //清空表!
		add(city);  //存入数据库
		for(String _str:city) {  //输出数据库
			find(_str);
		}
		
		DbUtil.delCityWeather2("重庆市");
		
		update(city);
		for(String _str:city) {  //输出数据库
			find(_str);
		}
		
		
	}
	
	//把从API获得的数据加入数据库中去
	public static void add(List<String> ID) {
		for(String _str:ID) {
			String idCity=_str;
			List<IdentityResults> foreList=Check.identityCheck(idCity);
			
			int i=0;   //对应数据库"count"列
			for(IdentityResults obj:foreList) {
				DbUtil.addCityWeather(obj,++i);  //加入数据库weather的表forecasts中
            }
		}
	}
	
	//删除整个表
	public static void del(List<String> ID) {
		DbUtil.delAll();
	}
	
	//更新整个表
	public static void update(List<String> ID) {
		for(String _str:ID) {
			String idCity=_str;
			DbUtil.updateCityWeather(idCity);
		}
	}
	
	//查询某个城市几天的天气预报
	public static void find(String city) {
		List<IdentityResults> foreList=DbUtil.findCityWeatherList(city);
		//输出查询:
		for(IdentityResults id:foreList) {
        	System.out.println(id);   //需自定义toString()方法
        }
	}
}
