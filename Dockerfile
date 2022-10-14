FROM eclipse-temurin:17
VOLUME [ "/data" ]

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

RUN chmod +x ./mvnw
RUN ./mvnw dependency:resolve

EXPOSE 3000
CMD ./mvnw spring-boot:run