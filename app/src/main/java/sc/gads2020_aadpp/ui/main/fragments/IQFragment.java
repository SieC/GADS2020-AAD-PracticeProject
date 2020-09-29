package sc.gads2020_aadpp.ui.main.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sc.gads2020_aadpp.ApiClient;
import sc.gads2020_aadpp.ApiInterface;
import sc.gads2020_aadpp.R;
import sc.gads2020_aadpp.models.IQItem;
import sc.gads2020_aadpp.models.IQItem;

/**
 * A fragment representing a list of Items.
 */
public class IQFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public IQFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static IQFragment newInstance() {
        return new IQFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
          final  ArrayList<IQItem> list = new ArrayList<>();
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<IQItem>> call = apiService.getSkillIQItems();

            call.enqueue(new Callback<List<IQItem>>() {
                @Override
                public void onResponse(Call<List<IQItem>> call, Response<List<IQItem>> response) {
                  try {
                      list.addAll(response.body());
                      Log.d("TAG", "Response = " + list);
                  }catch (Exception e){
                      Log.e("Exception",e.toString());
                      Toast.makeText(getActivity(), "An error occurred", Toast.LENGTH_SHORT).show();

                  }
                    recyclerView.setAdapter(new MyIQItemRecyclerViewAdapter(getActivity(),list));

                }

                @Override
                public void onFailure(Call<List<IQItem>> call, Throwable t) {
                    Log.e("TAG","Response = "+t.toString());
                    Toast.makeText(getActivity(), "Failed to load.", Toast.LENGTH_SHORT).show();
                }
            });
              }
        return view;
    }
}