package com.example.inventManager.models;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    // Getters and setters (omitted for brevity)

    // Constructors (omitted for brevity)
}
