package com.ejbexample5.entity;

import com.ejbexample5.entity.redis.DomainObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 26.08.2014.
 */


public class Product implements DomainObject {

    public static final String OBJECT_KEY = "PRODUCT";
    private static final String DEFAULF_STATUS = "OK";

    private String mpn;

    private String status = DEFAULF_STATUS;

    private int product_id;

    private List<Offer> offerList = new ArrayList<Offer>();



    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public String getMpn() {
        return mpn;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getKey() {
        return getMpn();
    }

    @Override
    public String getObjectKey() {
        return OBJECT_KEY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (product_id != product.product_id) return false;
        if (mpn != null ? !mpn.equals(product.mpn) : product.mpn != null) return false;
        if (offerList != null ? !offerList.equals(product.offerList) : product.offerList != null) return false;
        if (status != null ? !status.equals(product.status) : product.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mpn != null ? mpn.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + product_id;
        result = 31 * result + (offerList != null ? offerList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "mpn='" + mpn + '\'' +
                ", status='" + status + '\'' +
                ", product_id=" + product_id +
                ", offerList=" + offerList +
                '}';
    }
}
