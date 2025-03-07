package Interface;

import java.util.List;

import Dominio.Autos;

public interface Metodos {
	
	public void Guardar(Autos au);
	public List<Autos> Mostrar();
	public Autos BuscarXIndice(int indice);
	public void Editar(int indice, Autos aut);
	public void Eliminar(int indice);
	
}
