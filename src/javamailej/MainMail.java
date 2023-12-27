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
<<<<<<< HEAD
        correo.setCorreoFrom("correo@gmail.com");
        correo.setContraseña("password");
        correo.crearEmail("correo@gmail.com", "PRUEBA", "HOLA");
=======
        correo.setCorreoFrom("mail.com");
        correo.setContraseña("password");
        correo.crearEmail("mail@gmail.com", "PRUEBA", "HOLA");
>>>>>>> eaae5eaed9bf8fc1eae71712c67b5391586deb62
        correo.enviarMail();
    }
}
