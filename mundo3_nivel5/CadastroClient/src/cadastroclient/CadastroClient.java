/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroclient;

import cadastroserver.model.Produto;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author wellingtonfonseca
 */
public class CadastroClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 4321); ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
            System.out.println("Conectado ao servidor.");

            out.writeObject("123"); // Login
            out.writeObject("U3VhU3RyaW5nQXF1aQ=="); // Senha

            out.writeObject("L");

            List<Produto> produtos = (List<Produto>) in.readObject();
            for (Produto produto : produtos) {
                System.out.println(produto.getNome());
            }
        } catch (EOFException e) {
            // Handle EOFException
            System.out.println("Conexão com o servidor foi encerrada.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

