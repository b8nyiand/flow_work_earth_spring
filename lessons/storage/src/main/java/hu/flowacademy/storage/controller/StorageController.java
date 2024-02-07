package hu.flowacademy.storage.controller;

import hu.flowacademy.storage.model.StorageItem;
import hu.flowacademy.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    public StorageService storageService;

    @GetMapping("/listItems")
    public List<StorageItem> listItems() {
        return storageService.listItems();
    }

    @PostMapping("/addItem")
    @ResponseStatus(HttpStatus.CREATED)
    public StorageItem addItem(@RequestBody StorageItem storageItem) {
        return storageService.addItem(storageItem);
    }

    @DeleteMapping("/deleteItem/{index}")
    public void deleteItem(@PathVariable int index) {
        storageService.deleteItem(index);
    }

}
