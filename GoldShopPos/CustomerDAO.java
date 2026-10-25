import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
