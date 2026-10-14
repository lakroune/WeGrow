package ma.youcode.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ma.youcode.model.Departement;
import ma.youcode.repository.DepartementRepository;

public class DepartementRepositoryImpl implements DepartementRepository {

    private final JdbcTemplate jdbcTemplate;

    public DepartementRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Departement> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Departement findById(Long id) {
        return null;
    }

    @Override
    public void save(Departement departement) {
    }
}
