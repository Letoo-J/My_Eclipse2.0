package com.test.Third_Round;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Check {
	
	/**
	 * 聚合接口校验身份证
	 * @param idCity
	 * @return void
	 */
	@SuppressWarnings("finally")
	public static List<IdentityResults> identityCheck(String idCity){
		String key = "4c203be90335bba46f3e725432599061";
		String url = "https://restapi.amap.com/v3/weather/weatherInfo?" + "key=" + key + "&city=" + idCity + "&extensions=all";
		List<IdentityResults> finalForeList=null;
		
		try {
			String result = HttpClientUtil.doGet(url);  //进行get请求返回结果
			//System.out.println("请求结果：" + result);
			
			//对从取接口得的结果进行解析：
			if(result!=null){  
	            JSONObject obj=JSONObject.fromObject(result); 
	            result=obj.getString("status");   //得到返回状态码  
	            if(result!=null&&result.equals("1")){  //status:1表示成功返回数据  	                
	                JSONArray forecast = obj.getJSONArray("forecasts"); //得到预报天气信息数据数组
	                JSONObject fore = forecast.getJSONObject(0);  //得到forecast数组中的唯一一个JSON数据 
	                String city=fore.getString("city"); //获得城市
	                JSONArray casts = fore.getJSONArray("casts"); //得到预报数据数组
	                	                
	                List<IdentityResults> foreList = new ArrayList<>(); //用于存储四天的天气数据
	                for(Object o:casts){   //对预报数据JSON-list进行遍历 (一共四天)
	                    //对数组中的一个JSON个数字符串进行解析  
	                    obj=JSONObject.fromObject(o.toString()); //将数组成员变为一个JSON数据 
	                    /*此时obj如 JSON{"id":"2","province":"北京","city":"北京","district":"海淀"}*/  
	                    
	                    IdentityResults temp=new IdentityResults();  //建一个临时IdentityResults对象来存其中一天的天气数据
	                    temp.setCity(city);
	                    
	                    result=obj.getString("date");   //得到JSON的date 
	                    temp.setDate(result);
	                    
	                    
	                    result=obj.getString("dayweather");   
	                    temp.setDayweather(result);
	                    
	                    result=obj.getString("daytemp");  
	                    temp.setDaytemp(Integer.valueOf(result));
	                    
	                    result=obj.getString("daywind");  
	                    temp.setDaywind(result);
	                    
	                    result=obj.getString("daypower");   
	                    temp.setDaypower(result);
	                    
	                    result=obj.getString("nightweather");  
	                    temp.setNightweather(result);
	                    
	                    result=obj.getString("nighttemp");   
	                    temp.setNighttemp(Integer.valueOf(result));
	                    
	                    result=obj.getString("nightwind");   
	                    temp.setNightwind(result);
	                    
	                    result=obj.getString("nightpower");   
	                    temp.setNightpower(result);
	                    
	                    foreList.add(temp);  //将构建好的每一个天气对象放入预报List中去	               
	                }  
	                
	                /*输出检验：
	                for(IdentityResults id:foreList) {
	                	System.out.println(id);   //需自定义toString()方法
	                }*/
	                finalForeList=foreList;
	            }  
	        } 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return finalForeList;
	    }
		
	}
}
