import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private Instock instock;

    @Before
    public void setUp(){
        this.instock = new Instock();
    }

    @Test
    public void test_Count_Should_Be_Zero_When_InStock_Empty(){
        assertEquals(0, instock.getCount());
    }

    @Test
    public void test_Count_Should_Be_Five_When_InStock_HasFive_Products(){
        int productCount = 5;
        addProductsToStock(productCount);
        assertEquals(productCount, instock.getCount());

    }

    @Test
    public void test_Contains_Should_Be_True_Or_False_When_Product_Present_Or_Not(){
        Product product = addProductsToStock(5)[3];
        assertTrue(instock.contains(product));
        assertFalse(instock.contains(new Product("not_Present",1, 1)));
    }

    @Test
    public void testFindReturnsTheCorrectProduct(){
        Product expected = addProductsToStock(10)[4];
        Product actual = instock.find(4);
        assertNotNull(actual);
        assertEquals(expected.getLabel(),actual.getLabel());
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void testFindProductWithNegativeIndexThrowsException(){
        instock.find(-1);
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void testFindProductWithBiggerIndexThrowsException(){
        instock.find(instock.getCount());
    }

    @Test
    public void testChangeQuantityShouldUpdateTheProduct(){
        Product product= new Product("test",1, 10);
        instock.add(product);
        int expected = product.getQuantity()+ 5;
        instock.changeQuantity(product.getLabel(), expected);
        assertEquals(expected, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityWithFailsWhenNoProductWithThatLabel(){
        instock.changeQuantity("no-such-Product", 10);
    }

    @Test
    public void testFindByLabelShouldReturnCorrectProduct(){
        Product expected = addProductsToStock(10)[3];
        Product actual = instock.findByLabel(expected.getLabel());
        assertNotNull(actual);
        assertEquals(expected.getLabel(),actual.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindLabelWithFailsWhenNoProductWithThatLabel(){
        instock.findByLabel("no-such-Product");
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnTheCorrectProducts(){
        int productsToTake=10;

        List<Product> expectedProducts = Arrays.stream(addProductsToStock(20))
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(productsToTake)
                .collect(Collectors.toList());

        Iterable<Product> iterable = instock.findFirstMostExpensiveProducts(productsToTake);

        List<Product> actualProducts = assertIterableNotNullAndConvertToList(iterable);

        assertEquals(expectedProducts,actualProducts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldTrowWhenThereAreLessProducts(){
        addProductsToStock(10);
        instock.findFirstMostExpensiveProducts(11);
    }

    @Test
    public void testFindFirstProductAlphabetically(){
        int productsToTake=10;

        List<Product> expectedProducts = Arrays.stream(addProductsToStock(20))
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(productsToTake)
                .collect(Collectors.toList());

        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(productsToTake);

        List<Product> actualProducts = assertIterableNotNullAndConvertToList(iterable);

        assertEquals(expectedProducts,actualProducts);
    }

    @Test
    public void testFindProductAlphabeticallyThrowException(){
        int productsToTake = 10;

        List<Product> expectedProducts = new ArrayList<>();

        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(productsToTake);

        List<Product> actualProducts = assertIterableNotNullAndConvertToList(iterable);

        assertEquals(expectedProducts,actualProducts);
    }


    private List<Product> assertIterableNotNullAndConvertToList(Iterable<Product> iterable){
        assertNotNull(iterable);

        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);

        return products;
    }

    private Product[] addProductsToStock(int count){

        Product[] arr = new Product[count];

        for (int i = 1; i <=count ; i++) {
            Product product = new Product("Product_"+i, 10.00+i, i);
            instock.add(product);
            arr[i-1]= product;
        }
        return arr;
    }


}