public class Behandling {

    //TODO: metoder der opretter behandlinger med indtastet navn, pris og tid, til brug i bestillingController og Menu
    //TODO: SKAL SNAK MED BESTILLING


    //FIELD-----------V
    private int behandlingsId;
    private String behandlingsNavn;
    private int behandlingsPris;
    private int behandlingsTid;



    //CONSTRUCTOR-----------V
    public Behandling(String behandlingsNavn, int pris, int tid) { //uden id
        this.behandlingsNavn = behandlingsNavn;
        this.behandlingsPris = pris;
        this.behandlingsTid = tid;
    }

    public Behandling(int behandlingsId, String behandlingsNavn, int pris, int tid) { //med id
        this.behandlingsId = behandlingsId;
        this.behandlingsNavn = behandlingsNavn;
        this.behandlingsPris = pris;
        this.behandlingsTid = tid;
    }

    public Behandling() {

    }

    //METHODS------------V


    public int getBehandlingsId() {
        return behandlingsId;
    }

    public void setBehandlingsId(int behandlingsId) {
        this.behandlingsId = behandlingsId;
    }

    public String getBehandlingsNavn() {
        return behandlingsNavn;
    }

    public void setBehandlingsNavn(String behandlingsNavn) {
        this.behandlingsNavn = behandlingsNavn;
    }

    public int getBehandlingsTid() {
        return behandlingsTid;
    }

    public void setBehandlingsTid(int behandlingsTid) {
        this.behandlingsTid = behandlingsTid;
    }

    public int getBehandlingsPris() {
        return behandlingsPris;
    }

    public void setBehandlingsPris(int behandlingsPris) {
        this.behandlingsPris = behandlingsPris;
    }


    @Override
    public String toString() {
        return "Behandling{" +
                "behandlingsId=" + behandlingsId +
                ", behandlingsNavn='" + behandlingsNavn + '\'' +
                ", behandlingsPris=" + behandlingsPris +
                ", behandlingsTid=" + behandlingsTid +
                '}';
    }
}
