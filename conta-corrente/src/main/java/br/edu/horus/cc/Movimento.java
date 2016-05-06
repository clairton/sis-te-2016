package br.edu.horus.cc;

import java.util.Date;

public class Movimento {
	private Integer id;
	private Double valor;
	private Date criadoEm = new Date();
	private Conta conta;
	
	public Movimento(Double valor, Date criadoEm) {
		super();
		this.valor = valor;
		this.criadoEm = criadoEm;
	}

	public Movimento(Conta conta, Double valor){
		this.conta = conta;
		this.valor = valor;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public Date getCriadoEm() {
		return criadoEm;
	}
}
