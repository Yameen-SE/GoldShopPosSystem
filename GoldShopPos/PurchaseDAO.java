import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseDAO {

    // Purchase insert karta hai, generated purchaseId return karta hai.
    // Connection bahar se aata hai (con) taake Service class transaction
    // (purchase + stock update) ek saath commit/rollback kar sake.
    public int insert(Connection con, Purchase purchase) throws SQLException {

        String sql = "INSERT INTO purchase "
                   + "(item_id, purchase_date, supplier_name, quantity, cost) "
                   + "VALUES (?, ?, ?, ?, ?)";

        // Oracle mein generated key lene ke liye column name dena parta hai
        try (PreparedStatement ps = con.prepareStatement(sql, new String[] { "PURCHASE_ID" })) {

            ps.setInt(1, purchase.getItemId());
            ps.setDate(2, new java.sql.Date(purchase.getPurchaseDate().getTime()));
            ps.setString(3, purchase.getSupplierName());
            ps.setInt(4, purchase.getQuantity());
            ps.setDouble(5, purchase.getCost());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }
}
