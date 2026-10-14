package ma.youcode.service;

import java.util.List;

import ma.youcode.model.Employe;

public interface EmployeService {
    List<Employe> getAllEmployes();

    Employe getEmployeById(Long id);

    void saveEmploye(Employe employe);

    void deleteEmploye(Long id);
}
