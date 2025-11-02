## ☕ JSP & 웹 아키텍처 요약

### 📘 JSP (Java Server Page)
- **HTML 중심 + Java 연동형 웹 언어**  
- HTML 코드 안에 **Java 코드를 직접 작성**할 수 있다.  
- 주로 **동적 웹 페이지** 개발에 사용된다.  

---

### 🖥️ 서버(Server)와 클라이언트(Client)
| 구분 | 설명 |
|------|------|
| **서버(Server)** | 사용자의 요청에 따라 서비스(데이터, 페이지 등)를 제공 |
| **클라이언트(Client)** | 서버에 요청(Request)을 보내는 주체 |

- **요청(Request)**: 클라이언트 → 서버  
- **응답(Response)**: 서버 → 클라이언트  

---

### ⚙️ 웹 서버(Web Server) — *Apache*
- 사용자의 요청이 **정적(HTML)** 인지 **동적(JSP, Servlet)** 인지 구분  
- 정적 데이터 → HTML 문서 그대로 응답  
- 동적 데이터 → **웹 컨테이너(Servlet Container)** 로 전달  

---

### 🧩 웹 컨테이너(Servlet Container)
- JSP / Servlet을 통해 **동적 데이터 처리 및 DB 접근**  
- 복잡한 연산(DB 등)은 Java 코드로 수행  
- 연산 결과를 **정제된 정적 데이터로 변환** 후 웹 서버를 통해 클라이언트에 응답  

---

### 🚀 WAS (Web Application Server) — *Tomcat*
- **Servlet 실행 및 관리 역할** 수행  
- 동적 요청 발생 시:
  1. 해당 Servlet을 메모리에 로드  
  2. `web.xml`을 참조해 요청 매핑  
  3. **Thread 생성 → 요청 처리 → 응답 → 메모리 해제**

---

### 🧱 서블릿(Servlet)
- **Java 코드 안에 HTML을 포함**하는 서버 프로그램  
- Thread가 `service()` 메서드를 호출해 실행  
- 요청 방식에 따라:
  - `doGet()` → GET 요청 처리  
  - `doPost()` → POST 요청 처리  

---

## 🔀 요청 방식 (Request Methods)

### 🧩 GET 방식
- 데이터가 **URL에 직접 포함되어 전송**
- 빠르지만 **보안 취약** (주소창에 데이터 노출)
- 데이터 길이에 **제한 있음**
- 예: `example.com/login?id=test&pw=1234`

### 🔐 POST 방식
- 데이터가 **Header(본문)** 에 포함되어 전송  
- 브라우저 히스토리에 남지 않음  
- 길이 제한 없음 / 보안성 높음  
- 다만, GET보다 상대적으로 **전송 속도 느림**

---

## 🔁 페이지 이동 방식

| 방식 | 경로 표시 | 특징 |
|------|------------|------|
| **forward** | 요청한 경로가 그대로 유지 | 내부 페이지 이동용 (`.jsp` 등), 데이터 전달 가능 |
| **redirect** | 요청 경로 초기화됨 | 다른 Servlet 등 외부 이동 시 사용, 보안성 ↑ |

📌 **forward** → 단순 페이지 이동, 데이터 전달 목적  
📌 **redirect** → DB 연산 후 다른 요청으로 이동할 때 사용  

---

## 🧪 실습 예시

| 실습 | 설명 |
|------|------|
| **ex02.jsp → ex02-result.jsp** | 정수 2개 입력 → 덧셈 결과 출력 |
| **ex03.jsp → ex03-result.jsp** | 과일 이름/가격 전달 → `000은 000원입니다` 출력 |
| **숙제 1** | “경기도” 입력 → “남양주시” 출력 / “서울” → “강남구” 출력 |
| **숙제 2** | 아이디, 비밀번호 전달 → `test / 1234` 검사 → 성공 시 “test님 환영합니다”, 실패 시 원래 페이지 복귀 |

---

## 🧭 JSP 구조 vs MVC 패턴

### 🔹 JSP 방식
```
a.jsp → b.jsp → c.jsp
```
- 각 JSP에 Java 코드 포함  
- DB 연결 코드까지 JSP 안에 포함됨  
- **작은 프로젝트에 적합**, 그러나 **규모 커질수록 유지보수 어려움**

---

### 🔸 MVC 패턴

#### 🧩 Model1
```
a.jsp → b.jsp → c.jsp
       ↓
      DAO.java
```
- JSP에서 DAO 호출  
- View(JSP)와 Controller(로직)가 섞여 있음  
- 설계는 단순하지만, 유지보수에 불리  

---

#### 🧩 Model2 (MVC 패턴)
```
a.jsp → web.xml → FrontController → c.jsp
                   ↓
              Controller
                   ↓
                 DAO → DB
```

**특징**
- **비즈니스 로직 완전 분리**  
- 요청 확장자(`*.me`, `*.bo` 등)를 그룹화하여 FrontController로 전달  
- `FrontController`는 URL 패턴을 분석해 **적절한 Controller 호출**  
- 각 Controller는 **인터페이스 구현**으로 일관된 구조 유지  
- **DAO**에서 DB 연산 담당  
- 최종 결과는 **ActionForward 객체** 등을 통해 이동 정보와 방식 전달  
- FrontController가 결과를 해석하여 View로 이동  

📌 장점:  
- 유지보수 용이  
- 코드 재사용 가능  
- 구조적 설계로 대규모 프로젝트에 적합  

---

## 💾 DBCP (Database Connection Pool)
- 다수의 요청 시 매번 DB 연결을 생성하면 속도 저하 발생  
- 미리 **Connection 객체를 풀(Pool)** 로 생성해 두고  
  필요할 때 빌려 쓰고, 사용 후 반납하는 방식  
- **성능 향상 + 자원 효율성 확보**

---

## 🧭 JNDI (Java Naming and Directory Interface)
- 디렉터리 서비스에서 객체 및 리소스를 찾고 참조하기 위한 **Java API**  
- 예: 외부 데이터베이스 연결 객체를 이름으로 찾아 사용  

---

## ⚙️ MyBatis Framework
- SQL을 Java 코드 안에 직접 작성하면 유지보수 불편  
- **MyBatis**는 SQL을 **XML 파일로 분리하여 관리**  
- 코드 가독성 향상 및 유지보수 용이  
- SQL 변경 시 Java 코드 수정 없이 XML만 수정하면 됨  

📘 **핵심 장점**
- SQL 분리로 코드 간결화  
- Mapper 파일(XML) 기반 구조  
- DAO와 연동 시 코드 재사용성 증가
