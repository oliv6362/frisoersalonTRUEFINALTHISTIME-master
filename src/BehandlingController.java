import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BehandlingController {

    DBSQL db = new DBSQL();
    static ErrorHandling err = new ErrorHandling();


    public Behandling getBehandling(int id) { //jeg laver Behandling obj fra base
        try {
            Behandling b = new Behandling(id);
            String sql = "SELECT * FROM Behandling where behandlingId = '" + id + "'";
            Statement stmt = db.connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                b.setBehandlingId(rs.getInt("behandlingId"));       //ID
                b.setBehandlingNavn(rs.getString("navn"));      //fnavn
                b.setPris(rs.getInt("pris"));
                b.setTid(rs.getInt("tid"));
            }
            return b;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void addBehandling(Behandling b) { //jeg tilføjer behandling obj til base
        try {
            String sql = "INSERT INTO Behandling (behandlingNavn, behandlingPris, behandlingTid) VALUES('"
                    + b.getBehandlingNavn() + "','" + b.getPris() + "','" + b.getTid() + "')";

            Statement stmt = db.connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Behandling> getAllBehandling() {
        try {
            String sql = "SELECT * FROM Behandling ";
            Statement stmt = db.connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<Behandling> behandlingsListe = new ArrayList<>();
            while (rs.next()) {
                {
                    Behandling b = new Behandling(
                            rs.getInt("behandlingId"),
                            rs.getString("behandlingNavn"),
                            rs.getInt("behandlingPris"),
                            rs.getInt("behandlingTid"));
                    behandlingsListe.add(b);
                }
            }
            return behandlingsListe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void getBehandlinger(){}
    //jeg laver ArrayList af Behandling obj fra base


    public void deleteBehandling(){
        //jeg sletter behandling fra base
    }

    public Behandling buildBehandling() {
        System.out.print("\nNavn:   ");
        String behandlingNavn = err.readString();

        System.out.println("\nBehandling tid i minutter:   ");
        int behandlingTid = err.readInteger("cifre", 1000);

        System.out.print("\nPris:    ");
        int behandlingPris = err.readInteger("cifre", 10000);

        Behandling behandling = new Behandling(behandlingNavn, behandlingPris, behandlingTid);

        return behandling;
        //jeg taster navn, pris og tid og opretter Behandling obj
    }
}
