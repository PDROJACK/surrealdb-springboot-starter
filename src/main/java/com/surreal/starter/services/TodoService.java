package com.surreal.starter.services;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.surreal.starter.models.TodoItem;
import com.surreal.starter.utils.DBConnection;
import com.surrealdb.driver.SyncSurrealDriver;
import com.surrealdb.driver.model.QueryResult;

@Service
public class TodoService implements ITodoService {
    
    private SyncSurrealDriver driver = null;
    String tableName = "todo";

    public TodoService() {
        this.driver = DBConnection.getDriver();
    }

    public TodoItem addListItem(String item) {
        TodoItem created = driver.create(tableName, TodoItem.builder().id(UUID.randomUUID().toString().replace("-", "")).value(item).build());
        return created;
    }

    @Override
    public TodoItem getItemById(String id) {
        // TODO Auto-generated method stub

        List<QueryResult<TodoItem>> query = driver.query("SELECT id,value FROM todo WHERE id=$id LIMIT BY 1;", Map.of("id", "todo:"+id), TodoItem.class);

        if(query.size() == 0 ) return null;

        if(query.get(0).getResult().size() == 0) return null;

        return query.get(0).getResult().get(0);
    }

    public TodoItem deleteItemById(String id) {
        List<QueryResult<TodoItem>> query = driver.query("DELETE todo WHERE id=$id;", Map.of("id", "todo:"+id), TodoItem.class);
        if(query.size() == 0) return null;
        if(query.get(0).getResult().size() == 0) return null;
        return query.get(0).getResult().get(0);

    }

    @Override
    public List<TodoItem> getAllItems() {
        // TODO Auto-generated method stub
        List<TodoItem> allUsers = driver.select(tableName, TodoItem.class);
        return allUsers;
    }

}
