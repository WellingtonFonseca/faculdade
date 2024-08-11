/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroserver;

import cadastroserver.controller.ProdutoJpaController;
import cadastroserver.controller.UsuariosJpaController;
import cadastroserver.controller.MovimentosJpaController;
import cadastroserver.controller.PessoaJpaController;
import cadastroserver.model.Usuarios;
import cadastroserver.model.Produto;
import cadastroserver.model.Movimentos;
import cadastroserver.model.Pessoa;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wellingtonfonseca
 */
public class CadastroThread extends Thread {

    private final ProdutoJpaController ctrlProd;
    private final UsuariosJpaController ctrlUsu;
    private final MovimentosJpaController ctrlMov;
    private final PessoaJpaController ctrlPessoa;
    private final Socket s1;

    public CadastroThread(ProdutoJpaController ctrl, UsuariosJpaController ctrlUsu, MovimentosJpaController ctrlMov, PessoaJpaController ctrlPessoa, Socket s1) {
        this.ctrlProd = ctrl;
        this.ctrlUsu = ctrlUsu;
        this.ctrlMov = ctrlMov;
        this.ctrlPessoa = ctrlPessoa;
        this.s1 = s1;
    }

    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(s1.getOutputStream()); 
             ObjectInputStream in = new ObjectInputStream(s1.getInputStream())) {

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
                } else if ("E".equals(command) || "S".equals(command)) {
                    long idPessoa = (Long) in.readObject();
                    long idProduto = (Long) in.readObject();
                    int quantidade = (Integer) in.readObject();
                    float preco = (Float) in.readObject();
                    
                    Movimentos movimento = new Movimentos();
                    movimento.setTipo(command);
                    movimento.setIdUsuario(usuario.getId());
                    movimento.setIdPessoa(idPessoa);
                    movimento.setIdProduto(idProduto);
                    movimento.setQuantidade(quantidade);
                    movimento.setPreco(preco);
                    movimento.setDataMovimento(new Date());

                    ctrlMov.create(movimento);

                    Produto produto = ctrlProd.findProduto(idProduto);
                    if (produto != null) {
                        if ("E".equals(command)) {
                            produto.setQuantidade(produto.getQuantidade() + quantidade);
                        } else if ("S".equals(command)) {
                            produto.setQuantidade(produto.getQuantidade() - quantidade);
                        }
                        
                        try {
                            ctrlProd.edit(produto);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    // Comando desconhecido, encerrar conexão
                    break;
                }
            }
        } catch (EOFException e) {
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