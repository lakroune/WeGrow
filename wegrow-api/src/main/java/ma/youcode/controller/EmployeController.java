package ma.youcode.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.youcode.model.Employe;
import ma.youcode.service.EmployeService;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    public List<Employe> listEmployes() {
        return employeService.getAllEmployes();
    }

    public void createEmploye(Employe employe) {
        employeService.saveEmploye(employe);
    }
}
