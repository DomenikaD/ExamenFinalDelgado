package ec.edu.ups.ppw.ExamenFinalDelgado.dao;

import java.util.List;

import ec.edu.ups.ppw.ExamenFinalDelgado.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDao {
	
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	public void insert(Recarga recarga) {
		em.persist(recarga);
	}
	
	public void update(Recarga recarga) {
		em.merge(recarga);
	}
	
	public void remove(int codigo) {
		Recarga recarga = em.find(Recarga.class, codigo);
		em.remove(recarga);
	}
	
	public Recarga read(int codigo) {
		Recarga recarga = em.find(Recarga.class, codigo);
		return recarga;
		
	}	
		
	//LISTA
	public List<Recarga> getAll(){
		String jpql = "SELECT r FROM Recarga r";
		Query q = em.createQuery(jpql, Recarga.class);
		return q.getResultList();
	}
			
	

	public Recarga getRecargaPorCedula(String cedula){
		String jpql = "SELECT r FROM Recarga r WHERE r.dni = :cedula";
		Query q = em.createQuery(jpql, Recarga.class);
		q.setParameter("cedula", cedula);
		List<Recarga> recargas = q.getResultList();
		if(recargas.size()>0)
			return recargas.get(0);
		return null;
	}
	
	
	

}
