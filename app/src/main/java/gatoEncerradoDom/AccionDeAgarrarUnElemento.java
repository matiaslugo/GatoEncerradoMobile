package gatoEncerradoDom;

/**
 * Created by matielchino on 10/06/16.
 */
public class AccionDeAgarrarUnElemento extends Accion {

    private Item item;

    public AccionDeAgarrarUnElemento(final Habitacion habitacion) {
        super(habitacion);
        Item item = new Item();
        this.item = item;
        String nombre = this.item.getNombre();
        String nombreAccion = ("Elemmbento - " + nombre);
        this.setAccion(nombreAccion);
    }

    public AccionDeAgarrarUnElemento(final Integer id, final String nombre, final Habitacion habitacion, final String nombItem) {
        super(id, nombre, habitacion);
        Item item = new Item();
        this.item = item;
        this.item.setNombre(nombItem);
        String _nombre = this.item.getNombre();
        String nombreAccion = ("Elemento - " + _nombre);
        this.setAccion(nombreAccion);
    }

    public AccionDeAgarrarUnElemento() {
    }

    public String ejecutar(final GatoEncerradoModel sistema, final Jugador jugador) {
        jugador.agregarItemAlInventario(this.item);
        String _nombre = this.item.getNombre();
        return (("Se agarro el elemento" + " ") + _nombre);
    }


    public Item getItem() {
        return this.item;
    }

    public void setItem(final Item item) {
        this.item = item;
    }
}


