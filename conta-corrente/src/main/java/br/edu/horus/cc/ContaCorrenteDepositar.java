package br.edu.horus.cc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/depositar/*"})
public class ContaCorrenteDepositar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getPathInfo();
		String[] dados = url.split("\\/");
		Double valor = Double.valueOf(dados[dados.length - 1]);
		String numero = dados[dados.length -2];
		System.err.println("Depositado valor " + valor + " conta " + numero);
	}
	
}
