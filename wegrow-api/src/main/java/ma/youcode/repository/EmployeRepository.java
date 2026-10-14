package ma.youcode.repository;

import java.util.List;

import ma.youcode.model.Employe;

public interface EmployeRepository {
    List<Employe> findAll();

    Employe findById(Long id);

    void save(Employe employe);
}
