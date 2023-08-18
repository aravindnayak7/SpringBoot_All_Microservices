FROM openjdk:17-jdk-alpine
WORKDIR usr/src
ENV MONGO_DB=Emplpeedb
ENV MONG_URI=mongodb://localhost:27017/Employeedb
ADD ./target/RestFulpracticeown-1-0.0.1-SNAPSHOT.jar /usr/src/RestFulpracticeown-1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodbcontainers/Employeedb","-jar","RestFulpracticeown-1-0.0.1-SNAPSHOT.jar"]