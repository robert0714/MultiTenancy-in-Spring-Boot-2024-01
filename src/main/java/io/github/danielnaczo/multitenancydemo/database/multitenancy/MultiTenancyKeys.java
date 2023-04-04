package io.github.danielnaczo.multitenancydemo.database.multitenancy;

import static org.springframework.boot.jdbc.DatabaseDriver.POSTGRESQL;

public class MultiTenancyKeys {
    public static final String defaultDBName = "shared";
    public static final String urlPrefix = "jdbc:postgresql://localhost:5432/";
    public static final String username = "postgres";
    public static final String password = "";
    public static final String driverClassName = POSTGRESQL.getDriverClassName();
}
