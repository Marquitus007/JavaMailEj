/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamailej;


/**
 *
 * @author 2004m
 */
public class MainMail {
    public static void main(String[] args){
        Mail correo = new Mail();
        correo.setCorreoFrom("correo.com");
        correo.setContraseña("password");
        correo.crearEmail("correo@gmail.com", "PRUEBA", "HOLA");
        correo.enviarMail();
    }
}
