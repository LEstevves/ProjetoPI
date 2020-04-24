package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstufaDAO;
import model.Estufa;

/**
 * Servlet implementation class ListarPlantas
 */
@WebServlet("/ListarPlantas")
public class ListarPlantas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPlantas() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EstufaDAO es = new EstufaDAO();
		List<Estufa> lista;
		lista = es.getLista();
		request.setAttribute("lista", lista);
		
		RequestDispatcher listar = 
		request.getRequestDispatcher("listaPlantas.jsp");
		listar.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
		
	}

}
