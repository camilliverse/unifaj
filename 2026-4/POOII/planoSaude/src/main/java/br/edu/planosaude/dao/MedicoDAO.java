package br.edu.planosaude.dao;

import br.edu.planosaude.model.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/** DAO implementado com JPA (EntityManager). Nao usa JDBC. */
@Repository
@Transactional
public class MedicoDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Medico> listar() {
        return em.createQuery("select x from Medico x order by x.id", Medico.class).getResultList();
    }

    public Medico buscar(Long id) {
        return em.find(Medico.class, id);
    }

    public Medico incluir(Medico obj) {
        obj.setId(null);
        em.persist(obj);
        return obj;
    }

    public Medico alterar(Medico obj) {
        return em.merge(obj);
    }

    public boolean excluir(Long id) {
        Medico obj = em.find(Medico.class, id);
        if (obj == null) return false;
        em.remove(obj);
        return true;
    }
}
