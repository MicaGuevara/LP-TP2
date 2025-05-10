/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dev.labintec.demo;

import dev.labintec.business.ConfigurationService;
import dev.labintec.business.IConfService;
import dev.labintec.model.IRepoTrans;
import dev.labintec.model.RepositoryTransaction;
import dev.labintec.model.entities.Tramite;
import java.util.List;

/**
 *
 * @author HP Pavilion
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        

        //GESTION DE TRAMITES
        IRepoTrans repo = new RepositoryTransaction();
        IConfService confService = new ConfigurationService(repo);

        // Crear un nuevo trámite
        Tramite tramite = new Tramite(1, "Inscripcion", "Pendiente", "Trámite de inscripción en el sistema");
        Tramite tramite2 = new Tramite(2, "Inscripcion", "Pendiente", "Trámite de inscripción en el sistema");
        
        // Registrar el trámite
        confService.registrarTramite(tramite);
        confService.registrarTramite(tramite2);

        // Listar los trámites para verificar que se agregó
        List<Tramite> tramites = confService.listarTramites();
        System.out.println("Lista de trámites:");
        for (Tramite t : tramites) {
            System.out.println(t);
        }
        
        
        // Actualizamos el estado
        confService.actualizarEstadoTramite(1, "Aprobado");
 
        
        // Verificamos si se actualizó
        Tramite actualizado = confService.obtenerTramitePorId(1);
        System.out.println("Estado actualizado:");
        System.out.println(actualizado);
        
        
        // Eliminamos un Tramite
        boolean fueEliminado = repo.eliminar(1); // por ejemplo, ID 1

        if (fueEliminado) {
            System.out.println("Trámite eliminado correctamente.");
            } else {
            System.out.println("No se encontró un trámite con ese ID.");
        }
        
        
        
    }
}
