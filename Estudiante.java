public class Estudiante {
    private int id;
    private String nombre;
    private int edad;

    public Estudiante() {
        this(1, "Sin nombre", 16);
    }

    public Estudiante(int id, String nombre, int edad) {
        setId(id);
        setNombre(nombre);
        setEdad(edad);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                "El ID debe ser mayor que cero."
            );
        }
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre no puede estar vacío."
            );
        }
        this.nombre = nombre.trim();
    }

    public void setEdad(int edad) {
        if (edad < 5 || edad > 100) {
            throw new IllegalArgumentException(
                "La edad debe estar entre 5 y 100 años."
            );
        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "ID: " + id
            + " | Nombre: " + nombre
            + " | Edad: " + edad;
    }
}