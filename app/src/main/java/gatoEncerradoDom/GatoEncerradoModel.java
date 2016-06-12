package gatoEncerradoDom;

import java.util.ArrayList;

/**
 * Created by matielchino on 10/06/16.
 */
public class GatoEncerradoModel {

    private ArrayList<Laberinto> listaLaberintos;

    private ArrayList<Jugador> jugadores;

    private Laberinto laberintoActual;

    private Habitacion habitacionActual;

    private Jugador jugadorActual;

    public GatoEncerradoModel() {

        this.jugadores = new ArrayList<Jugador>();
        ArrayList<Laberinto> newArrayList_1 = new ArrayList<Laberinto>();
        this.listaLaberintos = new  ArrayList<Laberinto>();
        Jugador jugador = new Jugador(1);
        this.jugadores.add(jugador);
        this.jugadorActual = jugador;
        Laberinto laberinto1 = new Laberinto("La Cueva", 1);
        Laberinto laberinto2 = new Laberinto("La Mansion",2);
        Laberinto laberinto3 = new Laberinto("El Bosque ",3);
        this.listaLaberintos.add(laberinto1);
        this.listaLaberintos.add(laberinto2);
        this.listaLaberintos.add(laberinto3);
        this.laberintoActual = laberinto1;
        Habitacion habitacion1 = new Habitacion("Habitacion1", 1,"c/algo");
        Habitacion habitacion2 = new Habitacion("Habitacion2", 2,"c/algo");
        Habitacion habitacion3 = new Habitacion("Habitacion3", 3,"c/algo");
        this.laberintoActual.agregarHabitacion(habitacion1);
        this.laberintoActual.agregarHabitacion(habitacion2);
        this.laberintoActual.agregarHabitacion(habitacion3);
        this.laberintoActual.marcarHabitacionInicial(1);
        this.laberintoActual.marcarHabitacionFinal(3);
        this.habitacionActual = this.seleccionarHabitacion(this.laberintoActual);
        AccionDeMoverse accion = new AccionDeMoverse(5, "Accion de Moverse", habitacion3);
        AccionDeUsarItem accion1 = new AccionDeUsarItem(1,"Accion de Usar Item Cuchara", habitacion1, "Cuchara", accion);
        AccionDeMoverse accion2 = new AccionDeMoverse(2,"AccionDeMoverse", habitacion2);
        AccionDeAgarrarUnElemento accion3 = new AccionDeAgarrarUnElemento(3,"Accion de agarrar elemento", habitacion3, "Martillo");
        AccionDeMoverse accion4 = new AccionDeMoverse(4, "Accion de moverse", habitacion2);
        this.laberintoActual.agregarAccionALaHabitacion(1, accion1);
        this.laberintoActual.agregarAccionALaHabitacion(1, accion2);
        this.laberintoActual.agregarAccionALaHabitacion(1, accion3);
        this.laberintoActual.agregarAccionALaHabitacion(3, accion4);
        Item item = new Item(1, "Pala", "Esto es una pala para palear");
        this.agregarItemAlJugador(item);
    }

    public Habitacion seleccionarHabitacion(Laberinto laberinto) {
        return laberinto.habitacionInicial();
    }

    public void agregarItemAlJugador(Item item) {
        this.jugadorActual.agregarItemAlInventario(item);
    }

    /**
     * Crea un laberinto sin habitaciones y lo guarda en ListaLaberintos
     */
    public void crearLaberinto(String nomLab,Integer id) {


            Laberinto laberinto = new Laberinto(nomLab, id);
            this.agregarLaberinto(laberinto);
    }

    /**
     * Elimina una laberinto
     */
    public void eliminarLaberinto(String nomLab) {
        Laberinto buscarLaberinto = this.buscarLaberinto(nomLab);
        this.listaLaberintos.remove(buscarLaberinto);
    }

    public Laberinto buscarLaberinto(final String nomLab) {

            int i = 0;
            Laberinto laberinto = this.listaLaberintos.get(0);
            while(i<this.listaLaberintos.size()){
                    if(this.listaLaberintos.get(i).getNombreLaberinto() != nomLab){
                        i++;
                    }
                    else{
                        laberinto = this.listaLaberintos.get(i);
                    }
        }
        return laberinto;
    }

    public Laberinto laberintoPorId(Integer idLab) {

        int i = 0;
        Laberinto laberinto = this.listaLaberintos.get(0);
        while(i<this.listaLaberintos.size()){
            if(this.listaLaberintos.get(i).getId() != idLab){
                i++;
            }
            else{
                laberinto = this.listaLaberintos.get(i);
            }
        }
        return laberinto;
    }


    public boolean agregarLaberinto(Laberinto lab) {
        return this.listaLaberintos.add(lab);
    }

    /**
     * Agrega una habitacion al laberinto pasado por parametro
     */
    public void agregarHabitacionALaberinto(final String nomLab, final Habitacion hab) {
        Laberinto lab = this.buscarLaberinto(nomLab);
        lab.agregarHabitacion(hab);
    }

    public void agregarAccionAHabitacionDeLaberinto(final String nombLab, final String nomHab, final Accion acc) {
        Laberinto lab = this.buscarLaberinto(nombLab);
        Habitacion habitacion = lab.buscarHabitacion(nomHab);
        habitacion.agregarAccion(acc);
    }

    /**
     * Elimina una habitacion al laberinto pasado por parametro
     */
    public boolean eliminarHabitacionDelLaberinto(final Laberinto laberinto, final Habitacion habitacion) {
        return laberinto.eliminarHabitacion(habitacion);
    }

    /**
     * Elimina una accion de la habitacion pasada por parametro
     */
    public void eliminarAccionDeLaHabitacion(final Habitacion habitacion, final Accion accion) {
        habitacion.eliminarAccion(accion);
    }

    public ArrayList<String> nombresDeLaberintos() {

        int i = 0;
        ArrayList<String> nombres = new ArrayList<String>();
        while(i<this.listaLaberintos.size()){
            nombres.add(this.listaLaberintos.get(i).getNombreLaberinto());
        };
        return nombres;
    }

    public Boolean hayLaberintosConElMismoNombre(String nombreLab) {
        ArrayList<String> nombresDeLaberintos = this.nombresDeLaberintos();
        return nombresDeLaberintos.contains(nombreLab);
    }

    public Jugador buscarJugador(Integer idUsuario) {

        int i = 0;
        Jugador jugador = new Jugador(1);
        while (i < this.jugadores.size()) {
            if (this.jugadores.get(i).getIdUsuario() != idUsuario) {
                i++;
            } else {
                jugador = this.jugadores.get(i);
            }

        }
        return jugador;
    }

    public Laberinto seleccionarLaberinto(String nombreDeLaberinto) {
        Laberinto buscarLaberinto = this.buscarLaberinto(nombreDeLaberinto);
        return this.laberintoActual = buscarLaberinto;
    }


    public ArrayList<Laberinto> getListaLaberintos() {
        return this.listaLaberintos;
    }

    public void setListaLaberintos(ArrayList<Laberinto> listaLaberintos) {
        this.listaLaberintos = listaLaberintos;
    }


    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }


    public Laberinto getLaberintoActual() {
        return this.laberintoActual;
    }

    public void setLaberintoActual(Laberinto laberintoActual) {
        this.laberintoActual = laberintoActual;
    }


    public Habitacion getHabitacionActual() {
        return this.habitacionActual;
    }

    public void setHabitacionActual(Habitacion habitacionActual) {
        this.habitacionActual = habitacionActual;
    }


    public Jugador getJugadorActual() {
        return this.jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }
}
