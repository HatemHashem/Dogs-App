package com.example.dogsapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogsapp.adapters.DogsAdapter;
import com.example.dogsapp.R;
import com.example.dogsapp.databinding.FragmentDogsListBinding;
import com.example.dogsapp.viewModel.ViewModel;
import com.example.dogsapp.model.DogsBreed;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DogsListFragment extends Fragment {
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private ViewModel viewModel;




    public DogsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentDogsListBinding fragmentDogsListBinding= DataBindingUtil
                .inflate(inflater,R.layout.fragment_dogs_list,container,false);
        recyclerView=fragmentDogsListBinding.recyclerview;
        fab=fragmentDogsListBinding.details;
        return fragmentDogsListBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    //    recyclerView=view.findViewById(R.id.recyclerview);
    //    fab=view.findViewById(R.id.details);
        initiation();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action= DogsListFragmentDirections.actionDogsListFragmentToDetailsFragment2();
                Navigation.findNavController(view).navigate(action);

            }
        });
    }
    public void initiation(){
        DogsAdapter adapter=new DogsAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewModel=new ViewModelProvider(getActivity()).get(ViewModel.class);
        /*
        viewModel.getDogsBreedLiveData().observe(getActivity(), new Observer<List<DogsBreed>>() {
            @Override
            public void onChanged(List<DogsBreed> dogsBreeds) {
                adapter.setDogsBreedList(dogsBreeds);
            }
        });

         */
        viewModel.getDogsBreedRoom().observe(getActivity(), new Observer<List<DogsBreed>>() {
            @Override
            public void onChanged(List<DogsBreed> breeds) {
                adapter.setDogsBreedList(breeds);
            }
        });

    }
}
