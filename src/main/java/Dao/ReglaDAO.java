package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Dispositivo.Dispositivo;
import Observer.Regla;

public class ReglaDAO implements WithGlobalEntityManager {
	
	EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	EntityTransaction transaccion = entityManager.getTransaction();

	public void ingresarRegla(Regla regla){
		
		transaccion.begin();
		entityManager().persist(regla);
		transaccion.commit();
	}
	
	public Regla obtenerRegla (String nombre){ 
		
		return (Regla) entityManager().createQuery("from Observer.Regla where nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
		
	}
	
	
	public List<Regla> obtenerReglas(){
		
		return entityManager.createQuery("FROM Observer.Regla").getResultList();
		
	}
}
