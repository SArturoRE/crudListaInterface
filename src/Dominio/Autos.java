package Dominio;

public class Autos {

	private String marca;
	private String modelo;
	private float precio;
	private int stock;
	
	
	public Autos() {
	}
	
	public Autos(String marca, String modelo, float precio, int stock) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Autos [marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", stock="
				+ stock + "]\n";
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
