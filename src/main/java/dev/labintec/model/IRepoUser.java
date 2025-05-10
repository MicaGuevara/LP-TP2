/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.labintec.model;

import dev.labintec.model.entities.Usuario;
import java.util.List;

/**
 *
 * @author HP Pavilion
 */
public interface IRepoUser {
    Usuario buscarPorUsuario(String username, String password); //Metodo para buscar un usuario mediante nombre y contraseña.
    List<Usuario> listarTodos(); // Listar todos los usuarios.
    void agregarUsuario(Usuario nuevoUsuario); // Agregar un nuevo usuario.
    void eliminarUsuarioPorId(long id); // Eliminar usuario por ID.
    void actualizarUsuario(Usuario usuarioActualizado); // Actualizar los datos de un usuario.
}
