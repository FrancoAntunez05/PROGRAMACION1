import java.util.Scanner;

/**
 * Clase principal para ejecutar el gestor de catálogo de remeras.
 */
public class Main {
    public static void main(String[] args) {
        CatalogoRemeras catalogo = new CatalogoRemeras();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar Remera");
            System.out.println("2. Eliminar Remera");
            System.out.println("3. Modificar Remera");
            System.out.println("4. Mostrar Catálogo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Equipo de la remera: ");
                    String equipo = scanner.nextLine();
                    System.out.print("Precio de la remera: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cantidad de remeras: ");
                    int cantidad = scanner.nextInt();
                    catalogo.agregarRemera(new Remera(equipo, precio, cantidad));
                    break;
                case 2:
                    System.out.print("Equipo de la remera a eliminar: ");
                    String equipoEliminar = scanner.nextLine();
                    catalogo.eliminarRemera(equipoEliminar);
                    break;
                case 3:
                    System.out.print("Equipo de la remera a modificar: ");
                    String equipoModificar = scanner.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();
                    catalogo.modificarRemera(equipoModificar, nuevoPrecio, nuevaCantidad);
                    break;
                case 4:
                    catalogo.mostrarCatalogo();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
