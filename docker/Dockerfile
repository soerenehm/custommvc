FROM java:8-alpine
# Working directories for Tomcat by default
VOLUME /tmp
EXPOSE 8080
ADD custommvc-1.0.0-SNAPSHOT.jar custommvc.jar
RUN sh -c 'touch /custommvc.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /custommvc.jar" ]
