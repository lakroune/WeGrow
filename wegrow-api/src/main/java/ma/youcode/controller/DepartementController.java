package ma.youcode.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.HttpRequestHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.youcode.dto.DepartementDTO;
import ma.youcode.model.Departement;
import ma.youcode.service.DepartementService;

public class DepartementController implements HttpRequestHandler {

    private final DepartementService departementService;
    private final ObjectMapper mapper;

    public DepartementController(DepartementService departementService) {
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
        // index

        if ("GET".equals(method)
                && "/api/departements".equals(path)) {

            List<Departement> departements = departementService.getAllDepartements();

            List<DepartementDTO> result = departements.stream()
                    .map(DepartementDTO::new)
                    .toList();

            response.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(response.getWriter(), result);
            return;
        }

        // show
        if ("GET".equals(method)
                && path.matches("/api/departements/\\d+")) {

            String[] parts = path.split("/");
            Long id = Long.parseLong(parts[3]);

            Optional<Departement> departement = departementService.getDepartementById(id);

            if (departement.isPresent()) {
                DepartementDTO dto = new DepartementDTO(departement.get());
                response.setStatus(HttpServletResponse.SC_OK);
                mapper.writeValue(response.getWriter(), dto);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                mapper.writeValue(response.getWriter(),
                        Map.of("message", "Département introuvable"));
            }
            return;
        }

        // store
        if ("POST".equals(method) && "/api/departements".equals(path)) {

            Departement departement = mapper.readValue(request.getInputStream(), Departement.class);

            departementService.saveDepartement(departement);

            response.setStatus(HttpServletResponse.SC_CREATED);
            mapper.writeValue(response.getWriter(), departement);
            return;
        }

    }
}
