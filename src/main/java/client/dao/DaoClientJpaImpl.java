package client.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import aeroport.util.EntityManagerFactorySingleton;
import client.model.Client;

public class DaoClientJpaImpl implements DaoClient {
	
	@Override
	public List<Client> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Client> clients=null;
		Query query=em.createQuery("select p from Client p");
		clients = query.getResultList();
		em.close();
		return clients;
	}

	@Override
	public Client findByKey(Integer key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Client client=null;
		client=em.find(Client.class, key);
		em.close();
		return client;
	}

	@Override
	public void insert(Client obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx=null;
		try{
			tx=em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null&& tx.isActive())
				tx.rollback();
		} finally{
			em.close();
		}
	}

	@Override
	public Client update(Client obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx=null;
		Client client=null;
		try{
			tx=em.getTransaction();
			tx.begin();
			client = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null&& tx.isActive())
				tx.rollback();
		} finally{
			em.close();
		}
		return client;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx=null;
		try{
			tx=em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null&& tx.isActive())
				tx.rollback();
		} finally{
			em.close();
		}
		
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx=null;
		try{
			tx=em.getTransaction();
			tx.begin();
			em.remove(em.merge(findByKey(key)));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null&& tx.isActive())
				tx.rollback();
		} finally{
			em.close();
		}
		
	}

}
