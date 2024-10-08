/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroserver;

import cadastroserver.controller.ProdutoJpaController;
import cadastroserver.controller.UsuariosJpaController;
import cadastroserver.controller.MovimentosJpaController;
import cadastroserver.controller.PessoaJpaController;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author wellingtonfonseca
 */
public class CadastroServer {

    public static void main(String[] args) {
        // Criação do EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CadastroServerPU");

        // Criação dos controladores
        ProdutoJpaController ctrlProd = new ProdutoJpaController(emf);
        UsuariosJpaController ctrlUsu = new UsuariosJpaController(emf);
        MovimentosJpaController ctrlMov = new MovimentosJpaController(emf);
        PessoaJpaController ctrlPessoa = new PessoaJpaController(emf);

        // Criação do ServerSocket
        try (ServerSocket serverSocket = new ServerSocket(4321)) {
            System.out.println("Servidor iniciado na porta 4321...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                CadastroThread thread = new CadastroThread(ctrlProd, ctrlUsu, ctrlMov, ctrlPessoa, clientSocket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
