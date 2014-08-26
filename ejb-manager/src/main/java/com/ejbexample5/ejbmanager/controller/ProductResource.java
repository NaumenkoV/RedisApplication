package com.ejbexample5.ejbmanager.controller;

/**
 * Created by Вадим on 26.08.2014.
 */

import com.ejbexample5.ejbmanager.jsonUtil.JsonUtil;
import com.ejbexample5.ejbmanager.serivce.ProductService;
import com.ejbexample5.entity.Product;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/getprice")
public class ProductResource {

    @EJB
    ProductService productServiceImpl;

    @EJB
    private JsonUtil jsonUtilGsonImpl;

    @Produces("application/json")
    @GET
    public Response getProduct(@QueryParam("mpn") String mpn,
                               @DefaultValue("0") @QueryParam("availability") int availability,
                               @DefaultValue("0") @QueryParam("pricesort") int pricesort) {

        if (availability != 0 && availability != 1 && availability != 2)
            return Response.ok("Ooops) Error 400, wrong availability").build();

        if (pricesort != 0 && pricesort != 1 && pricesort != 2)
            return Response.ok("Ooops) Error 400, wrong pricesort").build();

        Product product = productServiceImpl.getProduct(mpn, availability, pricesort);
        if (product != null)
        return Response.ok(jsonUtilGsonImpl.toJson(product), MediaType.APPLICATION_JSON).build();
        else return Response.ok("Ooops) Error 400, wrong mpn").build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addProduct(String json) {
        Product product = jsonUtilGsonImpl.fromJson(json, Product.class);
        productServiceImpl.addProduct(product);
        return Response.ok(jsonUtilGsonImpl.toJson(product.getProduct_id()), MediaType.APPLICATION_JSON).build();
    }

}

