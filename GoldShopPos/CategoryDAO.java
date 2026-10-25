import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public int addCategory(Category category) {
        String sql = "INSERT INTO CATEGORY (CATEGORY_ID, CATEGORY_NAME) "
                   + "VALUES (CATEGORY_SEQ.NEXTVAL, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, new String[] {"CATEGORY_ID"})) {

            ps.setString(1, category.getCategoryName());

            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        category.setCategoryId(id);
                        return id;
                    }
                }
            }
            return -1;
        } catch (SQLException e) {
            System.out.println("Error adding category: " + e.getMessage());
            return -1;
        }
    }

    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT CATEGORY_ID, CATEGORY_NAME FROM CATEGORY ORDER BY CATEGORY_ID";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Category(rs.getInt("CATEGORY_ID"),
                                      rs.getString("CATEGORY_NAME")));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving categories: " + e.getMessage());
        }
        return list;
    }

    public boolean updateCategory(Category category) {
        String sql = "UPDATE CATEGORY SET CATEGORY_NAME = ? WHERE CATEGORY_ID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getCategoryId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Error updating category: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCategory(int categoryId) {
        String sql = "DELETE FROM CATEGORY WHERE CATEGORY_ID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Error deleting category: " + e.getMessage());
            return false;
        }
    }
}
