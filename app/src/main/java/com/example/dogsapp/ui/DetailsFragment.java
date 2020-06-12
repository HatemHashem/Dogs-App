package com.example.dogsapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dogsapp.R;
import com.example.dogsapp.databinding.FragmentDetailsBinding;
import com.example.dogsapp.model.DogsBreed;
import com.example.dogsapp.viewModel.ViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {
    private FloatingActionButton fab;
    private TextView dogName;
    private TextView dogWeight;
    private ViewModel viewModel;
    private static final String TAG = "DetailsFragment";

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDetailsBinding fragmentDetailsBinding = DataBindingUtil.inflate(inflater
                , R.layout.fragment_details, container, false);
        fab = fragmentDetailsBinding.list;
        dogName = fragmentDetailsBinding.dogName;
        dogWeight = fragmentDetailsBinding.dogWeight;
        return fragmentDetailsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initiation();

    }

    private void initiation() {
        ViewModel viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);
        DetailsFragmentArgs args = DetailsFragmentArgs.fromBundle(getArguments());
        dogName.setText(args.getName());
        List<DogsBreed> dogDetails = viewModel.getDogsBreedRoom().getValue();
        if (!dogDetails.isEmpty()) {
            for (DogsBreed currentDogsBreed : dogDetails) {
                if (currentDogsBreed.getName() == args.getName()) {
                    dogWeight.setText(currentDogsBreed.getWeight().getMetric());

                }
            }
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavDirections action = DetailsFragmentDirections.actionDetailsFragmentToDogsListFragment2();
                Navigation.findNavController(view).navigate(action);
            }
        });

    }
}
