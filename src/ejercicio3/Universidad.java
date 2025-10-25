/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author Daniela Romero
 */
import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void agregarProfesor(Profesor p) {
        if (buscarProfesorPorId(p.getId()) == null) {
            profesores.add(p);
            System.out.println("Profesor " + p.getNombre() + " agregado.");
        } else {
            System.out.println("Profesor con ID " + p.getId() + " ya existe.");
        }
    }

    public void agregarCurso(Curso c) {
        if (buscarCursoPorCodigo(c.getCodigo()) == null) {
            cursos.add(c);
            System.out.println("Curso " + c.getNombre() + " agregado.");
        } else {
            System.out.println("Curso con código " + c.getCodigo() + " ya existe.");
        }
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);

        if (curso != null && profesor != null) {
            curso.setProfesor(profesor); 
            System.out.println("Profesor " + profesor.getNombre() + " asignado al curso " + curso.getNombre());
        } else {
            System.out.println("Error de asignación: Curso o Profesor no encontrado.");
        }
    }

    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public void eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            // Rompemos la relación bidireccional ANTES de remover el curso de la lista.
            curso.setProfesor(null); 
            cursos.remove(curso);
            System.out.println("Curso " + curso.getNombre() + " eliminado.");
        } else {
            System.out.println("Error: Curso con código " + codigo + " no encontrado.");
        }
    }

    /**
     * Elimina el profesor y deja profesor = null en todos los cursos que dictaba.
     */
    public void eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Dejar null en todos los cursos que dictaba.
            List<Curso> cursosDictados = new ArrayList<>(profesor.getCursos());
            for (Curso c : cursosDictados) {
                c.setProfesor(null); 
            }
            profesores.remove(profesor);
            System.out.println("Profesor " + profesor.getNombre() + " eliminado. (" + cursosDictados.size() + " cursos desvinculados).");
        } else {
            System.out.println("Error: Profesor con ID " + id + " no encontrado.");
        }
    }

    public void listarProfesores() {
        System.out.println("\n--- LISTADO DE PROFESORES DE " + nombre + " ---");
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        for (Profesor p : profesores) {
            p.mostrarInfo();
        }
    }

    public void listarCursos() {
        System.out.println("\n--- LISTADO DE CURSOS DE " + nombre + " ---");
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        for (Curso c : cursos) {
            c.mostrarInfo();
        }
    }
}