/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclientv2;
import cadastroserver.model.Produto;
import java.io.IOException;
import javax.swing.JTextArea;
import java.io.ObjectInputStream;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author wellingtonfonseca
 */
public class ThreadClient extends Thread {

    private final ObjectInputStream entrada;
    private final JTextArea textArea;

    public ThreadClient(ObjectInputStream entrada, JTextArea textArea) {
        this.entrada = entrada;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = entrada.readObject();
                SwingUtilities.invokeLater(() -> {
                    if (obj instanceof String) {
                        textArea.append((String) obj + "\n");
                    } else if (obj instanceof List) {
                        @SuppressWarnings("unchecked")
                        List<Produto> produtos = (List<Produto>) obj;
                        for (Produto produto : produtos) {
                            textArea.append(produto.getNome() + " - Quantidade: " + produto.getQuantidade() + "\n");
                        }
                    }
                });
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}