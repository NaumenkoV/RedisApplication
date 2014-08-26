package com.ejbexample5.entity;

import com.ejbexample5.entity.redis.DomainObject;

/**
 * Created by Вадим on 26.08.2014.
 */

public class Offer implements DomainObject {

    public static final String OBJECT_KEY = "ADDRESS";

    private int offer_id;

    private double price;

    private ProductAvailability productAvailability;

    @Override
    public String getKey() {
        return String.valueOf(getOffer_id());
    }

    @Override
    public String getObjectKey() {
        return OBJECT_KEY;
    }

    public Offer() {
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductAvailability getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(ProductAvailability productAvailability) {
        this.productAvailability = productAvailability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;

        Offer offer = (Offer) o;

        if (offer_id != offer.offer_id) return false;
        if (Double.compare(offer.price, price) != 0) return false;
        if (productAvailability != offer.productAvailability) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = offer_id;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (productAvailability != null ? productAvailability.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offer_id=" + offer_id +
                ", price=" + price +
                ", productAvailability=" + productAvailability +
                '}';
    }
}
