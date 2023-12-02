package com.example.myapps;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class fragmento1 extends Fragment {
    private EditText editTextFirstName, editTextLastName;
    private Button btnAdd;
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    private List<Person> personList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento1, container, false);

        editTextFirstName = view.findViewById(R.id.editTextFirstName);
        editTextLastName = view.findViewById(R.id.editTextLastName);
        btnAdd = view.findViewById(R.id.btnAdd);
        recyclerView = view.findViewById(R.id.recyclerView);

        // Configurar el RecyclerView
        personList = new ArrayList<>();
        personAdapter = new PersonAdapter(personList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(personAdapter);

        // Configurar el evento de clic del botón para agregar nuevos datos
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPerson();
            }
        });

        return view;
    }

    private void addPerson() {
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();

        if (!firstName.isEmpty() && !lastName.isEmpty()) {
            Person person = new Person(firstName, lastName);
            personList.add(person);
            personAdapter.notifyDataSetChanged();

            // Limpiar los campos después de agregar
            editTextFirstName.setText("");
            editTextLastName.setText("");
        }
    }
}
