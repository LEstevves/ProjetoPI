package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estufa;
import service.EstufaService;

/**
 * Servlet implementation class ManterEstufaController
 */
@WebServlet("/ManterEstufaController")
public class ManterEstufaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String tempMin = request.getParameter("tempMin");
		String tempMax = request.getParameter("tempMax");
		String umidArMin = request.getParameter("umidArMin");
		String umidArMax = request.getParameter("umidArMax");
		String umidSoloMin = request.getParameter("umidSoloMin");
		String umidSoloMax = request.getParameter("umidSoloMax");
		
		//instanciar o javabean
		Estufa estufa = new Estufa();
		estufa.setNome(nome);
		estufa.setTempMin(tempMin);
		estufa.setTempMax(tempMax);
		estufa.setUmidArMin(umidArMin);
		estufa.setUmidArMax(umidArMax);
		estufa.setUmidSoloMin(umidSoloMin);
		estufa.setUmidSoloMax(umidSoloMax);
				
		//instanciar o service
		EstufaService es = new EstufaService();
		es.criar(estufa);
		estufa = es.carregar(estufa.getId());
		
		  //enviar para o jsp
        request.setAttribute("estufa", estufa);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Estufa.jsp");
        view.forward(request, response);
		
	}

}
