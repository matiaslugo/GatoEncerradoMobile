package Servicios;

import java.util.ArrayList;

import gatoEncerradoDom.GatoEncerradoModel;
import gatoEncerradoDom.Inventario;
import gatoEncerradoDom.Item;
import gatoEncerradoDom.Laberinto;

/**
 * Created by matielchino on 12/06/16.
 */

public class Servicio {

    private ArrayList<Laberinto> listLaberinto;

    private Laberinto labActual;

    private Inventario inventario;

    public Servicio(ArrayList<Laberinto> listLab) {
        this.listLaberinto = listLab;
    }

    public Servicio(final Inventario inv){
        inventario = inv;
    }

    public Servicio(final Laberinto lab) {
        this.labActual = lab;
    }

    public Servicio(GatoEncerradoModel sistema){
        this.listLaberinto = sistema.getListaLaberintos();
        this.labActual = sistema.getLaberintoActual();
        this.inventario = sistema.getJugadorActual().getInventario();
    }

    public ArrayList<LaberintoMinimizado> listaDeLaberintosMinimizados() {
        ArrayList<LaberintoMinimizado> res = new ArrayList<LaberintoMinimizado>();
        for (Laberinto lab : this.listLaberinto) {
            {
                LaberintoMinimizado mini = new LaberintoMinimizado();
                Integer id = lab.getId();
                String string = id.toString();
                mini.setIdLaberinto(string);
                String nombreLaberinto = lab.getNombreLaberinto();
                mini.setNombreLaberinto(nombreLaberinto);
                String rutaImagen = lab.getRutaImagen();
                mini.setPath(rutaImagen);
                res.add(mini);
            }
        }
        return res;
    }

    public DetalleLaberinto detallesDelLaberinto(String nombreLab){
        DetalleLaberinto res = new DetalleLaberinto();
        res.setNombreLaberinto(this.getPorNombre(nombreLab).getNombreLaberinto());
        res.setPath(this.getPorNombre(nombreLab).getRutaImagen());
        res.setDescripcion(this.getPorNombre(nombreLab).getDescripcion());
        return res;

    }

    public ArrayList<ItemDelInventarioMinimizado> listaDeItems(){
        ArrayList<ItemDelInventarioMinimizado> res = new ArrayList<ItemDelInventarioMinimizado>();
        for(Item inv : this.inventario.getItems()){
            ItemDelInventarioMinimizado mini = new ItemDelInventarioMinimizado();
            String idString = inv.getId().toString();
            mini.setIdItem(idString);
            mini.setNombreItem(inv.getNombre());
            mini.setDescripcionItem(inv.getDescripcion());
            res.add(mini);
        }

        return res;
    }

    public Laberinto getPorNombre(String nombreLab){
        for (int i= 0; i< listLaberinto.size();i++){
            if(listLaberinto.get(i).getNombreLaberinto() == nombreLab){
                return listLaberinto.get(i);
            }
        }
        return null;
    }


}
