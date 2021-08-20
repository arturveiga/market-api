FROM adoptopenjdk/openjdk12-openj9:alpine-slim
RUN mkdir -p /app/_cache
RUN apk update && apk add bash
COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar
VOLUME /app/_cache
EXPOSE 8080
CMD ["java", "-Xvirtualized", "-Duser.Timezone=America/Fortaleza" , "-Xshareclasses", "-Xshareclasses:name=sum", "-Xshareclasses:cacheDir=/app/_cache", "-jar", "/app/app.jar"]