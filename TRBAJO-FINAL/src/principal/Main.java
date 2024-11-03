import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        catalogocamisetas catalogo = new catalogocamisetas();
        catalogo.cargarCatalogo(); // Cargar catálogo previamente guardado (si existe)

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Catálogo de Camisetas ---");
            System.out.println("1. Agregar camiseta");
            System.out.println("2. Eliminar camiseta");
            System.out.println("3. Modificar camiseta");
            System.out.println("4. Listar camisetas");
            System.out.println("5. Guardar catálogo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Equipo: ");
                    String equipo = scanner.nextLine();
                    System.out.print("Nombre del jugador: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Talla: ");
                    String talla = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la nueva línea

                    catalogo.agregarCamiseta(new Camiseta(equipo, nombre, talla, precio));
                    break;

                case 2:
                    System.out.print("Índice de la camiseta a eliminar: ");
                    int indexEliminar = scanner.nextInt();
                    catalogo.eliminarCamiseta(indexEliminar);
                    break;

                case 3:
                    System.out.print("Índice de la camiseta a modificar: ");
                    int indexModificar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    System.out.print("Nuevo equipo: ");
                    String nuevoEquipo = scanner.nextLine();
                    System.out.print("Nuevo nombre del jugador: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nueva talla: ");
                    String nuevaTalla = scanner.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la nueva línea

                    catalogo.modificarCamiseta(indexModificar, new Camiseta(nuevoEquipo, nuevoNombre, nuevaTalla, nuevoPrecio));
                    break;

                case 4:
                    catalogo.listarCamisetas();
                    break;

                case 5:
                    catalogo.guardarCatalogo();
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }

    @Override
    public String toString() {
        return "main []";
    }
}
