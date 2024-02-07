package hu.flowacademy.storage.service;

import hu.flowacademy.storage.model.StorageItem;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageService {

    public List<StorageItem> list = new ArrayList<>();

    public List<StorageItem> listItems() {
        return list.stream().filter(storageItem -> {
            return storageItem.getQuantity() > 0;
        }).collect(Collectors.toList());
    }

    public StorageItem addItem(@RequestBody StorageItem storageItem) {
        list.add(storageItem);
        return storageItem;
    }

    public void deleteItem(@PathVariable int index) {
        list.remove(index);
    }

}
