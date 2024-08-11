/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroserver;

import cadastroserver.controller.ProdutoJpaController;
import cadastroserver.controller.UsuariosJpaController;
import cadastroserver.model.Usuarios;
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
public class CadastroThread1 extends Thread {

    private final ProdutoJpaController ctrlProd;
    private final UsuariosJpaController ctrlUsu;
    private final Socket s1;

    public CadastroThread1(ProdutoJpaController ctrlProd, UsuariosJpaController ctrlUsu, Socket s1) {
        this.ctrlProd = ctrlProd;
        this.ctrlUsu = ctrlUsu;
        this.s1 = s1;
    }

    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(s1.getOutputStream()); ObjectInputStream in = new ObjectInputStream(s1.getInputStream())) {

            String login = (String) in.readObject();
            String senha = (String) in.readObject();

            Usuarios usuario = ctrlUsu.findUsuario(login, senha);
            if (usuario == null) {
                System.out.println("Usuário não autenticado");
                s1.close();
                return;
            }
            
            System.out.println("Usuário autenticado");

            while (true) {
                String command = (String) in.readObject();
                if ("L".equals(command)) {
                    List<Produto> produtos = ctrlProd.findProdutoEntities();
                    out.writeObject(produtos);
                } else {
                    // Se comando desconhecido, talvez encerrar a conexão
                    break;
                }
            }
        } catch (EOFException e) {
            // Handle EOF, normalmente quando o cliente fecha o socket
            System.out.println("Conexão fechada pelo cliente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                s1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
