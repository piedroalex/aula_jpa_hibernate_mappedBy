package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Despesa;
import util.HibernateUtil;

/**
 * @author Pedro Alex
 */
public class DespesaDAO {

	public void salvar(Despesa despesa) {    	
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	    	entityManager.getTransaction().begin();
	    	entityManager.persist(despesa);
	    	entityManager.getTransaction().commit();
	    	System.out.println("Despesa salva com sucesso!");
    	} catch (Exception e) {
        	entityManager.getTransaction().rollback();
	    	System.out.println("Erro ao salvar a despesa!");
            e.printStackTrace();
        } finally {
        	entityManager.close();			
		}
	}
		
	public List<Despesa> listarTodos(){
		TypedQuery<Despesa> query = HibernateUtil.getEntityManager().createQuery("SELECT d FROM Despesa d", Despesa.class);
		List<Despesa> despesas = query.getResultList();
		return despesas;
	}
}
