/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.labintec.business.security;

import dev.labintec.model.IRepoUser;
import dev.labintec.model.entities.Usuario;

/**
 *
 * @author HP Pavilion
 */
public class AuthenticationService implements IAuthService{
    private IRepoUser repoUser; //Dependencia al repositorio de usuarios.

    public AuthenticationService(IRepoUser repoUser) {
        this.repoUser = repoUser;
    }

    @Override
    public long signin(String username, String password) {
        Usuario user = repoUser.buscarPorUsuario(username, password); //Busca al usuario por ID utilizando el repositorio.
        return (user != null) ? user.getId() : -1; // Devuelve el ID del usuario si lo encunetra, caso contrario devuelve un -1
    }
}
