import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Pedido {
	private Collection<Item> itens = new ArrayList<>();
	private Double total = 0.0;
	private Integer numero;
	private Cliente cliente;

	public Pedido(Integer numero) {
		this.numero = numero;
	}

	public void adicionar(Item item) {
		this.itens.add(item);
		total = total + (item.getQuantidade() * item.getValor());
	}

	public Double getTotal() {
		return total;
	}

	public Integer getNumero() {
		return numero;
	}

	public Collection<Item> getItens() {
		return Collections.unmodifiableCollection(itens);
	}

	public void concluir(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
}
