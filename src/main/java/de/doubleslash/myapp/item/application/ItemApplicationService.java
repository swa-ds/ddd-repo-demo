package de.doubleslash.myapp.item.application;

import java.util.List;

import de.doubleslash.myapp.item.domain.model.Item;
import de.doubleslash.myapp.item.domain.model.ItemRepository;

@org.springframework.stereotype.Service
public class ItemApplicationService {

    private final ItemRepository repo;

    public ItemApplicationService(ItemRepository repo) {
        this.repo = repo;
    }

    public Item createItem(String name) {
        return repo.save(new Item(name));
    }

    public List<Item> getAll() {
        return repo.findAll();
    }

    public List<Item> findByName(String name) {
        return repo.findByName(name);
    }

    public List<Item> complexQuery(String name) {
        return repo.findByCustomQuery(name);
    }
}
