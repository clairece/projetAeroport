package formationJpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import formationJpa.dao.DaoEnseignement;
import formationJpa.dao.DaoEnseignementFactory;
import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoFormationFactory;
import formationJpa.dao.DaoMatiere;
import formationJpa.dao.DaoMatiereFactory;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneFactory;
import formationJpa.dao.DaoRessource;
import formationJpa.dao.DaoRessourceFactory;
import formationJpa.dao.DaoSalle;
import formationJpa.dao.DaoSalleFactory;
import formationJpa.model.Adresse;
import formationJpa.model.CPU;
import formationJpa.model.Enseignement;
import formationJpa.model.EnseignementPK;
import formationJpa.model.Formateur;
import formationJpa.model.Formation;
import formationJpa.model.Matiere;
import formationJpa.model.Niveau;
import formationJpa.model.Ordinateur;
import formationJpa.model.Personne;
import formationJpa.model.Salle;
import formationJpa.model.Stagiaire;
import formationJpa.model.Titre;
import formationJpa.util.EntityManagerFactorySingleton;

public class AppTestv2 {
	public static void main(String[] args) throws ParseException {

		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();

		Formateur olivier = new Formateur();

		Date uneDate = null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		uneDate = sdf.parse("05/01/1975");

		Matiere jpa = new Matiere();
		jpa.setNom("jpa");
		Matiere html = new Matiere();
		html.setNom("html");
		DaoMatiere daoMatiere = DaoMatiereFactory.getInstance();

		daoMatiere.insert(html);
		daoMatiere.insert(jpa);

		// Calendar calendar=Calendar.getInstance();
		// calendar.set(2001, 1, 28);
		olivier.setDtNaiss(uneDate);
		olivier.setPrenom("olivier");
		olivier.setNom("gozlan");
		olivier.setTitre(Titre.M);
		olivier.setAdresse(new Adresse("6 rue rougemont", "75009", "Paris"));
		olivier.setExperience(20);
		olivier.setReferent(true);
		daoPersonne.insert(olivier);

		EnseignementPK key = new EnseignementPK(olivier, jpa);
		Enseignement olivierJpa = new Enseignement();
		olivierJpa.setKey(key);
		olivierJpa.setNiveau(Niveau.EXPERT);

		DaoEnseignement daoEnseignement = DaoEnseignementFactory.getInstance();
		daoEnseignement.insert(olivierJpa);

		key = new EnseignementPK(olivier, html);
		Enseignement olivierHtml = new Enseignement();
		olivierHtml.setKey(key);
		olivierHtml.setNiveau(Niveau.INITIATION);
		daoEnseignement.insert(olivierHtml);

		Stagiaire pierre = new Stagiaire();
		pierre.setPrenom("pierre");
		pierre.setNom("gorrity");
		pierre.setTitre(Titre.M);
		pierre.setEntreprise("SOPRA STERIA");

		Ordinateur pc = new Ordinateur();
		pc.setCode("pc1");
		pc.setCpu(CPU.I5);
		pc.setRam(16);

		DaoRessource daoRessource = DaoRessourceFactory.getInstance();
		daoRessource.insert(pc);

		pierre.setOrdinateur(pc);

		daoPersonne.insert(pierre);
		// daoPersonne.update(olivier);
		// System.out.println(daoPersonne.findAllFormateur());
		// daoPersonne.delete(olivier);
		// daoPersonne.deleteByKey(1);
		System.out.println("-----------------------");
		Personne recherche = daoPersonne.findByKey(50);
		if (recherche instanceof Formateur) {
			//System.out.println(((Formateur) recherche).getMatieres());
		} else if (recherche instanceof Stagiaire) {
			System.out.println(((Stagiaire) recherche).getOrdinateur());
		}

		Salle topaze = new Salle();
		topaze.setNom("topaze");
		DaoSalle daoSalle = DaoSalleFactory.getInstance();
		daoSalle.insert(topaze);

		Formation java = new Formation();
		java.setSalle(topaze);

		DaoFormation daoFormation = DaoFormationFactory.getInstance();
		daoFormation.insert(java);

		Formation unix = new Formation();
		unix.setSalle(topaze);

		daoFormation.insert(unix);

		System.out.println("----------------");

		System.out.println(daoSalle.findByKey(1));

		EntityManagerFactorySingleton.destroy();

	}
}
