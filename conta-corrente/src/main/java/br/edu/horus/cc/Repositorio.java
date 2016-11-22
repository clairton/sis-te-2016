package br.edu.horus.cc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Repositorio {
	private Connection conexao;
	
	public Repositorio(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void salvar(Conta conta){
		String sql = "INSERT INTO contas (numero, saldo) VALUES (?, ?)";
		try{
			PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, conta.getNumero());
			statement.setDouble(2, conta.getSaldo());
			statement.executeUpdate();
			
			//recupera o id de conta gerado pelo banco
			ResultSet result = statement.getGeneratedKeys();
			if(result.next()){
				conta.setId(result.getInt(1));
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void salvar(Movimento movimento) {
		String sql = "INSERT INTO movimentos (valor, conta_id, criado_em) VALUES (?, ?, ?)";
		try{
			PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setDouble(1, movimento.getValor());
			statement.setInt(2, movimento.getConta().getId());
			statement.setDate(3, new java.sql.Date(movimento.getCriadoEm().getTime()));
			statement.executeUpdate();
			
			//recupera o id de conta gerado pelo banco
			ResultSet result = statement.getGeneratedKeys();
			if(result.next()){
				movimento.setId(result.getInt(1));
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Conta selecionar(String numero) {
		String sql = "SELECT * FROM contas WHERE numero = ?";
		try{
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, numero);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				Conta conta = new Conta(result.getString("numero"));
				conta.setId(result.getInt("id"));
				conta.setSaldo(result.getDouble("saldo"));
				return conta;
			} else {
				throw new ContaNaoExisteException();
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	public Collection<Movimento> extrato(String numero){
		String sql = "SELECT movimentos.* FROM movimentos "
				+ "INNER JOIN contas on movimentos.conta_id= contas.id WHERE numero = ?";
		try{
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, numero);
			ResultSet result = statement.executeQuery();
			Collection<Movimento> movimentos = new ArrayList<>();
			while(result.next()){
				Double valor = result.getDouble("valor");
				Date criadoEm = result.getDate("criado_em");
				Movimento movimento = new Movimento(valor, criadoEm);
				movimentos.add(movimento);
			}
			return movimentos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}







