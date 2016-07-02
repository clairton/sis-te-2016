public class Item {
	private String descricao;
	private Double valor;
	private Integer quantidade;
	private Integer codigo;

	public Item(String descricao, 
				Double valor,
				Integer quantidade,
				Integer codigo){
		this.descricao = descricao;
		this.valor = valor;
		this.quantidade = quantidade;
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getValor() {
		return valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Integer getCodigo() {
		return codigo;
	}
}