package de.doubleslash.myapp.item.port.adapter.persistence;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.doubleslash.myapp.item.domain.model.Item;
import de.doubleslash.myapp.item.domain.model.ItemRepository;

public interface JdbcItemRepository extends ItemRepository, CrudRepository<Item, Long> {

    @Override
    @Query("select * from Item i where i.name = :name")
    List<Item> findByCustomQuery(@Param("name") String name);

}
