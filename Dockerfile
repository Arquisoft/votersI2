FROM java:openjdk-8-jdk

ENV MAVEN_VERSION 3.3.9

RUN mkdir -p /usr/share/maven \
  && curl -fsSL http://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz \
    | tar -xzC /usr/share/maven --strip-components=1 \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven


COPY . /usr/src
WORKDIR /usr/src

RUN mvn clean && \
    mvn install -DskipTests

EXPOSE 8443

CMD cd voter-access && \
    mvn spring-boot:run -DDB_URL=$DB_URL -DDB_PASSWORD=$DB_PASSWORD -DDB_USER=$DB_USER