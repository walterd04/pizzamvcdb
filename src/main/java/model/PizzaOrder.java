package model;

/**
 * A class that represents a single pizza order.
 *
 * @author John Phillips
 */
public class PizzaOrder {

    private int id;
    private String email;
    private String size;
    private String toppings;
    private String date;

    public PizzaOrder() {
        email = "";
        size = "";
        toppings = null;
        id = 0;
        date = "";
    }

    public PizzaOrder(int id, String email, String size, String toppings, String date) {
        this.email = email;
        this.size = size;
        this.toppings = toppings;
        this.id = id;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" + "email=" + email + ", size=" + size
                + ", toppings=" + toppings + '}';
    }
}
