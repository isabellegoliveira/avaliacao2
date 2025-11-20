# avaliacao2
# 🎓 Sistema Acadêmico – Full Stack (Spring Boot + Frontend + Docker + JMeter)

Este projeto consiste em um sistema acadêmico completo permitindo controlar:

* Cadastro de alunos
* Cadastro de cursos
* Relacionamento Aluno ↔ Curso
* Autenticação com Spring Security (Keycloak)
* Monitoramento da aplicação
* Testes de carga
* Deploy completo (Backend + Frontend)

---

# 🚀 Tecnologias Utilizadas

## Backend

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Spring Security
* Spring Boot Actuator
* Springdoc / Swagger
* H2 Database

## Frontend

* Implementação em JavaScript (framework simples)
* Integração via chamadas HTTP
* Consumo direto da API

## Infra e Outros

* Docker
* Prometheus
* Grafana
* Apache JMeter (testes de desempenho)

---

# 🧱 Funcionalidades

## 🧑‍🎓 Alunos

* Cadastrar aluno
* Listar alunos
* Editar aluno
* Relacionar com cursos

## 📚 Cursos

* Cadastrar curso
* Listar cursos
* Editar curso
* Relacionamento com alunos

## 🔐 Autenticação

A autenticação é feita com **Spring Security + Keycloak**, protegendo o acesso aos endpoints.

> As credenciais são configuradas diretamente no Keycloak pelo usuário responsável.

---

# ⚙️ Como Executar o Backend

## 1️⃣ Requisitos

* Java 21
* Maven ou Gradle
* Porta **8080** livre

## 2️⃣ Executar com Maven

```bash
mvn spring-boot:run
```

Ou build completo:

```bash
mvn clean package
java -jar target/*.jar
```

## 3️⃣ Acessar a aplicação

```
http://localhost:8080
```

---

# 📖 Documentação da API (Swagger)

Após iniciar o backend, acessar:

```
http://localhost:8080/swagger-ui.html
```

ou

```
http://localhost:8080/swagger-ui/index.html
```

---

# 🧑‍💻 Executando o Frontend

## 1️⃣ Requisitos

* Node.js instalado
* Backend já rodando

## 2️⃣ Instalação

Dentro da pasta do frontend:

```bash
npm install
```

## 3️⃣ Rodar a aplicação

```bash
npm start
```

ou

```bash
npm run dev
```

## 4️⃣ Acesso

O frontend roda na porta definida pelo framework escolhido
(geralmente **3000**, **4200** ou similar).

---

# 🔗 Comunicação Backend ↔ Frontend

O frontend deve apontar para:

```
http://localhost:8080
```

Exemplo de chamado fetch:

```javascript
fetch("http://localhost:8080/alunos")
  .then(r => r.json())
  .then(console.log);
```

---

# 📊 Monitoramento com Prometheus e Grafana

## 1️⃣ Subir os serviços

```bash
docker compose up -d
```

## 2️⃣ Endereços

* Prometheus

  ```
  http://localhost:9090
  ```

* Grafana

  ```
  http://localhost:3000
  ```

Login padrão do Grafana:

```
usuário: admin
senha: admin
```

No Grafana:

* adicionar Prometheus como Data Source
* importar dashboards (como “Spring Boot Statistics”)

---

# 🧪 Testes de Carga – JMeter

## Objetivos dos testes

* Simular múltiplos acessos simultâneos
* Avaliar:

  * Latência
  * Throughput
  * Taxa de erro
  * Estabilidade da aplicação

## Como executar

1️⃣ Instalar o JMeter
[https://jmeter.apache.org](https://jmeter.apache.org)

2️⃣ Abrir o arquivo `.jmx` do projeto

3️⃣ Rodar:

```
Run > Start
```

### Gerar relatório completo em HTML:

```bash
jmeter -n -t test.jmx -l resultados.jtl -e -o ./relatorio
```

Abrir depois:

```
relatorio/index.html
```

---

# 🌐 Deploy

## Backend – Render

Guia oficial:

```
https://render.com/docs/deploy-spring
```

Configurações recomendadas:

* Web Service
* Porta: **8080**

## Frontend – Vercel

Passos:

1. Criar conta: [https://vercel.com](https://vercel.com)
2. Importar o repositório
3. Build automático
4. Se necessário, configurar variável com URL da API:

```
API_URL=http://<url-do-backend>
```

---

# 📚 Referências

* Spring Boot
  [https://docs.spring.io/spring-boot/docs/current/reference/html](https://docs.spring.io/spring-boot/docs/current/reference/html)

* Spring Security
  [https://docs.spring.io/spring-security/reference/index.html](https://docs.spring.io/spring-security/reference/index.html)

* Swagger
  [https://springdoc.org](https://springdoc.org)

* Prometheus
  [https://prometheus.io](https://prometheus.io)

* Grafana
  [https://grafana.com/docs/grafana/latest](https://grafana.com/docs/grafana/latest)

* JMeter
  [https://jmeter.apache.org/usermanual/index.html](https://jmeter.apache.org/usermanual/index.html)
