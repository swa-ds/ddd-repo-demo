package de.doubleslash.myapp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.doubleslash.myapp.item.domain.model.Item;
import de.doubleslash.myapp.item.domain.model.ItemRepository;

@SpringBootApplication
public class AppMain {

    Logger LOG = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }

    @Bean
    CommandLineRunner runner(ItemRepository repo) {
        return args -> {
            repo.save(new Item("Item 1"));
            repo.save(new Item("Item 2"));

            List<Item> allItems = repo.findAll();

            allItems.forEach(this::printIt);

            List<Item> items = repo.findByName("Item 1");
            items.forEach(this::printIt);

            items = repo.findByCustomQuery("Item 2");
            items.forEach(this::printIt);
        };
    }

    private void printIt(Item it) {
        LOG.info("><> ><> ><> " + it);
        LOG.info("><> ><> ><> ");
    }

}
