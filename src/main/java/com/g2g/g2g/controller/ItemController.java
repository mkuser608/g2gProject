package com.g2g.g2g.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g2g.g2g.ResponseItem;
import com.g2g.g2g.model.item;
import com.g2g.g2g.service.ItemService;

@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/items")
    public ResponseEntity<ResponseItem> getAllItem(@RequestParam(required = false) Integer Limit,  @RequestParam(required = false) 
            Integer Offset, @RequestParam(required = false) String nameLike, @RequestParam(required = false) String descriptionLike,
            @RequestParam(required = false) String sortBy, @RequestParam(required = false) String sortDirection ) {

                if(Limit==null){
                    Limit = 2147483647;
                }
                if(Offset==null){
                    Offset=0;
                }
                if(sortBy ==null){
                    sortBy ="";
                }
                System.out.println(nameLike);
                if(sortDirection==null || sortDirection.toLowerCase()=="asc"){
                    return service.getAllItemASC(Limit, Offset, nameLike, descriptionLike, sortBy);
                }else{
                    return service.getAllItemDESC(Limit, Offset, nameLike, descriptionLike, sortBy);
                }
        
    }

    @PostMapping("/items")
    public ResponseEntity<item> saveItem(@RequestBody item item) {
        return service.saveItem(item);
    }

    @GetMapping("/items/id/{id}")
    public ResponseEntity<item> getItemById(@PathVariable("id") int id) {
        return service.getItemById(id);

    }

    @PatchMapping("/items/id/{id}")
    public ResponseEntity<item> updateItemByIdAndData(@PathVariable("id") int id, @RequestBody Map<Object, Object> mp) {
        return service.updateItemByIdAndData(id, mp);

    }

    @DeleteMapping("/items/id/{id}")
    public ResponseEntity<Object>deleteItemById(@PathVariable("id") int id) {
        return service.deleteItemById(id);
    }

}
