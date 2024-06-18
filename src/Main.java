import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //crear array , hashmap y scanner
        Scanner scanner = new Scanner(System.in);
        Agenda miAgenda = new Agenda(10);


        while (true) {
            System.out.println("Bienvenid@ a la agenda telefónica de contactos \n");
            System.out.println("Ingresa 1 para añadir un contacto");
            System.out.println("Ingresa 2 para revisar si el contacto ya existe");
            System.out.println("Ingresa 3 para ver todos los contactos");
            System.out.println("Ingresa 4 para buscar un contacto por su nombre");
            System.out.println("Ingresa 5 para eliminar un contacto");
            System.out.println("Ingresa 6 para verificar si la agenda está llena");
            System.out.println("Ingresa 7 para mostrar cuantos contactos puedes agregar \n");
            System.out.print("Seleccione una opción: ");
            int opcionusuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcionusuario) {
                //Caso 1: Añadir un contacto
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    Contacto contacto = new Contacto(nombre, telefono);
                    if (miAgenda.añadirContacto(contacto)) {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Contacto añadido.");
                        System.out.println("-----------------------------------------------------");
                    } else {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("No se pudo añadir el contacto (puede que la agenda esté llena o el contacto ya exista).");
                        System.out.println("-----------------------------------------------------");
                    }
                    break;

                //Caso 2: Revisar si el contacto existe
                case 2:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    if (miAgenda.existeContacto(nombre)) {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("El contacto existe.");
                        System.out.println("-----------------------------------------------------");
                    } else {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("El contacto no existe.");
                        System.out.println("-----------------------------------------------------");
                    }
                    break;

                //Caso 3: Ver todos los contactos
                case 3:
                    System.out.println("-----------------------------------------------------");
                    miAgenda.listarContactos();
                    System.out.println("-----------------------------------------------------");
                    break;

                //Caso 4: Buscar contacto por nombre
                case 4:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    Contacto c = miAgenda.buscaContacto(nombre);
                    if (c != null) {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Contacto encontrado: " + c);
                        System.out.println("-----------------------------------------------------");
                    } else {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Contacto no encontrado.");
                        System.out.println("-----------------------------------------------------");
                    }
                    break;

                //Caso 5: Eliminar un contacto
                case 5:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    if (miAgenda.eliminarContacto(nombreEliminar)) {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Contacto eliminado correctamente.");
                        System.out.println("-----------------------------------------------------");
                    } else {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("No se pudo eliminar el contacto.");
                        System.out.println("-----------------------------------------------------");
                    }
                    break;

                //Caso 6: Verificar si la agenda está llena
                case 6:
                    if (miAgenda.agendaLlena()) {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("La agenda está llena.");
                        System.out.println("-----------------------------------------------------");
                    } else {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Aún hay espacio en la agenda.");
                        System.out.println("-----------------------------------------------------");
                    }
                    break;

                //Caso 7: Mostras cuántos contactos se pueden agregar
                case 7:
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Espacios libres: " + miAgenda.espaciosLibres());
                    System.out.println("-----------------------------------------------------");
                    break;

                //Default - Opción inválida
                default:
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Opción inválida.");
                    System.out.println("-----------------------------------------------------");
            }
        }
    }
}