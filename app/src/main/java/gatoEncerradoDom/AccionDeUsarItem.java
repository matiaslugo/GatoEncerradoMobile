package gatoEncerradoDom;

/**
 * Created by matielchino on 10/06/16.
 */
public class AccionDeUsarItem extends Accion{

    private Item item;

    public AccionDeUsarItem(Habitacion habitacion) {
        super(habitacion);
    }

    public AccionDeUsarItem(Integer id, String nombre,Habitacion habitacion,String nombItem, Accion accionDelItem) {
        super(id, nombre, habitacion);
        Item item = new Item();
        this.item = item;
        this.item.setNombre(nombItem);
        String nombre1 = this.item.getNombre();
        String nombreAccion= ("Elemento - " + nombre1);
        this.setAccion(nombreAccion);
        this.item.setAccionPosible(accionDelItem);
    }

    public String ejecutar(GatoEncerradoModel sistema, Jugador jugador) {
        Accion accionPosible = this.item.getAccionPosible();
        return accionPosible.ejecutar(sistema, jugador);
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(final Item item) {
        this.item = item;
    }
}
