package com.example.primera_entrega_das;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IntermedioJugarCrear extends AppCompatActivity {
    private String tema;

    private int imagenId;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedio_jugar_crear);

        imageView = findViewById(R.id.imageTema);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           tema = extras.getString("Tema");
            imagenId = extras.getInt("Imagen");

            // Carga la imagen en el ImageView
            imageView.setImageResource(imagenId);

            TextView temaTextView = findViewById(R.id.textViewTemaInter);

            temaTextView.setText(String.format("Tema: %s", tema));
        }

    }

    public void OnClickJugar(View v){
        // aparece la pantalla de Jugar
        Intent intentJugar = new Intent(this, JugarActivity.class);
        OperacionesBD opBD = new OperacionesBD(this,1);

        int idP = opBD.obtenerPregRandom(tema); // he cambiado aqui de "" a tema
        intentJugar.putExtra("idPregunta",idP);
        intentJugar.putExtra("TemaJugar",tema); // por si acaso puee dar problema
        intentJugar.putExtra("pregCorrecta",0);
        intentJugar.putExtra("pregRespondida",0);
        intentJugar.putExtra("imgJugarTema",imagenId);
        this.startActivity(intentJugar);
        finish();
    }

    public void OnClickCrearPreg(View v){

        Intent intentCP = new Intent(this, CrearPregunta.class);
        // Inicia la actividad
        intentCP.putExtra("TemaCP",tema);
        this.startActivity(intentCP);
        finish();
    }
}