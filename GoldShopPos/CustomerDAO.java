import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public int addCustomer(Customer customer) {

        String sql = "INSERT INTO CUSTOMER "
                   + "(CUSTOMER_ID, CUSTOMER_NAME, PHONE, ADDRESS) "
                   + "VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, new String[] {"CUSTOMER_ID"})) {

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAddress());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        customer.setCustomerId(id);
                        return id;
                    }
                }
            }
            return -1;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return -1;
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT CUSTOMER_ID, CUSTOMER_NAME, PHONE, ADDRESS "
                   + "FROM CUSTOMER ORDER BY CUSTOMER_ID";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("CUSTOMER_ID"),
                        rs.getString("CUSTOMER_NAME"),
                        rs.getString("PHONE"),
                        rs.getString("ADDRESS")));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving customers: " + e.getMessage());
        }
        return list;
    }

    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE CUSTOMER SET CUSTOMER_NAME = ?, PHONE = ?, ADDRESS = ? "
                   + "WHERE CUSTOMER_ID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAddress());
            ps.setInt(4, customer.getCustomerId());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println("Error updating customer: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCustomer(int customerId) {
        String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println("Error deleting customer: " + e.getMessage());
            return false;
        }
    }
}
