/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author Daniela Romero
 */
public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }

    /**
     * Asigna/cambia el profesor, sincronizando ambos lados:
     * Si tenía profesor previo, se quita de su lista.
     * Si el nuevo profesor es no nulo, se agrega a su lista.
     */
    public void setProfesor(Profesor nuevoProfesor) {
        if (this.profesor != null && this.profesor != nuevoProfesor) {
            this.profesor.getCursos().remove(this); 
        }

        this.profesor = nuevoProfesor;

        if (this.profesor != null) {
            if (!this.profesor.getCursos().contains(this)) {
                this.profesor.getCursos().add(this);
            }
        }
    }

    public void mostrarInfo() {
        String nombreProfesor = (profesor != null) ? profesor.getNombre() : "SIN ASIGNAR";
        System.out.println("---------------------------------");
        System.out.println("Curso: " + nombre + " (Código: " + codigo + ")");
        System.out.println("Profesor responsable: " + nombreProfesor);
        System.out.println("---------------------------------");
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }
}
