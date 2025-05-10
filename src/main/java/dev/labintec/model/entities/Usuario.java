/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.labintec.model.entities;

/**
 *
 * @author HP Pavilion
 */
public class Usuario {
   private int id;
   private String username;
   private String password;

    public Usuario() {
    }

    public Usuario(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId(){
     return this.id;
    }
    public void setId(int id){
     this.id=id;
    }

   public String getUsername(){
      return this.username;
   }
   public void setUsername(String username){
      this.username= username;
   }

   public String getPassword(){
      return this.password;
   }
   public void setPassword(String password){
      this.password=password;
   } 
}
