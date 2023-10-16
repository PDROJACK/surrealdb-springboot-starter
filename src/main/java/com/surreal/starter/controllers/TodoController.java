package com.surreal.starter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.surreal.starter.models.TodoItem;
import com.surreal.starter.services.ITodoService;

@Controller
public class TodoController {
    
    @Autowired
    private ITodoService todoService;

    @GetMapping("/todo")
	public List<TodoItem> getAllItems() {
        return todoService.getAllItems();
	}

    @DeleteMapping("/todo/${id}")
	public TodoItem deleteItem(String id) { 
        return todoService.deleteItemById(id);
	}

    @GetMapping("/todo/search")
	public TodoItem getSearchItems(String id) { 
        return todoService.deleteItemById(id);
	}

    @PutMapping("/todo")
	public TodoItem addItem(String todo) { 
        return todoService.addListItem(todo);
	}


}
