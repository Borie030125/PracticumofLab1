package Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;

    @BeforeEach
    void setUp() {
        product = new Product("000001", "Pipeweed", "Long Bottom Leaf", 600.0);
    }

    @Test
    void toCSVDataRecord() {
        System.out.println("Testing toCSVDataRecord()");
        String expectedCSV = "000001,Pipeweed,Long Bottom Leaf,600.0";
        assertEquals(expectedCSV, product.toCSVDataRecord());
    }
}