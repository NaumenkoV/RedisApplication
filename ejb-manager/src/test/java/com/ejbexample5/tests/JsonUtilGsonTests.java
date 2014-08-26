package com.ejbexample5.tests;

/**
 * Created by Вадим on 26.08.2014.
 */

import com.ejbexample5.ejbmanager.jsonUtil.JsonUtil;
import com.ejbexample5.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@ContextConfiguration("classpath:spring-gson-test-config.xml")
public class JsonUtilGsonTests extends BaseTest {

    @Autowired
    private JsonUtil jsonUtil;

    @Test
    public void testJsonUtilFromJsonShouldRerurnValidObject() throws Exception {
        String expectedMpn = "1";
        Product product = jsonUtil.fromJson("{mpn: " + expectedMpn + "}", Product.class);
        assertEquals(expectedMpn, product.getMpn() );
    }

    @Test
    public void testJsonUtiltoJsonShouldRerurnValidJson() throws Exception {
        String expectedName = "1";
        Product product = new Product();
        product.setMpn("1");
        String actualJson = jsonUtil.toJson(product.getMpn());

        assertEquals("\"" + expectedName + "\"", actualJson);
    }

}
