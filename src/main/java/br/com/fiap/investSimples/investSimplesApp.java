package br.com.fiap.investSimples;


import java.util.List;

import br.com.fiap.investSimples.dao.EntradaDao;

import br.com.fiap.investSimples.model.JavaBeans;

public class investSimplesApp {

	public static void main(String[] args) {

		JavaBeans entrada = new JavaBeans();

		entrada.setTipo("Salario");
		entrada.setDescricao("Salario Ref. Setembro");
//		Date date = new Date();
//		java.sql.Date sqldate = new java.sql.Date(date.getTime());
//		entrada.setDataLancamento();
		entrada.setValor(2500.0);
		entrada.setCliente(1);

		EntradaDao entDao = new EntradaDao();

//		entDao.NovaEntrada(entrada);

		//entDao.buscarEntradaPorId(1);

		 List<JavaBeans> ent = entDao.listarEntradas();

		for (JavaBeans selectEntrada : ent) {
			System.out.println(selectEntrada);
		}
		

	}

}
