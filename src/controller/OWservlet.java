package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GettheWeather;
import model.weatherBean;

/**
 * Servlet implementation class OWservlet
 */
@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OWservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");

		weatherBean wBean = new weatherBean(cityStr, countryStr);

		GettheWeather.getWeather(wBean);

		

		request.setAttribute("wBean", wBean);
		
		
		///get saved cookies
		Cookie arr[] = request.getCookies();
		//test print
		
		/*
		for(Cookie cc : arr) {
			System.out.println(cc.getValue());
		}
		
	*/
		
		
		if(arr!= null) {
			request.setAttribute("cityCookie", arr[0].getValue());
			request.setAttribute("countryName", arr[1].getValue());
			request.setAttribute("cityTemp", arr[2].getValue());
			request.setAttribute("cloudstatus", arr[3].getValue());
		
		}
		
		
		
		
		/// save seached  city in a cookie 
		Cookie cityCookie = new Cookie("cityname", wBean.getCityStr().replace(' ', '-'));
		Cookie countryCookie = new Cookie("countryName", wBean.getCountryStr());
		Cookie tempCookie = new Cookie("cityTemp", wBean.gettmprtrStr());
		
		String cloudtocookieValue = wBean.getCloudsStr().replace(' ', '-');
	    Cookie cloud = new Cookie("cloudstatus", cloudtocookieValue);

		
		response.addCookie(cityCookie);
		response.addCookie(countryCookie);
		response.addCookie(tempCookie);
      	response.addCookie(cloud);

		
		RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
		rd.forward(request, response);

	}
}