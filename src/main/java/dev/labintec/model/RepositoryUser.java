/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.labintec.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.labintec.model.entities.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP Pavilion
 */
public class RepositoryUser implements IRepoUser {
       private final String ruta = "src/main/java/dev/labintec/data/Usuario.json"; // Ruta del archivo JSON que contiene la lista de usuarios.

    @Override
    public Usuario buscarPorUsuario(String username, String password) {
        try {
            ObjectMapper objectMapper = new ObjectMapper(); // Crea una instancia de ObjectMapper para leer el archivo JSON.
            List<Usuario> usuarios = objectMapper.readValue( 
                new File(ruta), new TypeReference<List<Usuario>>() {} // Lee el archivo y convierte su contenido a una lista de objetos Usuario.
            );

            for (Usuario u : usuarios) { // Recorre la lista de usuarios y compara.
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    return u; // Devuelve el usuario que coincide el usuario y contraseña.
                }
            }
        } catch (IOException e) {
            System.out.println("[json] Error al leer usuarios: " + e.getMessage()); 
        }

        return null; 
    }

    
    @Override
    public List<Usuario> listarTodos() {
        try {
            File file = new File(ruta);
            // Verifica si el archivo existe y no está vacío
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>(); // Si está vacío, devuelve una lista vacía
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(
                new File(ruta), new TypeReference<List<Usuario>>() {}
            );
        } catch (IOException e) {
            System.out.println("[json] Error al leer usuarios: " + e.getMessage());
            return new ArrayList<>(); // Devuelve una lista vacía en caso de error
        }
    }

    
    @Override
    public void agregarUsuario(Usuario nuevoUsuario) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Usuario> usuarios = listarTodos();  // Carga los usuarios existentes.
    
        for (Usuario usuario : usuarios) { // Verificar si el usuario ya existe con el mismo ID
            if (usuario.getId() == nuevoUsuario.getId()) {
                System.out.println("El usuario con ID " + nuevoUsuario.getId() + " ya existe.");
                return;  // Salir del método si el usuario ya existe.
            }
        }

        usuarios.add(nuevoUsuario);  // Agregar el nuevo usuario a la lista
        objectMapper.writeValue(new File(ruta), usuarios);  // Guardar la lista actualizada en el archivo

        System.out.println("Usuario " + nuevoUsuario.getUsername()+ " agregado correctamente.");
    } catch (IOException e) {
        System.out.println("[json] Error al guardar usuario: " + e.getMessage());
    }
    }

    @Override
    public void eliminarUsuarioPorId(long id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Usuario> usuarios = listarTodos();  // Carga la lista de usuarios.
            usuarios.removeIf(u -> u.getId() == id); // Eliminar al usuario cuyo ID coincida con el proporcionado
        objectMapper.writeValue(new File(ruta), usuarios);// Guardar la lista actualizada en el archivo
        System.out.println("Usuario con ID " + id + " eliminado correctamente.");
    } catch (IOException e) {
        System.out.println("[json] Error al eliminar usuario: " + e.getMessage());
    }
    }

    @Override
    public void actualizarUsuario(Usuario usuarioActualizado) {
     try {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Usuario> usuarios = listarTodos();// Carga la lista de usuarios.
        for (int i = 0; i < usuarios.size(); i++) {  // Busca al usuario por ID y lo reemplaza con la nueva información.
            if (usuarios.get(i).getId() == usuarioActualizado.getId()) {
                usuarios.set(i, usuarioActualizado);// Reemplaza el objeto.
                break;
            }
        }
        objectMapper.writeValue(new File(ruta), usuarios); // Guarda la lista modificada en el archivo JSON.
    } catch (IOException e) {
        System.out.println("[json] Error al actualizar usuario: " + e.getMessage());
    }
    }
}
