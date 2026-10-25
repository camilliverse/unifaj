package br.edu.planosaude.dao;

import br.edu.planosaude.model.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/** DAO implementado com JPA (EntityManager). Nao usa JDBC. */
@Repository
@Transactional
public class PacienteDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Paciente> listar() {
        return em.createQuery("select x from Paciente x order by x.id", Paciente.class).getResultList();
    }

    public Paciente buscar(Long id) {
        return em.find(Paciente.class, id);
    }

    public Paciente incluir(Paciente obj) {
        obj.setId(null);
        em.persist(obj);
        return obj;
    }

    public Paciente alterar(Paciente obj) {
        return em.merge(obj);
    }

    public boolean excluir(Long id) {
        Paciente obj = em.find(Paciente.class, id);
        if (obj == null) return false;
        em.remove(obj);
        return true;
    }
}
