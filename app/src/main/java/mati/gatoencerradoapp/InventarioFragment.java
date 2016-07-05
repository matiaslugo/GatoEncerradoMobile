package mati.gatoencerradoapp;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import Servicios.LaberintosService;
import dominio.ItemAndroid;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class InventarioFragment extends ListFragment implements View.OnClickListener {

    LaberintosService laberintoService;

    private Callbacks mCallbacks = sDummyCallbacks;

    public interface Callbacks{

        void onItemSelected(ItemAndroid item);
    }

    private  static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(ItemAndroid item) {

        }
    };

    @Override
    public void onClick(View v) {

    }
    public InventarioFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String BASE_URL = "http://10.12.1.110:9000/inventario";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        laberintoService = retrofit.create(LaberintosService.class);

        Call<List<ItemAndroid>> laberintoCall = laberintoService.getInventario();

        laberintoCall.enqueue(new Callback<List<ItemAndroid>>(){
            @Override
            public void onResponse(Response<List<ItemAndroid>> response, Retrofit retrofit) {
                List<ItemAndroid> inventario = response.body();

                setListAdapter(new InventarioAdapter(
                        getActivity(),
                        inventario));
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                Log.e("LaberintosNo", t.getMessage());
            }
        });
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {
        super.onListItemClick(listView, v, position, id);
        ItemAndroid item = (ItemAndroid) listView.getAdapter().getItem(position);
        mCallbacks.onItemSelected(item);
    }

}



