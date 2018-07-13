package aeroport.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	private static EntityManagerFactory emf = null;
	
	public static EntityManagerFactory getInstance() {
		if(emf==null)
			emf = Persistence.createEntityManagerFactory("aeroport");
		return emf;
	}
	
	private EntityManagerFactorySingleton() { }
	
	public static void destroy() {
		if (emf!=null){
			emf.close();
			emf=null;
		}
	}


}
