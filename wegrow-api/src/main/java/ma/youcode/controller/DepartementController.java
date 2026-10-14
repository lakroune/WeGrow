package ma.youcode.controller;

import java.util.List;

import ma.youcode.model.Departement;
import ma.youcode.service.DepartementService;

public class DepartementController {

    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    public List<Departement> getAllDepartements() {
        return departementService.getAllDepartements();
    }

    public Departement getDepartementById(Long id) {
        return departementService.getDepartementById(id);
    }

    public void saveDepartement(Departement departement) {
        departementService.saveDepartement(departement);
    }

    public void updateDepartement(Long id, Departement departement) {
        departement.setId(id);
        departementService.saveDepartement(departement);
    }

    public void deleteDepartement(Long id) {
        departementService.deleteDepartement(id);
    }
}
