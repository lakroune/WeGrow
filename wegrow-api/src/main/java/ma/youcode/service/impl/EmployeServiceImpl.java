package ma.youcode.service.impl;

import java.util.List;
import java.util.Optional;

import ma.youcode.model.Departement;
import ma.youcode.model.Employe;
import ma.youcode.repository.DepartementRepository;
import ma.youcode.repository.EmployeRepository;
import ma.youcode.service.EmployeService;

public class EmployeServiceImpl implements EmployeService {

    private EmployeRepository employeRepository;
    private DepartementRepository departementRepository;

    public void setEmployeRepository(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public void setDepartementRepository(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public EmployeServiceImpl() {

    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public List<Employe> getEmployeByIdDepartemant(Long idDepartement) {
        return employeRepository.findByDepartement_Id(idDepartement);
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEmploye(Long id, Employe employe) {

        Optional<Departement> departement = departementRepository
                .findById(id);

        if (!departement.isPresent()) {
            throw new IllegalArgumentException("Departement with id " + id + " not found");
        }

        employe.setDepartement(departement.get());

        employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }
}
