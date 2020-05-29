package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Feed;
import model.Root;
import service.ThingSpeakService;

/**
 * Servlet implementation class ThingspeakController
 */
@WebServlet("/ThingspeakController")
public class ThingspeakController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThingspeakController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tempMin = request.getParameter("tempMin");
		String tempMax = request.getParameter("tempMax");
        Root dataInfoObject=ThingSpeakService.getDataInfo();
        dataInfoObject.getFeeds().get(0).getField1();
        request.setAttribute("tempMin", tempMin);
        request.setAttribute("tempMax", tempMax);
        request.setAttribute("temp", dataInfoObject.getFeeds().get(0).getField1());
        
        HttpSession session = request.getSession();
        session.setAttribute("thingspeak", dataInfoObject);
        
        RequestDispatcher dispatcher = request
				.getRequestDispatcher("Alerta.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
