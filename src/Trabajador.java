
public class Trabajador extends Thread {
	//Variables y objetos necesarios para procesar un pedido
	private String nombre;
	private Pedido pedido;
	private long initialTime;

	public Trabajador(String nombre,Pedido pedido, long initialTime) {
		this.nombre=nombre;
		pedido=this.pedido;
		this.initialTime=initialTime;
	}
	
	@Override
	public void start() {
		
		//Mensaje de inicio
		System.out.println("El trabajador " + this.nombre + " COMIENZA A PROCESAR EL PEDIDO " 
					+ this.pedido.getId() + " EN EL TIEMPO: " 
					+ (System.currentTimeMillis()- this.initialTime) / 1000 
					+ "seg");

		//Se procesa uno a uno todos los productos
		for (int i = 0; i < this.pedido.getProductos().length-1; i++) { 
			this.esperarcamion(pedido.getProductos()[i]); 
			System.out.println("Procesado el producto " + (i + 1) 
			+ " del pedido " + this.pedido.getId() + "->Tiempo: " 
			+ (System.currentTimeMillis()) / 1000 
			+ "seg");
		}

		//Finalizado el pedido
		System.out.println("\"El trabajador " + this.nombre + " HA TERMINADO DE PROCESAR " 
						+ this.pedido.getId() + " EN EL TIEMPO: " 
						+ (System.currentTimeMillis()- this.initialTime) / 1000 
						+ "seg");
	}
	
	//Tiempo introducido para simular el tiempo que tarda en llegar cada producto al almacen
	private void esperarcamion(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
