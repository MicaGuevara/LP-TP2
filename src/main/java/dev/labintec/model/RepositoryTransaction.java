/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.labintec.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.labintec.model.entities.Tramite;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP Pavilion
 */
public class RepositoryTransaction implements IRepoTrans{
    private final String ruta = "src/main/java/dev/labintec/data/Tramite.json"; // Ruta donde se encuentra el archivo JSON con los trámites

    //Lee todos los trámites desde el archivo JSON y los devuelve como lista.
    //Si ocurre un error, devuelve una lista vacía.
    private List<Tramite> leerDesdeArchivo() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(ruta), new TypeReference<List<Tramite>>() {});// Lee el archivo JSON y lo convierte a una lista de objetos Tramite.
        } catch (IOException e) {
            System.out.println("[json] Error al leer tramites: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    private void guardarEnArchivo(List<Tramite> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(ruta), lista);// Escribe la lista en el archivo JSON.
        } catch (IOException e) {
            System.out.println("[json] Error al guardar tramites: " + e.getMessage());
        }
    }

    @Override
    public List<Tramite> obtenerTodos() {
        return leerDesdeArchivo();// Devuelve la lista completa leída desde el archivo.
    }

    @Override
    public Tramite buscarPorId(int id) {
        List<Tramite> lista = leerDesdeArchivo();// Lee todos los trámites desde el archivo.
        for (Tramite t : lista) {// Recorre la lista y busca el que tenga el ID indicado
            if (t.getId() == id) {
                return t; //Devuelve el tramite encontrado.
            }
        }
        return null;
    }
    
    @Override
    public boolean agregar(Tramite tramite) {
        List<Tramite> tramites = obtenerTodos();// Obtiene todos los trámites actuales.
        for (Tramite t : tramites) { // Verifica si ya existe un trámite con el mismo ID.
            if (t.getId() == tramite.getId()) {
                return false; // No se agrega porque ya existe
            }
        }
        tramites.add(tramite);// Si no existe, se agrega a la lista
        guardarEnArchivo(tramites);// Se guarda la lista actualizada en el archivo
        return true;

    }

    @Override
    public boolean eliminar(int id) {
        List<Tramite> tramites = obtenerTodos();// Lee todos los trámites desde el archivo
        boolean eliminado = tramites.removeIf(t -> t.getId() == id);// Intenta eliminar el trámite que tenga el ID especificado
        
        if (eliminado) {// Si se eliminó al menos uno, se guarda la lista nueva
            guardarEnArchivo(tramites);
        }
        return eliminado;
    }

    @Override
    public void actualizarPorID(int id, Tramite actualizado) {
        List<Tramite> lista = leerDesdeArchivo();
        for (int i = 0; i < lista.size(); i++) {  // Recorre la lista buscando el trámite a actualizar.
            if (lista.get(i).getId() == id) {
                lista.set(i, actualizado);// Reemplaza el trámite por el actualizado.
                break;
            }
        }
        guardarEnArchivo(lista);// Guarda la lista modificada.
    }
}
