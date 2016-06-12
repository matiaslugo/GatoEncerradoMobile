package Servicios;

import java.util.ArrayList;

/**
 * Created by matielchino on 12/06/16.
 */
public class IniciarLaberinto {

    private String idLaberinto;
    private ArrayList<HabitacionMinimizada> habitaciones;
    private ArrayList<ItemDelInventarioMinimizado> inventario;

    public String getIdLaberinto() {
        return this.idLaberinto;
    }

    public void setIdLaberinto(String idLaberinto) {
        this.idLaberinto = idLaberinto;
    }

    public ArrayList<HabitacionMinimizada> getHabitaciones() {
        return this.habitaciones;
    }

    public void setHabitaciones(ArrayList<HabitacionMinimizada> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public ArrayList<ItemDelInventarioMinimizado> getInventario() {
        return this.inventario;
    }

    public void setInventario(ArrayList<ItemDelInventarioMinimizado> inventario) {
        this.inventario = inventario;
    }

}
