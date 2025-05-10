/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.labintec.business;

import dev.labintec.model.entities.Tramite;
import java.util.List;

/**
 *
 * @author avila
 */
public interface ITransTypeService {
    List<Tramite> getTramites();  // En lugar de tipos de transacción, devolvemos trámites
}
