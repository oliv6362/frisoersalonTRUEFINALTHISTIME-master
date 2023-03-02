import java.util.Date;

public class Bestilling {
    /* vi skal bruge:
     * dato for behandling
     * klokkeslæt
     * hvornår aftalen er lavet
     * hvilken behandling
     * tid behandling tager
     * pris
     * status(f.eks. aflyst, afsluttet, bestilt etc.) v
     * */
    private int bestillingId;
    private int behandlingsType;
    private int kunde;
    private int medarbejder;

    private String datoFormat;
    private int status;

    public Bestilling() {

    }

    public Bestilling(int bestillingId, int behandlingsType, int kunde, int medarbejder, String datoFormat, int status) {
        this.bestillingId = bestillingId;
        this.behandlingsType = behandlingsType;
        this.kunde = kunde;
        this.medarbejder = medarbejder;
        this.datoFormat = datoFormat;
        this.status = status;
    }

    //oprettelse af en bestilling
    public Bestilling(int behandlingsType, int kunde, int medarbejder, String datoFormat, int status) {
        this.behandlingsType = behandlingsType;
        this.kunde = kunde;
        this.medarbejder = medarbejder;
        this.datoFormat = datoFormat;
        this.status = status;
    }

    public int getBestillingId() {
        return bestillingId;
    }

    public void setBestillingId(int bestillingId) {
        this.bestillingId = bestillingId;
    }
    public int getBehandlingsId() {
        return behandlingsType;
    }

    public int getBehandlingsType() {
        return behandlingsType;
    }
    public void setBehandlingsType(int behandlingsType) {
        this.behandlingsType = behandlingsType;
    }

    public int getKunde() {
        return kunde;
    }
    public void setKunde(int kunde) {
        this.kunde = kunde;
    }

    public int getMedarbejder() {
        return medarbejder;
    }
    public void setMedarbejder(int medarbejder) {
        this.medarbejder = medarbejder;
    }

    public String getDatoFormat() {
        return datoFormat;
    }
    public void setDatoFormat(String datoFormat) {
        this.datoFormat = datoFormat;
    }

    public int getStatusId() {
        return status;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bestilling{" +
                "bestillingId=" + bestillingId +
                ", behandlingsType=" + behandlingsType +
                ", kunde=" + kunde +
                ", medarbejder=" + medarbejder +
                ", datoFormat='" + datoFormat + '\'' +
                ", status=" + status +
                '}';
    }
}