import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {

    public boolean addCustomer(Customer customer) {

        String sql = "INSERT INTO CUSTOMER "
                   + "(CUSTOMER_ID, CUSTOMER_NAME, PHONE, ADDRESS) "
                   + "VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAddress());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }
}