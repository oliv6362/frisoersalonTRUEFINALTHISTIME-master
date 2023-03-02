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
import java.util.Scanner;

public class BestillingController {


    DBSQL db = new DBSQL();

    //TODO: BehandlingController og UserController brugt til print, skal lave ny printer class?
    static BehandlingController behandlingCon = new BehandlingController();
    static UserController usercon = new UserController();


/*

    public Bestilling UpdategetBestilling(int Id) {
        try {
            Bestilling bestilling = new Bestilling();

            String sql = "SELECT * FROM Bestilling WHERE bestillingId = " + Id + ";";
            Statement stmt = db.connection.createStatement();
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

     //       sql = "UPDATE bestilling SET (behandlingsType,kunde,medarbejder,status) = '" + bestilling.getBehandlingsType() + ";";
       //     stmt.execute(sql);

            return bestilling;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
*/


/*
    public static Bestilling testbestillingredigering() {

        Scanner input = new Scanner(System.in);


        System.out.println("behandlingsType");
        int behandlingsType = input.nextInt();

        int kunde = testbestillingredigering().getKunde();

        int medarbejder =

        String datoFormat =

        int status =


        Bestilling b = new Bestilling(behandlingsType,kunde, medarbejder, datoFormat, status);

       // System.out.println(b);

        return b;
    }

*/

    /*
                  /*System.out.println("Indtast bestillings ID");
                bestillingId = this.input.readInteger("et gyldigt bruger ID", 9999999);
                Bestilling myBestilling = bestillingcon.getBestilling(bestillingId);
                System.out.println(myBestilling.toString());


                System.out.println("Indtast ny Behandlings type");

    int nyBehandlType = input.readInteger("", 999999999);

    nyBehandlType = bestillingcon.updateBestillingBehandling(bestillingId, nyBehandlType,0,0,0);
    //  bestillingcon.updateBestilling(bestId, nyBehandlType, nyBehandlType, 0,  "2023-12-12", 0);

                System.out.println("Nye behandling er: " + behandlingCon.getBehandling(nyBehandlType).getBehandlingsNavn());

*/
/*

//  synlig return_type Navn                     brug af parameter
    public Bestilling updateBestillingBehandling(Bestilling retBestilling) {
        int behandlingId = 0;
        try {

            String sql = "UPDATE bestilling SET (behandlingsType,kunde,medarbejder,datoFormat,status) = '" +
                    retBestilling.getBehandlingsType() +
                    nyKundeId +
                    nyMedarbejderId +
                    nyDatoFormat +
                    nyStatus + "'" +
                    "WHERE bestillingId = '" + bestillingId + "'" ;


            Statement stmt = db.connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT behandlingsType FROM Bestilling WHERE bestillingId = '" + bestillingId + "'";
            stmt.execute(sql);


            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                behandlingId = rs.getInt("behandlingsType");
                behandlingId = rs.getInt("kunde");
                behandlingId = rs.getInt("medarbejder");
                //behandlingId = rs.getString("datoFormat");
                behandlingId = rs.getInt("status");

            }


            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return retBestilling;
    }



    */


    /*public int updateBestillingBehandling(int bestillingId, int nyBehandlingsType, int nyKundeId, int nyMedarbejderId, String nyDatoFormat, int nyStatus) {
        int behandlingId = 0;
        try {


             String sql = "UPDATE bestilling SET (behandlingsType,kunde,medarbejder,datoFormat,status) = '" + nyBehandlingsType + nyKundeId + nyMedarbejderId + nyDatoFormat + nyStatus + "'" + "WHERE bestillingId = '" + bestillingId + "'" ;


            Statement stmt = db.connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT behandlingsType FROM Bestilling WHERE bestillingId = '" + bestillingId + "'";
            stmt.execute(sql);


            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                behandlingId = rs.getInt("behandlingsType");
                behandlingId = rs.getInt("kunde");
                behandlingId = rs.getInt("medarbejder");
                //behandlingId = rs.getString("datoFormat");
                behandlingId = rs.getInt("status");

            }


            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return behandlingId;
    }*/






