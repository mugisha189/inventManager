package com.example.inventManager.repositories;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.inventManager.models.Item;



@Repository
public interface ItemRepository extends JpaRepository<Item,UUID> {
    
}
