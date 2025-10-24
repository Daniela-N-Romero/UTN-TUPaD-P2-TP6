/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;
/**
 *
 * @author Daniela Romero
 */
public class Producto {
    private String id;
    private String nombre; 
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }
    
    

    public int getCantidad() {
        return cantidad;
    }

    
    
    public CategoriaProducto getCategoria() {
        return categoria;
    }

    
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    public void mostrarInfo(){
        System.out.println("Producto "+nombre+"\tcategoria: "+this.getCategoria().getDescripcion()+"\tid: "+id+"\t$"+precio+"\ten stock: "+cantidad);
    }
    
}

