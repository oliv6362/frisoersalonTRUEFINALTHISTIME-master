import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserController {

    DBSQL db = new DBSQL();

    public User getUser(int Id) {
        try {
            User u = new User();

            String sql = "SELECT * FROM User where userId = '" + Id + "'" ;
            Statement stmt = db.connection.createStatement();
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

    //Adds en user til databasen
    public void addUser(User u) {
        try {
            String sql = "INSERT INTO User (fNavn,eNavn,adresse,postNr,telefonNr,eMail,password, isMedarbejder) VALUES('"
                    + String.valueOf(u.getfNavn()) + "','" + u.geteNavn() + "','";
            sql = sql + u.getAdresse() + "','" + u.getPostNr() + "','" + u.getTelefonNr() + "','" + u.geteMail() + "','" + u.getPassword() + "','" + u.getIsMedarbejder() + "')";

            Statement stmt = db.connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //til oprettelsen af en user
    public static User buildUser() { //TODO: er den testet?

        ErrorHandling errorHandling = new ErrorHandling();
        System.out.println("Indtast bruger:");

        System.out.println("fornavn");
        String userfNavn = errorHandling.readString("fornavn");

        System.out.println("efternavn");
        String usereNavn = errorHandling.readString("efternavn");

        System.out.println("adresse");
        String userAdresse = errorHandling.readString("adresse");

        System.out.println("postnummer");
        int userPostnr = errorHandling.readInteger("postnummer", 9999);

        System.out.println("telefonnummer");
        int userTelefonnr = errorHandling.readInteger("Tlf nummer", 999999999);

        System.out.println("email");
        String userEmail = errorHandling.readString("email addresse");

        System.out.println("Password");
        String userPassword = errorHandling.readString("gyldigt password");

        System.out.println("Tryk 1 for kunde, 2 for medarbejder");
        int boolMedarbejder = errorHandling.readInteger("1 eller 2", 3);

        User u = new User(userfNavn, usereNavn, userAdresse, userPostnr, userTelefonnr, userEmail, userPassword, boolMedarbejder);

        return u;
    }


}