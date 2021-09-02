# Gateway Manager Project

This sample project is managing gateways - master devices that control multiple peripheral devices. 

## Table of Contents

* [Pre-requisites](#pre-requisites)
* [Background](#background)
* [Instructions](#instructions)
* [License](#license)
* [Acknowledgement](#acknowledgement)

## Pre-requisites

The project requires a pre-installed Java 8, Eclipse STS and postman.

## Background

This application is built using Spring Boot Restful technology, which provide the backend restful APIs for the Gateway Manager Application.

## Instructions

- Unzip the project folder.
- Import the GatewayTask.postman_collection.json into Postman
- Import the folder inside 'Source code' as General Java Project in eclipse
- Run the class com.task.GatewayManagerApplication as Java Application
- then run the different postman requests to invoke the APIs
- You can view the database tables, using the following url:
http://localhost:8080/h2-console (sa /no password)


## Acknowledgement

- StackOverflow
- http://www.h2database.com/html/datatypes.html#timestamp_type
- https://www.baeldung.com/hibernate-one-to-many
- All the refrences commented in code