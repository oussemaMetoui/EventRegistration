package com.oussema.eventregistration.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oussema.eventregistration.DatabaseHandler;
import com.oussema.eventregistration.MyAdapter;
import com.oussema.eventregistration.R;
import com.oussema.eventregistration.model.Member;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttendeesListFragment extends Fragment {

    private final String TAG = AttendeesListFragment.class.getSimpleName();
    DatabaseHandler db;

    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendees_list, container, false);

        recyclerView = view.findViewById(R.id.registred_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        db = new DatabaseHandler(getActivity());

        setMembers(db);
        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    private void setMembers(DatabaseHandler db){
        List<Member> members = db.getAllMembers();

        if (members.size()>0) {
            MyAdapter adapter = new MyAdapter(members);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}