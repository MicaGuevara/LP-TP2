/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.labintec.business.security;

/**
 *
 * @author HP Pavilion
 */
public interface IAuthService {
    //Metodo para inciar sesión.
    long signin(String username, String password);  //Recibe usuario y contraseña, devuleve el ID del usuario autenticado en caso contrario devuelve un -1.
}

