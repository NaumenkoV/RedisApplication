package com.ejbexample5.ejbmanager.controller;

/**
 * Created by Вадим on 26.08.2014.
 */
import com.ejbexample5.ejbmanager.jsonUtil.JsonUtil;
import com.ejbexample5.ejbmanager.serivce.ProductService;
import com.ejbexample5.entity.Product;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/get_products_list")
public class GetProductsList {

    @EJB
    ProductService productServiceImpl;

    @EJB
    private JsonUtil jsonUtilGsonImpl;

    @Produces("application/json")
    @GET
    public Response getProductsList() {

        List<Product> productsList2;
        productsList2 = productServiceImpl.getAllProducts();
        return Response.ok(jsonUtilGsonImpl.toJson(productsList2), MediaType.APPLICATION_JSON).build();
    }

}