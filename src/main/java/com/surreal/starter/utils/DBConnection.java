package com.surreal.starter.utils;

import org.springframework.stereotype.Component;

import com.surrealdb.connection.SurrealConnection;
import com.surrealdb.connection.SurrealWebSocketConnection;
import com.surrealdb.driver.SyncSurrealDriver;

@Component
public class DBConnection {
    
    private static SyncSurrealDriver driver = null;

    private DBConnection(){
    }

    public static synchronized SyncSurrealDriver getDriver() {
        if(driver == null){
            SurrealConnection conn = new SurrealWebSocketConnection("localhost", 8000, false);
            conn.connect(5);
            driver = new SyncSurrealDriver(conn);
            driver.use("spring", "todo");
        } 

        return driver;
    }
    
}
