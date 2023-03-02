

public class Menu {
    //FIELD
    LoginController loginc = new LoginController();
    UserController usercon = new UserController();
    ErrorHandling input = new ErrorHandling();
    BestillingController bestillingcon = new BestillingController();
    BehandlingController behandlingCon = new BehandlingController();
    KvitteringPrinter print = new KvitteringPrinter();



    //METHODS
    //Bliver kaldt fra main class og hvis login er succesful bliver man viderstillet til enten kunde menu eller medarbejder menu
    public void loginMenu() { //TODO: testet og funktionel
        int accessType;
        System.out.println("Indtast email og password");
        System.out.println("Tast 0 for at afslutte programmet");

        accessType = loginc.checkUser();
        if (accessType == 1) {
            kundeMenu();
        }
        if (accessType == 2) {
            medarbejderMenu();
        }
        if (accessType == 3) {
            mainMenu();
        }
    }

    //mainMenu gør at hvis man har skrevet ens email eller pass forkert kan man enten vælge at prøve igen eller afslutte
    public void mainMenu() { // TODO: skriv manglende function + ryd op
        int valg;
        //fortæller brugeren deres valgmuligheder
        System.out.println(
                "1. Prøv igen \n" +
                        "2. Afslut \n" +
                        "Indtast dit valg");
        valg = input.readInteger("tal mellem 1 og 9", 10);
        //Et switch statement, hvor at user kan vælge imellem de forskellige cases og hver case gør noget forskelligt
        switch (valg) {
            case 1:
                loginMenu();
                break;

            case 2:
                System.exit(0);
                break;
        }
    }

    //Menuen for users som er registeret som kunder
    public static void kundeMenu() {
        System.out.println("kundemenu");


    }

    //Menuen for users som er registeret som medarbejdere
    //TODO: bryd medarbejder menu op : bestilling menu / bruger menu / behandling menu
    public void medarbejderMenu() {
        System.out.println();
        System.out.println("Medarbejder menu:");
        int valg;

        int userId;
        int bestillingId;
        //fortæller brugeren deres valgmuligheder
        System.out.println(
                "1 Opret Bestilling \n" +
                        "2 Rediger en Bestilling \n" +
                        "3. Vis alle bestillinger \n" +
                        "4. Vis en bestilling \n" +
                        "\n" +
                        "5. Opret ny hårbehandling\n" +
                        "6. Se alle hbehandlings typer\n" +
                        "\n" +
                        "7. Opret Bruger \n" +
                        "8. Vis alle brugere \n" +
                        "9. Vis en bruger \n" +
                        "\n" +
                        "10. Log ud og afslut \n" +
                        "Indtast dit valg");
        valg = input.readInteger("tal mellem 1 og 10", 11);
        //Et switch statement, hvor at user kan vælge imellem de forskellige cases og hver case gør noget forskelligt
        switch (valg) {
            case 1:
                //todo Medarbejder opretter en bestilling og kalder bestillingscontroller
                System.out.println("Viser alle bestillinger");
                bestillingcon.addBestilling();

                this.input.endMenu();
                medarbejderMenu();
                break;

            case 2:
                redigerBestillingsMenu();

               /* System.out.println("Indtast bestillings ID");
                bestillingId = this.input.readInteger("et gyldigt bruger ID", 9999999);

                Bestilling myBestillingtest = db.getBestilling (bestillingId);

                //todo test for kun at ændre behandlingstypen
                System.out.println("Tast behandlings id");
               // int behandlingsType = input.readInteger("gyldig behandling id", 99999);

                Scanner scan = new Scanner(System.in);
                myBestillingtest.setBehandlingsType(scan.nextInt());

                //ret så den retunere en korrekt bestilling //todo rettebestilled not used?
                Bestilling rettedBestilling = db.redigerBestilling(myBestillingtest);

                //todo send bestillingen ind til dbsql controlleren
                //todo send til fra db controller til dbsql, hvor i sender det ind på databasen
                //todo færdig
*/
                break;

            case 3:
                //todo vis alle bestillinger
                System.out.println("Viser alle users");
                bestillingcon.getAllBestilling();

                this.input.endMenu();
                medarbejderMenu();
                break;

            case 4:
                //todo vis en bestilling -
                System.out.println("Vis en bestilling:");
                System.out.println("Indtast bestillings ID");

                bestillingId = this.input.readInteger("et gyldigt bestilling ID", 9999999);

                bestillingcon.getBestilling(bestillingId);
                System.out.println(bestillingcon.getBestilling(bestillingId));

                this.input.endMenu();
                medarbejderMenu();
                break;

            case 5:
                //TODO opret hårbehandling
                Behandling behandling = behandlingCon.buildBehandling();
                //buildBehandling opretter Behandling obj

         //       db.addBehandling(behandling);
                //addBehandling tilføjer Behandling obj til base
                System.out.println("Ny behandling tilføjet");
                //System.out.println(print.printBehandling(behandling.getBehandlingsId()));
                //printer behandling pænt til String

                this.input.endMenu();
                medarbejderMenu();
                break;

            case 6:
                System.out.println("Viser alle behandlinger");
                behandlingCon.getAllBehandlinger();

                this.input.endMenu();
                medarbejderMenu();
                break;

            case 7:
                //todo medarbejder opretter en bruger og kalder userController klassen
                usercon.addUser();

                this.input.endMenu();
                medarbejderMenu();
                break;

            case 8:
                //todo vis alle brugere
                usercon.getAllUser();

                this.input.endMenu();
                medarbejderMenu();
                break;

            case 9:
                //todo vis en bruger
                System.out.println("Vis en bruger:");
                System.out.println("Indtast bruger ID");

                userId = this.input.readInteger("et gyldigt bruger ID", 9999999);

                usercon.getUser(userId);

                System.out.println(usercon.getUser(userId));

                this.input.endMenu();
                medarbejderMenu();
                break;
            case 10:
                System.out.println("Du er logget ud");
                System.exit(0);
                //quit

                break;
        }
    }



