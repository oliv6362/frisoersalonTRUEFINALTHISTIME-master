public class User {

    //Variables
    private int userId;
    private String fNavn;
    private String eNavn;
    private String adresse;
    private int postNr;
    private int telefonNr;
    private String eMail;
    private String password;
    private int isMedarbejder;

    //Usdr
    public User() {

    }

    public User(int userId, String fNavn, String eNavn, String adresse, int postNr, int telefonNr, String eMail, String password, int isMedarbejder){
        this.userId = userId;
        this.fNavn = fNavn;
        this.eNavn = eNavn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.telefonNr = telefonNr;
        this.eMail = eMail;
        this.password = password;
        this.isMedarbejder = isMedarbejder;
    }

    //Create user to database
    public User(String fNavn, String eNavn, String adresse, int postNr, int telefonNr, String eMail, String password, int isMedarbejder){
        this.fNavn = fNavn;
        this.eNavn = eNavn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.telefonNr = telefonNr;
        this.eMail = eMail;
        this.password = password;
        this.isMedarbejder = isMedarbejder;
    }

    //Password table
    public User(String eMail, String password) {
        this.eMail = eMail;
        this.password = password;
    }



    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getfNavn() {
        return fNavn;
    }
    public void setfNavn(String fNavn) {
        this.fNavn = fNavn;
    }

    public String geteNavn() {
        return eNavn;
    }
    public void seteNavn(String eNavn) {
        this.eNavn = eNavn;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPostNr() {
        return postNr;
    }
    public void setPostNr(int postNr) {
        this.postNr = postNr;
    }

    public int getTelefonNr() {
        return telefonNr;
    }
    public void setTelefonNr(int telefonNr) {
        this.telefonNr = telefonNr;
    }

    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsMedarbejder() {
        return isMedarbejder;
    }
    public void setIsMedarbejder(int isMedarbejder) {
        this.isMedarbejder = isMedarbejder;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fNavn='" + fNavn + '\'' +
                ", eNavn='" + eNavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postNr=" + postNr +
                ", telefonNr=" + telefonNr +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", medarbejder=" + isMedarbejder +
                '}';
    }
}