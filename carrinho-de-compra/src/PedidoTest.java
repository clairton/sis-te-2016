import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Assert;

public class PedidoTest {

	@Test
	public void test() {
		Cliente pedro = new Cliente("Pedro");
		Pedido pedido = new Pedido(1);
		Item banana = new Item("Banana", 3.0, 2, 123);
		pedido.adicionar(banana);		
		Assert.assertEquals(Double.valueOf(6.0), pedido.getTotal());
		Assert.assertEquals(1, pedido.getItens().size());		
		pedido.concluir(pedro);
		Assert.assertNotNull(pedido.getCliente());
	}
}
