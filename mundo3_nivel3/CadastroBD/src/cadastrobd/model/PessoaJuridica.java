/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;


/**
 *
 * @author wellingtonfonseca
 */
public class PessoaJuridica extends Pessoa {
    private String tipo = "pj";

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
    private String cnpj;
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public PessoaJuridica(
            int id,
            String nome,
            String logradouro,
            String cidade,
            String estado,
            String telefone,
            String email,
            String cnpj
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
        this.cnpj = cnpj;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("tipo: " + tipo);
        System.out.println("cnpj: " + cnpj);
    }
}
