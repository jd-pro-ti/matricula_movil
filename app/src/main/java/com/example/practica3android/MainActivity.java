package com.example.practica3android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btMensaje;
    private EditText edNombre;
    private EditText edApellid;
    private RadioGroup edCarrera;
    private TextView tvMensaje;
    private int contador = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre = findViewById(R.id.EdNombre);
        edApellid = findViewById(R.id.edApellidos);
        edCarrera = findViewById(R.id.btcarreras);
        btMensaje = findViewById(R.id.btMensaje);
        tvMensaje = findViewById(R.id.tvMensaje);


        btMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edNombre.getText().toString().trim();
                nombre= nombre.toUpperCase();
                String apellidos = edApellid.getText().toString().trim();
                apellidos = apellidos.toUpperCase();
                String [] sepaApellidos = apellidos.split(" ");
                String carre= "";
                String salida = "";
                if (nombre.isEmpty()) {
                    edNombre.setError("Ingresa tu nombre");
                    edNombre.requestFocus();
                    return;
                }
                if (apellidos.isEmpty()) {
                    edApellid.setError("Ingresa tus apellidos");
                    edApellid.requestFocus();
                    return;
                }
                if (sepaApellidos.length != 2){
                    edApellid.setError("Ingresa exactamente 2 apellidos (separados por espacio)");
                    edApellid.requestFocus();
                    return;
                }

                int idcarrera = edCarrera.getCheckedRadioButtonId();

                if (idcarrera==R.id.btTi){
                    carre="01";
                }else if (idcarrera==R.id.Gatronomia){
                    carre="02";
                }else if (idcarrera==R.id.btBiotecnologia){
                    carre="03";
                }else {
                    edCarrera.requestFocus();
                    return;
                }
                char [] caraNombre = nombre.toCharArray();
                char [] iniApellidos = new char[sepaApellidos.length];

                for (int i = 0; i<sepaApellidos.length; i++ ){
                    iniApellidos[i] = sepaApellidos[i].charAt(0);
                }
                String inicialesApellidos = new String(iniApellidos);

                if (contador >= 10) {
                    salida = "UTOM26" + carre +contador+caraNombre[0]+
                    inicialesApellidos;
                    contador++;
                }else{
                    salida = "UTOM26" + carre +"0"+contador+caraNombre[0]+
                            inicialesApellidos;
                    contador++;
                }
                tvMensaje.setText(salida);
            }
        });

        edNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edNombre.setText(" ");
            }
        });
    }
}