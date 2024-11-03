import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class catalogocamisetas {
    private List<Camiseta> camisetas = new ArrayList<>();
    private final String archivo = "catalogo.dat";

    // Añadir una nueva camiseta al catálogo
    public void agregarCamiseta(Camiseta camiseta) {
        camisetas.add(camiseta);
        System.out.println("Camiseta añadida al catálogo.");
    }

    // Eliminar una camiseta por su índice
    public void eliminarCamiseta(int index) {
        if (index >= 0 && index < camisetas.size()) {
            camisetas.remove(index);
            System.out.println("Camiseta eliminada del catálogo.");
        } else {
            System.out.println("Índice no válido.");
        }
    }

    // Modificar una camiseta existente
    public void modificarCamiseta(int index, Camiseta nuevaCamiseta) {
        if (index >= 0 && index < camisetas.size()) {
            camisetas.set(index, nuevaCamiseta);
            System.out.println("Camiseta modificada.");
        } else {
            System.out.println("Índice no válido.");
        }
    }

    // Listar todas las camisetas
    public void listarCamisetas() {
        if (camisetas.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            for (int i = 0; i < camisetas.size(); i++) {
                System.out.println(i + ". " + camisetas.get(i));
            }
        }
    }

    // Guardar el catálogo en un archivo
    public void guardarCatalogo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(camisetas);
            System.out.println("Catálogo guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el catálogo: " + e.getMessage());
        }
    }

    // Cargar el catálogo desde un archivo
    public void cargarCatalogo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            camisetas = (List<Camiseta>) ois.readObject();
            System.out.println("Catálogo cargado exitosamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el catálogo: " + e.getMessage());
        }
    }
}
