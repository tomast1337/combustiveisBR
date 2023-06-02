# Use the official MySQL 8.0 image as the base image
FROM mysql:8.0

# Set environment variables for MySQL configuration
ENV MYSQL_DATABASE=distribuidorabr
ENV MYSQL_ROOT_PASSWORD=root

# Copy custom MySQL configuration file
COPY custom.cnf /etc/mysql/conf.d/custom.cnf

# Expose the default MySQL port (3306)
EXPOSE 3306
