package com.test.Third_Round;

public class IdentityResults {  //用于存放每天的天气数据
	private String city;
	private String date;
	private String dayweather;
	private int daytemp;
	private String daywind;
	private String daypower;
	private String nightweather;
	private int nighttemp;
	private String nightwind;
	private String nightpower;
	
/***********************************get()***********************************/
	public String getCity() {
		return city;
	}
	public String getDate() {
		return date;
	}
	public String getDayweather() {
		return dayweather;
	}
	public int getDaytemp() {
		return daytemp;
	}
	public String getDaywind() {
		return daywind;
	}
	public String getDaypower() {
		return daypower;
	}
	public String getNightweather() {
		return nightweather;
	}
	public int getNighttemp() {
		return nighttemp;
	}
	public String getNightwind() {
		return nightwind;
	}
	public String getNightpower() {
		return nightpower;
	}
	
/***********************************set()***********************************/
	public void setCity(String city) {
		this.city = city;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setDayweather(String dayweather) {
		this.dayweather = dayweather;
	}
	public void setDaytemp(int daytemp) {
		this.daytemp = daytemp;
	}
	public void setDaywind(String daywind) {
		this.daywind = daywind;
	}
	public void setDaypower(String daypower) {
		this.daypower = daypower;
	}
	public void setNightweather(String nightweather) {
		this.nightweather = nightweather;
	}
	public void setNighttemp(int nighttemp) {
		this.nighttemp = nighttemp;
	}
	public void setNightwind(String nightwind) {
		this.nightwind = nightwind;
	}
	public void setNightpower(String nightpower) {
		this.nightpower = nightpower;
	}
	
	@Override
    public String toString() {
        return "Weather [city=" + city + ", date=" + date + ", dayweather=" + dayweather + ", daytemp="+daytemp+"]";
    }
	
}
