package Servicios;

/**
 * Created by matielchino on 12/06/16.
 */
public class LaberintoMinimizado {

    private String idLaberinto;
    private String nombreLaberinto;
    private String path;

    public String getIdLaberinto() {
        return this.idLaberinto;
    }

    public void setIdLaberinto(final String idLaberinto) {
        this.idLaberinto = idLaberinto;
    }

    public String getNombreLaberinto() {
        return this.nombreLaberinto;
    }

    public void setNombreLaberinto(String nombreLaberinto) {
        this.nombreLaberinto = nombreLaberinto;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(final String path) {
        this.path = path;
    }
}
