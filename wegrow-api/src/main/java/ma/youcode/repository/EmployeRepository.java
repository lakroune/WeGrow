package ma.youcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.youcode.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    
}
