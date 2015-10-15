package com.example.smallbirdking.seriess;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smallbirdking.seriess.function.response;
import com.squareup.picasso.Picasso;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link Serie}
 * in two-pane mode (on tablets) or a {@link Serie}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private response.ResultsEntity mItem;
    private Context context;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("detailFrag", "start");
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = list.responseObj.getResults().get(Integer.valueOf(getArguments().getString(ARG_ITEM_ID)).intValue());
            //Integer.valueOf(getArguments().getLong(ARG_ITEM_ID)).intValue()
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_serie_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            String imageURL = content.urlImage+mItem.getPoster_path();
            ImageView imageView = (ImageView) rootView.findViewById(R.id.serie_detail_Image);
            Picasso.with(context).load(imageURL).into(imageView);
            ((TextView) rootView.findViewById(R.id.serie_detail)).setText(mItem.getOverview());
        }

        return rootView;
    }
}
