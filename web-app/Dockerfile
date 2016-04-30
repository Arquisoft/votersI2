FROM maven

COPY . /usr/src
WORKDIR /usr/src

RUN mvn clean
RUN mvn install -DskipTests

EXPOSE 8888

CMD ["java", "-jar",  "target/web-app-0.0.1.jar", "-DAPI_URL=$API_URL"]