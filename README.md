# WeGrow

REST API for managing **departments** and **employees**, built with Java 17, Spring MVC, Spring Data JPA, Hibernate, and PostgreSQL. Packaged as a WAR (Maven) and configured with XML-based Spring configuration.

## 🛠 Tech stack

| Layer | Technology |
|-------|------------|
| Language | Java 17 |
| Web framework | Spring MVC 6.1.14 (DispatcherServlet, `HttpRequestHandler` controllers) |
| Data access | Spring Data JPA 3.2.12, Hibernate 6.4.4 |
| Database | PostgreSQL 42.7.3 (HikariCP connection pool) |
| JSON | Jackson 2.17.1 |
| Build tool | Apache Maven (WAR packaging) |
| Servlet container | Jakarta Servlet 6.0 (web.xml / any Servlet 6.0 container: Tomcat, Jetty…) |
| Testing | JUnit 5, Mockito |

## 📁 Project structure

```text
WeGrow/
├── README.md
├── LICENSE
├── .gitignore
├── .github/
│   └── modernize/java-upgrade/…
└── wegrow-api/                 # Maven module (war, ma.youcode:wegrow-api:1.0.0)
    ├── pom.xml
    ├── src/main/java/ma/youcode/
    │   ├── Main.java
    │   ├── controller/
    │   │   ├── DepartementController.java   # GET/POST /api/departements, GET /api/departements/{id}
    │   │   └── EmployeController.java        # GET/POST /api/departements/{id}/employes
    │   ├── dto/
    │   │   ├── DepartementDTO.java
    │   │   ├── EmployeDTO.java
    │   │   └── DepartementAvecEmployesDTO.java
    │   ├── model/
    │   │   ├── Departement.java
    │   │   ├── Employe.java
    │   │   └── enums/ (Contrat, Poste)
    │   ├── repository/ (DepartementRepository, EmployeRepository)
    │   └── service/ + impl/ (DepartementService, EmployeService)
    └── src/main/webapp/WEB-INF/
        ├── web.xml               # DispatcherServlet mapping (/)
        └── spring-config.xml     # DataSource, JPA/Hibernate, services, controllers, URL mappings
```

## 🔌 API endpoints

Base path: `/api`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/departements` | List all departments |
| `GET` | `/api/departements/{id}` | Get a department by ID |
| `POST` | `/api/departements` | Create a department |
| `GET` | `/api/departements/{id}/employes` | List employees of a department |
| `POST` | `/api/departements/{id}/employes` | Create an employee in a department |

Responses are JSON (`application/json`, UTF-8).

### Models

**Departement**: `id`, `nom` (unique), `description`, `employes`

**Employe**: `id`, `matricule` (unique), `nom`, `prenom`, `poste` (enum), `contrat` (enum), `departement` (ManyToOne)

## 🗄️ Database setup

The API connects to PostgreSQL (configured in `wegrow-api/src/main/webapp/WEB-INF/spring-config.xml`):

```text
jdbc:postgresql://localhost:5432/wegrow_db
username: postgres
password: 123456
```

1. Install and start PostgreSQL.
2. Create the database:
   ```sql
   CREATE DATABASE wegrow_db;
   ```
3. Hibernate is configured with `generateDdl=true` and `PostgreSQLDialect`, so tables are created automatically on startup.

> ⚠️ Update `spring-config.xml` if your PostgreSQL credentials differ.

## ▶️ Build and run

### Prerequisites
- JDK 17+
- Apache Maven 3.8+
- A Servlet 6.0 container (Apache Tomcat 10.1+,   …)

### Build the WAR

```bash
cd wegrow-api
mvn clean package
```

The artifact `wegrow-api-1.0.0.war` is produced in `target/`.

### Deploy

1. Copy `target/wegrow-api-1.0.0.war` into your servlet container's `webapps/` folder (Tomcat) or deploy it via your container's management console.
2. Start the container.
3. The API is available at `http://localhost:8080/wegrow-api-1.0.0/api/…` (context path depends on the WAR file name).

### Run tests

```bash
cd wegrow-api
mvn test
```

## ⚙️ Configuration

Main configuration file: `wegrow-api/src/main/webapp/WEB-INF/spring-config.xml`

- `dataSource` — HikariCP DataSource (URL, username, password)
- `entityManagerFactory` — JPA/Hibernate (packagesToScan `ma.youcode.model`, `showSql=true`, `generateDdl=true`)
- `transactionManager` — JpaTransactionManager
- Controllers and URL mappings (`SimpleUrlHandlerMapping`)

## 🧪 Testing the API

Once deployed, test the endpoints with `curl`:

```bash
# List all departments
curl -i http://localhost:8080/wegrow-api-1.0.0/api/departements

# Get a department by ID
curl -i http://localhost:8080/wegrow-api-1.0.0/api/departements/1

# Create a department
curl -i -X POST http://localhost:8080/wegrow-api-1.0.0/api/departements \
  -H "Content-Type: application/json" \
  -d '{"nom":"Informatique","description":"Département informatique"}'

# List employees of a department
curl -i http://localhost:8080/wegrow-api-1.0.0/api/departements/1/employes

# Create an employee in a department
curl -i -X POST http://localhost:8080/wegrow-api-1.0.0/api/departements/1/employes \
  -H "Content-Type: application/json" \
  -d '{"matricule":"EMP-001","nom":"Doe","prenom":"John","poste":"DEVELOPPEUR","contrat":"CDI"}'
```

Adjust the host, port, and context path to match your servlet container setup.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/ma-fonctionnalite`)
3. Commit your changes (`git commit -m "Add: ma fonctionnalite"`)
4. Push to the branch (`git push origin feature/ma-fonctionnalite`)
5. Open a Pull Request

Please follow the existing code style and conventions.

## 📜 License

This project is licensed under the [MIT License](LICENSE).

## 👤 Author

**Ismail Lakroune** — [lakroune/WeGrow](https://github.com/lakroune/WeGrow)