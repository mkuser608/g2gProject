package com.g2g.g2g;

import java.util.List;

import org.springframework.stereotype.Component;

import com.g2g.g2g.model.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter

public class ResponseItem {
    
    
    private int totalItems;

    private List<item> items;

    
}
