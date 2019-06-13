/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejava;

import java.io.IOException;
import java.util.Scanner;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author JP
 */
public class ClienteJava {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        menu(keyboard);
    }
    
    public static void menu(Scanner keyboard) 
            throws IOException{
        System.out.print("Deseja receber um JSON (1) ou XML(2)? ");
        int opc = keyboard.nextInt();
        String conteudo;
        switch(opc){
            case 1:
                // Prepara o cabeçalho Rest
                conteudo = Request
                        // Local do serviço
                        .Post("http://localhost:8080/carrinho/produtoService")
                        // Define protocolo Rest
                        .addHeader("accept", "application/json")
                        // Executa
                        .execute()
                        // Retorna o conteúdo como string
                        .returnContent()
                        .asString();
                // Apresenta o retorno (JSON)
                System.out.println(conteudo);
                break;
            case 2:
                // Prepara o cabeçalho SOAP
                conteudo = Request
                        // Local do serviço
                        .Post("http://localhost:8080/carrinho/produtoService")
                        // Define protocolo SOAP
                        .addHeader("accept", "application/xml")
                        // Executa
                        .execute()
                        // Retorna o conteúdo como string
                        .returnContent()
                        .asString();
                // Apresenta o retorno (XML)
                System.out.println(conteudo);
                break;
            default:
                System.out.println("Digite uma opção válida");
                menu(keyboard);
                break;
        }
    }
    
}
