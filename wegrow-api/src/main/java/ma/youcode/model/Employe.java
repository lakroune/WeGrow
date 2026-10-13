package ma.youcode.model;

import ma.youcode.model.enums.Contrat;
import ma.youcode.model.enums.Poste;

public class Employe {

    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
    private Poste poste;
    private Contrat contrat;
    private Long idDepartement;

    public Employe() {
    }

    public Employe(Long id, String matricule, String nom, String prenom, Poste poste,
            Contrat contrat, Long idDepartement) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.contrat = contrat;
        this.idDepartement = idDepartement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public Long getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Long idDepartement) {
        this.idDepartement = idDepartement;
    }
}
