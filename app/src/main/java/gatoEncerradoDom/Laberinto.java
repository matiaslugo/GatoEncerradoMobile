package gatoEncerradoDom;

import java.util.ArrayList;

/**
 * Created by matielchino on 12/06/16.
 */
public class Laberinto {

    private Integer id;

    private String nombreLaberinto;

    private ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();

    private String rutaImagen;

    private String descripcion;

    public Laberinto(final String nombreLab, final Integer numeroLaberinto) {
        this.id = numeroLaberinto;
        this.nombreLaberinto = nombreLab;
        this.descripcion = id.toString() + "this.nombreLaberinto" + "this.rutaImagen";
    }

    public Laberinto(String nombreLab, Integer numeroLaberinto, String rutaDeLaImagen) {
        this.id = numeroLaberinto;
        this.nombreLaberinto = nombreLab;
        this.rutaImagen = rutaDeLaImagen;
        this.descripcion = id.toString() + "this.nombreLaberinto" + "this.rutaImagen";
    }

    public Laberinto(Integer idLab, String nombreLab, String path, String descrip) {
        this.id = idLab;
        this.nombreLaberinto = nombreLab;
        this.rutaImagen = path;
        this.descripcion = descrip;
    }

    public Laberinto() {
    }

    public void agregarHabitacion(Habitacion habitacionNueva) {
        this.listaHabitaciones.add(habitacionNueva);
    }

    public Habitacion buscarHabitacion(String nomHab) {


        int i = 0;
        Habitacion habitacion = this.listaHabitaciones.get(0);
        while(i<this.listaHabitaciones.size()){
            if(this.listaHabitaciones.get(i).getNombreHabitacion()!=nomHab){
                i++;
            }
            else{
                habitacion = this.listaHabitaciones.get(i);
            }
        }
        return habitacion;
    }

    public Habitacion buscarHabitacionPorId(final Integer idHab) {

        int i = 0;
        Habitacion habitacion = this.listaHabitaciones.get(0);
        while(i<this.listaHabitaciones.size()){
            if(this.listaHabitaciones.get(i).getId()!= idHab){
                i++;
            }
            else{
                habitacion = this.listaHabitaciones.get(i);
            }
        }
        return habitacion;
    }

    public boolean eliminarHabitacion(Habitacion habitacion) {
        return this.listaHabitaciones.remove(habitacion);
    }

    public boolean existeHabitacionFinal() {

        int i = 0;
        Boolean res = false;
        while(i<this.listaHabitaciones.size()){
            if(!this.listaHabitaciones.get(i).getEsFinal()){
                i++;
            }
            else{
                res = true;
            }
        }
        return res;
    }

    public void agregarAccionALaHabitacion(Integer idHab, Accion acc) {
        Habitacion _buscarHabitacionPorId = this.buscarHabitacionPorId(idHab);
        _buscarHabitacionPorId.agregarAccion(acc);
    }

    public void marcarHabitacionInicial(int numeroHabitacion) {
        Habitacion buscarHabitacionPorId = this.buscarHabitacionPorId(numeroHabitacion);
        buscarHabitacionPorId.setEsInicial();
    }

    public void marcarHabitacionFinal(final int numeroHabitacion) {
        Habitacion buscarHabitacionPorId = this.buscarHabitacionPorId(numeroHabitacion);
        buscarHabitacionPorId.setEsFinal();
    }

    public Habitacion habitacionInicial() {
        return this.buscarHabitacionPorId(1);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreLaberinto() {
        return this.nombreLaberinto;
    }

    public void setNombreLaberinto(String nombreLaberinto) {
        this.nombreLaberinto = nombreLaberinto;
    }

    public ArrayList<Habitacion> getListaHabitaciones() {
        return this.listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public String getRutaImagen() {
        return this.rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}


