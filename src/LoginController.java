public class LoginController {

    public int checkUser() { //boolean?
        DBSQL DB = new DBSQL();
        Login login = new Login();

        String userEmail = login.inputEmail();
        String userPassword = login.inputPassword();


        User hentetUser = DB.getUserPass(userEmail, userPassword);
        int accessType = 2;


        System.out.println(hentetUser.toString());



        if (userEmail.equals(hentetUser.geteMail()) && userPassword.equals(hentetUser.getPassword())) {
            System.out.print("Du er nu logget ind som: " );
            if (hentetUser.getIsMedarbejder() == 1) {
                System.out.println("kunde");
                accessType = 1;
            } else if (hentetUser.getIsMedarbejder() == 2) {
                System.out.println("medarbejder");
                accessType = 2;
            }

        } else {
            System.out.print("Email eller Password var ikke korrekt");
            accessType = 3;

        }
        return accessType;

    }


}



