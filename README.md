# 🚀 AWS Deploy Application

A Spring Boot application demonstrating AWS deployment using Elastic Beanstalk, RDS (PostgreSQL), and automated CI/CD via CodePipeline and CodeBuild.

---

## ☁️ AWS Architecture

| Component | Service |
|-----------|---------|
| App Hosting | AWS Elastic Beanstalk (EC2 + Load Balancer + Autoscaling) |
| Database | AWS RDS (PostgreSQL) |
| CI/CD | AWS CodePipeline + CodeBuild |
| Source | GitHub (master branch) |

---

## 🛠️ AWS Setup (How I Built This)

### 1. RDS (PostgreSQL) Setup
1. AWS Console → RDS → **Create database**
2. Engine: **PostgreSQL**
3. Template: **Free tier**
4. DB instance identifier: `postgres-springboot`
5. Master username & password set 
6. Connectivity: **Public access → Yes**
7. Create database

### 2. Elastic Beanstalk Setup
1. AWS Console → Elastic Beanstalk → **Create application**
2. Application name: `springboot-service`
3. Platform: **Corretto 21 (Java)**
4. Environment type: **Load balanced**
5. Configure environment variables:
   - `SPRING_PROFILES_ACTIVE` = `prod`
   - `DB_URL` = RDS endpoint
   - `DB_USERNAME` = RDS username
   - `DB_PASSWORD` = RDS password
6. Create environment

### 3. CodeBuild Setup
1. AWS Console → CodeBuild → **Create build project**
2. Source: **GitHub** → repository connect 
3. Buildspec: **Use buildspec.yml from repo**
4. Artifacts: **Amazon S3**
5. Create build project

### 4. CodePipeline Setup
1. AWS Console → CodePipeline → **Create pipeline**
2. Source stage: **GitHub → master branch**
3. Build stage: **CodeBuild project select**
4. Deploy stage: **Elastic Beanstalk → environment select**
5. Create pipeline

### 5. GitHub Connection
1. CodePipeline → Settings → **Connections**
2. **Create connection → GitHub**
3. Authorize AWS to access GitHub repo

---

## ⚙️ CI/CD Pipeline Flow

Push to `master` → CodePipeline triggers → CodeBuild builds JAR → Elastic Beanstalk deploys
```yaml
# buildspec.yml (CodeBuild)
phases:
  build:
    commands:
      - mvn clean package 
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
