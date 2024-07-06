/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;
import java.io.IOException;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.PessoaFisicaRepo;
import model.PessoaJuridicaRepo;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author wellingtonfonseca
 */
public class CadastroPOO1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            
            PessoaFisica pessoaFisica1 = new PessoaFisica(1, "Wellington", "123.456.789-00", 31);
            PessoaFisica pessoaFisica2 = new PessoaFisica(2, "Amanda", "001.234.567-89", 30);
            
            System.out.println("pessoas_fisicas: inserindo");
            
            repo1.inserir(pessoaFisica1);
            repo1.inserir(pessoaFisica2);
            
            System.out.println("pessoas_fisicas: persistindo");
            
            repo1.persistir("pessoas_fisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            
            System.out.println("pessoas_fisicas: recuperando");
            
            repo2.recuperar("pessoas_fisicas.dat");
            
            ArrayList<PessoaFisica> pessoasFisicasRecuperadas = repo2.obterTodos();
            
            for (PessoaFisica pessoa : pessoasFisicasRecuperadas) {
                pessoa.exibir();
            }

            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            
            PessoaJuridica pessoaJuridica1 = new PessoaJuridica(1, "Empresa A", "12345678901234");
            PessoaJuridica pessoaJuridica2 = new PessoaJuridica(2, "Empresa B", "98765432109876");
               
            System.out.println("pessoas_fisicas: inserindo");
            
            repo3.inserir(pessoaJuridica1);
            repo3.inserir(pessoaJuridica2);
            
            System.out.println("pessoas_fisicas: persistindo");
            
            repo3.persistir("pessoas_juridicas.bin");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
               
            System.out.println("pessoas_fisicas: recuperando");
            
            repo4.recuperar("pessoas_juridicas.bin");
            
            ArrayList<PessoaJuridica> pessoasJuridicasRecuperadas = repo4.obterTodos();
            
            for (PessoaJuridica pessoa : pessoasJuridicasRecuperadas) {
                pessoa.exibir();
            }
        } catch (IOException ex) {
            System.err.println("Erro ao manipular arquivos: " + ex.getMessage());
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao recuperar objeto: Classe não encontrada.");
        }
    }   
}
