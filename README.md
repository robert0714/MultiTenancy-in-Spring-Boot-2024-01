# Multi-Tenancy Demo Project
Demo project for using Multi-Tenancy in Spring Boot

Reference: https://conciso.de/multi-tenancy-in-spring-boot-projekten/

Multi-tenancy describes a system in which an application serves multiple tenants on the server side.
This project demonstrates how to build an application using the Multi-Tenancy architecture based on the following technologies:

* **Java** (v.17)
* **Spring Boot** (v.3.1.12)
* **PostgreSQL** (v.15)

In this project each tenant shall use **a separate database**. In addition, a **shared database** is used for shared data. This scenario often arises in practice when sensitive data has to be persisted in isolation on the one hand, but is based on a shared data base on the other.

The project represents a **minimalistic online store**. Products are offered and can be ordered by customers from different countries. Customers and their orders are stored in country-specific databases, so every country describes a tenant.

* Example:
  ```bash
  curl --location 'localhost:8080/customers' \
       --header 'X-Tenant-Id: spain' \
       --header 'Content-Type: application/json' \
       --data '{
         "customerCode": "testCustomerCode02",
         "firstName": "testFirstName02",
         "lastName": "testLastName02",
         "address": "testAddress02"
        }'
  ```
