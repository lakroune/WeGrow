// package ma.youcode.service;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Spy;
// import org.mockito.junit.jupiter.MockitoExtension;

// import ma.youcode.model.Departement;
// import ma.youcode.model.Employe;
// import ma.youcode.model.enums.Contrat;
// import ma.youcode.model.enums.Poste;
// import ma.youcode.repository.DepartementRepository;
// import ma.youcode.repository.EmployeRepository;
// import ma.youcode.service.impl.EmployeServiceImpl;

// @ExtendWith(MockitoExtension.class)
// class EmployeServiceImplTest {

//     @Mock
//     private EmployeRepository employeRepository;

//     @Mock
//     private DepartementRepository departementRepository;

//     @Spy
//     @InjectMocks
//     private EmployeServiceImpl service;

//     @Test
//     void shouldReturnAllEmployes() {
//         Employe employe = new Employe(1L, "E001", "Ali", "Benali", Poste.DEVELOPPEUR, Contrat.CDI,
//                 new Departement(10L, "Informatique", "Equipe technique"));
//         when(employeRepository.findAll()).thenReturn(List.of(employe));

//         List<Employe> result = service.getAllEmployes();

//         assertEquals(1, result.size());
//         assertEquals("E001", result.get(0).getMatricule());
//         verify(employeRepository).findAll();
//     }

//     @Test
//     void shouldReturnEmployeById() {
//         Employe employe = new Employe(2L, "E002", "Sara", "Ait", Poste.MANAGER, Contrat.CDD,
//                 new Departement(11L, "RH", "Gestion du personnel"));
//         when(employeRepository.findById(2L)).thenReturn(Optional.of(employe));

//         Employe result = service.getEmployeById(2L);

//         assertNotNull(result);
//         assertEquals("E002", result.getMatricule());
//         verify(employeRepository).findById(2L);
//     }

//     @Test
//     void shouldSaveEmploye() {
//         Employe employe = new Employe(null, "E003", "Nadia", "Lahbabi", Poste.RH, Contrat.CDI,
//                 new Departement(12L, "RH", "Recrutement"));

//         service.saveEmploye(12L, employe);

//         verify(employeRepository).save(employe);
//     }

//     @Test
//     void shouldDeleteEmploye() {
//         service.deleteEmploye(3L);

//         verify(employeRepository).deleteById(3L);
//     }
// }
