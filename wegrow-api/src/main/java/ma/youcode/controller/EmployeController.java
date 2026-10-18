package ma.youcode.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.HttpRequestHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.youcode.dto.EmployeDTO;
import ma.youcode.model.Employe;
import ma.youcode.service.DepartementService;
import ma.youcode.service.EmployeService;

public class EmployeController implements HttpRequestHandler {

    private final EmployeService employeService;
    private final DepartementService departementService;
    private final ObjectMapper mapper;

    public EmployeController(EmployeService employeService, DepartementService departementService) {
        this.employeService = employeService;
        this.departementService = departementService;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String method = request.getMethod();
        String path = request.getRequestURI()
                .substring(request.getContextPath().length());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // show

        if ("GET".equals(method)
                && path.matches("/api/departements/\\d+/employes")) {

            String[] partsPath = path.split("/");
            Long idDepartement = Long.parseLong(partsPath[3]);

            List<Employe> employes = employeService.getEmployeByIdDepartemant(idDepartement);

            if (departementService.getDepartementById(idDepartement).isPresent()) {
                List<EmployeDTO> result = employes.stream()
                        .map(EmployeDTO::new)
                        .collect(Collectors.toList());

                response.setStatus(HttpServletResponse.SC_OK);
                mapper.writeValue(response.getWriter(), result);
                return;

            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

        }

        // store

        if ("POST".equals(method)
                && path.matches("/api/departements/\\d+/employes")) {

            String[] partsPath = path.split("/");
            Long idDepartement = Long.parseLong(partsPath[3]);

            Employe employe = mapper.readValue(
                    request.getInputStream(),
                    Employe.class);

            try {
                employeService.saveEmploye(idDepartement, employe);

                response.setStatus(HttpServletResponse.SC_CREATED);

                mapper.writeValue(response.getWriter(), new EmployeDTO(employe));

            } catch (IllegalArgumentException e) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.setStatus(404);
            }

            return;
        }

    }
}