package com.example.semana2_2;

import java.util.ArrayList;

import com.area51.adapters.ListaAdapter;
import com.area51.models.Persona;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView lvLista;
	ListaAdapter adapter;
	ArrayList<Persona> listaPersona;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lvLista = (ListView) findViewById(R.id.lvLista);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		listaPersona = new ArrayList<Persona>();
		listaPersona.add(new Persona(1, "Johann", "5 min ago", "Texto Uno",
				"Texto Dos", R.drawable.logo));
		listaPersona.add(new Persona(1, "Sam", "6 min ago", "Hungry", "Hola",
				R.drawable.logo));
		listaPersona.add(new Persona(1, "Erik", "7 min ago", "Tennis", "TEst",
				R.drawable.logo));
		listaPersona.add(new Persona(1, "Michelle", "8 min ago", "Great",
				"JEJEJE", R.drawable.logo));
		listaPersona.add(new Persona(1, "Alice", "9 min ago", "Holaaa", "Tres",
				R.drawable.logo));
		listaPersona.add(new Persona(1, "Josh", "10 min ago", "Test", "Cuatro",
				R.drawable.logo));
		listaPersona.add(new Persona(1, "Mom", "11 min ago", "Union", "SEis",
				R.drawable.logo));
		listaPersona.add(new Persona(1, "Dad", "12 min ago", "San Francisco",
				"Diez", R.drawable.logo));
		listaPersona.add(new Persona(1, "Chino", "13 min ago", "Chicago",
				"Once", R.drawable.logo));
		adapter = new ListaAdapter(getApplicationContext(), listaPersona);
		lvLista.setAdapter(adapter);
	}
}
