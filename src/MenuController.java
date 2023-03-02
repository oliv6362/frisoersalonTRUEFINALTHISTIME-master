import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {
    //FIELD
    LoginController loginc = new LoginController();
    UserController usercon = new UserController();
    ErrorHandling errorHandling = new ErrorHandling();
    BestillingController bestillingcon = new BestillingController();
    BehandlingController behandlingCon = new BehandlingController();

    KvitteringPrinter print = new KvitteringPrinter();



    //METHODS
    //Bliver kaldt fra main class og hvis login er succesful bliver man viderstillet til enten kunde menu eller medarbejder menu
    public void loginMenu() { //TODO: testet og funktionel
        int accessType;
        System.out.println("Indtast email og password");

        accessType = loginc.checkUser();
        if (accessType == 1) { kundeMenu(); }
        if (accessType == 2) { medarbejderMenu(); }
        if (accessType == 3) { mainMenu(); }
    }

    //mainMenu gør at hvis man har skrevet ens email eller pass forkert kan man enten vælge at prøve igen eller afslutte
    public void mainMenu() { // TODO: skriv manglende function + ryd op
        int valg;
        //fortæller brugeren deres valgmuligheder
        System.out.println(
                "1. Prøv igen \n" +
                        "2. Afslut \n" +
                        "Indtast dit valg");
        valg = errorHandling.readInteger("tal mellem 1 og 9", 10);
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
    public static void kundeMenu(){
        System.out.println("kundemenu");


    }

    //Menuen for users som er registeret som medarbejdere
    //TODO: bryd medarbejder menu op : bestilling menu / bruger menu / behandling menu
    public void medarbejderMenu() {
        System.out.println();
        System.out.println("Medarbejder menu:");
        int valg;

        //opretter ui til scanner

        DBSQL db = new DBSQL();

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
                        "10. Log ud \n" +
                        "Indtast dit valg");
        valg = errorHandling.readInteger("tal mellem 1 og 10", 11);
        //Et switch statement, hvor at user kan vælge imellem de forskellige cases og hver case gør noget forskelligt
        switch (valg) {
            case 1:
                //todo Medarbejder opretter en bestilling og kalder bestillingscontroller
                bestillingcon.addBestilling();

                this.input.endMenu();
                medarbejderMenu();
                break;

            case 2:
               // opdaterBestillingsMenu();





                System.out.println("Indtast bestillings ID");
                bestillingId = this.input.readInteger("et gyldigt bruger ID", 9999999);




                Bestilling myBestillingtest = db.getBestilling (bestillingId);




                //test for kun at ændre behandlingstypen
                System.out.println("Tast behandlings id");
               // int behandlingsType = input.readInteger("gyldig behandling id", 99999);


                Scanner scan = new Scanner(System.in);
                myBestillingtest.setBehandlingsType(scan.nextInt());

                //ret så den retunere en korrekt bestilling //todo rettebestilled not used?
                Bestilling rettedBestilling = db.redigerBestilling2(myBestillingtest);

                //todo send bestillingen ind til dbsql controlleren
                //todo send til fra db controller til dbsql, hvor i sender det ind på databasen
                //todo færdig







               // behandlingsType = bestillingcon.updateBestillingBehandling(myBestillingtest);
                //behandlingsType = bestillingcon.updateBestillingBehandling(bestillingId, behandlingsType, kunde, medarbejder, datoFormat, status);

              //  System.out.println(myBestillingtest.toString());



                //bestillingcon.testbestillingredigering();


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
                bestillingId = this.input.readInteger("et gyldigt bruger ID", 9999999);
                Bestilling myBestilling = db.getBestilling(bestillingId);
                System.out.println(myBestilling.toString());


                this.input.endMenu();
                medarbejderMenu();
                break;

            case 5:
                Behandling behandling = behandlingCon.buildBehandling();
                //buildBehandling opretter Behandling obj

                db.addBehandling(behandling);
                //addBehandling tilføjer Behandling obj til base
                System.out.println("Ny behandling tilføjet");
                //System.out.println(print.printBehandling(behandling.getBehandlingsId()));
                //printer behandling pænt til String

                medarbejderMenu();
                break;

            case 6:


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
                System.out.println("Indtast bruger ID");
                userId = errorHandling.readInteger("et gyldigt bruger ID", 9999999);
                User myUser = usercon.getUser(userId);
                System.out.println(myUser.toString());

                medarbejderMenu();
                break;
            case 10:


                    db.DeleteEntriesBasedOnAge();

                //user vælger af afslutte og programmet lukker
              //  System.out.println("Du er logget ud");
               // System.exit(0);
                //quit

                //medarbejderMenu();
                break;
        }
    }


    /*
    //TODO opdater/rediger en bestilling
    public void opdaterBestillingsMenu() {

        System.out.println("Redigerings menu af en bestilling:");
        int valg;


        int userId;
        int bestillingId;
        //fortæller brugeren deres valgmuligheder
        System.out.println(
                "1 Ret behandlingstype \n" +
                        "2 Ret kunde \n" +
                        "3. Ret Medarbejder \n" +
                        "4. Ret Dato og tid \n" +
                        "5. Ret Status\n" +
                        "6. Afslut \n" +
                        "Indtast dit valg");
        valg = input.readInteger("tal mellem 1 og 10", 11);
        //Et switch statement, hvor at user kan vælge imellem de forskellige cases og hver case gør noget forskelligt
        switch (valg) {
            case 1:

                //bestillingcon.updateBestillingBehandlingstype();
                System.out.println("Indtast Bestillings Id");
                int bestId = input.readInteger("", 999999999);

                print.printAllBehandling();

                System.out.println("Indtast ny Behandlings type");
                int nyBehandlType = input.readInteger("", 999999999);

                nyBehandlType = bestillingcon.updateBestillingBehandling(bestId, nyBehandlType,0,0,0);
              //  bestillingcon.updateBestilling(bestId, nyBehandlType, nyBehandlType, 0,  "2023-12-12", 0);

                System.out.println("Nye behandling er: " + behandlingCon.getBehandling(nyBehandlType).getBehandlingsNavn());

                this.input.endMenu();
                medarbejderMenu();
                break;

            case 2:
                System.out.println("Indtast Bestillings Id");
                bestId = input.readInteger("", 999999999);

                System.out.println("Indtast ny kunde");
                int nyKunde = input.readInteger("", 999999999);

            //    nyKunde = bestillingcon.updateBestillingKunde(bestId, nyKunde);

                System.out.println("Den nye kunde til bestillingen er: " + usercon.getUser(nyKunde).getfNavn());

                this.input.endMenu();
                medarbejderMenu();

                break;

            case 3:


                break;


            case 4:


                break;

            case 5:


                break;
            case 6:
            //tilbage til hovedmenu
                break;
            case 7:
            //afslut
                break;


        }
    }

     */
}