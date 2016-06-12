package gatoEncerradoDom;

import java.util.ArrayList;

/**
 * Created by matielchino on 12/06/16.
 */
public class Jugador {

    private Integer idUsuario;

    private Inventario inventario = new Inventario(0);

    private ArrayList<String> laberintosJugados = new ArrayList<String>();

    public Jugador(Integer id) {
        this.idUsuario = id;
    }

    public void agregarItemAlInventario(Item item) {
        this.inventario.agregarItemDelInventario(item);
    }

    public boolean agarroItem(String nombreItem) {
        return this.inventario.estaElItem(nombreItem);
    }

    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public ArrayList<String> getLaberintosJugados() {
        return this.laberintosJugados;
    }

    public void setLaberintosJugados(ArrayList<String> laberintosJugados) {
        this.laberintosJugados = laberintosJugados;
    }
}

