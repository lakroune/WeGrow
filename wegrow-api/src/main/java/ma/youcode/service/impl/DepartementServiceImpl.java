package ma.youcode.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import ma.youcode.model.Departement;
import ma.youcode.repository.DepartementRepository;
import ma.youcode.service.DepartementService;

public class DepartementServiceImpl implements DepartementService {

    private DepartementRepository departementRepository;

    public void setdepartementRepository(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Optional<Departement> getDepartementById(Long id) {
        Long validId = Objects.requireNonNull(id, "id");
        return departementRepository.findById(validId);
    }

    @Override
    public void saveDepartement(Departement departement) {
        Departement validDepartement = Objects.requireNonNull(departement, "departement");
        departementRepository.save(validDepartement);
    }

    @Override
    public void deleteDepartement(Long id) {
        Long validId = Objects.requireNonNull(id, "id");
        departementRepository.deleteById(validId);
    }
}
