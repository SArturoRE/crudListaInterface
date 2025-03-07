package Main;

import java.util.List;
import java.util.Scanner;

import Dominio.Autos;
import Implementacion.LogicaMetodos;

public class AutosMain {

	public static void main(String[] args) {
		//Declaramos las variables
		Scanner leer = null;
		String marca, modelo;
		float precio;
		int stock, menuPrinc, subMenu, indice;
		
		Autos auto=null;
		
		LogicaMetodos cont = new LogicaMetodos();
		
		//Menu principal....
		
		do {
			
			System.out.println("Elige la operacion que vamos a realizar");
			System.out.println("[1]---- Alta de autos");
			System.out.println("[2]---- Mostrar");
			System.out.println("[3]---- Buscar");
			System.out.println("[4]---- Editar");
			System.out.println("[5]---- Eliminar");
			System.out.println("[6]---- Buscar por modelo");
			System.out.println("[7]---- Buscar por marca");
			System.out.println("[8]---- Calcular dinero invertido");
			System.out.println("[9]---- Editar buscando por modelo");
			System.out.println("[10]---- Eliminar buscando por modelo");
			System.out.println("[11]---- Salir");
			leer = new Scanner(System.in);
			menuPrinc = leer.nextInt();
			switch (menuPrinc) {
			case 1:
				try {
					System.out.println("Ingrese la marca del coche");
					leer = new Scanner(System.in);
					marca = leer.next();
					System.out.println("Ingrese el modelo del coche");
					leer = new Scanner(System.in);
					modelo = leer.next();
					System.out.println("Ingrece el precio del coche");
					leer = new Scanner(System.in);
					precio = leer.nextFloat();
					System.out.println("Ingrece el stock de coches");
					leer = new Scanner(System.in);
					stock = leer.nextInt();
					
					auto = new Autos(marca, modelo, precio, stock);
					cont.Guardar(auto);					
				} catch (Exception e) {
					System.out.println("Algo salio mal al guardar!!!" + e.getMessage());
				}
				break;
			case 2:
				try {					
					System.out.println("Su stock es:\n" + cont.Mostrar());
				} catch (Exception e) {
					System.out.println("Algo salio mal!!!" + e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("Ingrece el indice del coche que quiere que se le muestre");
					leer = new Scanner(System.in);
					indice = leer.nextInt();
					System.out.println("El coche que busca contiene: \n"+ cont.BuscarXIndice(indice));
				} catch (Exception e) {
					System.out.println("Algo salio mal!!!" + e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.println("Ingrese el indice del auto a editar:");
					leer = new Scanner(System.in);
					indice = leer.nextInt();
					auto = cont.BuscarXIndice(indice);
					do {
						System.out.println("Se encontro el auto\n"+ auto);
						System.out.println("\nElige la operacion que vamos a realizar");
						System.out.println("[1]---- Marca");
						System.out.println("[2]---- Precio");
						System.out.println("[3]---- Stock");
						System.out.println("[4]---- Cancelar");
						leer = new Scanner(System.in);
						subMenu = leer.nextInt();
						
						switch (subMenu) {
						case 1:
							System.out.println("Ingrese la nueva marca del coche");
							leer = new Scanner(System.in);
							marca = leer.next();
							auto.setMarca(marca);
							break;
						case 2:
							System.out.println("Ingrece el precio del coche");
							leer = new Scanner(System.in);
							precio = leer.nextFloat();
							auto.setPrecio(precio);
							break;
						case 3:
							System.out.println("Ingrece el stock de coches");
							leer = new Scanner(System.in);
							stock = leer.nextInt();
							auto.setStock(stock);
							break;

						default:
							System.out.println("Regresaremos al menu principal.....");
							break;
						}
						cont.Editar(indice, auto);
					} while (subMenu < 4);
				} catch (Exception e) {
					System.out.println("Algo salio mal al editar!!!" + e.getMessage());
				}
				break;
			case 5:
				try {
					System.out.println("Ingrese el indice del elemento que desea eliminar");
					leer = new Scanner(System.in);
					indice = leer.nextInt();
					cont.Eliminar(indice);
					System.out.println("Elemento eliminado");
				} catch (Exception e) {
					System.out.println("Algo salio mal al eliminar!!!" + e.getMessage());
				}
				break;
			case 6:
				try {
					System.out.println("Por favor ingrese el modelo que desea ver");
					leer = new Scanner(System.in);
					modelo = leer.next();
					auto = cont.BuscarXModelo(modelo);
					if(auto != null) {
						System.out.println("Se encontro el siguiente elemento:\n" + auto);
					}else {
						System.out.println("Lo sentimos, no encontramos nada");
					}
				} catch (Exception e) {
					System.out.println("Algo salio mal al buscar por modelo"+e.getMessage());
				}
				break;
			case 7:
				try {
					System.out.println("Por favor ingrese la marca que desea ver");
					leer = new Scanner(System.in);
					marca = leer.next();
					List<Autos> bxm = cont.BuscarXMarca(marca);
					if( bxm != null) {
						System.out.println("Se encontro:\n" + bxm);
					}else {
						System.out.println("No encontramos nada, lo siento....");
					}
				} catch (Exception e) {
					System.out.println("Algo salio mal al buscar por marca"+e.getMessage());
				}
				break;
			case 8:
				System.out.println("usted tiene invertido:\n"+ cont.CalcularInversion()+
						" Pesos");
				break;
			case 9:
				System.out.println("Por favor ingrese el modelo que vamos a editar");
				leer = new Scanner(System.in);
				modelo = leer.next();
				System.out.println("Solo podemos editar el stock, ingrese el nuevo stokc del coche");
				leer = new Scanner(System.in);
				stock = leer.nextInt();
				cont.EditarXModelo(modelo, stock);
				break;
			case 10:
				System.out.println("Por favor ingrese el modelo que vamos a eliminar");
				leer = new Scanner(System.in);
				modelo = leer.next();
				cont.EliminarXModelo(modelo);
				break;
			case 11:
				System.out.println("Terminaremos la ejecucion del programa \n GRACIAS.....");
				break;
			default:
				System.out.println("Opcion invalida, intentalo...");
				break;
			}
		}while(menuPrinc < 11);
		System.out.println("Muchas gracias por utilizar nuestro programa.....");
	}

}
