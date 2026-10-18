package ma.youcode.service;

import java.util.List;

import ma.youcode.model.Employe;

public interface EmployeService {
    List<Employe> getAllEmployes();

    List<Employe> getEmployeByIdDepartemant(Long idDepartement);

    Employe getEmployeById(Long id);

    void saveEmploye(Long id, Employe employe);

    void deleteEmploye(Long id);
}
