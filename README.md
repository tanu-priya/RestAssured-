# RestAssured – API Automation Framework

A scalable and maintainable **API automation framework** built using **Rest Assured**, **TestNG**, **Maven**, and **Allure**.  
This project follows real-world best practices and is suitable for **enterprise-level API testing**, learning, and interview demonstrations.

---

## 🚀 Tech Stack

- **Java**: 17  
- **API Automation**: Rest Assured  
- **Test Framework**: TestNG  
- **Build Tool**: Maven  
- **Reporting**: Allure  
- **Configuration Management**: `.env` / Environment Variables  
- **IDE**: VS Code (IDE independent)

---

## ✨ Key Features

- ✅ **BaseTest** for common setup and configuration
- ✅ **POJO-based request and response handling**
- ✅ **Payload Manager** for payload creation and parsing
- ✅ **Environment-based configuration** using `.env` / environment variables
- ✅ **Allure reporting with request & response attachments**
- ✅ **Clean separation of test logic and business logic**
- 🔜 **Token-based authentication reuse** (planned)

---

## 📁 Project Structure

RestAssured
│
├── src
│ ├── main
│ │ └── java
│ │ ├── constants # API endpoint constants
│ │ ├── payloads # PayloadManager / service layer
│ │ ├── pojos
│ │ │ ├── request # Request POJOs
│ │ │ └── response # Response POJOs
│ │ └── utils # Common utilities (non-test)
│ │
│ └── test
│ ├── java
│ │ ├── base # BaseTest setup
│ │ ├── utils # Test utilities (AllureUtils)
│ │ └── tests
│ │ └── ic
│ │ ├── crud
│ │ └── e2e
│ │
│ └── resources
│ └── testng.xml
│
├── .env.example # Sample environment file (safe to commit)
├── .gitignore
├── pom.xml
└── README.md


---

## 🔐 Configuration & Security

Sensitive data such as:
- API base URLs  
- Authentication endpoints  
- User credentials  

are **NOT hardcoded**.

### 🔹 Local Setup
Configuration is managed using a `.env` file (ignored by Git):

```env
BASE_URL=https://api.example.com
AUTH_ENDPOINT=/auth/login
USERNAME=your_email
PASSWORD=your_password

## How to Run Tests
mvn clean test

## 📊 Allure Reports
🔹 Generate & View Report
allure serve allure-results

🔹 What You’ll See in Allure
✔ Test execution status
✔ Request payload
✔ Request URL
✔ Response body
✔ HTTP status code

## 🧪 Sample API Test

@Test
public void testAccessToken() {

    String payload = payloadManager.createUserPayload();

    AllureUtils.attachRequest(payload);

    response = given()
            .spec(requestSpecification)
            .basePath(EndpointConstant.AUTH_URL)
            .body(payload)
    .when()
            .post();

    LoginResponse loginResponse =
            response.as(LoginResponse.class);

    Assert.assertNotNull(
            loginResponse.getAccessToken(),
            "Access token should not be null"
    );
}

## 📸 Allure Report Preview

Allure reports include:
Request Payload
Response Body
Status Code
Execution history

## 🧠 Design Principles Followed

Separation of concerns
No hardcoded configuration
Reusable and extensible structure
CI/CD friendly execution
Interview-ready framework design
