package representation;

public class Representant {

	private final int numero;

	private final String nom;

	private final String prenom;

	private String adresse;

	private float salaireFixe;
        
        private ZoneGeographique secteur;
        
        private float[] listeCA= new float[12];

	public Representant(int numero, String nom, String prenom,   ZoneGeographique secteur) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
                this .secteur= secteur;
	}

	public int getNumero() {
		return numero;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public float getSalaireFixe() {
		return salaireFixe;
	}

	public void setSalaireFixe(float salaireFixe) {
		this.salaireFixe = salaireFixe;
	}

	public ZoneGeographique getSecteur() {
                return secteur ;
	}

	public void setSecteur(ZoneGeographique secteur) {
            this.secteur = secteur;
	}

	public void enregistrerCA(int mois, float montant) {
		if (mois < 0 || mois > 11) {
			throw new IllegalArgumentException("Le mois doit être compris entre 0 et 11");
		}
		if (montant < 0) {
			throw new IllegalArgumentException("Le montant doit être superieur à 0") ;
		}
                
                listeCA[mois]=montant;
	}
        /** calcul le salaire mensuel de ce representant por un mois donné
        *
         * @param mois le numero de mois (de 0 à11)
         * @param pourcentage le pourcentage à appliquer sur le CA réalisé par ce representant 
         * @return  le salaire pour ce mois tenant compte du salire fixe et de l'indemnité repas 
         */

	public float salaireMensuel(int mois, float pourcentage) {
                if (mois < 0 || mois > 11) {
                   throw new IllegalArgumentException("Le mois doit être compris entre 0 et 11");
                }
                return salaireFixe + pourcentage* listeCA[mois]+ secteur.getIndemniteRepas()  ;
	}

	@Override
	public String toString() {
		return "Representant{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + '}';
	}

}
