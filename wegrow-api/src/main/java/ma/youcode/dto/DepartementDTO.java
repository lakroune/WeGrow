package ma.youcode.dto;

import ma.youcode.model.Departement;

public class DepartementDTO {

    private Long id;
    private String nom;
    private String description;

    public DepartementDTO(Departement departement) {
        this.id = departement.getId();
        this.nom = departement.getNom();
        this.description = departement.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }
}