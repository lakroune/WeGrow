package ma.youcode.service.impl;

import java.util.List;

import ma.youcode.model.Employe;
import ma.youcode.repository.DepartementRepository;
import ma.youcode.repository.EmployeRepository;
import ma.youcode.service.EmployeService;

public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;
    private final DepartementRepository departementRepository;

    public EmployeServiceImpl(EmployeRepository employeRepository, DepartementRepository departementRepository) {
        this.employeRepository = employeRepository;
        this.departementRepository = departementRepository;
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEmploye(Employe employe) {
        employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }
}
