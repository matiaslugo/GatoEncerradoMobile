package Servicios;

/**
 * Created by vhzanardi on 12/06/2016.
 */
public class DetalleLaberinto {

    private String nombreLaberinto;
    private String path;
    private String descripcion;

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

    public String getDescripcion() {return  this.descripcion;}

    public void setDescripcion(final String descrip){this.descripcion = descrip;}


}
