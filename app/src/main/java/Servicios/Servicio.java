package Servicios;

import java.util.ArrayList;

import gatoEncerradoDom.Laberinto;

/**
 * Created by matielchino on 12/06/16.
 */

public class Servicio {

    private ArrayList<Laberinto> listLaberinto;

    private Laberinto laberinto;

    public Servicio(ArrayList<Laberinto> listLab) {
        this.listLaberinto = listLab;
    }

    public Servicio() {
    }

    public Servicio(final Laberinto lab) {
        this.laberinto = lab;
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

}
