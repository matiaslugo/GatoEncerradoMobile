package dominio;

import java.io.Serializable;

public class ItemAndroid implements Serializable{

    String nombreItem;
    String pathImagen;

    public ItemAndroid(String nombreItem, String pathImagen) {
        this.nombreItem = nombreItem;
        this.pathImagen = pathImagen;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }
}
