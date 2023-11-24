/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Quezada bryam
 */
public class Medicina {
    //declaracion de atributos
    private int codigo;
    private String nombre;
    private String marca;
    private String descripcion;
    private Double precio;
    //Creacion de constructores
    public Medicina (){
        
    }
    
    public Medicina(int codigo, String nombre, String marca, String descripcion, Double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    //creacion de getters y setters 
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    //devuelve el toString
    @Override
    public String toString() {
        return "Medicina{" + "codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    
}
