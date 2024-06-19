package io.github.danielnaczo.multitenancydemo.database.multitenancy;

import static org.springframework.boot.jdbc.DatabaseDriver.POSTGRESQL;

public class MultiTenancyKeys {
    public static final String DEFAULT_DB_NAME = "shared";
    // public static final String DEFAULT_DB_NAME = "germany";
    // public static final String DEFAULT_DB_NAME = "spain";
    
    public static final String URL_PREFIX = "jdbc:postgresql://172.18.204.152:5432/";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "password";
    public static final String DRIVER_CLASS_NAME = POSTGRESQL.getDriverClassName();
}
