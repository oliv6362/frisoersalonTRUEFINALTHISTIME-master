public class Login {

    String email;
    String password;
    ErrorHandling scan = new ErrorHandling();

    //public static void main(String[] args) {
    //loginController loginController = new loginController();


    public String inputEmail(){
        System.out.println("Indtast email:");
        email = scan.readString("gyldig email");

        return email;
    }
    public String inputPassword(){
        System.out.println("Indtast password:");
        password = scan.readString("gyldig password");
        return password;
    }
}

//todo tager username/email, password, sender cred til controller, DB siger om det match database