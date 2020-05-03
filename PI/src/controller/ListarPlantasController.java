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

import model.Planta;
import service.VendedorService;

/**
 * Servlet implementation class ListarPlantasController
 */
@WebServlet("/listar_plantas.do")
public class ListarPlantasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   /* public ListarPlantasController() {
        super();
        // TODO Auto-generated constructor stub
    }
*/
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");
		String acao = request.getParameter("acao");
		VendedorService vendedor = new VendedorService();
		ArrayList<Planta> lista = null;
		HttpSession session = request.getSession();
		if (acao.equals("buscar")) {
			if (chave != null && chave.length() > 0) {
				lista = vendedor.listarPlantas(chave);
			} else {
				lista = vendedor.listarPlantas();
			}
			session.setAttribute("lista", lista);
		} else if (acao.equals("reiniciar")) {
			session.setAttribute("lista", null);
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarPlantas.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);		
	}

}
