package com.ejbexample5.ejbmanager.redis;


import com.ejbexample5.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 26.08.2014.
 */

public class ProductRepository implements Repository<Product> {

    public ProductRepository() {
    }

    @Autowired
    private RedisTemplate<String,Product> redisTemplate;

    public RedisTemplate<String, Product> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Product> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void put(Product obj) {
        redisTemplate.opsForHash()
                .put(obj.getObjectKey(), obj.getKey(), obj);
    }

    @Override
    public Product get(String id) {

        return (Product) redisTemplate.opsForHash().get(Product.OBJECT_KEY,
                id);
    }

    @Override
    public void delete(String id) {
        redisTemplate.opsForHash().delete(Product.OBJECT_KEY, id);
    }

    @Override
    public List<Product> getObjects() {
        List<Product> products = new ArrayList<Product>();
        redisTemplate.setDefaultSerializer(new GenericToStringSerializer<Integer>(Integer.class));
        for (Object user : redisTemplate.opsForHash().values(Product.OBJECT_KEY) ){
            products.add((Product) user);
        }
        return products;
    }


}