    //TODO opdater/rediger en bestilling
    public void redigerBestillingsMenu() {

        System.out.println("Redigerings menu af en bestilling:");
        int valg;

        //todo dbsql connection skal slettes
        DBSQL db = new DBSQL();

        int userId;
        int bestillingId;
        //fortæller brugeren deres valgmuligheder
        System.out.println(
                "1 Ret behandlingstype \n" +
                        "2 Ret kunde \n" +
                        "3. Ret Medarbejder \n" +
                        "4. Ret Status\n" +
                        "5. Log ud og Afslut \n" +
                        "Indtast dit valg");
        valg = input.readInteger("tal mellem 1 og 10", 11);
        //Et switch statement, hvor at user kan vælge imellem de forskellige cases og hver case gør noget forskelligt
        switch (valg) {
            case 1:
                //ret Behandlingstype
                System.out.println("Indtast bestillings ID");
                int bId = input.readInteger("et gyldigt bestilling ID", 9999999);

                System.out.println("Indtast ny behandlingstype");

                int nyBehandlingstype = input.readInteger("et gyldigt bestilling ID", 9999999);

                nyBehandlingstype = db.redigerBehandlingsType(bId, nyBehandlingstype);
                System.out.println("Nye behandling er: " + db.getBehandling(nyBehandlingstype).getBehandlingsNavn());

                this.input.endMenu();
                redigerBestillingsMenu();
                break;

            case 2:
                //ret Kunde
                System.out.println("Indtast bestillings ID");
                bId = input.readInteger("et gyldigt kunde ID", 9999999);

                System.out.println("Indtast ny kunde id til bestillingen");

                int nyKundeId = input.readInteger("et gyldigt kunde ID", 9999999);

                nyKundeId= db.redigerKunde(bId, nyKundeId);
                System.out.println("Den nye kunde til bestillingen er: " + db.getUser(nyKundeId).getfNavn() + " " + db.getUser(nyKundeId).geteNavn());

                //TODO: bruger skal være kunde
                this.input.endMenu();
                redigerBestillingsMenu();
                break;

            case 3:
                //ret medarbejder
                System.out.println("Indtast bestillings ID");
                bId = input.readInteger("et gyldigt user ID", 9999999);

                System.out.println("Indtast ny medarbejder id til besetillingen");

                int nyMedarbejder = input.readInteger("et gyldigt user ID", 9999999);

                nyMedarbejder = db.redigerMedarbedjer(bId, nyMedarbejder);
                System.out.println("Den nye medarbejder til bestillingen er: " + db.getUser(nyMedarbejder).getfNavn() + " " + db.getUser(nyMedarbejder).geteNavn());

                //TODO: bruger skal være medarbejder
                this.input.endMenu();
                redigerBestillingsMenu();
                break;

            case 4:
                //ret status
                System.out.println("Indtast bestillings ID");
                bId = input.readInteger("et gyldigt user ID", 9999999);

                System.out.println("Indtast ny Status id til bestillingen");
                int nyStatusId = input.readInteger("1-3", 4);

                nyStatusId = db.redigerStatus(bId, nyStatusId);

                String status = bestillingcon.getStatusName(nyStatusId);
                System.out.println("Bestilling er nu: " + status);

                this.input.endMenu();
                redigerBestillingsMenu();
                break;
            case 5:
                mainMenu();
                break;
            case 6:
                System.out.println("Du er logget ud");
                System.exit(0);
                //quit
                break;


        }
    }
}