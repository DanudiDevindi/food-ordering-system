package repository;

import daoUtil.CrudUtil;
import dto.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Repository {
    public void saveCustomer(CustomerDTO o) throws Exception {
        CrudUtil.executeUpdate("INSERT INTO customer(name,address,tel)VALUES(?,?,?)", o.getName(), o.getAddress(), o.getTel());
    }

    public void saveOrder(OrderDTO o, int cid) throws Exception {
        CrudUtil.executeUpdate("INSERT INTO orders(date,qty,cid,typeId,cheffId,boyId,total)VALUES (CURRENT_DATE(),?,?,?,?,?,?)", o.getQty(), cid, 1, o.getCheffId(), o.getBoyId(), o.getQty() * 1000);

    }

    public ArrayList<OrderDTO> getAllOrders() throws SQLException, ClassNotFoundException {
        ArrayList<OrderDTO> orders = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM order");
        while (rst.next()) {
            orders.add(new OrderDTO(rst.getInt("oid"),rst.getInt("qty"),rst.getString("status"),rst.getInt("recpId"),rst.getInt("cheffId"),rst.getInt("boyId"),rst.getInt("typeId"),rst.getDouble("amount")));
        }
        return orders;
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> customers = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customer");
        while (rst.next()) {
            customers.add(new CustomerDTO(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));

        }
        return customers;
    }

    public ArrayList<ChefDTO> loadAllCheffs() throws SQLException, ClassNotFoundException {
        ArrayList<ChefDTO> chefDTOS = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM cheff");
        while (rst.next()) {
            chefDTOS.add(new ChefDTO(rst.getInt(1), rst.getString(2), rst.getString(3)));

        }
        return chefDTOS;
    }

    public ArrayList<ReceptionDTO> getAllReceptions() throws SQLException, ClassNotFoundException {
        ArrayList<ReceptionDTO> receptionDTOS = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM reception");
        while (rst.next()) {
            receptionDTOS.add(new ReceptionDTO(rst.getInt(1), rst.getString(2)));

        }
        return receptionDTOS;
    }

    public ArrayList<DelivaryDTO> loadAllDeliveryBoys() throws SQLException, ClassNotFoundException {
        ArrayList<DelivaryDTO> delivarys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM deliveryBoy");
        while (rst.next()) {
            delivarys.add(new DelivaryDTO(rst.getInt(1), rst.getString(2)));
        }
        return delivarys;
    }

    public ArrayList<PizzaTypeDTO> getAllPizzaTypes() throws SQLException, ClassNotFoundException {
        ArrayList<PizzaTypeDTO> pizzaTypes = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM pizzaTypes");
        while (rst.next()) {
            pizzaTypes.add(new PizzaTypeDTO(rst.getInt(1), rst.getString(2),rst.getDouble(3)));
        }
        return pizzaTypes;
    }
}


