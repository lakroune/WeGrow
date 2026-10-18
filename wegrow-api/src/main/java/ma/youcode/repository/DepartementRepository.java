package ma.youcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.youcode.dto.DepartementNombreEmployesDTO;
import ma.youcode.model.Departement;
import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    @Query("""
            SELECT new ma.youcode.dto.DepartementNombreEmployesDTO(
                d.id,
                d.nom,
                d.description,
                COUNT(e.id)
            )
            FROM Departement d
            LEFT JOIN d.employes e
            GROUP BY d.id, d.nom, d.description
            ORDER BY d.id
            """)
    List<DepartementNombreEmployesDTO> findAllWithEmployeCount();
}
