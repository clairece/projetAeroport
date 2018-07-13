package client.test;

import client.dao.*;
import client.model.*;
import aeroport.util.EntityManagerFactorySingleton;

public class test1 {

	public static void main(String[] args) {
		
		DaoClient daoClient = DaoClientFactory.getInstance();
		
		Client c1 = new Client();
		
		c1.setNom("toto");
		c1.setNumeroFax(0000000000);
		c1.setNumeroTel(0101010101);
		c1.setEmail("toto@tamere.fr");
		
		c1.setAdresse(new Adresse("6 rue de toto", "785623", "totocity", "totoworld"));
		Login log = new Login("user","mdp",false);
		
		c1.setLogin(log);
		
		daoClient.insert(c1);
		

		
		
		
		
		
		
		
		EntityManagerFactorySingleton.destroy();
	}
}
