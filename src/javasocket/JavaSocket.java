/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasocket;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author masalas
 */
public class JavaSocket {

    public static String user;
    public static String IP;
    public static ChatSocketServer server;
    public static ChatSocketClient client;
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Username: ");
        user = teclado.next();
        
        int opcao=-1;
        while(opcao!=3){
            System.out.print(menu());
            opcao = Integer.valueOf(teclado.next());
            switch(opcao){
                case 1:{
                    System.out.print("Digite o ip: ");
                    IP = teclado.next();
                    client = new ChatSocketClient(IP, user);
                    try {
                        client.conectar();
                    } catch (IOException ex) {
                        System.out.println("Falha ao conectar ao servidor: "+ex.getMessage());
                    }
                    break;
                }
                case 2:{
                    System.out.println("Escutando na porta 9090");
                    server = new ChatSocketServer(user);
                    try {
                        server.listener();
                    } catch (IOException ex) {
                        System.out.println("Falha ao abrir servidor: "+ex.getMessage());
                    }
                    break;
                }
            }
        }
    }
    
    public static String menu(){
        return "Bem vindo!\n"+
                "1 - Conectar\n" +
                "2 - Abrir servidor\n"+
                "3 - Sair\n"+
                "Opção: ";
    }
    
}
