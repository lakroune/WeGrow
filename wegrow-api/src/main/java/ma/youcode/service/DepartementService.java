package ma.youcode.service;

import java.util.List;
import java.util.Optional;

import ma.youcode.model.Departement;

public interface DepartementService {
    List<Departement> getAllDepartements();

    Optional<Departement> getDepartementById(Long id);

    void saveDepartement(Departement departement);

    void deleteDepartement(Long id);
}
