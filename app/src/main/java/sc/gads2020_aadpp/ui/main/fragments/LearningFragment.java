package sc.gads2020_aadpp.ui.main.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sc.gads2020_aadpp.ApiClient;
import sc.gads2020_aadpp.ApiInterface;
import sc.gads2020_aadpp.R;
import sc.gads2020_aadpp.models.LearningItem;

/**
 * A fragment representing a list of Items.
 */
public class LearningFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LearningFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LearningFragment newInstance() {
        return new LearningFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
          final  ArrayList<LearningItem> list = new ArrayList<>();
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<LearningItem>> call = apiService.getLearningItems();

            call.enqueue(new Callback<List<LearningItem>>() {
                @Override
                public void onResponse(Call<List<LearningItem>> call, Response<List<LearningItem>> response) {
                try {
                    Log.e("TAG", response.body().toString());
                    list.addAll(response.body());
                }catch(Exception e){
                    Log.e("Exception",e.toString());
                    Toast.makeText(getActivity(), "An error occurred", Toast.LENGTH_SHORT).show();

                }
                    Log.e("TAG","Response = "+list);
                    recyclerView.setAdapter(new MyLearningItemRecyclerViewAdapter(getActivity(),list));

                }

                @Override
                public void onFailure(Call<List<LearningItem>> call, Throwable t) {
                    Log.e("TAG","Response = "+t.toString());
                    Toast.makeText(getActivity(), "Failed to load.", Toast.LENGTH_SHORT).show();
                }
            });
              }
        return view;
    }
}