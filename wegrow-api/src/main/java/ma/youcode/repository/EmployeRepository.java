package ma.youcode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.youcode.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
