package com.test.Third_Round;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DbUtil {
    /**
	 * 取得数据库的连接
	 * @return 一个数据库的连接
	 */
	public static Connection getConnection(){
		Connection conn = null;
		 try {
			 	//初始化驱动类com.mysql.jdbc.Driver
			 	//"jdbc:mysql://127.0.0.1:3306/weather?characterEncoding=UTF-8"
			 	//"jdbc:mysql://127.0.0.1:3306/weather?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT12"
			 	String url="jdbc:mysql://127.0.0.1:3306/weather?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=GMT";
	            Class.forName("com.mysql.cj.jdbc.Driver");    
	            conn = DriverManager.getConnection(url,"root", "123456");  //~~~~~~~
	            //该类就在 mysql-connector-java-5.0.8-bin.jar中,如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
	        } catch (ClassNotFoundException e) { 				
	            e.printStackTrace();
	        }catch (SQLException e) {							
	            e.printStackTrace();
	        }
		 return conn;
	}
	
    /**
	 * 添加某城市某天的天气
	 * @param IdentityResults对象：oneW, count)
	 */
	public static void addCityWeather(IdentityResults oneW,int count){
		//该语句为每个插入参数保留一个问号（“？”）作为占位符
		String sql = "insert into forecasts values(?,?,?,?,?,?,?,?,?,?,?)";  
		Connection conn = null;				//和数据库取得连接
		PreparedStatement pstmt = null;		//创建statement
		try{
			conn = DbUtil.getConnection();    //~~~~~~~~~
			pstmt = (PreparedStatement) conn.prepareStatement(sql);  //~~~~~~~~
			//给占位符赋值:
			pstmt.setString(1, oneW.getCity()); 
			pstmt.setString(2, oneW.getDate()); 
			pstmt.setString(3, oneW.getDayweather()); 
			pstmt.setInt(4, oneW.getDaytemp()); 
			pstmt.setString(5, oneW.getDaywind()); 
			pstmt.setString(6, oneW.getDaypower()); 
			pstmt.setString(7, oneW.getNightweather()); 
			pstmt.setInt(8, oneW.getNighttemp()); 
			pstmt.setString(9, oneW.getNightwind()); 
			pstmt.setString(10, oneW.getNightpower()); 
			pstmt.setInt(11, count); 
			//执行
			pstmt.executeUpdate();			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);		//必须关闭
		}
	}
	
    /**
	 * 删除某城市某天的天气数据
	 * @param city, date
	 */
	public static void delCityWeather1(String city, String date){
		String sql = "delete from forecasts where city = ? and date = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtil.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			//给占位符赋值:
			pstmt.setString(1, city);
			pstmt.setString(2, date);
			//执行:
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);		//必须关闭
		}
	}
	
	public static void delCityWeather2(String city){
		String sql = "delete from forecasts where city = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtil.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			//给占位符赋值:
			pstmt.setString(1, city);
			//执行:
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);		//必须关闭
		}
	}
	
	public static void delAll(){   //删除整个表!~~
		String sql = "delete from forecasts ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtil.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			//执行:
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);		//必须关闭
		}
	}
	
    /**
	 * 更新某个城市的天气预报（数组）
	 * @param idCity
	 */
	public static void updateCityWeather(String idCity){
		String sql = "update forecasts set date=?,dayweather=?,daytemp=?,daywind=?,daypower=?,"
				+ "nightweather=?,nighttemp=?,nightwind=?,nightpower=? where city= ? and count= ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtil.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			List<IdentityResults> foreList=Check.identityCheck(idCity); //通过API获取此城市的天气预报List
			
			int i=0;
			for(IdentityResults obj:foreList) {
				//给占位符赋值:
				pstmt.setString(1, obj.getDate()); 
				pstmt.setString(2, obj.getDayweather()); 
				pstmt.setInt(3, obj.getDaytemp()); 
				pstmt.setString(4, obj.getDaywind()); 
				pstmt.setString(5, obj.getDaypower()); 
				pstmt.setString(6, obj.getNightweather()); 
				pstmt.setInt(7, obj.getNighttemp()); 
				pstmt.setString(8, obj.getNightwind()); 
				pstmt.setString(9, obj.getNightpower()); 
				pstmt.setString(10, idCity); 
				pstmt.setInt(11, ++i); 
				//执行：
				pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);		//必须关闭
		}
	}
	
    /**
	 * 查询某个城市的未来几天的天气预报
	 * @return List<IdentityResults>
	 */
	public static List<IdentityResults> findCityWeatherList(String idCity){
		String sql = "select * from forecasts where city=? order by count";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;  //执行查询语句，并把结果集返回给集合ResultSet
		//创建一个集合对象用来存放查询到的数据
		List<IdentityResults> foreList = new ArrayList<>();
		
		try {
			conn = DbUtil.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			//给占位符赋值:
			pstmt.setString(1, idCity);
			//执行：（结果存在一个List里面）
			rs = (ResultSet) pstmt.executeQuery();
			
			while (rs.next()){  //遍历查询结果List
				int num;
				String _str;
				
				IdentityResults temp=new IdentityResults();  //建一个临时IdentityResults对象来存其中一天的天气数据
                temp.setCity(idCity);
                
				_str=rs.getString("date");
				temp.setDate(_str);
				
				_str=rs.getString("dayweather");
				temp.setDayweather(_str);
				
				num=rs.getInt("daytemp");
				temp.setDaytemp(num);
				
				_str=rs.getString("daywind");
				temp.setDaywind(_str);
				
				_str=rs.getString("daypower");
				temp.setDaypower(_str);
				
				_str=rs.getString("nightweather");
				temp.setNightweather(_str);
				
				num=rs.getInt("nighttemp");
				temp.setNighttemp(num);
				
				_str=rs.getString("nightwind");
				temp.setNightwind(_str);
				
				_str=rs.getString("nightpower");
				temp.setNightpower(_str);
				
				//将对象放到集合中
				foreList.add(temp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);		//必须关闭
		}
		return foreList;
	}
		
	
	
	/**
	 * 封装三个关闭方法
	 * @param pstmt
	 */
	public static void close(PreparedStatement pstmt){
		if(pstmt != null){						//避免出现空指针异常
			try{
				pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
	}
	
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}
