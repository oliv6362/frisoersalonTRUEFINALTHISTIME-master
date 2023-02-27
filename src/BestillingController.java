//TODO:
//opretBestilling()
//getAllBestillinger()
//updateBestilling()
//deleteBestilling()
//setBestillingStatus

//import com.mysql.cj.xdevapi.SqlUpdateResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BestillingController {


    DBSQL db = new DBSQL();

    //TODO: BehandlingController og UserController brugt til print, skal lave ny printer class?
    static BehandlingController behandlingCon = new BehandlingController();
    static UserController usercon = new UserController();

    public void addBestilling(Bestilling b) {
        try {
            String sql = "INSERT INTO bestilling (behandlingsType,kunde,medarbejder,datoFormat,status) VALUES('"
                    + String.valueOf(b.getBehandlingsId()) + "','" + b.getKunde() + "','";
            sql = sql + b.getMedarbejder() + "','" + b.getDatoFormat() + "','" + b.getStatusId() + "')";

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


    public String getStatusName(int id) { // navngir status id
        if (id == 1) {
            return "Afventer";
        }
        if (id == 2) {
            return "Færdig";
        }
        if (id == 3) {
            return "Aflyst";
        }
        return null;
    }


    //sæt status af bestilling, hvor der spørges om bestilling ID og status ID, hvor DBSQL kaldes til at rette status i databasen
    public void setStatus(int id, int status) {     //TODO: brug setStatus i en menu

        try {

            String sql = "INSERT INTO Bestillinger WHERE bestillingId = '" + id + "'" + "VALUES'('" + status + "')";
            Statement stmt = db.connection.createStatement();
            stmt.execute(sql);
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }





    }
    public boolean isBestillingTimeFree(String dato, int behandlingId) {
        // metode henter alle Bestillinger med dato inden for behandlingens tidsrum og er false hvis en bestilling er fundet

        try {
            int behandlingTid = behandlingCon.getBehandling(behandlingId).getTid();

            String sql = "SELECT * FROM Bestilling " +
                    "WHERE datetime BETWEEN '" + dato + "' - INTERVAL " + behandlingTid + " MINUTE " + // tjek bestilling med dato 1 time før: - INTERVAL 60 MINUTE (burde vel eg
                    "AND '" + dato + "' + INTERVAL " + behandlingTid + " MINUTE"; // tjek bestilling med dato 1 time efter: + INTERVAL 60 MINUTE

            Statement stmt = db.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String reserveretBestillingDato = rs.getString("datoFormat");
            String reserveretBestillingBehandling = rs.getString("behandling");

            if (rs.next()){ //rs.next() er boolean der er true hvis der er flere bestillinger fundet
                System.out.print("Tid reserveret inden for 1 time:  " + reserveretBestillingBehandling + " - " + reserveretBestillingDato);
                return false;
            }
            return true;

        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }





    public Bestilling buildBestilling() {

        ErrorHandling errorHandling = new ErrorHandling();


        //medarbejder opretter en bestilling
        System.out.println("Behandlingstype");
        int behandlingsType = errorHandling.readInteger("BehandlingsType", 999999);

        System.out.println("KundeNr");
        int kunde = errorHandling.readInteger("kundeId", 999999);

        System.out.println("Medarbejder nr");
        int medarbejder = errorHandling.readInteger("MedarbejderId", 999999);


        //v---Dato Registrering---V
        //jeg taster dato, og hvis der er bestillinger fra basen med dato inden for 1 time af min dato,
        //gentages dato tast i loopet, indtil fri dato er tastet, og bestilling sendt til database

        String datoFormat;
        //definerer datoFormat uden for loop så det kan kaldes i if(!dato), do while kører alligevel altid mindst 1 gang

        do {

            System.out.println();
            System.out.println("Time på dagen: ");

            int hour = errorHandling.readIntegerExact("time på dagen", 1, 24, 2);

            System.out.println("Minut i timen: ");
            System.out.print(hour + ":");
            int minute = errorHandling.readIntegerExact("minut i timen", 0,59, 2);

            System.out.println("Dag på måneden:");
            System.out.print(hour + ":" + minute + " ");
            int day = errorHandling.readIntegerExact("dag på måneden", 1, 12, 2);

            System.out.println("Måned i året:");
            System.out.print(hour + ":" + minute + " " + day + "-");
            int month = errorHandling.readIntegerExact("måned i året", 1, 12, 2);

            System.out.println("År efter 2000");
            System.out.print(hour + ":" + minute + " " + day + "-");
            int decade = errorHandling.readIntegerExact("årti", 23, 99, 2);

            datoFormat = "20" + decade + "-" + month + "-" + day + " " + hour + ":" + minute + ":00";

        } while(!isBestillingTimeFree(datoFormat, behandlingsType));

        System.out.println("Bestilt til: " + datoFormat);

        Bestilling b = new Bestilling(behandlingsType, kunde, medarbejder, datoFormat, 1);
        //bestilling obj oprettet, default status: 1 for 'bestilt' når en bestilling først bliver lavet

        return b;


    }


    public String printBestilling(int id) { // jeg skriver en bestilling pænt TODO: printer class??



        int behandlingsId = getBestilling(id).getBehandlingsId();
        int medarbejderId = getBestilling(id).getMedarbejder();
        int kundeId = getBestilling(id).getKunde();
        int bestillingStatusId = getBestilling(id).getStatusId();

        int behandlingPris = behandlingCon.getBehandling(id).getPris();
        int behandlingTid = behandlingCon.getBehandling(id).getTid();
        int kundeTlf = usercon.getUser(kundeId).getTelefonNr();
        String bestillingStatus = behandlingCon.getBehandling(bestillingStatusId).getBehandlingNavn();


        String behandlingNavn = behandlingCon.getBehandling(id).getBehandlingNavn();
        String medarbejderNavn = usercon.getUser(medarbejderId).getfNavn() + " " + usercon.getUser(medarbejderId).geteNavn();
        String kundeNavn = usercon.getUser(kundeId).getfNavn() + " " + usercon.getUser(kundeId).geteNavn();
        String kundeEmail = usercon.getUser(kundeId).geteMail();
        String bestillingDato = getBestilling(id).getDatoFormat();

        return ("Behandling reserveret til : " + bestillingDato +
                "\n" + behandlingNavn + " - " + bestillingStatus + " - " + behandlingTid + " min. - " + behandlingPris +
                "kr.\nMedarbejder: " + medarbejderNavn +
                "\nKunde: " + kundeNavn + "\nTlf:" + kundeTlf + "\nEmail:" + kundeEmail);


        //Behandling reserveret til : 2023-02-26 12:30:00
        //Barbering - Bestilt - 40 min. - 300kr.
        //Medarbejder: Lau Breilev
        //Kunde: Oliver Olisen - 28204190 - oliver@gmail.com
    }

    public void printAllBestilling(){ //TODO: printer class??

        //getAllBestilling laver ArrayList af Bestilling obj læst fra basen
        ArrayList<Bestilling> bestillingList = (getAllBestilling());
        for (int i = 0; i < bestillingList.size(); i++) {
            //laver Bestilling obj fra ArrayListen
            Bestilling bestilling = bestillingList.get(i);
            //hvert obj findes behandling via Bestilling behandlingId så det også printes
            String behandlingNavn = behandlingCon.getBehandling(bestilling.getBehandlingsId()).getBehandlingNavn();
            int behandlingPris = behandlingCon.getBehandling(bestilling.getBestillingId()).getPris();
            int behandlingTid = behandlingCon.getBehandling(bestilling.getBestillingId()).getTid();
            String kundeNavn = usercon.getUser(bestilling.getKunde()).getfNavn() + " " + usercon.getUser(bestilling.getKunde()).geteNavn();


            System.out.println(
                    "behandling reserveret til : " + bestilling.getDatoFormat() +
                            "\n" + behandlingNavn + " - " + bestilling.getStatusId() + " - " + behandlingPris +
                            "kr.\nMedarbejder: " + bestilling.getMedarbejder() + "\nKunde: " + bestilling.getKunde() + "\n"

            );
        }

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