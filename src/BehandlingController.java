import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BehandlingController {

    DBSQL db = new DBSQL();
    static ErrorHandling err = new ErrorHandling();





    public void getBehandlinger(){}
    //jeg laver ArrayList af Behandling obj fra base


    public void deleteBehandling(){
        //jeg sletter behandling fra base
    }

    public Behandling buildBehandling() {
        System.out.print("\nNavn:   ");
        String behandlingsNavn = err.readString();

        System.out.println("\nBehandling tid i minutter:   ");
        int behandlingsTid = err.readInteger("cifre", 1000);

        System.out.print("\nPris:    ");
        int behandlingsPris = err.readInteger("cifre", 10000);

        Behandling behandling = new Behandling(behandlingsNavn, behandlingsPris, behandlingsTid);

        return behandling;
        //jeg taster navn, pris og tid og opretter Behandling obj
    }
}
