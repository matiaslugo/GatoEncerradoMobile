package Servicios;

import java.util.ArrayList;

/**
 * Created by matielchino on 12/06/16.
 */
public class HabitacionMinimizada {

    private String idHabitacion;

    private ArrayList<AccionMinimizada> listAcciones;

    private String tipoDeHabitacion;

    private String path;

    public String getIdHabitacion() {
        return this.idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public ArrayList<AccionMinimizada> getListAcciones() {
        return this.listAcciones;
    }

    public void setListAcciones(ArrayList<AccionMinimizada> listAcciones) {
        this.listAcciones = listAcciones;
    }

    public String getTipoDeHabitacion() {
        return this.tipoDeHabitacion;
    }

    public void setTipoDeHabitacion(String tipoDeHabitacion) {
        this.tipoDeHabitacion = tipoDeHabitacion;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(final String path) {
        this.path = path;
    }
}


