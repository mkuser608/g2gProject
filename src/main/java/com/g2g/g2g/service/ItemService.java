package com.g2g.g2g.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.g2g.g2g.ResponseItem;
import com.g2g.g2g.model.item;

public interface ItemService {

    public ResponseEntity<item> saveItem(item item);

    public ResponseEntity<ResponseItem> getAllItemASC(Integer limit, Integer offset, String nameLike, String descriptionLike, String sortBy);

    public ResponseEntity<ResponseItem> getAllItemDESC(Integer limit, Integer offset, String nameLike, String descriptionLike, String sortBy);

    public ResponseEntity<item> getItemById(int id);

    public ResponseEntity<item> updateItemByIdAndData(int id, Map<Object, Object> mp);

    public ResponseEntity<Object>deleteItemById(int id);

    
    
}
