package com.example.dogsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dogsapp.BR;
import com.example.dogsapp.R;
import com.example.dogsapp.databinding.DoglistItemBinding;
import com.example.dogsapp.model.DogsBreed;
import com.example.dogsapp.ui.DogsListFragmentDirections;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {

    private List<DogsBreed> dogsBreedList;
    private Context context;

    public DogsAdapter(Context context) {
        dogsBreedList = new ArrayList<>();
        this.context = context;
    }

    public void setDogsBreedList(List<DogsBreed> dogsBreedList) {
        this.dogsBreedList = dogsBreedList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DoglistItemBinding doglistItemBinding = DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.doglist_item, parent, false);
        return new ViewHolder(doglistItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DogsBreed currentBreed = dogsBreedList.get(position);
        holder.bindTo(currentBreed);

    }

    @Override
    public int getItemCount() {
        return dogsBreedList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView breedName;
        private TextView breedOrigin;
        private TextView breedWeight;
        private DoglistItemBinding doglistItemBinding;

        public ViewHolder(@NonNull DoglistItemBinding doglistItemBinding) {
            super(doglistItemBinding.getRoot());
            this.doglistItemBinding = doglistItemBinding;
            doglistItemBinding.getRoot().setOnClickListener(this);

        }

        public void bindTo(DogsBreed currentBreed) {
            /*
            breedName.setText(currentBreed.getName());
            breedWeight.setText(currentBreed.getWeight().getMetric());
            breedOrigin.setText(currentBreed.getOrigin());

             */
            doglistItemBinding.setVariable(BR.dogsBreed,currentBreed);
            doglistItemBinding.executePendingBindings();


        }

        @Override
        public void onClick(View view) {
            DogsBreed currentBreed = dogsBreedList.get(getAdapterPosition());
            DogsListFragmentDirections.ActionDogsListFragmentToDetailsFragment2 action =
                    DogsListFragmentDirections.actionDogsListFragmentToDetailsFragment2();
            action.setName(currentBreed.getName());
            Navigation.findNavController(view).navigate(action);

        }
    }
}
