/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroclientv2;

import cadastroserver.model.Produto;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author wellingtonfonseca
 */
public class CadastroClientV2 {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 4321); ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Login: ");
            String login = reader.readLine();
            System.out.print("Senha: ");
            String senha = reader.readLine();
            out.writeObject(login);
            out.writeObject(senha);

            while (true) {
                System.out.println("Menu: L - Listar, X - Finalizar, E - Entrada, S - Saída");
                String command = reader.readLine();
                out.writeObject(command);

                if ("X".equals(command)) {
                    break;
                } else if ("L".equals(command)) {
                    List<Produto> produtos = (List<Produto>) in.readObject();
                    for (Produto produto : produtos) {
                        System.out.print(produto.getNome());
                        System.out.print("::");
                        System.out.println(produto.getQuantidade());
                    }
                } else if ("E".equals(command) || "S".equals(command)) {
                    System.out.print("ID Pessoa: ");
                    long idPessoa = Long.parseLong(reader.readLine());
                    out.writeObject(idPessoa);

                    System.out.print("ID Produto: ");
                    long idProduto = Long.parseLong(reader.readLine());
                    out.writeObject(idProduto);

                    System.out.print("Quantidade: ");
                    int quantidade = Integer.parseInt(reader.readLine());
                    out.writeObject(quantidade);

                    System.out.print("Valor Unitário: ");
                    float preco = Float.parseFloat(reader.readLine());
                    out.writeObject(preco);
                }
            }
        } catch (EOFException e) {
            // Handle EOFException
            System.out.println("Conexão com o servidor foi encerrada.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
