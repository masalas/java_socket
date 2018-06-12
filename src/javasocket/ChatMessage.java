/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasocket;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.net.Socket;

/**
 *
 * @author masalas
 */
public class ChatMessage {
    public String user;
    public String message;
    
    public ChatMessage(String user, String message, Socket s) throws IOException{
        try {
            PrintWriter out =
                new PrintWriter(s.getOutputStream(), true);
            out.println(format("%s>> %s", user, message));
        } finally {
            s.close();
        }
    }
}
