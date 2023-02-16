package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import java.util.List;

import Gestion.Chambre;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	public class Marche {
		private Etal [] etals;
		
	public Marche(int nbEtals) {
		this.etals = new Etal[nbEtals];
	}
	private void utiliserEtal(int indiceEtal, Gaulois vendeur,String produit, int nbProduit) {
		this.etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}
	
	
	private int trouverEtalLibre() {
		int indiceLibre=-1;
		for (int i=0; i<etals.length;i++) {
			if(!etals[i].isEtalOccupe()) {
				indiceLibre=i;
			}
		}
		return indiceLibre;
	
	}
	
	private Etal[] trouverEtals(String produit) {
		 Etal[] correspondances =new Etal[etals.length];
		 int pos=0;
		 for(int i=0; i<etals.length;i++) {
			 if (etals[i].contientProduit(produit)){
				 correspondances[pos]=etals[i];
				 pos++;
			 }
		 }
		 return correspondances;
	}
	
	private Etal trouverVendeur(Gaulois gaulois) {
		for (int i=0; i<etals.length;i++) {
			if(etals[i].getVendeur()==gaulois) {
				return etals[i];
			}
		}
		return null;
		
	}
	
	private void afficherMarche() {
		int nbEtalVide = 0;
		for (int i = 0 ; i < etals.length ; i++) {
			if (etals[i].isEtalOccupe()) {
				System.out.println(etals[i].afficherEtal() + "\n");
			}
			nbEtalVide++;
		}
		if (nbEtalVide != 0) {
			System.out.println("Il reste " + nbEtalVide + " étals non utilisés dans le marché.\n");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private Etal[] trouverEtals(String produit) {
//		int nbEtalsLibres = 0;
//		for (int i = 0 ; i < etals.length ; i++) {
//			if (etals[i] != null && etals[i].isEtalOccupe() && etals[i].contientProduit(produit)) {
//				nbEtalsLibres++;
//			}
//		}
//		Etal[] etalsLibres = new Etal[nbEtalsLibres];
//		int j = 0;
//		for (int i = 0 ; i < etals.length ; i++) {
//			if (etals[i] != null && etals[i].isEtalOccupe() && etals[i].contientProduit(produit)) {
//				etalsLibres[j++] = etals[i];
//			}
//		}
//		return etalsLibres;
//	}}

}}	