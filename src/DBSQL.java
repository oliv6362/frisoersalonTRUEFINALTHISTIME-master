import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBSQL {

    public Connection connection;

    private Statement stmt;

    DBSQL() {
        connection = null;
        stmt = null;
        try {
            //String url = "jdbc:sqlite:C://Users/aikke/IdeaProjects/TrackAndTrace/TrackAndTraceDB.db";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hairsaloon", "root", "1234");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String formatDateTime(String dato, String klokkeslæt){ // String år String måned String dag??
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //DateTimeFormatter er et importeret Java library class som kan alt med dato og klokke
        String formattedDateTime = dato + klokkeslæt;
        formattedDateTime = formattedDateTime.trim();
        return null;
    }


    public User getUserPass(String eMail, String password) {
        try {
            User u = new User();

            //String sql = "SELECT * FROM User where password = '" + password + "'" + " AND WHERE eMail = '" + eMail + "'";
            String sql = "SELECT * FROM User WHERE eMail = '" + eMail + "' AND password = '" + password + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                u.setUserId(rs.getInt("userId"));       //ID
                u.setfNavn(rs.getString("fNavn"));      //fnavn
                u.seteNavn(rs.getString("eNavn"));      //enavn
                u.setAdresse(rs.getString("adresse"));  //adresse
                u.setPostNr(rs.getInt("postNr"));       //postnr
                u.setTelefonNr(rs.getInt("telefonNr"));
                u.seteMail(rs.getString("eMail"));
                u.setPassword(rs.getString("password"));
                u.setIsMedarbejder(rs.getInt("isMedarbejder"));
            }

            return u;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*

//todo se på dette i forbindelse med skat 5 år // 1820 dage er 5 år. proc 1 januar ?
public DeleteEntriesBasedOnAge {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/my_database";
        String user = "my_username";
        String password = "my_password";
        int ageInDays = 30;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(
                 "DELETE FROM my_table WHERE created_at < DATE_SUB(NOW(), INTERVAL 1820 DAY)")) {
            pstmt.setInt(1, ageInDays);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted + " rows deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/

}


