package gatoEncerradoDom;

/**
 * Created by matielchino on 10/06/16.
 */
public class Accion {

    private Integer id;

    private String nombreAccion;

    private Habitacion habitacion;

    private String accion;

    public Accion(final Habitacion hab) {
        this.habitacion = hab;
    }

    public Accion(final Integer idAcc, final String nombre, final Habitacion hab) {
        this.id = idAcc;
        this.nombreAccion = nombre;
        this.habitacion = hab;
    }

    public Accion() {
    }

    public String ejecutar(final GatoEncerradoModel sistema, final Jugador jugador){
        return null;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }


    public String getNombreAccion() {
        return this.nombreAccion;
    }

    public void setNombreAccion(final String nombreAccion) {
        this.nombreAccion = nombreAccion;
    }


    public Habitacion getHabitacion() {
        return this.habitacion;
    }

    public void setHabitacion(final Habitacion habitacion) {
        this.habitacion = habitacion;
    }


    public String getAccion() {
        return this.accion;
    }

    public void setAccion(final String accion) {
        this.accion = accion;
    }
}


