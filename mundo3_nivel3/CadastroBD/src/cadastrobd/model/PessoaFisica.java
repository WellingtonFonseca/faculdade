/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;


/**
 *
 * @author wellingtonfonseca
 */
public class PessoaFisica extends Pessoa {
    private String tipo = "pf";

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
    private String cpf;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
        
    public PessoaFisica(
            int id,
            String nome,
            String logradouro,
            String cidade,
            String estado,
            String telefone,
            String email,
            String cpf
    ) {
        super(
            id,
            nome,
            logradouro,
            cidade,
            estado,
            telefone,
            email
        );
        this.cpf = cpf;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("tipo: " + tipo);
        System.out.println("cpf: " + cpf);
    }
}
