package com.example.inventManager.repositories;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.inventManager.models.Store;



@Repository
public interface IStoreRepository extends JpaRepository<Store,UUID> {
    
}
