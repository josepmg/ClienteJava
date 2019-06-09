/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejava;

import java.io.IOException;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author JP
 */
public class ClienteJava {

    public static void main(String[] args) throws IOException {
        String conteudo = Request
                .Post("http://localhost:8080/carrinho/produtoService")
                .addHeader("accept", "application/json")
                .execute()
                .returnContent()
                .asString();

        System.out.println(conteudo);
    }
    
}
