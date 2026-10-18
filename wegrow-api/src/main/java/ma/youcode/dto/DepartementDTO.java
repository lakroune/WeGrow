package ma.youcode.dto;

import java.util.List;
import java.util.stream.Collectors;

import ma.youcode.model.Departement;

public class DepartementDTO {
    private Long id;
    private String nom;
    private String description;
    private List<EmployeDTO> employes;

    public DepartementDTO(Departement departement) {
        this.id = departement.getId();
        this.nom = departement.getNom();
        this.description = departement.getDescription();
        if (departement.getEmployes() == null)
            this.employes = List.of();
        else
            this.employes = departement.getEmployes()
                    .stream()
                    .map(EmployeDTO::new)
                    .collect(Collectors.toList());
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
