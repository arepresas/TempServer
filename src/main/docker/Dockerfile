FROM java:8
VOLUME /tmp
ADD temp-service-1.0.0.jar temp-service-1.0.0.jar
RUN bash -c 'touch /temp-service-1.0.0.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/temp-service-1.0.0.jar"]