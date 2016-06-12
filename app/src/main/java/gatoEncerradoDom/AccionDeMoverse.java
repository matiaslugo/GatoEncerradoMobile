package gatoEncerradoDom;

/**
 * Created by matielchino on 10/06/16.
 */
public class AccionDeMoverse extends Accion {

    public AccionDeMoverse(final Habitacion habitacion) {
        super(habitacion);
        String nombreHabitacion = habitacion.getNombreHabitacion();
        String plus = ("Ir a habitacion - " + nombreHabitacion);
        this.setAccion(plus);
    }

    public AccionDeMoverse(final Integer id, final String nombre, final Habitacion habitacion) {
        super(id, nombre, habitacion);
        String _nombreHabitacion = habitacion.getNombreHabitacion();
        String _plus = ("Ir a habitacion - " + _nombreHabitacion);
        this.setAccion(_plus);
    }

    public AccionDeMoverse() {
    }

    public String ejecutar(final GatoEncerradoModel sistema, final Jugador jugador) {
        Habitacion habitacion = this.getHabitacion();
        sistema.setHabitacionActual(habitacion);
        Habitacion _habitacion_1 = this.getHabitacion();
        Integer _id = _habitacion_1.getId();
        String _string = _id.toString();
        return (("Se movio a la Habitacion" + " ") + _string);
    }
}


