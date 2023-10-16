package com.surreal.starter.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TodoItem {
    
    String id;
    String value;

}
