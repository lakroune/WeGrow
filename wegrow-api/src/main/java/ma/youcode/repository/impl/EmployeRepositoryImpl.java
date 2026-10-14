package ma.youcode.repository.impl;

import java.util.ArrayList;
import java.util.List;

import ma.youcode.model.Employe;
import ma.youcode.repository.EmployeRepository;

public class EmployeRepositoryImpl implements EmployeRepository {

    @Override
    public List<Employe> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Employe findById(Long id) {
        return null;
    }

    @Override
    public void save(Employe employe) {
    }
}
