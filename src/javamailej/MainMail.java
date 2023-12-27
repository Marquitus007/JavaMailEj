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
        correo.setCorreoFrom("m7504256@gmail.com");
        correo.setContraseña("rfekgbgepiqkmgus");
        correo.crearEmail("markitus0072004@gmail.com", "PRUEBA", "HOLA");
        correo.enviarMail();
    }
}
