package ma.youcode.dto;

import ma.youcode.model.Employe;

public class EmployeDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private String poste;
    private String contrat;

    public EmployeDTO(Employe employe) {
        this.id = employe.getId();
        this.nom = employe.getNom();
        this.prenom = employe.getPrenom();
        this.matricule = employe.getMatricule();
        this.poste = employe.getPoste().name();
        this.contrat = employe.getContrat().name();
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getPoste() {
        return poste;
    }

    public String getContrat() {
        return contrat;
    }
}