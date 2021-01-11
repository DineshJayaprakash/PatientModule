FROM adoptopenjdk/openjdk11
EXPOSE 8082
ADD /target/PatientModule-0.0.1-SNAPSHOT.jar PatientModule.jar
ENTRYPOINT ["java","-jar","/PatientModule.jar"]