package com.efectura.utilities;

public class DbConfigs {
    public static final String DEV_MDM_URL = "jdbc:sqlserver://10.15.16.196:1433;databaseName=DEV_MDM;encrypt=true;trustServerCertificate=true;";
    public static final String DEV_STAGING_URL = "jdbc:sqlserver://10.15.16.196:1433;databaseName=STAGING;encrypt=true;trustServerCertificate=true;";
    public static final String TESTING_MDM_URL = "jdbc:sqlserver://10.15.16.197:1433;databaseName=DEV_MDM;encrypt=true;trustServerCertificate=true;";
    public static final String TESTING_STAGING_URL = "jdbc:sqlserver://10.15.16.197:1433;databaseName=STAGING;encrypt=true;trustServerCertificate=true;";
    public static final String DB_USERNAME = "dev_hero";
    public static final String DB_PASSWORD = "6KQlSamV4D2x7T9179STCK";
    public static final String DB_URL = "jdbc:sqlserver://server12.efectura.com:1433;databaseName=DIA_PREPROD;encrypt=true;trustServerCertificate=true;";

    public static final String CLICKHOUSE_USERNAME = "efectura";

    public static final String SQLSERVER_PROD = "jdbc:sqlserver://;serverName=212.68.49.16;databaseName=MEDIAMARKT;encrypt=true;trustServerCertificate=true;";
    public static final String SQLSERVER_DIA_PROD = "jdbc:sqlserver://;serverName=212.68.49.16;databaseName=DEV_MDM;encrypt=true;trustServerCertificate=true;";
    public static final String SQLSERVER_PREPROD = "jdbc:sqlserver://server12.efectura.com:1433;databaseName=MEDIAMARKT;encrypt=true;trustServerCertificate=true;";
    public static final String SQLSERVER_USERNAME = "dev_hero";

    public static final String CLICKHOUSE_PROD = "jdbc:clickhouse://212.68.49.250:8123/default";
    public static final String CLICKHOUSE_PREPROD = "jdbc:clickhouse://server15.efectura.com:10030/my_database";

}
