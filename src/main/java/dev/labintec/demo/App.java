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

import dev.labintec.business.security.AuthenticationService;
import dev.labintec.business.security.IAuthService;
import dev.labintec.model.IRepoUser;
import dev.labintec.model.RepositoryUser;
import dev.labintec.model.entities.Usuario;


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
        
        
        
        IRepoUser repoUser = new RepositoryUser(); // Creamos el repositorio de usuarios con la ruta donde se encuentra el archivo Usuario.json
        IAuthService authService = new AuthenticationService(repoUser);// Creamos el servicio de autenticación que utiliza el repositorio
        
        // ESCENARIO DE PRUEBA 1:
        System.out.println("ESCENARIO DE PRUEBA: AGREGAR USUARIOS.");
        Usuario U1 = new Usuario(1, "Micaela", "1234");// Crea un nuevo Usuario
        repoUser.agregarUsuario(U1);// Agregar un nuevo usuario
        
        //ESCENARIO DE PRUEBA 2:
        System.out.println("ESCENARIO DE PRUEBA: AGREGAR OTRO USUARIO CON EL MISMO ID.");
        Usuario U2 = new Usuario(1, "Esteban", "5678");
        repoUser.agregarUsuario(U2);  // No se debe agregar
        
        //ESCENARIO DE PRUEBA 3:
        System.out.println("ESCECARIO DE PRUEBA: AGREGR OTRO USUARIO CON OTRO ID");
        Usuario usuario2 = new Usuario(2, "Ihara", "91011");
        repoUser.agregarUsuario(usuario2);
        
        //ESCENARIO DE PRUEBA 4:
        System.out.println("ESCENARIO DE PRUEBA: LISTAR USUARIOS EXISTENTES");
        for (Usuario user : repoUser.listarTodos()) {
            System.out.println(user.getUsername());
        }
        
        //ESCENARIO DE PRUEBA 5:
        System.out.println("ESCENARIO DE PRUEBA: ELIMINAR USUARIO POR ID");
        repoUser.eliminarUsuarioPorId(2);
        System.out.println("LISTAR USUARIOS EXISTENTES:");
        for (Usuario user : repoUser.listarTodos()) {
            System.out.println(user.getUsername());
        }
        
        //ESCENARIO DE PRUEBA 6: 
        System.out.println("ESCENARIO DE PRUEBA: INICIAR SESION ");
        long idAutenticado = authService.signin("Micaela", "1234");
        if (idAutenticado != -1) {
            System.out.println("Usuario autenticado con ID: " + idAutenticado);
        } else {
            System.out.println("No se pudo autenticar el usuario.");
        }
        
        //ESCENARIO DE PRUEBA 7:
        System.out.println("ESCENARIO DE PRUEBA: ACTUALIZAR USUARIO");
        Usuario UA = new Usuario(1, "Mica", "Xiomara");
        repoUser.actualizarUsuario(UA);
        System.out.println("LISTAR USUARIO:");
        for (Usuario user : repoUser.listarTodos()) {
            System.out.println(user.getUsername());
        }
    }
}
