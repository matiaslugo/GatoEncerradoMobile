package gatoEncerradoDom;

/**
 * Created by matielchino on 12/06/16.
 */
public class Item {

    private Integer id;

    private String nombre;

    private String descripcion;

    private Accion accionPosible;

    public Item() {
    }

    public Item(Integer idItem,String nombreItem,String descripcionItem) {
        this.id = idItem;
        this.nombre = nombreItem;
        this.descripcion = descripcionItem;
    }

    public void ejecutarAccion() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Accion getAccionPosible() {
        return this.accionPosible;
    }

    public void setAccionPosible(Accion accionPosible) {
        this.accionPosible = accionPosible;
    }
}
