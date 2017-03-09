package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Data Access Object for pizza orders. Here we use a MySQL database to
 * store the data.
 *
 * @author John Phillips
 */
public class DAOPizzaOrder {

    protected final static boolean DEBUG = true;

    public static void addOrder(PizzaOrder order) {
        final String QUERY = "insert into order_table (id, email, size, toppings, orderTime) VALUES (null, ?, ?, ?, now());";
        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(QUERY);) {
            stmt.setString(1, order.getEmail());
            stmt.setString(2, order.getSize());
            stmt.setString(3, order.getToppings());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPizzaOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<PizzaOrder> getOrderList() {
        final List<PizzaOrder> myList = new ArrayList();
        final String QUERY = "select id, email, size, toppings, orderTime from order_table order by orderTime desc;";
        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                myList.add(new PizzaOrder(rs.getInt("id"), rs.getString("email"), rs.getString("size"), rs.getString("toppings"), rs.getString("orderTime")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPizzaOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myList;
    }

    public static void main(String[] args) {
        System.out.println("List=" + getOrderList().toString());
    }
}
