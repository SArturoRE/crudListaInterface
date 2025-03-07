package Implementacion;

import java.util.ArrayList;
import java.util.List;

import Dominio.Autos;
import Interface.Metodos;
import Interface.Metodos2;

public class LogicaMetodos implements Metodos, Metodos2 {

	private List<Autos> lista = new ArrayList<Autos>();

	@Override
	public void Guardar(Autos au) {
		// Agregaremos las validaciones
		// Validamos que el modelo no se repita
		boolean repetido = false;
		for (Autos ab : lista) {
			if (au.getModelo().equalsIgnoreCase(ab.getModelo())) {
				repetido = true;
				break;
			}
		}

		if (!repetido) {
			this.lista.add(au);
			System.out.println("El auto se guardo con exito!!!");
		} else {
			System.out.println("El modelo que ingreso ya existe en la lista\n" + "No podemos tener modelos repetidos");
		}

	}

	@Override
	public List<Autos> Mostrar() {
		// List<Autos> lis = this.lista;
		return this.lista;
	}

	@Override
	public Autos BuscarXIndice(int indice) {

		return this.lista.get(indice);
	}

	@Override
	public void Editar(int indice, Autos aut) {
		this.lista.set(indice, aut);

	}

	@Override
	public void Eliminar(int indice) {
		this.lista.remove(indice);

	}

	@Override
	public Autos BuscarXModelo(String modelo) {

		for (Autos au : this.lista) {
			if (au.getModelo().equalsIgnoreCase(modelo)) {
				// System.out.println("Se encontro el auto\n" + au);
				return au;
			}
		}

		return null;
	}

	@Override
	public List<Autos> BuscarXMarca(String marca) {
		List<Autos> enc = new ArrayList<Autos>();
		// boolean ban = false;
		for (Autos lb : this.lista) {
			if (lb.getMarca().equalsIgnoreCase(marca)) {
				enc.add(lb);
			}
		}
		return enc;
	}

	@Override
	public float CalcularInversion() {
		float total;
		total = 0.0f;
		for (Autos c : this.lista) {
			total += (c.getStock() * c.getPrecio());
		}
		return total;
	}

	@Override
	public void EditarXModelo(String mode, int stock) {
		boolean ban = true;
		for (int i =0 ; i < this.lista.size(); i++) {
			if (this.lista.get(i).getModelo().equalsIgnoreCase(mode)) {
				this.lista.get(i).setStock(stock);
				ban = false;
				break;
			}
		}
		
		if(!ban) {
			System.out.println("Se modifico el elemento correctamente");
		}else {
			System.out.println("No se encontro ningun elemento de modelo " + mode);
		}
	}

	@Override
	public void EliminarXModelo(String modelo) {
		boolean ban = true;
		for (int i =0 ; i < this.lista.size(); i++) {
			if (this.lista.get(i).getModelo().equalsIgnoreCase(modelo)) {
				this.lista.remove(i);
				ban = false;
				break;
			}
		}
		
		if(!ban) {
			System.out.println("Se elimino el modelo correctamente");
		}else {
			System.out.println("No se encontro ningun elemento de modelo " + modelo);
		}

	}

}
