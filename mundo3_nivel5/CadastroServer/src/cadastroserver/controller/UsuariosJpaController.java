/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroserver.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import cadastroserver.model.Usuarios;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author wellingtonfonseca
 */
public class UsuariosJpaController {

    private EntityManagerFactory emf = null;

    public UsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Usuarios findUsuario(String login, String senha) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Usuarios> query = em.createQuery(
                    "SELECT u FROM Usuarios u WHERE u.usuario = :usuario AND u.senha = :senha", Usuarios.class);
            query.setParameter("usuario", login);
            query.setParameter("senha", senha);
            List<Usuarios> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }
}
