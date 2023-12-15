FROM bellsoft/liberica-openjdk-debian:17
VOLUME /tmp
RUN mkdir /var/app
WORKDIR /var/app
COPY ./target/doctor-who-app-backend-*.jar app.jar
RUN useradd -m -s /bin/bash doctorwho
USER doctorwho
ENTRYPOINT ["java", "-jar", "app.jar"]
