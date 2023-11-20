package br.com.fiap.investSimples.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.fiap.investSimples.model.JavaBeans;


public class EntradaDao {
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private static final String USER = "rm99073";
	private static final String PASS = "280585";

	
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return null;
		}
		
	}
	
	
	// Adicionar nova entrada
	public void NovaEntrada(JavaBeans entrada) {

		String create = "INSERT INTO T_ENTRADAS (id_entrada, dt_entrada, nr_valor_entrada, nm_tipo_entrada, nm_desc_entrada, t_cliente_id_cliente)"
				+ "VALUES (SQ_ENTRADAS.nextval, ?, ?, ?, ?, 1)";

		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(create);

			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			ps.setDate(1, data);
			ps.setDouble(2, entrada.getValor());
			ps.setString(3, entrada.getTipo());
			ps.setString(4, entrada.getDescricao());
			//ps.setInt(5, entrada.getCliente());

			ps.executeUpdate();
			ps.close();
			con.close();

			System.out.println("Lançamento de entrada concluído com sucesso.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro de SQL");
		}

	}
	
	// Listar Entradas - CRUD READ
	public ArrayList<JavaBeans> listarEntradas() {
		ArrayList<JavaBeans> listaEntrada = new ArrayList<>();
		String read = "SELECT * FROM T_ENTRADAS ORDER BY ID_ENTRADA";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(read);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				Date dt_entrada = rs.getDate(2);
				double valor = rs.getDouble(3);
				String tipo = rs.getString(4);
				String descricao = rs.getString(5);
				int idcliente = rs.getInt(6);

				listaEntrada.add(new JavaBeans(id, dt_entrada, valor, tipo, descricao, idcliente));
			}
			con.close();

			return listaEntrada;

		} catch (Exception e) {

			System.out.println(e);

			return null;
		}
	}

}
