import java.util.ArrayList;

public class KvitteringPrinter {

    static BehandlingController behandlingCon = new BehandlingController();
    static UserController usercon = new UserController();
    static BestillingController bestillingCon = new BestillingController();
    static DBSQL db = new DBSQL();

/*
    public String printBestilling(int id) { // jeg skriver en bestilling pænt TODO: MenuController methods?

        Bestilling bestilling = bestillingCon.getBestilling(id);
        // bestillingController opretter Bestilling obj fra id

        Behandling behandling = behandlingCon.getBehandling(bestilling.getBehandlingsId());
        // behandlingController opretter Behandling obj fra Bestilling behandlingId

        User medarbejder = usercon.getUser(bestilling.getMedarbejder());
        User kunde = usercon.getUser(bestilling.getKunde());
        // userController opretter 2 User obj fra Bestilling fra medarbejder/kunde id


        String bestillingDato = bestilling.getDatoFormat();
        String bestillingStatus = bestillingCon.getStatusName(bestilling.getStatusId());
        //hentes af Bestilling obj

        String medarbejderNavn = medarbejder.getfNavn() + " " + medarbejder.geteNavn(); // fuldt navn
        String kundeNavn = kunde.getfNavn() + " " + kunde.geteNavn();
        String kundeEmail = kunde.geteMail();
        int kundeTlf = kunde.getTelefonNr();
        //hentes af User objs

        String behandlingNavn = behandling.getBehandlingsNavn();
        int behandlingPris = behandling.getBehandlingsPris();
        int behandlingTid = behandling.getBehandlingsTid();
        //hentes af Behandling obj

        return ("Behandling reserveret til : " + bestillingDato +
                "\n" + behandlingNavn + " - " + bestillingStatus + " - " + behandlingTid + " min. - " + behandlingPris +
                "kr.\nMedarbejder: " + medarbejderNavn +
                "\nKunde: " + kundeNavn + "\nTlf:" + kundeTlf + "\nEmail:" + kundeEmail);


        //Behandling reserveret til : 2023-02-26 12:30:00
        //Barbering - Bestilt - 40 min. - 300kr.
        //Medarbejder: Lau Breilev
        //Kunde: Oliver Olisen - 28204190 - oliver@gmail.com
    }

    public void printAllBestilling(){ //TODO: MenuController methods?

        ArrayList<Bestilling> bestillingList = (bestillingCon.getAllBestilling());
        //getAllBestilling laver ArrayList af Bestilling obj læst fra basen

        for (int i = 0; i < bestillingList.size(); i++) {
            Bestilling bestilling = bestillingList.get(i);
            //laver Bestilling obj fra ArrayListen

            printBestilling(bestilling.getBestillingId());
            //bruger printBestilling til at printe hvert Bestilling obj pænt
            System.out.println();
        }

    }
*/




    public String printBehandling(int id){
        Behandling behandling = db.getBehandling(id);
        return(
                "ID: " + behandling.getBehandlingsId() +
                        "\n" + behandling.getBehandlingsNavn() +
                        "\nTidsrum: " + behandling.getBehandlingsTid() + " min." +
                        "\nPris: " + behandling.getBehandlingsPris() + " kr.");
    }

    public void printAllBehandling(){ // læser behandlinger i basen, laver Behandling array, print behandling array
        ArrayList<Behandling> behandlingList = (db.getAllBehandling());
        System.out.println("Behandlinger:");
        for (int i = 0; i < behandlingList.size(); i++) {
            Behandling behandling = behandlingList.get(i);
            System.out.println(
                    "ID: " + behandling.getBehandlingsId() +
                            "\n" + behandling.getBehandlingsNavn() +
                            "\nTidsrum: " + behandling.getBehandlingsTid() + " min." +
                            "\nPris: " + behandling.getBehandlingsPris() + " kr."
            );
            System.out.println();

        }

    }



}
