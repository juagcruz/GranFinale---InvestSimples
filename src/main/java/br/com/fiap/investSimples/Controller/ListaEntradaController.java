package br.com.fiap.investSimples.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.investSimples.dao.EntradaDao;
import br.com.fiap.investSimples.model.JavaBeans;


@WebServlet("/listaEntrada")
public class ListaEntradaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EntradaDao listaEntrada = new EntradaDao();
	
	JavaBeans lista = new JavaBeans();

	public ListaEntradaController() {
		super();
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		listarEntrada(request,response);
	}
	
	// Listas Entradas
	
	protected void listarEntrada(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		  ArrayList<JavaBeans> listaEnt = listaEntrada.listarEntradas();
		  request.setAttribute("listaEntradas", listaEnt);
		  System.out.println("Teste");
		  System.out.println(request.getSession().getAttribute("listaEntradas"));
		  RequestDispatcher rd = request.getRequestDispatcher("Entrada-Lista.jsp");
		  rd.forward(request, response);			
	}
	 
}
