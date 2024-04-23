FROM postgres:latest
ENV SQL_SCRIPT_PATH=/docker-entrypoint-initdb.d/init.sql
ENV POSTGRES_PASSWORD=dev
ENV POSTGRES_USERNAME=postgres
ENV POSTGRES_PORT=5566
ENV POSTGRES_DB=socialdb
ENV PGDATA=/var/lib/postgresql/data
RUN mkdir -p "$SQL_SCRIPT_PATH"
# Copy your SQL script to the container
COPY ./database.sql $SQL_SCRIPT_PATH
RUN chown postgres:postgres /docker-entrypoint-initdb.d/init.sql
# Optional: Set working directory for SQL script execution
WORKDIR $SQL_SCRIPT_PATH
USER postgres
# Execute the SQL script during container startup (entrypoint)
ENTRYPOINT ["postgres", "-d", "$PGDATA"]
EXPOSE 5432
