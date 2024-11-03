import java.io.Serializable;

/**
 * Clase que representa una remera de fútbol.
 */
public class Remera implements Serializable {
    private String equipo;
    private double precio;
    private int cantidad;

    public Remera(String equipo, double precio, int cantidad) {
        this.equipo = equipo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Remera{" +
                "equipo='" + equipo + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
