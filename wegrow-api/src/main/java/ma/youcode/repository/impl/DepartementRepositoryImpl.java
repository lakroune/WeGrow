package ma.youcode.repository.impl;

import java.util.ArrayList;
import java.util.List;

import ma.youcode.model.Departement;
import ma.youcode.repository.DepartementRepository;

public class DepartementRepositoryImpl implements DepartementRepository {
    @Override
    public List<Departement> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Departement findById(Long id) {
        return null;
    }

    @Override
    public void save(Departement departement) {
    }
}
