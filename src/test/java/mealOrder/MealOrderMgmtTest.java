package mealOrder;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MealOrderMgmtTest {

    // addMealOrder tests
    @Test
    public void addMealOrderTestFunction1() {
        MealOrderMgmt mgmt = new MealOrderMgmt();

        mgmt.addMealOrder(new MealOrder(1));
        int before = mgmt.getOrderCount();

        mgmt.addMealOrder(new MealOrder(2));
        int after = mgmt.getOrderCount();

        assertEquals(before + 1, after);
    }

    @Test
    public void addMealOrderTestFunction2() {
        MealOrderMgmt mgmt = new MealOrderMgmt();

        mgmt.addMealOrder(new MealOrder(10));
        int before = mgmt.getOrderCount();

        mgmt.addMealOrder(null);
        int after = mgmt.getOrderCount();

        assertEquals(before, after);
    }

    // updateMealOrder tests

    @Test
    public void updateMealOrderTestFunction1() {
        MealOrderMgmt mgmt = new MealOrderMgmt();

        mgmt.addMealOrder(new MealOrder(1001));
        mgmt.addMealOrder(new MealOrder(1002));
        mgmt.addMealOrder(new MealOrder(1003));
        int before = mgmt.countNumberOf(OrderStatus.DELIVERED);
        mgmt.updateMealOrder(1003, OrderStatus.DELIVERED);
        int after = mgmt.countNumberOf(OrderStatus.DELIVERED);
        assertEquals(before + 1, after);
    }

    @Test
    public void updateMealOrderTestFunction2() {
        MealOrderMgmt mgmt = new MealOrderMgmt();

        mgmt.addMealOrder(new MealOrder(2001));

        int before = mgmt.countNumberOf(OrderStatus.DELIVERED);
        // update non-existing order
        mgmt.updateMealOrder(9999, OrderStatus.DELIVERED);
        int after = mgmt.countNumberOf(OrderStatus.DELIVERED);
        assertEquals(before, after); 
    }
}
