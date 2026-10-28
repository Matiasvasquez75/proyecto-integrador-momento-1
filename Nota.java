public class Nota {
    private int id;
    private int idEstudiante;
    private String materia;
    private double calificacion;

    public Nota() {
        this(1, 1, "Matemáticas", 3.0);
    }

    public Nota(int id, int idEstudiante,
                String materia, double calificacion) {
        setId(id);
        setIdEstudiante(idEstudiante);
        setMateria(materia);
        setCalificacion(calificacion);
    }

    public int getId() {
        return id;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getMateria() {
        return materia;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                "El ID debe ser mayor que cero."
            );
        }
        this.id = id;
    }

    public void setIdEstudiante(int idEstudiante) {
        if (idEstudiante <= 0) {
            throw new IllegalArgumentException(
                "El ID del estudiante debe ser positivo."
            );
        }
        this.idEstudiante = idEstudiante;
    }

    public void setMateria(String materia) {
        if (materia == null || materia.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "La materia no puede estar vacía."
            );
        }
        this.materia = materia.trim();
    }

    public void setCalificacion(double calificacion) {
        if (calificacion < 0 || calificacion > 5) {
            throw new IllegalArgumentException(
                "La nota debe estar entre 0 y 5."
            );
        }
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "ID de nota: " + id
            + " | ID estudiante: " + idEstudiante
            + " | Materia: " + materia
            + " | Calificación: " + calificacion;
    }
}