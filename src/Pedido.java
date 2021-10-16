
public class Pedido {
	private String id;
	private int[] productos;
	
	public Pedido(String id,int[] productos) {
		this.id=id;
		this.productos=productos;
	}
	
	public String getId() {
		return this.productos;
	}
	
	public int[] getProductos() {
		return this.productos;
	}

}
