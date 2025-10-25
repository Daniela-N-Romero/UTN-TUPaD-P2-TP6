package ejercicio3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniela  Romero
 */

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos; // List<Curso> cursos que dicta

    // Constructor
    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }

    /**
     * Agrega un curso a su lista y sincroniza los cambios el lado del curso (establece el profesor del curso).
     */
    public void agregarCurso(Curso curso) {
        if (!this.cursos.contains(curso)) {
            this.cursos.add(curso);
            curso.setProfesor(this);
        }
    }

    public void eliminarCurso(Curso curso) {
        if (this.cursos.remove(curso)) {
            // Sincronizar el lado del curso: Si el curso actualmente lo dicta este profesor, quitar la referencia.
            if (curso.getProfesor() == this) {
                // Llama a setProfesor(null) para que el curso rompa la relación.
                curso.setProfesor(null); 
            }
        }
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("  > No dicta cursos actualmente.");
            return;
        }
        System.out.println("  > Cursos a cargo:");
        for (Curso c : cursos) {
            System.out.println("    - [" + c.getCodigo() + "] " + c.getNombre());
        }
    }

    public void mostrarInfo() {
        System.out.println("---------------------------------");
        System.out.println("Profesor: " + nombre + " (ID: " + id + ")");
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Cursos dictados: " + cursos.size());
        listarCursos();
        System.out.println("---------------------------------");
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Curso> getCursos() { return cursos; } 
}
