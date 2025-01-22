# Property Management System

A simple Property Management System built using **Spring Boot** and an **H2 Database**. This project provides an API to manage properties with basic CRUD operations (Create, Read, Update, Delete). The system allows users to manage property details like name, price, and description.

## Features

- **Create Property**: Add a new property to the system.
- **View Properties**: Retrieve a list of all properties.
- **Update Property**: Modify the details of an existing property.
- **Delete Property**: Remove properties from the system.

## API Endpoints

- `POST /api/v1/property/properties`: Create a new property (with JSON data).
- `GET /api/v1/property/properties`: Get a list of all properties.
- `PUT /api/v1/property/properties/{id}`: Update a property's details.
- `PATCH /api/v1/property/properties/update-description/{id}`: Update property description.
- `PATCH /api/v1/property/properties/update-price/{id}`: Update property price.
- `DELETE /api/v1/property/properties/{id}`: Delete a property by ID.

## Technologies Used

- **Spring Boot**: Framework for building the REST API.
- **H2 Database**: In-memory database for storing property data.
- **Java**: Programming language used.
- **Maven**: Dependency management and build tool.
  
## Usage
Run the project through the IDE and head out to http://localhost:8080


