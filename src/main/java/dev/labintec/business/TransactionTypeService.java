/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.labintec.business;

import dev.labintec.model.IRepoTrans;
import dev.labintec.model.entities.Tramite;
import java.util.List;

/**
 *
 * @author avila
 */
public class TransactionTypeService implements ITransTypeService{
    
    private IRepoTrans repo;

    public TransactionTypeService(IRepoTrans repo) {
        this.repo = repo;
    }

    @Override
    public List<Tramite> getTramites() {
        return repo.obtenerTodos();  // Devuelve la lista de trámites desde el repositorio
    }
}
