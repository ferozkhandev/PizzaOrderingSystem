# Pizza Ordering System - Docker Setup

This repository contains a microservices-based Pizza Ordering System with Docker support. The system consists of multiple services that can be run independently or together using Docker Compose.

## Services

1. **PizzaOrderingSystem** - The main service
2. **ProductManagementSystem** - Service for managing pizza products, crusts, toppings, and sizes

## Prerequisites

- Docker
- Docker Compose V2 (using `docker compose` command instead of `docker-compose`)

## Getting Started

### Building and Running with Docker Compose

To build and run all services together:

```bash
docker compose up -d
```

This will:
- Build all service images
- Start all services
- Set up the PostgreSQL database for the ProductManagementSystem

### Accessing the Services

- **PizzaOrderingSystem**: http://localhost:8080
- **ProductManagementSystem**: http://localhost:8081

### Stopping the Services

To stop all services:

```bash
docker compose down
```

To stop all services and remove volumes:

```bash
docker compose down -v
```

## Building Individual Services

### PizzaOrderingSystem

```bash
cd PizzaOrderingSystem
docker build -t pizza-ordering-system .
docker run -p 8080:8080 pizza-ordering-system
```

### ProductManagementSystem

```bash
cd ProductManagementSystem
docker build -t product-management-system .
docker run -p 8081:8080 -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/productdb product-management-system
```

Note: When running the ProductManagementSystem individually, you'll need to have PostgreSQL running and accessible.

## Environment Variables

### PizzaOrderingSystem
- `SPRING_PROFILES_ACTIVE`: The Spring profile to use (default: prod)

### ProductManagementSystem
- `SPRING_PROFILES_ACTIVE`: The Spring profile to use (default: prod)
- `APP_PORT`: The port the application runs on inside the container (default: 8080)
- `DB_NAME`: PostgreSQL database name
- `DB_USER`: PostgreSQL username
- `DB_PASSWORD`: PostgreSQL password
- `SPRING_DATASOURCE_URL`: JDBC URL for the database
- `SPRING_DATASOURCE_USERNAME`: Database username
- `SPRING_DATASOURCE_PASSWORD`: Database password

## Docker Compose Configuration

The `compose.yaml` file in the root directory configures all services to work together. It sets up:

1. The main PizzaOrderingSystem service
2. The ProductManagementSystem service
3. A PostgreSQL database for the ProductManagementSystem
4. A custom network for service communication
5. A volume for PostgreSQL data persistence
