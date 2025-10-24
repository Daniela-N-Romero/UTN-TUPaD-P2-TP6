
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
public class Inventario {
    ArrayList<Producto> productos = new ArrayList<>();
    
    public void agregarProducto(Producto p) {
        productos.add(p);
    }
    
    public void listarProductos() {
        for (Producto p : productos){
            p.mostrarInfo();
        }
    }
    public Producto buscarProductoPorId(String id){
        int i = 0;
        Producto productoEncontrado = null;
        while (i < productos.size() && !productos.get(i).getId().equals(id)){
            i++;
        }
        if (i < productos.size()){
            productoEncontrado = productos.get(i);
        }
        return productoEncontrado;
    }
    
    public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoria){
        ArrayList<Producto> productosPorCategoria;
        productosPorCategoria = new ArrayList<>();
        for (Producto producto : productos){
            if (producto.getCategoria().equals(categoria)){
                productosPorCategoria.add(producto);
            }
        }
        return productosPorCategoria;
    }
    
    public ArrayList<Producto> filtrarProductosPorPrecio(double min, double max){
        ArrayList<Producto> productosPorRangoPrecio;
        productosPorRangoPrecio = new ArrayList<>();
        for (Producto producto : productos){
            if (producto.getPrecio() >= min && producto.getPrecio() < max){
                productosPorRangoPrecio.add(producto);
            }
        }
        return productosPorRangoPrecio;
    }
    
    public void mostrarCategoriasDisponibles(){
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            System.out.println("-> " + cat.name() + ": " + cat.getDescripcion());
        }
    }

        
    public Producto eliminarProducto(String id) {
        Producto prodABorrar = buscarProductoPorId(id);
        productos.remove(prodABorrar);
        return prodABorrar;
    }
    
    public void actualizarStock(String id, int nuevaCantidad){
        Producto prodAActualizar = buscarProductoPorId(id);
        prodAActualizar.setCantidad(nuevaCantidad);
    }
    
    public int obtenerTotalStock(){  
        int stockTotal = 0;
        for (Producto producto : productos){
            stockTotal += producto.getCantidad();
        }
        return stockTotal;
    }
    
    public Producto obtenerProductoConMayorStock(){
        int mayorStock = 0;
        String id = null;
        for (Producto producto : productos){
            if(producto.getCantidad() > mayorStock){
                mayorStock = producto.getCantidad();
                id = producto.getId();
            }
        }
        return buscarProductoPorId(id);                
    } 
    
        
}
