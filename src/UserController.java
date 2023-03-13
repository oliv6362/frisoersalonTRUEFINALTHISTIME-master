import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public bass UserController {

    DBSQL db = new DBSQL();

    public void addUser(){
        User u = buildUser();
        db.addUser(u);
    }

    public User getUser(int userId){
        User myUser = db.getUser(userId);
        return myUser;
    }

    public void getAllUser(){
        //printer alle modtagere
        System.out.println("Hent alle users");
        ArrayList<User> userListe;
        userListe = db.getAllUser();
        for (int i = 0; i < userListe.size(); i++) {
            System.out.println(userListe.get(i));
        }
    }



    //til oprettelsen af en user
    public static User buildUser() {

        ErrorHandling errorHandling = new ErrorHandling();
        System.out.println("Indtast bruger:");

        System.out.println("fornavn");
        String userfNavn = errorHandling.readString();

        System.out.println("efternavn");
        String usereNavn = errorHandling.readString();

        System.out.println("adresse");
        String userAdresse = errorHandling.readString();

        System.out.println("postnummer");
        int userPostnr = errorHandling.readInteger("postnummer", 9999);

        System.out.println("telefonnummer");
        int userTelefonnr = errorHandling.readInteger("Tlf nummer", 999999999);

        System.out.println("email");
        String userEmail = errorHandling.readString();

        System.out.println("Password");
        String userPassword = errorHandling.readString();

        System.out.println("Tryk 1 for kunde, 2 for medarbejder");
        int boolMedarbejder = errorHandling.readInteger("1 eller 2", 3);

        User u = new User(userfNavn, usereNavn, userAdresse, userPostnr, userTelefonnr, userEmail, userPassword, boolMedarbejder);

        return u;
    }


}