FROM openjdk:11
EXPOSE 8080
ADD target/capacity-plan-0.0.1-SNAPSHOT.jar capacity-plan-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/capacity-plan-0.0.1-SNAPSHOT.jar"]