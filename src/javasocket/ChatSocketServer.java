/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author masalas
 */
public class ChatSocketServer {
    
    public String user;
    
    public ChatSocketServer(String user){
        this.user = user;
    }
    
    public void listener() throws IOException{
        Scanner teclado = new Scanner(System.in);
        ServerSocket listener = new ServerSocket(9090);
        boolean responde=false;
        try {
            while (true) {
                Socket socket = listener.accept();
                if (responde){
                    System.out.print(format("%s>> ",this.user));
                    String texto = teclado.next();

                    try {
                        PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                        out.println(format("%s>> %s",this.user, texto));
                    } finally {
                        socket.close();
                    }
                    responde=false;
                }else{
                    BufferedReader input =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String answer = input.readLine();
                    System.out.println(answer);
                    responde=true;
                }
            }
        }
        finally {
            listener.close();
        }
    }
    
}
