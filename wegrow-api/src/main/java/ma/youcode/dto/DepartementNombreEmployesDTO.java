package ma.youcode.dto;

public class DepartementNombreEmployesDTO {

    private Long id;
    private String nom;
    private String description;
    private Long nombreEmployes;

    public DepartementNombreEmployesDTO(
            Long id,
            String nom,
            String description,
            Long nombreEmployes) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.nombreEmployes = nombreEmployes;
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

    public Long getNombreEmployes() {
        return nombreEmployes;
    }
}