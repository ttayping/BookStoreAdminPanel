FROM openjdk
RUN echo "it works"
COPY ./build/libs/BookstoreAdminPanel-0.1.jar /app/
WORKDIR /app/
# Set the environment variable to specify the PostgreSQL host
ENV DB_HOST=postgres_container

# Expose any ports your Java application listens on (if needed)

# Command to run your Java application
ENTRYPOINT ["java"]
CMD ["-jar", "/app/BookstoreAdminPanel-0.1.jar"]