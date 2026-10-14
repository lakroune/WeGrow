package ma.youcode.controller;

import java.util.List;

import ma.youcode.model.Employe;
import ma.youcode.service.EmployeService;

public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    public Employe getEmployeById(Long id) {
        return employeService.getEmployeById(id);
    }

    public void saveEmploye(Employe employe) {
        employeService.saveEmploye(employe);
    }

    public void updateEmploye(Long id, Employe employe) {
        employe.setId(id);
        employeService.saveEmploye(employe);
    }

    public void deleteEmploye(Long id) {
        employeService.deleteEmploye(id);
    }
}