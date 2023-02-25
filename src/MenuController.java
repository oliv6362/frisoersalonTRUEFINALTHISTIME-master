import java.util.ArrayList;

public class MenuController {
    //FIELD
    LoginController loginc = new LoginController();
    UserController usercon = new UserController();
    ErrorHandling errorHandling = new ErrorHandling();
    BestillingController bestillingcon = new BestillingController();


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
                        "7. Afslut \n" +
                        "Indtast dit valg");
        valg = errorHandling.readInteger("tal mellem 1 og 7", 8);
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
    public static void kundeMenu(){ //TODO: WIP
        System.out.println("kundemenu");


    }

    //Menuen for users som er registeret som medarbejdere
    public void medarbejderMenu(){ // TODO: WIP, ryd op
        System.out.println("Medarbejder menu");
        int valg;

        //opretter ui til scanner


        int userId;
        //fortæller brugeren deres valgmuligheder
        System.out.println(
                "1. Opret Bruger \n" +
                        "2. Opret Bestilling \n" +
                        "3. Opdater Bestilling \n" +
                        "4. Vis alle brugere \n" +
                        "5. Vis en bruger \n" +
                        "6. Vis alle bestllinger \n" +
                        "7. Vis en bestilling \n" +
                        "8. Log ud \n" +
                        "Indtast dit valg");
        valg = errorHandling.readInteger("tal mellem 1 og 8", 9);
        //Et switch statement, hvor at user kan vælge imellem de forskellige cases og hver case gør noget forskelligt
        switch (valg) {
            case 1:
                //medarbejder opretter en bruger og kalder userController klassen
                User u = usercon.buildUser();
                usercon.addUser(u);
                break;

            case 2:
                //Medarbejder opretter en bestilling og kalder bestillingscontroller
                Bestilling b = bestillingcon.buildBestilling();
                bestillingcon.addBestilling(b);
                break;

            case 3:
                //medarbejder opdatere/redigere en bestilling

                break;

            case 4:
                /*//printer alle users/brugere
                System.out.println("Vis alle brugere");
                userListe = db.getUser();
                for (int i = 0; i < userListe.size(); i++) {
                    System.out.println(userListe.get(i));
                }*/
                break;

            case 5:


                System.out.println("Indtast bruger ID");
                userId = errorHandling.readInteger("et gyldigt bruger ID", 9999999);

                User myUser = usercon.getUser(userId);

                System.out.println(myUser.toString());
                break;

            case 6:
         /*       //printer alle bestillinger
                System.out.println("Vis alle bestillinger");
                ArrayList<Bestilling> bestillingListe;
                bestillingListe = db.getAllBestilling();
                for (int i = 0; i < bestillingListe.size(); i++) {
                    System.out.println(bestillingListe.get(i));
                }
*/
                break;

            case 7:

                break;
            case 8:
                //user vælger af afslutte og programmet lukker
                System.out.println("Du er logget ud");
                //quit
                break;
        }
    }
}
