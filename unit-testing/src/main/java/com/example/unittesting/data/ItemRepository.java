package com.example.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.unittesting.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
