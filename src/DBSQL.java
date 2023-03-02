import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DBSQL {

    //todo skal nok slettes
    static BehandlingController behandlingCon = new BehandlingController();

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


    //TODO Bestilling
    public void addBestilling(Bestilling b) {
        try {
            String sql = "INSERT INTO bestilling (behandlingsType,kunde,medarbejder,datoFormat,status) VALUES('"
                    + String.valueOf(b.getBehandlingsId()) + "','" + b.getKunde() + "','";
            sql = sql + b.getMedarbejder() + "','" + b.getDatoFormat() + "','" + b.getStatus() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Bestilling getBestilling(int Id) {
        try {
            Bestilling bestilling = new Bestilling();

            String sql = "SELECT * FROM Bestilling WHERE bestillingId = " + Id + ";";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                bestilling.setBestillingId(rs.getInt("bestillingId"));       //ID
                bestilling.setBehandlingsType(rs.getInt("behandlingsType"));    //fnavn
                bestilling.setKunde(rs.getInt("kunde"));    //enavn
                bestilling.setMedarbejder(rs.getInt("medarbejder")); //adresse
                bestilling.setDatoFormat(rs.getString("datoFormat"));
                bestilling.setStatus(rs.getInt("status"));       //postnr
            }
            return bestilling;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Henter alle bestillinger
    public ArrayList<Bestilling> getAllBestilling() {
        try {
            String sql = "SELECT * FROM Bestilling ";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<Bestilling> bestillingListe = new ArrayList<>();
            while (rs.next()) {
                {
                    Bestilling b = new Bestilling(
                            rs.getInt("bestillingId"),
                            rs.getInt("behandlingsType"),
                            rs.getInt("kunde"),
                            rs.getInt("medarbejder"),
                            rs.getString("datoFormat"),
                            rs.getInt("status"));
                    bestillingListe.add(b);
                }
            }
            return bestillingListe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int redigerBehandlingsType(int bestillingsId, int nyBehandlingsType) {
         int bestillingId = 0;

        try {
            String sql = "UPDATE Bestilling SET behandlingsType = '" + nyBehandlingsType + "'" + "WHERE bestillingId = '" + bestillingsId + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT behandlingsType FROM Bestilling WHERE bestillingId = '" + bestillingsId + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                bestillingId = rs.getInt("behandlingsType");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bestillingId;
    }

    public int redigerKunde(int bestillingsId, int nyKunde) {
        int bestillingId = 0;

        try {
            String sql = "UPDATE Bestilling SET kunde = '" + nyKunde + "'" + "WHERE bestillingId = '" + bestillingsId + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT kunde FROM Bestilling WHERE bestillingId = '" + bestillingsId + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                bestillingId = rs.getInt("kunde");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bestillingId;
    }


    public int redigerMedarbedjer(int bestillingsId, int nyMedarbejder) {
        int bestillingId = 0;

        try {
            String sql = "UPDATE Bestilling SET medarbejder = '" + nyMedarbejder + "'" + "WHERE bestillingId = '" + bestillingsId + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT medarbejder FROM Bestilling WHERE bestillingId = '" + bestillingsId + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                bestillingId = rs.getInt("medarbejder");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bestillingId;
    }

    public String redigerDatoformat(int bestillingsId, String nyDatoFormat) {
        String bestillingId = "";

        try {
            String sql = "UPDATE Bestilling SET datoFormat = '" + nyDatoFormat + "'" + "WHERE bestillingId = '" + bestillingsId + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT datoFormat FROM Bestilling WHERE bestillingId = '" + bestillingsId + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                bestillingId = rs.getString("datoFormat");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bestillingId;
    }

    public int redigerStatus(int bestillingsId, int nyStatus) {
        int bestillingId = 0;

        try {
            String sql = "UPDATE Bestilling SET status = '" + nyStatus + "'" + "WHERE bestillingId = '" + bestillingsId + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT status FROM Bestilling WHERE bestillingId = '" + bestillingsId + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                bestillingId = rs.getInt("status");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bestillingId;
    }



    public void redigerBestillingColumn(int bestillingId, int pick, int updatedAtb){
        switch (pick) {
            case 1: // behandling
                break;
            case 2: //
                break;
            case 3:
                break;
        }


    }



    public Bestilling redigerBestilling(Bestilling retBestilling) {
        int behandlingId = retBestilling.getBehandlingsId();
        int behandlingsType = retBestilling.getBehandlingsType();


        try {
            System.out.println(retBestilling.getDatoFormat());
            String sql = "UPDATE bestilling SET (behandlingsType,kunde,medarbejder,datoFormat,status) ='" +
                    behandlingsType +
                    retBestilling.getKunde() +
                    retBestilling.getMedarbejder() +
                    retBestilling.getDatoFormat() +
                    retBestilling.getStatus() + "'" +
                    "where bestillingId = '" + behandlingId +"'";

          /*String sql = "UPDATE bestilling SET (behandlingsType,kunde,medarbejder,datoFormat,status) VALUES('"
                    + String.valueOf(retBestilling.getBehandlingsType()) + "','";
            sql = sql + retBestilling.getKunde() + "','" + retBestilling.getMedarbejder() + "','" + retBestilling.getDatoFormat() + "','" + retBestilling.getStatus() + "')";
*/

            Statement stmt = connection.createStatement();
            /*stmt.execute(sql);
            System.out.println("made it past 1st execute");
           sql = "SELECT behandlingsType FROM Bestilling WHERE bestillingId = '" + bestillingId + "'";*/
            stmt.execute(sql);
            System.out.println("made it past 1st execute");


            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
              /*  behandlingId = rs.getInt("behandlingsType");
                behandlingId = rs.getInt("kunde");
                behandlingId = rs.getInt("medarbejder");
                //behandlingId = rs.getString("datoFormat");
                behandlingId = rs.getInt("status");*/

            }


            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return retBestilling;
    }


    //sæt status af bestilling, hvor der spørges om bestilling ID og status ID, hvor DBSQL kaldes til at rette status i databasen





    public void setStatus(int id, int status) {

        try {

            String sql = "INSERT INTO Bestillinger WHERE bestillingId = '" + id + "'" + "VALUES'('" + status + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isBestillingTimeFree(String dato, int behandlingsId) {
        // metode henter alle Bestillinger med dato inden for behandlingens tidsrum og er false hvis en bestilling er fundet

        try {
            int behandlingTid = getBehandling(behandlingsId).getBehandlingsTid();  // time in minutes
            String sql = "SELECT * FROM bestilling " +
                    "WHERE datoFormat BETWEEN '" + dato + "' - INTERVAL " + behandlingTid + " MINUTE " + // tjek bestilling med dato 1 time før: - INTERVAL 60 MINUTE
                    "AND '" + dato + "' + INTERVAL " + behandlingTid + " MINUTE"; // + AND WHERE STATUS = 1 (afventer)

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //FIXED v
            if (rs.next()) { // check if any rows returned by the query
                String reserveretBestillingDato = String.valueOf(rs.getTimestamp("datoFormat"));
                int reserveretBestillingBehandlingId = rs.getInt("behandlingsType");

                String reserveretBestillingBehandling = getBehandling(reserveretBestillingBehandlingId).getBehandlingsNavn();
                System.out.println("\nTid allerede optaget:\n" + reserveretBestillingBehandling + " - " + behandlingTid + " minutters behandling\nReserveret den " + reserveretBestillingDato + "" );
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return true;
    }


    //TODO Behandling
    public Behandling getBehandling(int id) { //jeg laver Behandling obj fra base
        try {
            String sql = "SELECT * FROM Behandling where behandlingsId = '" + id + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            Behandling b = new Behandling();

            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                b.setBehandlingsId(rs.getInt("behandlingsId"));       //ID
                b.setBehandlingsNavn(rs.getString("behandlingsNavn"));      //fnavn
                b.setBehandlingsPris(rs.getInt("behandlingsPris"));
                b.setBehandlingsTid(rs.getInt("behandlingsTid"));
            }
            return b;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBehandling(Behandling b) { //jeg tilføjer behandling obj til base
        try {
            String sql = "INSERT INTO Behandling (behandlingsNavn, behandlingsPris, behandlingsTid) VALUES('"
                    + b.getBehandlingsNavn() + "','" + b.getBehandlingsPris() + "','" + b.getBehandlingsTid() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Behandling> getAllBehandling() {
        try {
            String sql = "SELECT * FROM Behandling ";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<Behandling> behandlingsListe = new ArrayList<>();
            while (rs.next()) {
                {
                    Behandling b = new Behandling(
                            rs.getInt("behandlingsId"),
                            rs.getString("behandlingsNavn"),
                            rs.getInt("behandlingsPris"),
                            rs.getInt("behandlingsTid"));
                    behandlingsListe.add(b);
                }
            }
            return behandlingsListe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    //TODO User
    public User getUser(int Id) {
        try {
            User u = new User();

            String sql = "SELECT * FROM User where userId = '" + Id + "'" ;
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

    public ArrayList<User> getAllUser() {
        try {
            String sql = "SELECT * FROM User ";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<User> userListe = new ArrayList<>();
            while (rs.next()) {
                {
                    User u = new User(
                            rs.getInt("userId"),      //ID
                            rs.getString("fNavn"),      //fnavn
                            rs.getString("eNavn"),      //enavn
                            rs.getString("adresse"), //adresse
                            rs.getInt("postNr"),     //postnr
                            rs.getInt("telefonNr"),
                            rs.getString("eMail"),
                            rs.getString("password"),
                            rs.getInt("isMedarbejder"));
                    userListe.add(u);
                }
            }
            return userListe;
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

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }







    //TODO Status









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

    //todo se på dette i forbindelse med skat 5 år // 1825 dage er 5 år. proc 1 januar ?
    public static void DeleteEntriesBasedOnAge() {

        String url = "jdbc:mysql://localhost:3306/hairsaloon";
        String user = "root";
        String password = "1234";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(
                     "DELETE FROM bestilling WHERE datoFormat <= NOW() - INTERVAL 5 YEAR")) {
            pstmt.execute();
            System.out.println("bestilling sletted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}