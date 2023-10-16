package com.surreal.starter.services;

import java.util.List;

import com.surreal.starter.models.TodoItem;

public interface ITodoService {
    public TodoItem addListItem(String item);
    public List<TodoItem> getAllItems();
    public TodoItem deleteItemById(String id);
    public List<TodoItem> searchTodoItems(String id);
}
