package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Feed;
import model.Planta;
import model.Root;
import service.ThingSpeakService;
import service.VendedorService;

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
		String umidArMin = request.getParameter("umidArMin");
		String umidArMax = request.getParameter("umidArMax");
		
        Root dataInfoObject=ThingSpeakService.getDataInfo();
        String x = dataInfoObject.getFeeds().get(0).getField1();
        String umidAr = dataInfoObject.getFeeds().get(0).getField2();
        int xumidAr = Integer.parseInt(umidAr);
        int y = Integer.parseInt(x);
        
        
        request.setAttribute("tempMin", tempMin);
        request.setAttribute("tempMax", tempMax);
        request.setAttribute("umidArMin", umidArMin);
        request.setAttribute("umidArMax", umidArMax);
        
        //sensores
        request.setAttribute("temp", y);
        request.setAttribute("umidAr", xumidAr);
        
        VendedorService vendedor = new VendedorService();
        ArrayList<Planta> lista = null;
        lista = vendedor.listarPlantas();
       
                
        HttpSession session = request.getSession();
        session.setAttribute("thingspeak", dataInfoObject);
        session.setAttribute("lista", lista);
        
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
