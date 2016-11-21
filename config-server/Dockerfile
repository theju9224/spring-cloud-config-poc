FROM java:8 

# Install maven
RUN apt-get update  
RUN apt-get install -y maven

# Adding config-server project
ADD . /usr/config-server  
WORKDIR /usr/config-server
RUN ["mvn", "package"]

EXPOSE 8888  
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "-Dspring.profiles.active=cloud", "target/config-server-0.0.1-SNAPSHOT.jar"]
