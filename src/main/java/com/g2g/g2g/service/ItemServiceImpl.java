package com.g2g.g2g.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.g2g.g2g.ResponseItem;
import com.g2g.g2g.model.item;
import com.g2g.g2g.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public ResponseEntity<item> saveItem(item item) {
        return new ResponseEntity<item>(repository.save(item), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseItem> getAllItemASC(Integer limit, Integer offset, String nameLike,
            String descriptionLike, String sortBy) {

        if (nameLike != null && descriptionLike != null) {
            var items = repository.getItemWithQuaryFilterWithNameAndDescription(limit, offset, nameLike,
                    descriptionLike, sortBy);
            return new ResponseEntity<ResponseItem>(new ResponseItem(items.size(), items), HttpStatus.OK);
        } else if (nameLike != null) {
            var items = repository.getItemWithQuaryFilterWithName(limit, offset, nameLike, sortBy);
            return new ResponseEntity<ResponseItem>(new ResponseItem(items.size(), items), HttpStatus.OK);
        } else if (descriptionLike != null) {
            var items = repository.getItemWithQuaryFilterWithDescription(limit, offset, descriptionLike, sortBy);
            return new ResponseEntity<ResponseItem>(new ResponseItem(items.size(), items), HttpStatus.OK);
        } else {
            var items = repository.getItemWithQuary(limit, offset, sortBy);
            return new ResponseEntity<ResponseItem>(new ResponseItem(items.size(), items), HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<ResponseItem> getAllItemDESC(Integer limit, Integer offset, String nameLike,
            String descriptionLike, String sortBy) {
        if (nameLike != null && descriptionLike != null) {
            var items = repository.getItemWithQuaryFilterWithNameAndDescriptionDESC(limit, offset, nameLike,
                    descriptionLike, sortBy);
            return new ResponseEntity<ResponseItem>(new ResponseItem(items.size(), items), HttpStatus.OK);
        } else if (nameLike != null) {
            var items = repository.getItemWithQuaryFilterWithNameDESC(limit, offset, nameLike, sortBy);
            return new ResponseEntity<ResponseItem>(new ResponseItem(items.size(), items), HttpStatus.OK);
        } else if (descriptionLike != null) {
            var items = repository.getItemWithQuaryFilterWithDescriptionDESC(limit, offset, descriptionLike, sortBy);
            return new ResponseEntity<ResponseItem>(new ResponseItem(items.size(), items), HttpStatus.OK);
        } else {
            var items = repository.getItemWithQuaryDESC(limit, offset, sortBy);
            return new ResponseEntity<ResponseItem>(new ResponseItem(items.size(), items), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<item> getItemById(int id) {

        System.out.println(repository.findById(id));

        if (isPresent(id)) {
            item item = repository.findById(id).get();
            return new ResponseEntity<item>(item, HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity<item> updateItemByIdAndData(int id, Map<Object, Object> mp) {
        System.out.println(isPresent(id));
        if (isPresent(id)) {

            item it = getItemById(id).getBody();
            item itemPatched = applyPatchtoItem(mp, it);
            return ResponseEntity.ok(itemPatched);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

   

    @Override
    public ResponseEntity<Object> deleteItemById(int id) {
        if (isPresent(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    private item applyPatchtoItem(Map<Object, Object> mp, item it) {
        System.out.println(mp);
        if (mp.containsKey("name")) {
            it.setName((String) mp.get("name"));
        }
        if (mp.containsKey("price")) {
            it.setPrice(BigDecimal.valueOf((double) mp.get("price")));
        }
        if (mp.containsKey("description")) {
            it.setDescription((String) mp.get("description"));
        }
        if (mp.containsKey("available")) {
            it.setAvailable((boolean) mp.get("available"));
        }

        return repository.save(it);

    }

    private boolean isPresent(int id) {
        return !repository.findById(id).equals(Optional.empty());
    }

}
