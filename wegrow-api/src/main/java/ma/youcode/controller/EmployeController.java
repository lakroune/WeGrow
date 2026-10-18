package ma.youcode.controller;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import ma.youcode.model.Employe;
import ma.youcode.service.EmployeService;

public class EmployeController implements HttpRequestHandler {

    private final EmployeService employeService;
    private final ObjectMapper mapper;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
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

            response.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(response.getWriter(), employes);
            return;
        }

        // store
        // store
        if ("POST".equals(method)
                && path.matches("/api/departements/\\d+/employes")) {

            String[] partsPath = path.split("/");
            Long idDepartement = Long.parseLong(partsPath[3]);

            Employe employe = mapper.readValue(
                    request.getInputStream(), Employe.class);

            employeService.saveEmploye(idDepartement, employe);

            response.setStatus(HttpServletResponse.SC_CREATED);
            mapper.writeValue(response.getWriter(), employe);
            return;
        }

    }
}