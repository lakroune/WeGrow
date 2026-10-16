package ma.youcode.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.HttpRequestHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

        if ("GET".equals(method)
                && "/api/departements".equals(path)) {

            List<Departement> departements = departementService.getAllDepartements();

            mapper.writeValue(response.getWriter(), departements);
            response.setStatus(200);
            return;
        }

        if ("POST".equals(method)
                && "/api/departements".equals(path)) {

            response.getWriter().write("ok POST");
            response.setStatus(201);
            return;
        }
        if ("PUT".equals(method)
                && "/api/departements".equals(path)) {

            response.getWriter().write("ok PUT");
            response.setStatus(200);
            return;
        }

        response.sendError(404, "Route not found");
    }
}
