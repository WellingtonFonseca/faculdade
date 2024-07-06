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
public class PessoaFisicaDAO {
    public PessoaFisica getPessoa(int id) {
        PessoaFisica pf = null;
        
        String sql = "select * from pessoa p where p.tipo = 'pf' p.id = ?";
        
        try (Connection conn = ConectorBD.getConnection();
             PreparedStatement stmt = ConectorBD.getPrepared(conn, sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pf = new PessoaFisica(
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
            e.printStackTrace();
        }
        return pf;
    }

    public List<PessoaFisica> getPessoas() {
        List<PessoaFisica> pessoas = new ArrayList<>();
        
        String sql = "select * from pessoa p where p.tipo = 'pf'";
        
        try (Connection conn = ConectorBD.getConnection();
             ResultSet rs = ConectorBD.getSelect(conn, sql)) {
            while (rs.next()) {
                PessoaFisica pf = new PessoaFisica(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("logradouro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf_cnpj")
                );
                pessoas.add(pf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public PessoaFisica incluir(PessoaFisica pf) {
        String sqlPessoa = "insert into pessoa (id, tipo, nome, logradouro, email, telefone, cpf_cnpj, cidade, estado) VALUES (?, 'pf', ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConectorBD.getConnection()) {
            conn.setAutoCommit(false);

            int id = SequenceManager.getValue("pessoa_id_seq");
            
            try (PreparedStatement stmtPessoa = ConectorBD.getPrepared(conn, sqlPessoa)) {
                
                stmtPessoa.setInt(1, id);
                stmtPessoa.setString(2, pf.getNome());
                stmtPessoa.setString(3, pf.getLogradouro());
                stmtPessoa.setString(4, pf.getEmail());
                stmtPessoa.setString(5, pf.getTelefone());
                stmtPessoa.setString(6, pf.getCpf());
                stmtPessoa.setString(7, pf.getCidade());
                stmtPessoa.setString(8, pf.getEstado());
                
                stmtPessoa.executeUpdate();

                conn.commit();
                
                pf.setId(id);

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return pf;
    }

    public void alterar(PessoaFisica pf) {
        String sqlPessoa = "update pessoa set nome = ?, logradouro = ?, email = ?, telefone = ?, cpf_cnpj = ?, cidade = ?, estado = ? WHERE tipo = 'pf' and id = ?";

        try (Connection conn = ConectorBD.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtPessoa = ConectorBD.getPrepared(conn, sqlPessoa)) {
                stmtPessoa.setString(1, pf.getNome());
                stmtPessoa.setString(2, pf.getLogradouro());
                stmtPessoa.setString(3, pf.getEmail());
                stmtPessoa.setString(4, pf.getTelefone());
                stmtPessoa.setString(5, pf.getCpf());
                stmtPessoa.setString(6, pf.getCidade());
                stmtPessoa.setString(7, pf.getEstado());
                stmtPessoa.setInt(8, pf.getId());
                
                stmtPessoa.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sqlPessoa = "delete from pessoa where tipo = 'pf' and id = ?";
        
        try (Connection conn = ConectorBD.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtPessoa = ConectorBD.getPrepared(conn, sqlPessoa)) {
                stmtPessoa.setInt(1, id);
                stmtPessoa.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
