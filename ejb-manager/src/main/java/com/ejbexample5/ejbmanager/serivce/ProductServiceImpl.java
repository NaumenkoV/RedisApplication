package com.ejbexample5.ejbmanager.serivce;


import com.ejbexample5.ejbmanager.redis.ProductRepository;
import com.ejbexample5.ejbmanager.redis.Repository;
import com.ejbexample5.entity.Offer;
import com.ejbexample5.entity.Product;
import com.ejbexample5.entity.ProductAvailability;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ejb.Stateless;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Вадим on 22.08.2014.
 */

@Stateless
public class ProductServiceImpl implements ProductService {


//    @Autowired
//    Repository productRepository;

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    Repository productRepository = (ProductRepository) applicationContext.getBean("productRepository");

    public ProductServiceImpl() {
    }

    @Override
    public Product getProduct(String mpn, int availability, int pricesort) {

        Product product = (Product) productRepository.get(mpn);
        if (availability != 0 && product != null) sortByAvailability(product.getOfferList(), availability);
        if (pricesort != 0 && product != null) sortByPrice(product.getOfferList(), pricesort);
        return product;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.put(product);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.delete(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.put(product);
    }

    @Override
    public List<Product> getAllProducts() {
       return productRepository.getObjects();
    }

    @Override
    public void addAllProducts(List<Product> productList) {
        for (Product product : productList){
            addProduct(product);
        }
    }

    public void sortByAvailability(List<Offer> offerList, int availability){
       for (int i = 0; i < offerList.size(); i++){
           if (offerList.get(i).getProductAvailability().equals(ProductAvailability.NO)) offerList.remove(i);

               if(availability == 2 && offerList.get(i).getProductAvailability().equals(ProductAvailability.LITTLE))
                   offerList.remove(i);
       }
    }

    public void sortByPrice(List<Offer> offerList, int pricesort){
        Collections.sort(offerList, new Comparator<Offer>() {
            @Override
            public int compare(Offer offer1, Offer offer2) {
                return Double.compare(offer1.getPrice(), offer2.getPrice());
            }
        });

        if (pricesort == 2) Collections.reverse(offerList);
    }


}
