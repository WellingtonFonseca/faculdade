/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclientv2;
import javax.swing.JDialog;
import javax.swing.JTextArea;
/**
 *
 * @author wellingtonfonseca
 */
public class SaidaFrame extends JDialog {

    public JTextArea texto;

    public SaidaFrame() {
        texto = new JTextArea();
        texto.setEditable(false);
        this.add(texto);
        this.setBounds(100, 100, 400, 300);
        this.setModal(false);
    }
}