           /* String sql = "UPDATE bestilling SET (behandlingsType,kunde,medarbejder,datoFormat,status) VALUES('"
                    + String.valueOf(b.getBehandlingsId()) + "','" + b.getKunde() + "','";
            sql = sql + b.getMedarbejder() + "','" + b.getDatoFormat() + "','" + b.getStatusId() + "')";
            */


    // public String updateBestilling(int bestillingsId, int nyBehandlingsType, int kunde, int medarbejder, String datoFormat, int status) {
    //behandlingstype  / kunde / medarbejder / datoformat/ status
    public void updateBestilling(int bestillingId, int nyBehandlingsType, int nyKundeId, int nyMedarbejderId, String nyDatoFormat, int nyStatus) {
        try {
            String sql = "UPDATE bestilling SET (behandlingsType,kunde,medarbejder,datoFormat,status) VALUES('"
                    + String.valueOf(bestillingId) + "','" + nyKundeId + "','";
            sql = sql + nyMedarbejderId + "','" + nyDatoFormat + "','" + nyStatus + "')";

            Statement stmt = db.connection.createStatement();
            stmt.execute(sql); // upd

            sql = "SELECT behandlingsType FROM Bestilling WHERE bestillingId = '" + bestillingId + "'";
            stmt.execute(sql);


            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                int behandlingId = rs.getInt("behandlingsType");
                int kundeId = rs.getInt("kunde");
                int medarbejderId = rs.getInt("medarbejder");
                String datoFormat = rs.getString("datoFormat");
                int status = rs.getInt("status");
                Bestilling bestilling = new Bestilling(bestillingId,behandlingId, kundeId,medarbejderId,datoFormat, status); //skal bestilling return til print??
                System.out.println("[TEST]bestilling er nu : \n" + bestilling);

            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
            System.out.println("\n\n\nFx: hh:mm dd:mm:yyyy");
            System.out.println("FX: 10 30 5 6 14");



            // YYYY-mm-dd hh:MM:ss | 2014-06-05 10:30:00 (base)
            // HH:mm dd-mm-YY | 10 30 5 6 6 (input)

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

        } while(!db.isBestillingTimeFree(datoFormat, behandlingsType));

        System.out.println("Bestilt til: " + datoFormat);

        Bestilling b = new Bestilling(behandlingsType, kunde, medarbejder, datoFormat, 1);
        //bestilling obj oprettet, default status: 1 for 'bestilt' når en bestilling først bliver lavet

        return b;


    }

    public void addBestilling()
    {
        Bestilling b = buildBestilling();
        db.addBestilling(b);
    }

    public void getBestilling()
    {

    }


    public void getAllBestilling(){

        //todo vis alle bestillinger

        ArrayList<Bestilling> bestillingListe;
        bestillingListe = db.getAllBestilling();
        for (int i = 0; i < bestillingListe.size(); i++)
        {
            System.out.println(bestillingListe.get(i));
        }
    }



    //TODO BRUGES
/*
    public void printAllBestilling(){ //TODO: lagt i print class

        //getAllBestilling laver ArrayList af Bestilling obj læst fra basen
        ArrayList<Bestilling> bestillingList = (getAllBestilling());
        for (int i = 0; i < bestillingList.size(); i++) {
            //laver Bestilling obj fra ArrayListen
            Bestilling bestilling = bestillingList.get(i);
            //hvert obj findes behandling via Bestilling behandlingId så det også printes
            String behandlingNavn = behandlingCon.getBehandling(bestilling.getBehandlingsId()).getBehandlingsNavn();
            int behandlingPris = behandlingCon.getBehandling(bestilling.getBestillingId()).getBehandlingsPris();
            int behandlingTid = behandlingCon.getBehandling(bestilling.getBestillingId()).getBehandlingsTid();
            String kundeNavn = usercon.getUser(bestilling.getKunde()).getfNavn() + " " + usercon.getUser(bestilling.getKunde()).geteNavn();


            System.out.println(
                    "behandling reserveret til : " + bestilling.getDatoFormat() +
                            "\n" + behandlingNavn + " - " + bestilling.getStatusId() + " - " + behandlingPris +
                            "kr.\nMedarbejder: " + bestilling.getMedarbejder() + "\nKunde: " + bestilling.getKunde() + "\n"

            );
        }

    }
    */
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