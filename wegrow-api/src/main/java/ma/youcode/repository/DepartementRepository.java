package ma.youcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.youcode.model.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

    
}
