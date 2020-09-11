package sc.gads2020_aadpp.ui.main.fragments;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import sc.gads2020_aadpp.R;
import sc.gads2020_aadpp.models.IQItem;

/**
 * {@link RecyclerView.Adapter} that can display a {@link sc.gads2020_aadpp.models.IQItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyIQItemRecyclerViewAdapter extends RecyclerView.Adapter<MyIQItemRecyclerViewAdapter.ViewHolder> {

    private final List<IQItem> mValues;

    private final Activity activity;

    public MyIQItemRecyclerViewAdapter(Activity activity, ArrayList<IQItem> items) {
        mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_learning_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getName());
        holder.mContentView.setText(holder.mItem.getScore()+" skill IQ Score, "+mValues.get(position).getCountry());
        Glide
                .with(activity)
                .load(holder.mItem.getBadgeUrl())
                .centerCrop()
                .fitCenter()
              //  .placeholder(R.drawable.loading_spinner)
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final ImageView img;
        public IQItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
            img =  view.findViewById(R.id.imageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}