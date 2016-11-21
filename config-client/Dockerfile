FROM java:8 

# Install maven
RUN apt-get update  
RUN apt-get install -y maven

# Adding config-server project
ADD . /usr/config-client  
WORKDIR /usr/config-client
RUN ["mvn", "package"]

EXPOSE 8000 
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "target/config-client-0.0.1-SNAPSHOT.jar"]
