package ma.youcode.service.impl;

import ma.youcode.repository.DepartementRepository;
import ma.youcode.service.DepartementService;

public class DepartementServiceImpl implements DepartementService {

    private final DepartementRepository departementRepository;

    public DepartementServiceImpl(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

}
