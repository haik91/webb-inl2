<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@page import="model.weatherBean"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="styles.css">

<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>


	<%
	weatherBean wBean = (weatherBean) request.getAttribute("wBean");
	
	String  country = wBean.getCountryStr();
	String tempreture = wBean.gettmprtrStr();
	String windSPeed = wBean.getwndSpeedStr();
	String cloud = wBean.getCloudsStr();


	
	
	%>



<div class="grid-container">
  <div class="item1">
      <h1>the weather in <%out.print(wBean.getCityStr()); %></h1>
      <p> </p>
  </div>

  <div class="item3"> Summarize 
  
    <div class="grid-container2">
      <div> Country:  <% out.print(country);%>
      </div>
   
      <div>tempreture: <%out.print(tempreture); %>  kelvin</div>
   
      <div> clouds:  <%out.print(cloud); %></div>  
  
   
    </div>

  </div>  
 
  <div class="item5">
    last  visited:  
    <%out.print(request.getAttribute("cityCookie")+","+
    		request.getAttribute("countryName")+"...... tempretur was:  "+
    		request.getAttribute("cityTemp")+" kelvin and the  weather was:"+
    		request.getAttribute("cloudstatus")+" ");  %>
  </div>
</div>

		
</body>
</html>