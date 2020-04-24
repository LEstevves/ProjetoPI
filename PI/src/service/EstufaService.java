package service;

import dao.EstufaDAO;
import model.Estufa;


public class EstufaService {


		
		public void criar(Estufa estufa) {
			EstufaDAO.criar(estufa);
		}
		
		public void atualizar(Estufa estufa){
			EstufaDAO.atualizar(estufa);
		}
		
		public void excluir(int id){
			EstufaDAO.excluir(id);
		}
		
		public Estufa carregar(int id){
			return EstufaDAO.carregar(id);
		}
		

	}
	

