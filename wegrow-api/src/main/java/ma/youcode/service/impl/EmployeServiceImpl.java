package ma.youcode.service.impl;

import ma.youcode.repository.DepartementRepository;
import ma.youcode.repository.EmployeRepository;

import ma.youcode.service.EmployeService;

public class EmployeServiceImpl  implements  EmployeService{
    

    private final EmployeRepository employeRepository;
    private final DepartementRepository  departementRepository;

    public EmployeServiceImpl(EmployeRepository employeRepository, DepartementRepository departementRepository) {
        this.employeRepository = employeRepository;
        this.departementRepository = departementRepository;
    }
}
