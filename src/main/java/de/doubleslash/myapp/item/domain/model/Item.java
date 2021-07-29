package de.doubleslash.myapp.item.domain.model;

import org.springframework.data.annotation.Id;

public class Item {

    @Id
    private Long id;

    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
