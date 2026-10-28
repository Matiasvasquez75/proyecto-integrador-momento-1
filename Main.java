import java.util.Scanner;

public class Main {
    private static final Scanner teclado = new Scanner(System.in);
    private static final SistemaNotas sistema = new SistemaNotas();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("   sistema de notas"); 
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Registrar nota");
            System.out.println("4. Listar notas");
            System.out.println("5. Consultar promedio");
            System.out.println("0. Salir");

            opcion = leerEntero("Selecciona una opción: ");

            try {
                switch (opcion) {
                    case 1:
                        registrarEstudiante();
                        break;
                    case 2:
                        listarEstudiantes();
                        break;
                    case 3:
                        registrarNota();
                        break;
                    case 4:
                        listarNotas();
                        break;
                    case 5:
                        consultarPromedio();
                        break;
                    case 0:
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);

        teclado.close();
    }

    private static void registrarEstudiante() {
        int id = leerEntero("ID del estudiante: ");

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        int edad = leerEntero("Edad: ");

        Estudiante estudiante = new Estudiante(id, nombre, edad);

        if (sistema.agregarEstudiante(estudiante)) {
            System.out.println("Estudiante registrado correctamente.");
        } else {
            System.out.println("Ese ID ya está registrado.");
        }
    }

    private static void listarEstudiantes() {
        System.out.println("\n--- ESTUDIANTES ---");

        if (sistema.getEstudiantes().isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        }

        for (Estudiante estudiante : sistema.getEstudiantes()) {
            System.out.println(estudiante);
        }
    }

    private static void registrarNota() {
        int id = leerEntero("ID de la nota: ");
        int idEstudiante = leerEntero("ID del estudiante: ");

        System.out.print("Materia: ");
        String materia = teclado.nextLine();

        double calificacion = leerDouble("Calificación (0 a 5): ");

        Nota nota = new Nota(
            id, idEstudiante, materia, calificacion
        );

        if (sistema.agregarNota(nota)) {
            System.out.println("Nota registrada correctamente.");
        } else {
            System.out.println(
                "No se registró. Verifica el ID de la nota "
                + "y que el estudiante exista."
            );
        }
    }

    private static void listarNotas() {
        System.out.println("notas");

        if (sistema.getNotas().isEmpty()) {
            System.out.println("No hay notas registradas.");
        }

        for (Nota nota : sistema.getNotas()) {
            System.out.println(nota);
        }
    }

    private static void consultarPromedio() {
        int id = leerEntero("ID del estudiante: ");

        Estudiante estudiante = sistema.buscarEstudiante(id);

        if (estudiante == null) {
            System.out.println("El estudiante no existe.");
            return;
        }

        double promedio = sistema.calcularPromedio(id);

        if (promedio == -1) {
            System.out.println("El estudiante todavía no tiene notas.");
        } else {
            System.out.printf(
                estudiante.getNombre(), promedio
            );
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            try {
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número entero válido.");
            }
        }
    }
    
    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            try {
                return Double.parseDouble(
                    teclado.nextLine().trim().replace(',', '.')
                );
            } catch (NumberFormatException e) {
                System.out.println("Ingresa una nota numérica válida.");
            }
        }
    }
}