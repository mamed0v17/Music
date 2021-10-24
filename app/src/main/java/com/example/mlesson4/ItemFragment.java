package com.example.mlesson4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mlesson4.placeholder.PlaceholderContent;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemFragment extends Fragment implements Adapter.Listener {
    private RecyclerView recyclerView;
    private ArrayList<Musics> arrayList = new ArrayList<>();
    private Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CreateList();
        initFrag(view);
    }


    private void initFrag(@NotNull View view) {
        recyclerView = view.findViewById(R.id.recycler);
        adapter = new Adapter();
        adapter.setListener(arrayList, this);
        recyclerView.setAdapter(adapter);
    }

    private void CreateList() {
        arrayList = new ArrayList<>();
        arrayList.add(new Musics(" I got love", "4:35", "1", "Miyagi", 11));
        arrayList.add(new Musics("Kino", "3:05", "2", "Macan", 12));
        arrayList.add(new Musics("Brooklyn", "3:15", "3", "Miyagi", 13));
        arrayList.add(new Musics("Sansara", "5:12", "4", "Basta", 14));
        arrayList.add(new Musics("Медляк", "3:17", "5", "Tanir", 15));
        arrayList.add(new Musics("Beggin", "3:44", "6", "Madcon", 16));
        arrayList.add(new Musics("Оружие ", "3:28", "7", "Группа ПИЦЦА", 17));
        arrayList.add(new Musics("Crocolaco", "3:12", "8", "Ulukmanapo", 18));
        arrayList.add(new Musics("Lonely", "3:42", "9", "Lucaveros", 19));
        arrayList.add(new Musics("Lonely", "4:23", "10", "Akon", 20));
    }

    @Override
    public void onClick(Musics musics) {
        Intent intent = new Intent(getActivity(), MainActivity2.class);
        intent.putExtra("key", musics.getName());
        startActivity(intent);
    }
}