package catalogo;

import java.util.ArrayList;

/**
 *
 * @author joeld
 */
public class Paquete {
    private final String id;
    private String nombre;
    private double precio;
    private ArrayList<Servicio> listaServicios;
    private static int contadorPaquete = 0; 
    
    public Paquete(String id, String nombre, ArrayList<Servicio> servicios, double precio) {
        this.id = String.format("PAQ%02d", contadorPaquete++);
        this.nombre = nombre;
        this.setListaServicios(servicios);
        this.setPrecio(precio);
    }
    
    public Paquete(String nombre, ArrayList<Servicio> servicios, double precio) {
        this.id = String.format("PAQ%02d", contadorPaquete++);
        this.nombre = nombre;
        this.setListaServicios(servicios);
        this.setPrecio(precio);
    }
    
    public Paquete(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        if(precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        
        this.precio = precio;
    }
    
    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }
    
    public void setListaServicios(ArrayList<Servicio> servicios) {
        if(servicios.size() == 0)
           throw new IllegalArgumentException("No hay servicios");
        this.listaServicios = servicios;
    }
    
    public void agregarServicio(Servicio servicio) {
        if(buscar(servicio.getId())) {
            throw new IllegalArgumentException("El servicio ya esta en el paquete");
        }
        listaServicios.add(servicio);
    }
    
    public void eliminarServicio(Servicio servicio) {
        if(listaServicios.size() == 1) {
            throw new IllegalArgumentException("la lista debe tener almenos 2 o mas servicios para eliminar 1");
        }
        listaServicios.remove(servicio);
    }
    
    public static double calcularPrecio(ArrayList<Servicio> servicios) {
       if(servicios.size() == 0)
           throw new IllegalArgumentException("No hay servicios");
       
       double precioTotal = 0.0;
       
       for(Servicio s: servicios) {
           precioTotal += s.getPrecio();
       }
       
       return precioTotal;
    }
    
    public boolean buscar(String id) {
        boolean servicioEncontrado = false;
        for(int i = 0; i < getListaServicios().size(); i++) {
            if(getListaServicios().get(i).getId().equals(id)) {
                servicioEncontrado = true;
            }
        }
        
        return servicioEncontrado;
    }
    
    @Override
    public String toString() {
        return String.format("id: %s%nNombre: %s%nPrecio: %.2f%n%nCantidad de Servicios: %d%n",
                id, nombre, precio, listaServicios.size());
    }
    
    public String toCsv() {
        return String.join(";", id, nombre, String.valueOf(precio));
    }
}
