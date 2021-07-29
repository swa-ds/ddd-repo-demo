package de.doubleslash.myapp.item.domain.model;

import java.util.List;

public interface ItemRepository {

    Item save(Item anItem);

    List<Item> findAll();

    List<Item> findByName(String name);

    List<Item> findByCustomQuery(String name);

}
