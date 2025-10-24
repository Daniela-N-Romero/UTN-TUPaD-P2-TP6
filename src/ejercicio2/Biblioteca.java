/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniela Nahir Romero
 */
public class Biblioteca {
    
    private String nombre;
    private List<Libro> libros =  new ArrayList<>();

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }
    

    public String getNombre() {
        return nombre;
    }
    
    public void  agregarLibro(String isbn, String titulo,int anioPublicacion, Autor autor){
        libros.add(new Libro(isbn, titulo, anioPublicacion, autor));
    }
    public void  listarLibros(){
        for (Libro libro : libros){
            libro.mostrarInfo();
        }
    }
    public Libro  buscarLibroPorIsbn(String isbn){
        int i = 0;
        Libro libroEncontrado = null;
        while (i < libros.size() && !libros.get(i).getIsbn().equals(isbn)){
            i++;
        }
        if (i < libros.size()){
            libroEncontrado = libros.get(i);
        }
        return libroEncontrado;
    }
    
    public Libro eliminarLibro(String isbn){
        Libro libroEliminado =buscarLibroPorIsbn(isbn);
        libros.remove(libroEliminado);
        return libroEliminado;
    }
    
    public int  obtenerCantidadLibros(){
        return libros.size();
    }
    
    public ArrayList filtrarLibrosPorAnio(int anio){
        ArrayList<Libro> librosFiltrados = new ArrayList<>();
        for (Libro libro : libros){
            if (libro.getAnioPublicacion() == anio) {
                librosFiltrados.add(libro);
            }
        }
        return librosFiltrados;
    }
    
    public ArrayList  mostrarAutoresDisponibles(){
        ArrayList<Autor> autores = new ArrayList<>();
        for (Libro libro : libros ){
            if (!autores.contains(libro.getAutor())){
                autores.add(libro.getAutor());
            }
        }
        return autores;
    }
    
}
