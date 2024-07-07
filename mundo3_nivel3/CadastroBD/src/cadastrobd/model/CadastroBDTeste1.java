/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author wellingtonfonseca
 */
public class CadastroBDTeste1 {
    public static void main(String[] args) {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        
        System.out.println("-------------------------");
        System.out.println("Pessoa Fisica incluir");
        System.out.println("-------------------------");
        PessoaFisica pf = new PessoaFisica(0, "João Silva", "Rua A", "Cidade A", "Estado A", "123456789", "joao@exemplo.com", "111.222.333-44");
        pf = pessoaFisicaDAO.incluir(pf);
        System.out.println("OK");
        System.out.println("-------------------------");

        System.out.println("-------------------------");
        System.out.println("Pessoa Fisica alterar");
        System.out.println("-------------------------");
        pf.setNome("João Silva Alterado");
        pessoaFisicaDAO.alterar(pf);
        System.out.println("OK");
        System.out.println("-------------------------");
        
        System.out.println("-------------------------");
        System.out.println("Pessoa Fisica listar");
        System.out.println("-------------------------");
        // Consultar todas as pessoas Fisicas do banco de dados e listar no console
        for (PessoaFisica pessoa : pessoaFisicaDAO.getPessoas()) {
            System.out.println(" ");
            pessoa.exibir();
            System.out.println(" ");
        }
        System.out.println("-------------------------");
        
        System.out.println("-------------------------");
        System.out.println("Pessoa Fisica exluir");
        System.out.println("-------------------------");
        pessoaFisicaDAO.excluir(pf.getId());
        System.out.println("OK");
        System.out.println("-------------------------");
           
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        
        System.out.println("-------------------------");
        System.out.println("Pessoa Juridica incluir");
        System.out.println("-------------------------");
        PessoaJuridica pj = new PessoaJuridica(0, "Empresa X", "Rua B", "Cidade B", "Estado B", "987654321", "empresa@exemplo.com", "12.345.678/0001-99");
        pessoaJuridicaDAO.incluir(pj);
        System.out.println("OK");
        System.out.println("-------------------------");

        System.out.println("-------------------------");
        System.out.println("Pessoa Juridica alterar");
        System.out.println("-------------------------");
        pj.setNome("Empresa X Alterada");
        pessoaJuridicaDAO.alterar(pj);
        System.out.println("OK");
        System.out.println("-------------------------");

        System.out.println("-------------------------");
        System.out.println("Pessoa Juridica listar");
        System.out.println("-------------------------");
        for (PessoaJuridica pessoa : pessoaJuridicaDAO.getPessoas()) {
            System.out.println(" ");
            pessoa.exibir();
            System.out.println(" ");
        }
        System.out.println("-------------------------");

        System.out.println("-------------------------");
        System.out.println("Pessoa Juridica exluir");
        System.out.println("-------------------------");
        pessoaJuridicaDAO.excluir(pj.getId());
        System.out.println("OK");
        System.out.println("-------------------------");
    }
}
