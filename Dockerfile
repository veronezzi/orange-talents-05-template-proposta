FROM openjdk:11
COPY ./target/proposta.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","proposta.jar"]