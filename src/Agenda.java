import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> contactos;
    private int capacidad;

    public Agenda(int capacidad) {
        this.contactos = new ArrayList<>();
        this.capacidad = capacidad;
    }
    //1. Metodo: agregar contacto
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void mostrarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    //2. Metodo: Ya existe el contacto por nombre
    public boolean añadirContacto(Contacto contacto) {
        if (agendaLlena()) {
            return false;
        }
        if (!existeContacto(contacto.getNombre())) {
            contactos.add(contacto);
            return true;
        }
        return false;
    }
    public boolean existeContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    // 3. Metodo: listar contactos
    public ArrayList<Contacto> listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
            System.out.println("-----------------------------------------------------");
        } else {
            System.out.println("Contactos:");
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
        return contactos;
    }
    // 4. Metodo: buscar contactos
    public Contacto buscaContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }
    // 5. Metodo: eliminar contactos
    public boolean eliminarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(contacto);
                System.out.println("El contacto '" + nombre + "' se ha eliminado exitosamente.");
                return true;
            }
        }
        System.out.println("No se ha encontrado el contacto '" + nombre + "'.");
        return false;
    }
    // 6. Metodo: agenda llena
    public boolean agendaLlena() {
        return contactos.size() >= capacidad;
    }
    // 7. Metodo: eliminar contactos
    public int espaciosLibres() {
        return capacidad - contactos.size();
    }

}