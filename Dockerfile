FROM maven

COPY . /usr/src
WORKDIR /usr/src

EXPOSE 8443

CMD mvn clean && \
    mvn install -DskipTests && \
    cd voter-access && \
    mvn spring-boot:run -DDB_URL=$DB_URL -DDB_PASSWORD=$DB_PASSWORD -DDB_USER=$DB_USER