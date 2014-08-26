package com.ejbexample5.ejbmanager.controller;

/**
 * Created by Вадим on 26.08.2014.
 */

import com.ejbexample5.ejbmanager.jsonUtil.JsonUtil;
import com.ejbexample5.ejbmanager.serivce.ProductService;
import com.ejbexample5.entity.Offer;
import com.ejbexample5.entity.Product;
import com.ejbexample5.entity.ProductAvailability;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/add_products_list")
public class AddProductsList {

    @EJB
    ProductService productServiceImpl;

    @EJB
    private JsonUtil jsonUtilGsonImpl;

    @Produces("application/json")
    @GET
    public Response getProductsList() {

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

        productServiceImpl.addAllProducts(productList);

        List<Product> productsList2;
        productsList2 = productServiceImpl.getAllProducts();
        return Response.ok(jsonUtilGsonImpl.toJson(productsList2), MediaType.APPLICATION_JSON).build();
    }

}

