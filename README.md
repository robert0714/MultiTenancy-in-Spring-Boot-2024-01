# Multi-Tenancy Demo Project
Demo project for using Multi-Tenancy in Spring Boot

Multi-tenancy describes a system in which an application serves multiple tenants on the server side.
This project demonstrates how to build an application using the Multi-Tenancy architecture based on the following technologies:

* **Java** (v.17)
* **Spring Boot** (v.3.0.5)
* **PostgreSQL** (v.15)

In this project each tenant shall use **a separate database**. In addition, a **shared database** is used for shared data. This scenario often arises in practice when sensitive data has to be persisted in isolation on the one hand, but is based on a shared data base on the other.

The project represents a **minimalistic online store**. Products are offered and can be ordered by customers from different countries. Customers and their orders are stored in country-specific databases, so every country describes a tenant.
