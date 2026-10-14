package ma.youcode.repository;


import ma.youcode.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    

}
