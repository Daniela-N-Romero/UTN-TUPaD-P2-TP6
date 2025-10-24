/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author Daniela Romero
 */
public class main {
    
    public static void main(String[] args) {
        
        // 1. Inicializar el Inventario
        System.out.println("--- 1. Crear al menos cinco productos con diferentes categorías y agregarlos al\n" +
"inventario.  ---");
        Inventario miInventario = new Inventario();
        // Crear productos con diferentes categorías (Tarea 1)
        Producto p1 = new Producto("A001", "Leche Entera", 1200.0, 50, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("E002", "Smart TV 55'", 250000.0, 10, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("R003", "Remera Algodón", 2500.0, 150, CategoriaProducto.ROPA);
        Producto p4 = new Producto("H004", "Licuadora", 35000.0, 25, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("A005", "Pan Integral", 800.0, 80, CategoriaProducto.ALIMENTOS);
        Producto p6 = new Producto("R006", "Jeans", 4000.0, 60, CategoriaProducto.ROPA);
        
        // Agregar los productos al inventario (Tarea 1)
        miInventario.agregarProducto(p1);
        miInventario.agregarProducto(p2);
        miInventario.agregarProducto(p3);
        miInventario.agregarProducto(p4);
        miInventario.agregarProducto(p5);
        miInventario.agregarProducto(p6);
        
        System.out.println("Se han agregado 6 productos al inventario.\n");
          
        System.out.println("2. Listar todos los productos\n");
        miInventario.listarProductos();
        System.out.println("");
        
        String idBuscado = "E002";
        System.out.println("\n\n--- 3. Buscar producto por ID: " + idBuscado + " ---\n");
        Producto productoEncontrado = miInventario.buscarProductoPorId(idBuscado);
        if (productoEncontrado != null) {
            System.out.print("Producto encontrado: \n");
            productoEncontrado.mostrarInfo();
            System.out.println("");
        } else {
            System.out.println("Producto con ID " + idBuscado + " no encontrado.\n");
        }

        
        CategoriaProducto catAFiltrar = CategoriaProducto.ALIMENTOS;
        System.out.println("\n--- 4. Filtrar productos por categoría: " + catAFiltrar.name() + " ---");
        ArrayList<Producto> listaFiltrada = miInventario.filtrarPorCategoria(catAFiltrar);
        if (!listaFiltrada.isEmpty()) {
            for (Producto p : listaFiltrada) {
                p.mostrarInfo();
            }
        } else {
            System.out.println("No se encontraron productos en la categoría " + catAFiltrar.name()+"\n");
        }

        String idAEliminar = "E002";
        System.out.println("\n--- 5. Eliminar producto con ID: " + idAEliminar + " ---\n");
        Producto eliminado = miInventario.eliminarProducto(idAEliminar);
        if (eliminado != null) {
            System.out.println("Producto eliminado: " + eliminado.getId()+"\n");
        } else {
             System.out.println("No se encontró el producto con ID " + idAEliminar + " para eliminar.\n");
        }
        
        System.out.println("\nProductos restantes:");
        miInventario.listarProductos();
        System.out.println();

        String idAActualizar = "R003";
        int nuevoStock = 180;
        System.out.println("\n--- 6. Actualizar stock para ID: " + idAActualizar + " a " + nuevoStock + " ---\n");
        miInventario.actualizarStock(idAActualizar, nuevoStock);
        
        Producto stockActualizado = miInventario.buscarProductoPorId(idAActualizar);
        if (stockActualizado != null) {
            stockActualizado.mostrarInfo();
        }
        System.out.println();


        System.out.println("--- 7. Stock Total Disponible ---");
        int totalStock = miInventario.obtenerTotalStock();
        System.out.println("El stock total de todos los productos es: " + totalStock+".\n.");
   
        // 8. Obtener y mostrar el producto con mayor stock (Tarea 8)
        System.out.println("\n--- 8. Producto con Mayor Stock ---");
        Producto productoMayorStock = miInventario.obtenerProductoConMayorStock();
        if (productoMayorStock != null) {
            System.out.print("El producto con mayor stock es: ");
            productoMayorStock.mostrarInfo();
        } else {
             System.out.println("El inventario está vacío.");
        }
        System.out.println();


        double minPrecio = 1000.0;
        double maxPrecio = 3000.0;
        System.out.println("--- 9. Filtrar productos entre $" + minPrecio + " y $" + maxPrecio + " ---\n");
        // Usamos el nombre corregido/mejorado: filtrarProductosPorPrecio
        ArrayList<Producto> productosBaratos = miInventario.filtrarProductosPorPrecio(minPrecio, maxPrecio);
        if (!productosBaratos.isEmpty()) {
            for (Producto p : productosBaratos) {
                p.mostrarInfo();
            }
        } else {
            System.out.println("No se encontraron productos en ese rango de precio.");
        }
        System.out.println();

        System.out.println("--- 10. Categorías Disponibles con Descripciones ---");
        miInventario.mostrarCategoriasDisponibles();
    }
}


