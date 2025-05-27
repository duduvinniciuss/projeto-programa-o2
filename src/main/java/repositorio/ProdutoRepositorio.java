package repositorio;

import entidade.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.JPAUtil;

import java.util.List;

public class PedidoRepositorio {

    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();

    public void salvar(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pedido);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        pedido = em.merge(pedido);
        em.remove(pedido);
        em.getTransaction().commit();
        em.close();
    }

    public List<Pedido> listar() {
        EntityManager em = emf.createEntityManager();
        List<Pedido> lista = em.createQuery("FROM Pedido", Pedido.class).getResultList();
        em.close();
        return lista;
    }
}
