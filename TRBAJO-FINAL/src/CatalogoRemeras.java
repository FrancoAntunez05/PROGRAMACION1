import java.io.*;
import java.util.ArrayList;

/**
 * Clase que gestiona el catálogo de remeras.
 */
public class CatalogoRemeras {
    private ArrayList<Remera> remeras;
    private final String archivo = "productos.dat";

    public CatalogoRemeras() {
        remeras = new ArrayList<>();
        cargarProductos();
    }

    public void agregarRemera(Remera remera) {
        remeras.add(remera);
        guardarProductos();
    }

    public void eliminarRemera(String equipo) {
        remeras.removeIf(remera -> remera.getEquipo().equals(equipo));
        guardarProductos();
    }

    public void modificarRemera(String equipo, double nuevoPrecio, int nuevaCantidad) {
        for (Remera remera : remeras) {
            if (remera.getEquipo().equals(equipo)) {
                remera.setPrecio(nuevoPrecio);
                remera.setCantidad(nuevaCantidad);
                break;
            }
        }
        guardarProductos();
    }

    public void mostrarCatalogo() {
        for (Remera remera : remeras) {
            System.out.println(remera);
        }
    }

    private void guardarProductos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(remeras);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarProductos() {
        File file = new File(archivo);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                remeras = (ArrayList<Remera>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
