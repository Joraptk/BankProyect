/**
 * 
 */
package com.beeva.ProyectoBanco.implementacion;



import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ProyectoBanco.DAO.BancoDAO;
import com.beeva.ProyectoBanco.model.Banco;



/**
 * @author administradorcito
 *
 */

@Repository
public class BancoDAOImpl extends BancoDAO {

	@PersistenceContext
	EntityManager em;

@Override
@Transactional
	public Banco save(Banco banco) {
		em.persist(banco);
		return banco;
	}

	@Override
	public Banco getBanco(int id) {
		// TODO Auto-generated method stub
		return em.find(Banco.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List <Banco> getNumBancos(){
		return em.createNamedQuery("getBancos").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Banco> findWithName(String name) {
		return em.createQuery(
		    "SELECT b FROM banco c WHERE c.nombre LIKE bancoName",Banco.class)
		    .setParameter("bancocustName", name)
		    .setMaxResults(10)
		    .getResultList();
		}
    public List<Banco> getBancos() {	
        return em.createQuery("Select b from banco b ").getResultList();
    }
}