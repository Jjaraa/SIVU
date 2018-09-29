/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sivu;

/**
 *
 * @author Master
 */
public class Admin {
    public String nombreUsuario;
    private String contraseña; 


    private void crearUsuario(String nombreUsuario, String contraseña){
        Usuario usuario1 = new Usuario(nombreUsuario, contraseña);
    } 

}
