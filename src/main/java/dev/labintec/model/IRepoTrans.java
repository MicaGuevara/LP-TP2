/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.labintec.model;

import dev.labintec.model.entities.Tramite;
import java.util.List;

/**
 *
 * @author HP Pavilion
 */
public interface IRepoTrans {
    List<Tramite> obtenerTodos();  // Obtiene la lista de trámites
    Tramite buscarPorId(int id);  // Buscar trámite por ID
    boolean agregar(Tramite tramite);  // Agregar un trámite
    boolean eliminar(int id);  // Eliminar un trámite
    void actualizarPorID(int id, Tramite actualizado); // actualiza un tramite
}
