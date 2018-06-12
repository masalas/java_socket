/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.String.format;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author masalas
 */
public class ChatSocketClient {
    public String ip;
    public String user;

    public ChatSocketClient(String ip, String user) {
        this.ip = ip;
        this.user = user;
    }
    
    public void conectar() throws IOException{
        String texto="";
        Scanner teclado = new Scanner(System.in);
        while(texto.equals("/e")){
            System.out.print(format("%s>> ",this.user));
            texto = teclado.next();
            Socket s = new Socket(this.ip, 9090);
            BufferedReader input =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
            String answer = input.readLine();
            JOptionPane.showMessageDialog(null, answer);
        }
    }
    
    
}
