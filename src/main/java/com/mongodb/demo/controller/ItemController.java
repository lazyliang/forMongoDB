package com.mongodb.demo.controller;

import com.google.gson.JsonObject;
import com.mongodb.demo.pojo.Item;
import com.mongodb.demo.pojo.ItemRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by ll on 2018/6/21.
 */
@EnableScheduling
@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @Scheduled(fixedRate = 6000L)
    @RequestMapping("/addItem")
    public String addItem() throws JSONException {
        JSONObject data = new JSONObject();
        Item item = new Item();
        item.setName("商品1");
        item.setPrice("8888");
        try{
              itemRepository.save(item);
        }catch (Exception e){
           data.put("error","Add item error");
        }
        return data.toString();
    }
}
