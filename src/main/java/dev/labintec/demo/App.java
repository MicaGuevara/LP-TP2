/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dev.labintec.demo;

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
