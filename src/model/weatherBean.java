package model;
public class weatherBean {

	private String cityStr;
	private String countryStr;
	private String cloudsStr;
	
	////new
	private String tmprtrStr;
	private String wndSpeedStr;

	
	public weatherBean(String cityStr, String countryStr) {
		this.cityStr = cityStr;
		this.countryStr = countryStr;
	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}
	
	public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}
		

	
	/////////////////////////////
	public String gettmprtrStr() {
		return tmprtrStr;
	}
	
	public void settmprtrStr(String tmprtrStr) {
		this.tmprtrStr = tmprtrStr;
	}
			
	/////////////////////////////
	public String getwndSpeedStr() {
		return tmprtrStr;
	}
	
	public void setwndSpeedStr(String wndSpeedStr) {
		this.wndSpeedStr = wndSpeedStr;
	}
		
		
		
		
}