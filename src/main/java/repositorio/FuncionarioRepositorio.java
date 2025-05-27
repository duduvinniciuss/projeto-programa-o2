package repositorio;

import entidade.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.JPAUtil;

import java.util.List;

public class FuncionarioRepositorio {

    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();

    public void salvar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        funcionario = em.merge(funcionario);
        em.remove(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public List<Funcionario> listar() {
        EntityManager em = emf.createEntityManager();
        List<Funcionario> lista = em.createQuery("FROM Funcionario", Funcionario.class).getResultList();
        em.close();
        return lista;
    }
}
