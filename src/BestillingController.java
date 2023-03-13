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


public bass BestillingController {


    DBSQL db = new DBSQL();

    //TODO: BehandlingController og UserController brugt til print, skal lave ny printer bass?
    static BehandlingController behandlingCon = new BehandlingController();
    static UserController usercon = new UserController();



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

            //HELP

            // YYYY-mm-dd hh:MM:ss | 2014-06-05 10:30:00 (base)
            // HH:mm dd-mm-YY | 10 30 5 6 6 (input)

            System.out.println();
            System.out.println("Time på dagen: ");
            String hour = errorHandling.formatDateZero(errorHandling.readIntegerExact("time på dagen", 1, 24));

            System.out.println("Minut i timen: ");
            System.out.print(hour + ":");
            String minute = errorHandling.formatDateZero(errorHandling.readIntegerExact("minut i timen", 0,59));

            System.out.println("Dag på måneden:");
            System.out.print(hour + ":" + minute + " ");
            String day = errorHandling.formatDateZero(errorHandling.readIntegerExact("dag på måneden", 1, 12));

            System.out.println("Måned i året:");
            System.out.print(hour + ":" + minute + " " + day + "-");
            String month = errorHandling.formatDateZero(errorHandling.readIntegerExact("måned i året", 1, 12));

            System.out.println("År efter 2000");
            System.out.print(hour + ":" + minute + " " + day + "-");
            String decade = errorHandling.formatDateZero(errorHandling.readIntegerExact("årti efter 2010", 10, 99));

            datoFormat = "20" + decade + "-" + month + "-" + day + " " + hour + ":" + minute + ":00";
            System.out.println(datoFormat);


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

    public Bestilling getBestilling(int id)
    {
        Bestilling myBestilling = db.getBestilling(id);
        return myBestilling;
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
}
