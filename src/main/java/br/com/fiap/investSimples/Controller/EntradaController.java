package br.com.fiap.investSimples.Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.investSimples.dao.EntradaDao;
import br.com.fiap.investSimples.model.JavaBeans;
import br.com.fiap.investSimples.util.TrocaParser;

@WebServlet("/novaEntrada")
public class EntradaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EntradaDao entradaDao = new EntradaDao();
	
	JavaBeans entradas = new JavaBeans();

	public EntradaController() {
		super();

		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		novaEntrada(request,response);
	}
	
	// Nova Entrada
	
	
	  protected void novaEntrada(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
	  
	  // Variáveis de Entrada
	  
	  entradas.setTipo(request.getParameter("tipo"));
	  entradas.setDescricao(request.getParameter("descricao"));
	  entradas.setValor(TrocaParser.parseBrazilianCurrency(request.getParameter("valor"))); 
	  entradaDao.NovaEntrada(entradas);
	  
	  response.sendRedirect("Entrada-Lista.jsp");
	  
	  }
	 
}
