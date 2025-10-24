/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.ArrayList;

/**
 *
 * @author Daniela Nahir Romero
 */
public class main {
    public static void main(String[] args) {
        
        // 1. Creamos una biblioteca.
        System.out.println("--- 1. CREACIÓN DE BIBLIOTECA ---");
        Biblioteca miBiblioteca = new Biblioteca("Biblioteca Central UTN");
        System.out.println("Biblioteca creada: " + miBiblioteca.getNombre());
        System.out.println("-----------------------------------\n");

        // 2. Crear al menos tres autores
        System.out.println("--- 2. CREACIÓN DE AUTORES ---");
        // Nota: Estos autores deben tener el constructor en la clase Autor.
        Autor autor1 = new Autor("A001", "Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("A002", "Isabel Allende", "Chilena");
        Autor autor3 = new Autor("A003", "Jorge Luis Borges", "Argentina");
        
        autor1.mostrarInfo();
        autor2.mostrarInfo();
        autor3.mostrarInfo();
        System.out.println("-----------------------------------\n");

        // 3. Agregar 5 libros asociados a alguno de los Autores a la biblioteca.
        System.out.println("--- 3. AGREGAR LIBROS ---");
        miBiblioteca.agregarLibro("978-01", "Cien años de soledad", 1967, autor1);
        miBiblioteca.agregarLibro("978-02", "El amor en los tiempos del cólera", 1985, autor1);
        miBiblioteca.agregarLibro("978-03", "La casa de los espíritus", 1982, autor2);
        miBiblioteca.agregarLibro("978-04", "Ficciones", 1944, autor3);
        miBiblioteca.agregarLibro("978-05", "El Aleph", 1949, autor3);
        System.out.println("Se agregaron 5 libros al inventario.");
        System.out.println("-----------------------------------\n");
        
        // 4. Listar todos los libros con su información y la del autor.
        System.out.println("--- 4. LISTAR TODOS LOS LIBROS ---");
        miBiblioteca.listarLibros();
        System.out.println("-----------------------------------\n");

        // 5. Buscar un libro por su ISBN y mostrar su información.
        System.out.println("--- 5. BUSCAR LIBRO POR ISBN (978-03) ---");
        Libro libroBuscado = miBiblioteca.buscarLibroPorIsbn("978-03");
        if (libroBuscado != null) {
            libroBuscado.mostrarInfo();
        } else {
            System.out.println("Libro con ISBN 978-03 no encontrado.");
        }
        System.out.println("-----------------------------------\n");

        // 6. Filtrar y mostrar los libros publicados en un año específico.
        System.out.println("--- 6. FILTRAR LIBROS POR AÑO (1944) ---");
        ArrayList<Libro> libros1944 = miBiblioteca.filtrarLibrosPorAnio(1944);
        if (libros1944.isEmpty()) {
            System.out.println("No se encontraron libros publicados en 1944.");
        } else {
            for (Libro libro : libros1944) {
                libro.mostrarInfo();
            }
        }
        System.out.println("-----------------------------------\n");
        
        // 7. Eliminar un libro por su ISBN y listar los libros restantes.
        System.out.println("--- 7. ELIMINAR LIBRO POR ISBN (978-04) ---");
        Libro eliminado = miBiblioteca.eliminarLibro("978-04");
        if (eliminado != null) {
            System.out.println("Libro eliminado: " + eliminado.getTitulo());
        } else {
             System.out.println("Libro con ISBN 978-04 no encontrado.");
        }
        
        System.out.println("\n--- Libros restantes en la biblioteca ---");
        miBiblioteca.listarLibros();
        System.out.println("-----------------------------------\n");

        // 8. Mostrar la cantidad total de libros en la biblioteca.
        System.out.println("--- 8. CANTIDAD TOTAL DE LIBROS ---");
        System.out.println("Cantidad de libros actual: " + miBiblioteca.obtenerCantidadLibros());
        System.out.println("-----------------------------------\n");

        // 9. Listar todos los autores de los libros disponibles en la biblioteca.
        System.out.println("--- 9. AUTORES DISPONIBLES ---");
        ArrayList<Autor> autoresDisponibles = miBiblioteca.mostrarAutoresDisponibles();
        for (Autor autor : autoresDisponibles) {
            autor.mostrarInfo();
        }
        System.out.println("-----------------------------------\n");
    }
    
}
