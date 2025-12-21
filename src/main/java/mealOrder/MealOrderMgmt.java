package mealOrder;

import java.util.Vector;
import java.util.Iterator;

public class MealOrderMgmt {

    private Vector<MealOrder> orders = new Vector<MealOrder>();

    public void addMealOrder(MealOrder mo) {
        if (mo != null)
            this.orders.add(mo);
    }

    public void updateMealOrder(int oID, OrderStatus newStatus) {
        Iterator<MealOrder> iterator = this.orders.iterator();
        MealOrder theOrder = null;

        while (iterator.hasNext()) {
            MealOrder currentOrder = iterator.next();
            if (currentOrder.getOrderID() == oID) {
                theOrder = currentOrder;
                break;
            }
        }

        if (theOrder != null)
            theOrder.setStatus(newStatus);
    }

    public int countNumberOf(OrderStatus aStatus) {
        Iterator<MealOrder> iterator = this.orders.iterator();
        int count = 0;

        while (iterator.hasNext()) {
            if (iterator.next().getStatus() == aStatus)
                count++;
        }

        return count;
    }

    public int getOrderCount() {
        return this.orders.size();
    }
}
