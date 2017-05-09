package com.tw.wkh;

import com.tw.wkh.mappers.ProdOf;
import com.tw.wkh.mappers.ProdOfMapper;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProdOfMapperTest extends MapperTestBase {


    private ProdOfMapper prodOfMapper;

    @Before
    public void setUp() {
        super.setUp();
        prodOfMapper = getSqlSession().getMapper(ProdOfMapper.class);
    }


    @Test
    public void shouldFetchAProductById() {
        ProdOf product = someProduct().setProductName("arbitrary name");

        prodOfMapper.insertProdOf(product);
        ProdOf fetched = prodOfMapper.selectProdOf(product.getProductId());

        assertThat(fetched.getProductName(), is("arbitrary name"));
    }


    @Test
    public void shouldDeleteProductById() {
        ProdOf product = someProduct();
        prodOfMapper.insertProdOf(product);

        prodOfMapper.deleteProdOf(product.getProductId());
        ProdOf fetched = prodOfMapper.selectProdOf(product.getProductId());

        assertThat(fetched, is(nullValue()));
    }

    @Test
    public void shouldUpdateProduct() {
        ProdOf product = someProduct().setProductName("initial name");
        prodOfMapper.insertProdOf(product);

        product.setProductName("new updated name");
        prodOfMapper.updateProdOf(product);
        ProdOf fetched = prodOfMapper.selectProdOf(product.getProductId());

        assertThat(fetched.getProductName(), is("new updated name"));
    }



    private ProdOf someProduct() {
        return new ProdOf(10001, "Product Name Test", 200002);
    }


}
