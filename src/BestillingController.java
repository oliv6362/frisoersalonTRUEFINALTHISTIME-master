//TODO:
//opretBestilling()
//getAllBestillinger()
//updateBestilling()
//deleteBestilling()
//setBestillingStatus

import com.mysql.cj.xdevapi.SqlUpdateResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BestillingController {

    DBSQL db = new DBSQL();

    public void addBestilling(Bestilling b) {
        try {
            String sql = "INSERT INTO bestilling (behandlingsType,kunde,medarbejder,datoFormat,status) VALUES('"
                    + String.valueOf(b.getBehandlingsType()) + "','" + b.getKunde() + "','";
            sql = sql + b.getMedarbejder() + "','" + b.getDatoFormat() + "','" + b.getStatus() + "')";

            Statement stmt = db.connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //find bestilling ud fra bestillingid og opretter instans af bestilling med attributes læst fra sql database
    public Bestilling getBestilling(int id) {
        try {
            String sql = "SELECT * FROM Bestilling WHERE bestillingId = " + id + ";";

            Statement stmt = db.connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            return new Bestilling(
                    rs.getInt("bestillingId"),
                    rs.getInt("behandlingsType"),
                    rs.getInt("kunde"),
                    rs.getInt("medarbejder"),
                    rs.getString("datoFormat"),
                    rs.getInt("status"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Invalid Order ID");
        }
        return null;
    }

    //Henter alle bestillinger
    public ArrayList<Bestilling> getAllBestilling() {
        try {
            String sql = "SELECT * FROM Bestilling ";
            Statement stmt = db.connection.createStatement();
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


    //sæt status af bestilling, hvor der spørges om bestilling ID og status ID, hvor DBSQL kaldes til at rette status i databasen
    public void setStatus(int id, int status) {
        try {

            String sql = "INSERT INTO Bestillinger WHERE bestillingId = '" + id + "'" + "VALUES'('" + status + "')";
            Statement stmt = db.connection.createStatement();
            stmt.execute(sql);

            if (status == 1) {
                System.out.println("Bestilling er nu bestilt");
            }

            if (status == 2) {
                System.out.println("Bestilling er nu færdig");
            }

            if (status == 3) {
                System.out.println("Bestilling er nu afmeldt");
            }
            stmt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    //TOdo arbejd på mandag tjek dataformat in field list
    public static Bestilling buildBestilling() {

        ErrorHandling errorHandling = new ErrorHandling();

        //scanner for test
        Scanner input = new Scanner(System.in);


        System.out.println("Behandlingstype");
        //medarbejder opretter en bestilling
        int behandlingsType = errorHandling.readInteger("BehandlingsType", 999999);

        System.out.println("KundeNr");
        int kunde = errorHandling.readInteger("kundeId", 999999);

        System.out.println("Medarbejder nr");
        int medarbejder = errorHandling.readInteger("MedarbejderId", 999999);

        //int MedarbejderId = errorHandling.readInteger("MedarbejderId", 999999);
        System.out.println("Skriv time på dagen: ");
        int hour = errorHandling.readInteger("time på dagen", 100);
        System.out.println("Skriv minut i timen: ");
        System.out.print(hour + ":");
        int minute = errorHandling.readInteger("minut i timen", 61);
        System.out.println("Skriv dag på måneden:");
        System.out.print(hour + "-" + minute + " ");
        int day = errorHandling.readInteger("dag på måneden", 31);
        System.out.println("Skriv måned i året:");
        System.out.print(hour + ":" + minute + " " + day + "-");
        int month = errorHandling.readInteger("måned i året", 13);
        System.out.println("Skriv år efter 2000");
        System.out.print(hour + ":" + minute + " " + day + "-");
        int decade = errorHandling.readInteger("årti", 100);


        String datoFormat = "20" + decade + "-" + month + "-" + day + " " + hour + ":" + minute + ":00";
        System.out.println("Bestilt til: " + datoFormat);

        System.out.println("status afventer, gennemført, aflyst");
        int status = errorHandling.readInteger("MedarbejderId", 4);

        Bestilling b = new Bestilling(behandlingsType, kunde, medarbejder, datoFormat, status);

        return b;

    }
}
        /*String dateFormat = hour + ":" minute



       // System.out.println("Skriv en tid. Format hh:mm:ss");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date2 = null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + date, e);

        }
        System.out.println(date2);


        return null;
    }

//System.out.println("dato og tid");
//     int DatoTid = errorHandling.

//System.out.println("status");
//   int status = errorHandling.
/*

        System.out.println("Indtast bruger:");

        System.out.println("fornavn");
        String userfNavn = errorHandling.readString("fornavn");

        System.out.println("efternavn");
        String usereNavn = errorHandling.readString("efternavn");

        System.out.println("adresse");
        String userAdresse =         String userAdresse = errorHandling.readString("adresse");

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

        Bestilling b = new Bestilling(userfNavn, usereNavn, userAdresse, userPostnr, userTelefonnr, userEmail, userPassword, boolMedarbejder);

        return b;

    }*/

/*
    //medarbejder opretter en bestilling
    int Behandlingstype = errorHandling.readInteger("Hvilken type af behandling?",999999);

    //System.out.println("KundeNr");
    int kundeId = errorHandling.readInteger("Hvilken kunde?",999999);

    //System.out.println("Medarbejder nr");
    int MedarbejderId = errorHandling.readInteger("Hvilken medarbejder?",999999);

//System.out.println("dato og tid");
//     int DatoTid = errorHandling.

//System.out.println("status");
//   int status = errorHandling.
*/