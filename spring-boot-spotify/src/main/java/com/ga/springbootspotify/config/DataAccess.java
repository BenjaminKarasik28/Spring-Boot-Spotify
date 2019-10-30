package com.ga.springbootspotify.config;

import org.springframework.beans.factory.annotation.Value;

public class DataAccess {
    @Value("${host}")
    private String host; // sets the value to "mysqlxd001"
    @Value("${port}")
    private String port; // sets the value to "3306"
    @Value("${database}")
    private String database; // sets the value to "ga-users"
    @Value("${user}")
    private String user; // sets the value to "jjones"
    @Value("${password}")
    private String password; // sets the value to "pa55w0rd"
    @Value("${concurrent.connnections}")
    private int concurrentConnections; // sets the value to "10"
    @Value("${autocommit}")
    private boolean autocommit; // sets the value to false
}