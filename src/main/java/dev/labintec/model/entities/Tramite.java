/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.labintec.model.entities;

/**
 *
 * @author HP Pavilion
 */
public class Tramite {
     private int id;
    private String tipo;
    private String estado;
    private String descripcion;
    

     public Tramite() {

     }

    public Tramite(int id, String tipo, String estado, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getTipo() { 
        return tipo; 
    }
    public void setTipo(String tipo) { 
        this.tipo = tipo; 
    }

    public String getEstado() { 
        return estado; 
    }
    public void setEstado(String estado) { 
        this.estado = estado; 
    }

    public String getDescripcion() { 
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }

    @Override
    public String toString() {
        return "Tramite{id=" + id + ", tipo='" + tipo + "', estado='" + estado + "', descripcion='" + descripcion + "'}";
    }
    
}
