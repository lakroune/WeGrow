
package ma.youcode.dto;

import ma.youcode.model.Employe;

public class EmployeDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private String poste;
    private String contrat;

    public EmployeDTO(Employe e) {
        this.id = e.getId();
        this.nom = e.getNom();
        this.prenom = e.getPrenom();
        this.matricule = e.getMatricule();
        this.poste = e.getPoste().name();
        this.contrat = e.getContrat().name();

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
