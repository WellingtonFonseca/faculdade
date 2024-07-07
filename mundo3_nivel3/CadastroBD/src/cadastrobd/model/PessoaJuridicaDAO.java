/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

import cadastrobd.model.util.ConectorBD;
import cadastrobd.model.util.SequenceManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wellingtonfonseca
 */
public class PessoaJuridicaDAO {
    public PessoaJuridica getPessoa(int id) {
        PessoaJuridica pj = null;
        
        String sql = "select * from pessoa p where p.tipo = 'pj' and p.id = ?";
        
        try (Connection conn = ConectorBD.getConnection();
            PreparedStatement stmt = ConectorBD.getPrepared(conn, sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pj = new PessoaJuridica(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("logradouro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf_cnpj")
                );
            }
            ConectorBD.close(rs);
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return pj;
    }

    public List<PessoaJuridica> getPessoas() {
        List<PessoaJuridica> pessoas = new ArrayList<>();
        
        String sql = "select * from pessoa p where p.tipo = 'pj'";
        
        try (Connection conn = ConectorBD.getConnection();
             ResultSet rs = ConectorBD.getSelect(conn, sql)) {
            while (rs.next()) {
                PessoaJuridica pj = new PessoaJuridica(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("logradouro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf_cnpj")
                );
                pessoas.add(pj);
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return pessoas;
    }

    public PessoaJuridica incluir(PessoaJuridica pj) {
        String sqlPessoa = "insert into pessoa (id, tipo, nome, logradouro, email, telefone, cpf_cnpj, cidade, estado) VALUES (?, 'pj', ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConectorBD.getConnection()) {
            conn.setAutoCommit(false);

            int id = SequenceManager.getValue("pessoa_id_seq");
            
            try (PreparedStatement stmtPessoa = ConectorBD.getPrepared(conn, sqlPessoa)) {
                
                stmtPessoa.setInt(1, id);
                stmtPessoa.setString(2, pj.getNome());
                stmtPessoa.setString(3, pj.getLogradouro());
                stmtPessoa.setString(4, pj.getEmail());
                stmtPessoa.setString(5, pj.getTelefone());
                stmtPessoa.setString(6, pj.getCnpj());
                stmtPessoa.setString(7, pj.getCidade());
                stmtPessoa.setString(8, pj.getEstado());
                
                stmtPessoa.executeUpdate();

                conn.commit();
                
                pj.setId(id);
                
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("Erro: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        
        return pj;
    }

    public void alterar(PessoaJuridica pj) {
        String sqlPessoa = "update pessoa set nome = ?, logradouro = ?, email = ?, telefone = ?, cpf_cnpj = ?, cidade = ?, estado = ? WHERE tipo = 'pj' and id = ?";

        try (Connection conn = ConectorBD.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtPessoa = ConectorBD.getPrepared(conn, sqlPessoa)) {
                stmtPessoa.setString(1, pj.getNome());
                stmtPessoa.setString(2, pj.getLogradouro());
                stmtPessoa.setString(3, pj.getEmail());
                stmtPessoa.setString(4, pj.getTelefone());
                stmtPessoa.setString(5, pj.getCnpj());
                stmtPessoa.setString(6, pj.getCidade());
                stmtPessoa.setString(7, pj.getEstado());
                stmtPessoa.setInt(8, pj.getId());
                
                stmtPessoa.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("Erro: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sqlPessoa = "delete from pessoa where tipo = 'pj' and id = ?";
        
        try (Connection conn = ConectorBD.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtPessoa = ConectorBD.getPrepared(conn, sqlPessoa)) {
                stmtPessoa.setInt(1, id);
                stmtPessoa.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("Erro: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
