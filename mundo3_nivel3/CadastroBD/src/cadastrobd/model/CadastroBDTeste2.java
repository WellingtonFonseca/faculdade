/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

import java.util.Scanner;
/**
 *
 * @author wellingtonfonseca
 */
public class CadastroBDTeste2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

        while (true) {
            System.out.println("-------------------------");
            System.out.println("Menu:");
            System.out.println("-------------------------");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Exibir pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("0. Sair");
            System.out.println("-------------------------");
            System.out.print("Escolha uma opção: ");

            int opcao = -1;
            
            try {
                opcao = scanner.nextInt();
            }
            catch(Exception e) {}
            
            scanner.nextLine();
            
            System.out.println("-------------------------");

            switch (opcao) {
                case 1 -> incluir(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                case 2 -> alterar(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                case 3 -> excluir(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                case 4 -> exibirPeloId(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                case 5 -> exibirTodos(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                case 0 -> {
                    System.out.println("-------------------------");
                    System.out.println("Saindo...");
                    System.out.println("-------------------------");
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("-------------------------");
                    System.out.println("Opção Inválida");
                    System.out.println("-------------------------");
                }
            }
        }
    }

    private static void incluir(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        int opcao = -1;
            
        OUTER:
        while (true) {
            System.out.println("-------------------------");
            System.out.println("Incluir:");
            System.out.println("-------------------------");
            System.out.println("1. Pessoa Física");
            System.out.println("2. Pessoa Jurídica");
            System.out.println("0. Voltar");
            System.out.println("-------------------------");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
            }
            catch(Exception e) {}
            scanner.nextLine();
            System.out.println("-------------------------");
            
            switch (opcao) {
                case 1 -> {
                    break OUTER;
                }
                case 2 -> {
                    break OUTER;
                }
                case 0 -> {
                    System.out.println("-------------------------");
                    System.out.println("Voltando...");
                    System.out.println("-------------------------");
                    return;
                }
                default -> {
                    System.out.println("-------------------------");
                    System.out.println("Opção Inválida");
                    System.out.println("-------------------------");
                }
            }
        }
            
        try {
            System.out.print("cpf|cnpj: ");
            String cpf_cnpj = scanner.nextLine();
            System.out.print("nome: ");
            String nome = scanner.nextLine();
            System.out.print("logradouro: ");
            String logradouro = scanner.nextLine();
            System.out.print("cidade: ");
            String cidade = scanner.nextLine();
            System.out.print("estado: ");
            String estado = scanner.nextLine();
            System.out.print("telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("email: ");
            String email = scanner.nextLine();

            System.out.println("-------------------------");
            System.out.println("Incluindo...");
            System.out.println("-------------------------");
        
            if(opcao == 1) {
                PessoaFisica pf = new PessoaFisica(0, nome, logradouro, cidade, estado, telefone, email, cpf_cnpj);
                pessoaFisicaDAO.incluir(pf);
            } else if(opcao == 2){
                PessoaJuridica pj = new PessoaJuridica(0, nome, logradouro, cidade, estado, telefone, email, cpf_cnpj);
                pessoaJuridicaDAO.incluir(pj);
            }

            System.out.println("-------------------------");
            System.out.println("Incluir: OK");
            System.out.println("-------------------------");
        
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void alterar(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        int opcao = -1;
        int id = -1;
        
        while (true) {
            System.out.println("-------------------------");
            System.out.println("Alterar:");
            System.out.println("-------------------------");
            System.out.print("Informe o id (0. Voltar): ");

            try {
                opcao = scanner.nextInt();
            }
            catch(Exception e) {}
            
            scanner.nextLine();
            System.out.println("-------------------------");
            
            if(opcao > 0) {
                id = opcao;
                break;
            }
            if(opcao == 0){
                System.out.println("-------------------------");
                System.out.println("Voltando...");
                System.out.println("-------------------------");
                return;
            } else {
                System.out.println("-------------------------");
                System.out.println("Opção Inválida");
                System.out.println("-------------------------");
            }
        }
        
        System.out.println("-------------------------");
        System.out.println("Buscando...");
        System.out.println("-------------------------");
        
        PessoaFisica pf = pessoaFisicaDAO.getPessoa(id);
        PessoaJuridica pj = null;
        
        if(pf == null){
            pj = pessoaJuridicaDAO.getPessoa(id);
        }
        
        if(pf == null && pj == null) {
            System.out.println("-------------------------");
            System.out.println("Alterar: Não encontrado");
            System.out.println("-------------------------");

        } else {
            
            try {
                id = (pf != null) ? pf.getId() : pj.getId();
            
                System.out.println("-------------------------");
                System.out.print("Alterando id: ");
                System.out.println(id);
                System.out.println("-------------------------");

                String cpf_cnpj = (pf != null) ? pf.getCpf() : pj.getCnpj();
                System.out.print("cpf|cnpj (" + cpf_cnpj + "):");
                String resposta =  scanner.nextLine();
                cpf_cnpj = ("".equals(resposta)) ? cpf_cnpj : resposta;

                String nome = (pf != null) ? pf.getNome() : pj.getNome();
                System.out.print("nome (" + nome + "):");
                resposta =  scanner.nextLine();
                nome = ("".equals(resposta)) ? nome : resposta;

                String logradouro = (pf != null) ? pf.getLogradouro() : pj.getLogradouro();
                System.out.print("logradouro (" + logradouro + "):");
                resposta =  scanner.nextLine();
                logradouro = ("".equals(resposta)) ? logradouro : resposta;

                String cidade = (pf != null) ? pf.getCidade() : pj.getCidade();
                System.out.print("cidade (" + cidade + "):");
                resposta =  scanner.nextLine();
                cidade = ("".equals(resposta)) ? cidade : resposta;

                String estado = (pf != null) ? pf.getEstado() : pj.getEstado();
                System.out.print("estado (" + estado + "):");
                resposta =  scanner.nextLine();
                estado = ("".equals(resposta)) ? estado : resposta;

                String telefone = (pf != null) ? pf.getTelefone() : pj.getTelefone();
                System.out.print("telefone (" + telefone + "):");
                resposta =  scanner.nextLine();
                telefone = ("".equals(resposta)) ? telefone : resposta;

                String email = (pf != null) ? pf.getEmail() : pj.getEmail();
                System.out.print("email (" + email + "):");
                resposta =  scanner.nextLine();
                email = ("".equals(resposta)) ? email : resposta;
                
                System.out.println("-------------------------");
                System.out.println("Alterando...");
                System.out.println("-------------------------");

                if(pf != null){
                    pf = new PessoaFisica(
                            pf.getId(),
                            nome, 
                            logradouro, 
                            cidade, 
                            estado, 
                            telefone,
                            email,
                            cpf_cnpj
                    );

                    pessoaFisicaDAO.alterar(pf);

                } else {
                    pj = new PessoaJuridica(
                            pj.getId(),
                            nome, 
                            logradouro, 
                            cidade, 
                            estado, 
                            telefone,
                            email,
                            cpf_cnpj
                    );

                    pessoaJuridicaDAO.alterar(pj);

                }

                System.out.println("-------------------------");
                System.out.println("Alterar: OK");
                System.out.println("-------------------------");
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
            
            
        }
    }

    private static void excluir(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        int opcao = -1;
        int id = -1;
        
        while (true) {
            System.out.println("-------------------------");
            System.out.println("Excluir:");
            System.out.println("-------------------------");
            System.out.print("Informe o id (0. Voltar): ");

            try {
                opcao = scanner.nextInt();
            }
            catch(Exception e) {}
            
            scanner.nextLine();
            System.out.println("-------------------------");
            
            if(opcao > 0) {
                id = opcao;
                break;
            }
            if(opcao == 0){
                System.out.println("-------------------------");
                System.out.println("Voltando...");
                System.out.println("-------------------------");
                return;
            } else {
                System.out.println("-------------------------");
                System.out.println("Opção Inválida");
                System.out.println("-------------------------");
            }
        }
        
        System.out.println("-------------------------");
        System.out.println("Buscando...");
        System.out.println("-------------------------");
        
        PessoaFisica pf = pessoaFisicaDAO.getPessoa(id);
        PessoaJuridica pj = null;
        
        if(pf == null){
            pj = pessoaJuridicaDAO.getPessoa(id);
        }
        
        if(pf == null && pj == null) {
            System.out.println("-------------------------");
            System.out.println("Excluir: Não encontrado");
            System.out.println("-------------------------");

        } else {
            
            try {
                System.out.println("-------------------------");
                System.out.println("Excluindo...");
                System.out.println("-------------------------");

                if(pf != null){
                    pessoaFisicaDAO.excluir(pf.getId());
                } else {
                    pessoaJuridicaDAO.excluir(pj.getId());
                }

                System.out.println("-------------------------");
                System.out.println("Excluir: OK");
                System.out.println("-------------------------");
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
            
        }
    }

    private static void exibirPeloId(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        int opcao = -1;
        int id = -1;
        
        while (true) {
            System.out.println("-------------------------");
            System.out.println("Exibir pelo ID:");
            System.out.println("-------------------------");
            System.out.print("Informe o id (0. Voltar): ");

            try {
                opcao = scanner.nextInt();
            }
            catch(Exception e) {}
            
            scanner.nextLine();
            System.out.println("-------------------------");
            
            if(opcao > 0) {
                id = opcao;
                break;
            }
            if(opcao == 0){
                System.out.println("-------------------------");
                System.out.println("Voltando...");
                System.out.println("-------------------------");
                return;
            } else {
                System.out.println("-------------------------");
                System.out.println("Opção Inválida");
                System.out.println("-------------------------");
            }
        }
        
        System.out.println("-------------------------");
        System.out.println("Buscando...");
        System.out.println("-------------------------");
        
        PessoaFisica pf = pessoaFisicaDAO.getPessoa(id);
        PessoaJuridica pj = null;
        
        if(pf == null){
            pj = pessoaJuridicaDAO.getPessoa(id);
        }
        
        if(pf == null && pj == null) {
            System.out.println("-------------------------");
            System.out.println("Exibir pelo ID: Não encontrado");
            System.out.println("-------------------------");

        } else {           
            System.out.println("-------------------------");
            System.out.println("Exibindo: ");
            System.out.println("-------------------------");
            if(pf != null) {
                pf.exibir();
            } else {
                pj.exibir();
            }
            System.out.println("-------------------------");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        while (true) {
            System.out.println("-------------------------");
            System.out.println("Exibir todos:");
            System.out.println("-------------------------");
            System.out.println("1. Física");
            System.out.println("2. Jurídica");
            System.out.println("0. Voltar");
            System.out.println("-------------------------");
            System.out.print("Escolha uma opção: ");
            
            int opcao = -1;
            
            try {
                opcao = scanner.nextInt();
            }
            catch(Exception e) {}
            
            scanner.nextLine();
            
            System.out.println("-------------------------");
               
            boolean encontrado = false;
            
            switch (opcao) {
                case 1 -> {
                    System.out.println("-------------------------");
                    System.out.println("Resultado:");
                    System.out.println("-------------------------");
                    
                    for (PessoaFisica pessoa : pessoaFisicaDAO.getPessoas()) {
                        encontrado = true;
                        System.out.println(" ");
                        pessoa.exibir();
                        System.out.println(" ");
                    }
                    
                    if(encontrado == false) {
                        System.out.println("Sem resultado");
                    }
                    System.out.println("-------------------------");
                    return;
                }
                case 2 -> {
                    System.out.println("-------------------------");
                    System.out.println("Resultado:");
                    System.out.println("-------------------------");
                    
                    for (PessoaJuridica pessoa : pessoaJuridicaDAO.getPessoas()) {
                        encontrado = true;
                        System.out.println(" ");
                        pessoa.exibir();
                        System.out.println(" ");
                    }
                    
                    if(encontrado == false) {
                        System.out.println("Sem resultado");
                    }
                    System.out.println("-------------------------");
                    return;
                }
                case 0 -> {
                    System.out.println("-------------------------");
                    System.out.println("Voltando...");
                    System.out.println("-------------------------");
                    return;
                }
                default -> {
                    System.out.println("-------------------------");
                    System.out.println("Opção Inválida");
                    System.out.println("-------------------------");
                }
            }
        }
    }
}
