package ma.youcode.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import ma.youcode.model.Departement;
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
                && "/api/departements/\\d+/employes".equals(path)) {

            response.setStatus(HttpServletResponse.SC_OK);

            return;
        }

        // store
        if ("POST".equals(method) && "/api/departements/\\d+/employes".equals(path)) {

            Employe employe = mapper.readValue(request.getInputStream(), Employe.class);

            response.setStatus(HttpServletResponse.SC_CREATED);

            return;
        }

    }
}