public class Behandling {

    //TODO: metoder der opretter behandlinger med indtastet navn, pris og tid, til brug i bestillingController og Menu
    //TODO: SKAL SNAK MED BESTILLING


    //FIELD-----------V
    private int behandlingId;
    private String behandlingNavn;
    private int pris;
    private int tid;



    //CONSTRUCTOR-----------V
    public Behandling(String behandlingNavn, int pris, int tid) { //uden id
        this.behandlingNavn = behandlingNavn;
        this.pris = pris;
        this.tid = tid;
    }

    public Behandling(int behandlingId, String behandlingNavn, int pris, int tid) { //med id
        this.behandlingId = behandlingId;
        this.behandlingNavn = behandlingNavn;
        this.pris = pris;
        this.tid = tid;
    }

    public Behandling(int behandlingId) {
        this.behandlingId = behandlingId;
    }

    //METHODS------------V
    public int getBehandlingId() {return behandlingId;}

    public void setBehandlingId(int behandlingId) {
        this.behandlingId = behandlingId;
    }


    public String getBehandlingNavn() {
        return behandlingNavn;
    }

    public void setBehandlingNavn(String behandlingNavn) {
        this.behandlingNavn = behandlingNavn;
    }


    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}
