package com.surreal.starter.services;

import java.util.List;

import com.surreal.starter.models.TodoItem;

public interface ITodoService {
    public TodoItem addListItem(String item);
    public List<TodoItem> getAllItems();
    public TodoItem getItemById(String id);
    public TodoItem deleteItemById(String id);    

}
