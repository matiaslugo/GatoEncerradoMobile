package Servicios;

import java.util.List;

import dominio.ItemAndroid;
import dominio.LaberintoAndroid;
import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by matielchino on 02/07/16.
 */
public interface LaberintosService {

    @GET("/laberintosAndroid")
    Call<List<LaberintoAndroid>> getLaberintos();

    @GET("/inventario")
    Call<List<ItemAndroid>> getInventario();

}
