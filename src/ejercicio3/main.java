package ejercicio3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dani
 */
public class main {
    public static void main(String[] args) {
        // 1. Crear universidad, profesores y cursos
        Universidad utn = new Universidad("UTN - Programación II");
        
        Profesor p1 = new Profesor("P001", "Ana Gomez", "Programación");
        Profesor p2 = new Profesor("P002", "Juan Perez", "Bases de Datos");
        Profesor p3 = new Profesor("P003", "Maria Lopez", "Redes");

        Curso c1 = new Curso("C101", "Java Avanzado");
        Curso c2 = new Curso("C102", "Estructuras de Datos");
        Curso c3 = new Curso("C201", "SQL y Modelado");
        Curso c4 = new Curso("C202", "MongoDB NoSQL");
        Curso c5 = new Curso("C301", "Seguridad en Redes");

        // 2. Agregar a la universidad
        System.out.println("--- 2. AGREGAR PROFESORES Y CURSOS ---");
        utn.agregarProfesor(p1);
        utn.agregarProfesor(p2);
        utn.agregarProfesor(p3);
        utn.agregarCurso(c1);
        utn.agregarCurso(c2);
        utn.agregarCurso(c3);
        utn.agregarCurso(c4);
        utn.agregarCurso(c5);

        // 3. Asignar profesores a cursos
        System.out.println("\n--- 3. ASIGNACIÓN INICIAL ---");
        utn.asignarProfesorACurso("C101", "P001"); // Java -> Ana
        utn.asignarProfesorACurso("C102", "P001"); // Estructuras -> Ana
        utn.asignarProfesorACurso("C201", "P002"); // SQL -> Juan
        utn.asignarProfesorACurso("C202", "P002"); // MongoDB -> Juan
        utn.asignarProfesorACurso("C301", "P003"); // Redes -> Maria

        // 4. Listar cursos con su profesor y profesores con sus cursos
        utn.listarCursos();
        utn.listarProfesores();

        // 5. Cambiar el profesor de un curso y verificar sincronización.
        System.out.println("\n--- 5. CAMBIAR PROFESOR Y VERIFICAR SINCRONIZACIÓN ---");
        // Cambiamos Java (C101) de Ana (P001) a Juan (P002)
        utn.asignarProfesorACurso("C101", "P002"); 

        System.out.println("\nEstado del Curso C101 después del cambio:");
        utn.buscarCursoPorCodigo("C101").mostrarInfo();
        System.out.println("\nLista de Cursos de Ana (P001) - Debe haber 1:");
        p1.listarCursos(); 
        System.out.println("\nLista de Cursos de Juan (P002) - Debe haber 3:");
        p2.listarCursos(); 

        // 6. Remover un curso y confirmar que ya no aparece en la lista del profesor.
        System.out.println("\n--- 6. REMOVER CURSO Y VERIFICAR SINCRONIZACIÓN ---");
        // Eliminamos C202 (MongoDB), que está a cargo de Juan (P002)
        utn.eliminarCurso("C202"); 

        System.out.println("\nLista de Cursos de Juan (P002) - Debe haber 2:");
        p2.listarCursos(); 

        // 7. Remover un profesor y dejar profesor = null en sus cursos.
        System.out.println("\n--- 7. REMOVER PROFESOR Y VERIFICAR DESVINCULACIÓN ---");
        // Eliminamos a Juan (P002), que tenía los cursos C101 y C201
        utn.eliminarProfesor("P002"); 

        System.out.println("\nEstado de Cursos C101 y C201 después de eliminar a Juan:");
        utn.buscarCursoPorCodigo("C101").mostrarInfo(); // Debe decir "SIN ASIGNAR"
        utn.buscarCursoPorCodigo("C201").mostrarInfo(); // Debe decir "SIN ASIGNAR"
        
        // 8. Mostrar un reporte: cantidad de cursos por profesor (restantes).
        System.out.println("\n--- 8. REPORTE FINAL: CANTIDAD DE CURSOS POR PROFESOR ---");
        for (Profesor p : utn.getProfesores()) {
            System.out.println(p.getNombre() + ": " + p.getCursos().size() + " cursos.");
        }
        // Nota: Juan Perez (P002) no aparece porque fue eliminado.
    }
}
