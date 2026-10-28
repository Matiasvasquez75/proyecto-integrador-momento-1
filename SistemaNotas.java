import java.util.ArrayList;
import java.util.List;

public class SistemaNotas {
    private final ArrayList<Estudiante> estudiantes;
    private final ArrayList<Nota> notas;

    public SistemaNotas() {
        estudiantes = new ArrayList<>();
        notas = new ArrayList<>();
    }

    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null ||
            buscarEstudiante(estudiante.getId()) != null) {
            return false;
        }

        estudiantes.add(estudiante);
        return true;
    }

    public boolean agregarNota(Nota nota) {
        if (nota == null || buscarNota(nota.getId()) != null) {
            return false;
        }

        if (buscarEstudiante(nota.getIdEstudiante()) == null) {
            return false;
        }

        notas.add(nota);
        return true;
    }

    public Estudiante buscarEstudiante(int id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    public Nota buscarNota(int id) {
        for (Nota nota : notas) {
            if (nota.getId() == id) {
                return nota;
            }
        }
        return null;
    }

    public double calcularPromedio(int idEstudiante) {
        double suma = 0;
        int cantidad = 0;

        for (Nota nota : notas) {
            if (nota.getIdEstudiante() == idEstudiante) {
                suma += nota.getCalificacion();
                cantidad++;
            }
        }

        if (cantidad == 0) {
            return -1;
        }

        return suma / cantidad;
    }

    public List<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

    public List<Nota> getNotas() {
        return new ArrayList<>(notas);
    }
}