package io.github.danielnaczo.multitenancydemo.database.multitenancy;

import static org.springframework.boot.jdbc.DatabaseDriver.POSTGRESQL;

public class MultiTenancyKeys {
    public static final String DEFAULT_DB_NAME = "shared";
    public static final String URL_PREFIX = "jdbc:postgresql://localhost:5432/";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "";
    public static final String DRIVER_CLASS_NAME = POSTGRESQL.getDriverClassName();
}
