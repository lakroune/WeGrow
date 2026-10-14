package ma.youcode.repository;

import java.util.List;

import ma.youcode.model.Departement;

public interface DepartementRepository {
    List<Departement> findAll();

    Departement findById(Long id);

    void save(Departement departement);
}
