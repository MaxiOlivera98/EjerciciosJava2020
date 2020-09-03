package ui;

import entities.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {
	static Scanner lector;
	public static void main(String[] args) {
		System.out.println("Enunciados -- Ejercicio 05");
		lector = new Scanner(System.in);
		iterar(lector);
		lector.close();
	}
	
	private static void iterar(Scanner lector) {
		Empleado[] personal = new Empleado[20];
		int i = 0;
		int continuar = 0;
		
		while (continuar == 0 && (i < 20)) {
			System.out.println("Ingrese los datos del empleado " + (i + 1));
			int seleccion = JOptionPane.showOptionDialog(
					null,
					"Seleccionar Rol del Empleado",
					"Selector de Rol",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					new Object[] { "Administrativo", "Vendedor"},
					"Administrativo");
			
			if (seleccion == 0) {
				Administrativo adm = new Administrativo();
				cargaDatosEmpleado(adm);
				System.out.print("Ingrese Horas Mensuales: ");
				adm.setHsMes(Integer.parseInt(lector.nextLine()));
				System.out.print("Ingrese Horas Extras: ");
				adm.setHsExtra(Integer.parseInt(lector.nextLine()));
				personal[i] = adm;
				i++;
			}
			else if (seleccion == 1) {
				Vendedor v = new Vendedor();
				cargaDatosEmpleado(v);
				System.out.print("Ingrese Porcentaje de Comisi�n: ");
				v.setPorcenComision(Double.parseDouble(lector.nextLine()));
				System.out.print("Ingrese Total de Ventas: ");
				v.setTotalVentas(Double.parseDouble(lector.nextLine()));
				personal[i] = v;
				i++;
			}
			
			if (i < 20) {
				continuar = JOptionPane.showConfirmDialog(
						null,
						"�Desea ingresar otro Empleado?");
			}
		}
		
		for (int j = 0; j < i; j++) {
			System.out.println("Empleado " + (j + 1) + ":");
			System.out.println("\tDNI: " + personal[j].getDni());
			System.out.println("\tNombre y Apellido: " + personal[j].getNombre() + " " + personal[j].getApellido());
			System.out.println("\tRol: " + personal[j].getDefClase());
			System.out.println("\tSueldo: " + personal[j].getSueldo());
		}
	}
	
	public static void cargaDatosEmpleado(Empleado e) {
		System.out.print("Ingrese DNI: ");
		e.setDni(Integer.parseInt(lector.nextLine()));
		System.out.print("Ingrese Apellido: ");
		e.setApellido(lector.nextLine());
		System.out.print("Ingrese Nombre: ");
		e.setNombre(lector.nextLine());
		System.out.print("Ingrese E-Mail: ");
		e.setEmail(lector.nextLine());
		System.out.print("Ingrese Sueldo Base: ");
		e.setSueldoBase(Double.parseDouble(lector.nextLine()));
	}
}