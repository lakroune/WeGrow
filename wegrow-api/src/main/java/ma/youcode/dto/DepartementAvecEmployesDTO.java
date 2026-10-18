package ma.youcode.dto;

import java.util.List;

import ma.youcode.model.Departement;

public class DepartementAvecEmployesDTO {

    private Long id;
    private String nom;
    private String description;
    private List<EmployeDTO> employes;

    public DepartementAvecEmployesDTO(Departement departement) {
        this.id = departement.getId();
        this.nom = departement.getNom();
        this.description = departement.getDescription();

        this.employes = departement.getEmployes() == null
                ? List.of()
                : departement.getEmployes()
                        .stream()
                        .map(EmployeDTO::new)
                        .toList();
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

    public List<EmployeDTO> getEmployes() {
        return employes;
    }
}