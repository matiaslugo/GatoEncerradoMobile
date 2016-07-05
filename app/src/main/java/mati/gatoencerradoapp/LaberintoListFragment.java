
package mati.gatoencerradoapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import Servicios.LaberintosService;
import dominio.LaberintoAndroid;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LaberintoListFragment extends ListFragment implements View.OnClickListener {

    LaberintosService laberintoService;
    private Callbacks mCallbacks = sDummyCallbacks;

    public interface Callbacks {

        public void onItemSelected(LaberintoAndroid laberinto);
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(LaberintoAndroid laberinto) {

        }
    };

    @Override
    public void onClick(View v) {

    }

    public LaberintoListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String BASE_URL = "http://10.12.1.110:9000/laberintosAndroid";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        laberintoService = retrofit.create(LaberintosService.class);

        Call<List<LaberintoAndroid>> laberintoCall = laberintoService.getLaberintos();

        laberintoCall.enqueue(new Callback<List<LaberintoAndroid>>() {
            @Override
            public void onResponse(Response<List<LaberintoAndroid>> response, Retrofit retrofit) {
                List<LaberintoAndroid> laberintos = response.body();

                setListAdapter(new LaberintoAdapter(
                        getActivity(),
                        laberintos));
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
        LaberintoAndroid laberinto = (LaberintoAndroid) listView.getAdapter().getItem(position);
        mCallbacks.onItemSelected(laberinto);
    }

}