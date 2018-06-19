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
import java.net.Socket;
import java.util.Scanner;

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
        boolean responde=true;
        while(!texto.equals("/e")){
            Socket socket = new Socket(this.ip, 9090);
            if (responde){
                System.out.print(format("%s>> ",this.user));
                texto = teclado.next();
                
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
                socket.close();
            }
        }
    }
    
    
}
