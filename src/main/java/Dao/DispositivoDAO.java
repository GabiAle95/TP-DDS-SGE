package Dao;

import java.util.List;

import javax.persistence.*;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Dispositivo.Dispositivo;
import Repositorio.Repositorio;
import TipoDato.Log;

public class DispositivoDAO implements WithGlobalEntityManager {
	
	EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	EntityTransaction transaccion = entityManager.getTransaction();
	
	public void registrarDispositivo(Dispositivo dis) {
		
		transaccion.begin();
		entityManager().persist(dis);
		transaccion.commit();
	}
	
	public Dispositivo obtenerDispositivo (String nombre){ 
				
		return (Dispositivo) entityManager().createQuery("from Dispositivo.Dispositivo where nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
		
	}

	public void cargaInicial() {
		
		Repositorio repo = Repositorio.getInstance();
		
		for(Dispositivo dis : repo.getDispositivos()){
			
			entityManager().persist(dis);
		}
		
		for(Log log: repo.getLog()){
			
			entityManager().persist(log);
		}
	}
	
	public List<Dispositivo> obtenerDispositivos(){
		
		return entityManager.createQuery("FROM Dispositivo.Dispositivo").getResultList();
		
	}
	
}