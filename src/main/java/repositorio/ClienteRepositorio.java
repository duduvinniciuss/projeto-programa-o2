package repositorio;

import entidade.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.JPAUtil;

import java.util.List;

public class ClienteRepositorio {

    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();

    public void salvar(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        cliente = em.merge(cliente);
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public List<Cliente> listar() {
        EntityManager em = emf.createEntityManager();
        List<Cliente> lista = em.createQuery("FROM Cliente", Cliente.class).getResultList();
        em.close();
        return lista;
    }
}
