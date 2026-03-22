# 🚀 AWS Deploy Application

A **Spring Boot** application deployed on **AWS** using Elastic Beanstalk, RDS (PostgreSQL), and automated CI/CD via CodePipeline and CodeBuild.

---

## ☁️ AWS Architecture

| Component | Service |
|-----------|---------|
| App Hosting | AWS Elastic Beanstalk (EC2 + Load Balancer + Autoscaling) |
| Database | AWS RDS (PostgreSQL) |
| CI/CD | AWS CodePipeline + CodeBuild |
| Source | GitHub (master branch) |

---

## ⚙️ CI/CD Pipeline

Push to `master` → CodePipeline triggers → CodeBuild builds JAR → Elastic Beanstalk deploys
```yaml
# buildspec.yml (CodeBuild)
phases:
  build:
    commands:
      - mvn clean package -DskipTests
artifacts:
  files:
    - target/*.jar
```

---

## 🌱 Spring Profiles

| Profile | Usage |
|---------|-------|
| `dev` | Local development with RDS config |
| `local` | Local development with local DB config |
| `prod` | AWS production environment |
```bash
# Run with dev profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Run with local profile
mvn spring-boot:run -Dspring-boot.run.profiles=local

# Run with prod profile
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

---

## 📂 Project Structure
```
aws-deploy-application/
├── src/
│   ├── main/
│   │   ├── java/com/springboot/applicationtesting/
│   │   │   ├── controllers/        # REST Controllers
│   │   │   ├── repositories/       # JPA Repositories
│   │   │   └── services/           # Service Layer
│   │   └── resources/
│   │       ├── application.properties                # Base config
│   │       ├── application-dev.properties            # Dev profile (RDS)
│   │       ├── application-dev-example.properties    # Dev config template
│   │       ├── application-local.properties          # Local DB config
│   │       └── application-prod.properties           # Prod profile config
│   └── test/
│       └── java/com/springboot/applicationtesting/
│           ├── controllers/        # Controller integration tests
│           ├── repositories/       # Repository tests
│           └── services/           # Service tests
├── buildspec.yml                   # CodeBuild configuration
├── pom.xml                         # Maven dependencies
└── README.md
```

---

## 🚀 Quick Start (Local)

**Prerequisites:** Java 21+, Maven, PostgreSQL
```bash
git clone https://github.com/MansiArora-dev/aws-deploy-application.git
cd aws-deploy-application

# Copy example config and fill in your values
cp src/main/resources/application-dev-example.properties \
   src/main/resources/application-dev.properties

# Run with dev profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

---

## 💻 Technologies

- **Java 21** | **Spring Boot** | **Maven**
- **AWS** — Elastic Beanstalk, RDS, CodePipeline, CodeBuild
- **PostgreSQL** | **Docker**

---

## 👩‍💻 Developer

**Mansi Arora** — Software Engineer
