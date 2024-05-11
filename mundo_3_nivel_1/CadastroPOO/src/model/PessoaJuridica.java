/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;

/**
 *
 * @author wellingtonfonseca
 */
public class PessoaJuridica extends Pessoa implements Serializable {
    @Override
    public void exibir() {
        super.exibir(); // Chamando o método exibir da superclasse Pessoa
        System.out.println("CNPJ: " + cnpj);
    }
    
    private String cnpj;

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
