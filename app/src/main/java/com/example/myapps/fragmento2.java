package com.example.myapps;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fragmento2 extends Fragment {

    private EditText nombreEditText, apellidoEditText, fechaEditText;
    private Button guardarButton;

    public fragmento2() {
        // Constructor vacío requerido por Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento2, container, false);

        // Inicializar Firebase
        FirebaseApp.initializeApp(requireContext());

        // Inicializar vistas
        nombreEditText = view.findViewById(R.id.nombreEditText);
        apellidoEditText = view.findViewById(R.id.apellidoEditText);
        fechaEditText = view.findViewById(R.id.fechaEditText);
        guardarButton = view.findViewById(R.id.guardarButton);

        // Manejar clic en el botón de guardar
        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatosFirebase();
            }
        });

        return view;
    }

    private void guardarDatosFirebase() {
        // Obtener una referencia a la base de datos
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("usuarios");

        // Generar una clave única para el nuevo usuario
        String userId = databaseReference.push().getKey();

        // Crear un objeto Usuario con los datos del formulario
        Usuario usuario = new Usuario(
                nombreEditText.getText().toString(),
                apellidoEditText.getText().toString(),
                fechaEditText.getText().toString()
        );

        // Guardar el usuario en la base de datos
        databaseReference.child(userId).setValue(usuario);

        // Limpiar los campos después de guardar
        nombreEditText.setText("");
        apellidoEditText.setText("");
        fechaEditText.setText("");
    }
}
