package com.surreal.starter.controllers;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.surreal.starter.dto.ListItemRequest;
import com.surreal.starter.models.TodoItem;
import com.surreal.starter.services.ITodoService;

@RestController
public class TodoController {
    
    @Autowired
    private ITodoService todoService;

    @PostMapping("/todo")
	public TodoItem addItem( @RequestBody ListItemRequest listItemRequest) { 
        return todoService.addListItem(listItemRequest.getItem());
	}

    @GetMapping("/todo/{id}")
	public TodoItem getItembyId(@PathVariable String id) {
        return todoService.getItemById(id);
	}

    @GetMapping("/todo")
    @ResponseStatus( code = HttpStatus.OK)
	public List<TodoItem> getAllTodoItems() {
        return todoService.getAllItems();
	}

    @DeleteMapping("/todo/{id}")
	public TodoItem deleteItem(@PathVariable String id) { 
        return todoService.deleteItemById(id);
	}

}
