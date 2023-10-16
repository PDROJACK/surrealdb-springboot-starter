package com.surreal.starter.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.surreal.starter.models.TodoItem;
import com.surreal.starter.utils.DBConnection;
import com.surrealdb.driver.SyncSurrealDriver;

@Service
public class TodoService implements ITodoService {
    
    private SyncSurrealDriver driver = null;
    String tableName = "todo";

    public TodoService() {
        this.driver = DBConnection.getDriver();
    }

    public TodoItem addListItem(String item) {
        TodoItem created = driver.create(tableName, TodoItem.builder().id("123").value("buy milk").build());
        return created;
    }

    public TodoItem deleteItemById(String id) {
        // TodoItem created = driver.query();
        return null;
    }

    public List<TodoItem> searchTodoItems(String id) {
        // List<TodoItem> itemList = driver.query(id, null, null);

        return null;
    }

    @Override
    public List<TodoItem> getAllItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllItems'");
    }

}
