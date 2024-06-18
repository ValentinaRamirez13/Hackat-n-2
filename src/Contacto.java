public class Contacto {
    private String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    //GET
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    //SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre agregado: " + nombre + "\n" +
                "Teléfono agregado: " + telefono;
    }
}