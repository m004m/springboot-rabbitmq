FROM openjdk:17
#VOLUME /tmp
EXPOSE 8091
#ARG JAR_FILE=target/rabiitmq-base-docker.jar
##ADD ${JAR_FILE} rabiitmq-base-docker.jar
ADD target/rabiitmq-base-docker.jar rabiitmq-base-docker.jar 
ENTRYPOINT ["java","-jar","/rabiitmq-base-docker.jar"]