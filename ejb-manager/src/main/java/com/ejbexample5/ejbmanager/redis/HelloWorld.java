package com.ejbexample5.ejbmanager.redis;

/**
 * Created by Вадим on 24.08.2014.
 */


import com.ejbexample5.ejbmanager.jsonUtil.JsonUtil;
import com.ejbexample5.entity.Offer;
import com.ejbexample5.entity.Product;
import com.ejbexample5.entity.ProductAvailability;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloWorld {

//    @EJB
//    private JsonUtil jsonUtilGsonImpl;



    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        ProductRepository productRepository = (ProductRepository) applicationContext.getBean("companyRepository");

        JsonUtil jsonUtilGsonImpl = (JsonUtil) applicationContext.getBean("jsonUtil");

        List<Product> productList = new ArrayList<>();

        for (int i = 1; i < 21; i++) {
            Product product1 = new Product();
            product1.setProduct_id(i);
            product1.setMpn(String.valueOf(i));

            Offer offer1 = new Offer();
            offer1.setOffer_id(i);
            offer1.setPrice(i);
            offer1.setProductAvailability(ProductAvailability.ENOUGH);

            Offer offer2 = new Offer();
            offer2.setOffer_id(i + 40);
            offer2.setPrice(i + 1);
            offer2.setProductAvailability(ProductAvailability.NO);

            Offer offer3 = new Offer();
            offer3.setOffer_id(i + 80);
            offer3.setPrice(i + 2);
            offer3.setProductAvailability(ProductAvailability.LITTLE);

            List<Offer> offerList1 = new ArrayList<>();

            Collections.addAll(offerList1, offer1, offer2, offer3);

            product1.setOfferList(offerList1);

            productList.add(product1);
        }

        System.out.println(jsonUtilGsonImpl.toJson(productList));

    }
}
