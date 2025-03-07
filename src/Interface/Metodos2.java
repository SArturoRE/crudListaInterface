package Interface;

import java.util.List;

import Dominio.Autos;

public interface Metodos2 {
	//Nuevos metodos
		public Autos BuscarXModelo(String modelo);
		public List<Autos> BuscarXMarca(String marca);
		public float CalcularInversion();
		public void EditarXModelo(String modelo, int stock);
		public void EliminarXModelo(String modelo);
}
