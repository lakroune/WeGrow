package ma.youcode.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.youcode.model.Employe;
import ma.youcode.service.EmployeService;

@RestController
@RequestMapping("/api")
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping("/employes")
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    @GetMapping("/employes/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeService.getEmployeById(id);
    }

    @PostMapping("/employes")
    public void saveEmploye(@RequestBody Employe employe) {
        employeService.saveEmploye(employe);
    }

    @PutMapping("/employes/{id}")
    public void updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        employe.setId(id);
        employeService.saveEmploye(employe);
    }

    public void deleteEmploye(Long id) {
        employeService.deleteEmploye(id);
    }
}