FROM openjdk:8
VOLUME /tmp
ADD target/predix-metadata-extractor-1.0.jar predix-metadata-extractor-1.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/predix-metadata-extractor-1.0.jar"]
EXPOSE 8083