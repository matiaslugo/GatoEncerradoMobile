package gatoEncerradoDom;

import java.util.ArrayList;

/**
 * Created by matielchino on 12/06/16.
 */
public class Habitacion {

    private Integer id;

    private String nombreHabitacion;

    private Boolean esInicial = false;

    private Boolean esFinal = false;

    private ArrayList<Accion> listaAcciones = new ArrayList<Accion>();

    private String rutaImagen;

    public Habitacion(String nombre) {
        this.nombreHabitacion = nombre;
    }

    public Habitacion(String nombre,Integer idHab,String path) {
        this.nombreHabitacion = nombre;
        this.id = idHab;
        this.rutaImagen = path;
    }

    public Habitacion() {
    }

    public void setEsInicial() {
        this.esInicial = true;
    }

    public void setEsFinal() {
        this.esFinal = true;
    }

    public void agregarAccion(final Accion accion) {
        if ((accion instanceof AccionDeAgarrarUnElemento)) {
            Item item = ((AccionDeAgarrarUnElemento)accion).getItem();
            String nombre = item.getNombre();
            String descripcion = ("Elemento - " + nombre);
            ((AccionDeAgarrarUnElemento)accion).setAccion(descripcion);
        }
        this.listaAcciones.add(accion);
    }

    public Accion buscarAccion(Accion acc) {

        int i = 0;
        Accion accionRes = this.listaAcciones.get(0);
        while(i<this.listaAcciones.size()){
            if(this.listaAcciones.get(i).getNombreAccion()!= acc.getNombreAccion()){
                i++;
            }
            else{
                accionRes = this.listaAcciones.get(i);
            }
        };
        return accionRes;
    };

    public Accion buscarAccionPorId(final Integer idAccion) {

        int i = 0;
        Accion accionRes = this.listaAcciones.get(0);
        while(i<this.listaAcciones.size()){
            if(this.listaAcciones.get(i).getId()!= idAccion){
                i++;
            }
            else{
                accionRes = this.listaAcciones.get(i);
            }
        };
        return accionRes;
    };


    public String ejecutarAccion(Integer idAccion, GatoEncerradoModel sistema,Jugador jugador) {
        Accion accionAEjecutar = this.buscarAccionPorId(idAccion);
        String accionQueSeEjecuto = accionAEjecutar.ejecutar(sistema, jugador);
        this.eliminarAccion(accionAEjecutar);
        return accionQueSeEjecuto;
    }

    public void eliminarAccion(Accion accion) {
        this.listaAcciones.remove(accion);
    }

    public String ultimaAccionAgregada() {
        int size = this.listaAcciones.size();
        Accion get = this.listaAcciones.get(size-1);
        return get.getAccion();
    }

    public String tipo() {
        if ((this.esFinal).booleanValue()) {
            return "Es la Habitacion Final del Laberinto";
        } else {
            if ((this.esInicial).booleanValue()) {
                return "Es la Habitacion Incial del Laberinto";
            } else {
                return "Habitacion Comun";
            }
        }
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNombreHabitacion() {
        return this.nombreHabitacion;
    }

    public void setNombreHabitacion(final String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public Boolean getEsInicial() {
        return this.esInicial;
    }

    public void setEsInicial(final Boolean esInicial) {
        this.esInicial = esInicial;
    }

    public Boolean getEsFinal() {
        return this.esFinal;
    }

    public void setEsFinal(final Boolean esFinal) {
        this.esFinal = esFinal;
    }

    public ArrayList<Accion> getListaAcciones() {
        return this.listaAcciones;
    }

    public void setListaAcciones(ArrayList<Accion> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }


    public String getRutaImagen() {
        return this.rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}



