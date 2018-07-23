package com.mongodb.demo.pojo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Create by ll on 2018/6/21.
 */
public interface ItemRepository extends MongoRepository<Item,String> {
    Item findByName(String name);
}
