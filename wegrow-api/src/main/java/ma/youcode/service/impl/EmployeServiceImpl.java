package ma.youcode.service.impl;

import java.util.List;

import ma.youcode.model.Employe;
import ma.youcode.repository.EmployeRepository;
import ma.youcode.service.EmployeService;

public class EmployeServiceImpl implements EmployeService {

    private EmployeRepository employeRepository;

    public void setEmployeRepository(EmployeRepository employeRepository){
        this.employeRepository = employeRepository;
    }

    public EmployeServiceImpl() {
      
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
