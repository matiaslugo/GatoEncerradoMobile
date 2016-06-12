package gatoEncerradoDom;

import java.util.ArrayList;

/**
 * Created by matielchino on 12/06/16.
 */
public class Inventario {

    private int cantidadMaximaDeItems;

    private ArrayList<Item> items;

    public Inventario(int maximo) {
        this.cantidadMaximaDeItems = maximo;
        ArrayList<Item> arrayList = new ArrayList<Item>();
        this.items = arrayList;
    }

    /**
     * Retorna true si el inventario posee la cantidad maxima permitida de items.
     */
    public boolean inventarioLleno() {
        int size = this.items.size();
        return (size == this.cantidadMaximaDeItems);
    }

    public boolean agregarItemDelInventario(Item item) {
        return this.items.add(item);
    }

    public boolean estaElItem(String nombre) {

        int i = 0;
        Boolean res = false;
        while(i<this.items.size()){
            if(this.items.get(i).getNombre()!= nombre){
                i++;
            }
            else{
                res = true;
            }
        };
        return res;
    }

    public int getCantidadMaximaDeItems() {
        return this.cantidadMaximaDeItems;
    }

    public void setCantidadMaximaDeItems(int cantidadMaximaDeItems) {
        this.cantidadMaximaDeItems = cantidadMaximaDeItems;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}


