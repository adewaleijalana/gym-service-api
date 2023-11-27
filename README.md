## Steps to run

1. Clone the repository using
   `git clone https://github.com/adewaleijalana/gym-service-api.git`
2. change directory/folder to `gym-service-api`
3. Build the project using
   `mvn clean install`
4. Run using `mvn spring-boot:run`
5. The web application is accessible via localhost:8585

# List of endpoints:
- http://localhost:8585/api/training-session
- http://localhost:8585/api/training-session/search?coachName=Coach-B&values=WED,SAT
- http://localhost:8585/api/training-session/count