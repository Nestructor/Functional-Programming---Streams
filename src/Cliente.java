public class Cliente {

    String dni, nombre;
    int edad;

    public Cliente(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " | DNI: " + dni;
    }

}