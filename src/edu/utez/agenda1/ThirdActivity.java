package edu.utez.agenda1;

import java.util.ArrayList;
import java.util.List;

import edu.utez.conector.ConexionBD;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends ActionBarActivity implements TextWatcher {
	TextView txt;
	AutoCompleteTextView filtro;
	List<String> ls = new ArrayList<String>();

	int edtLength=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
	    
		ConexionBD con=new ConexionBD(this);
		Cursor datos=con.consultaGeneral("contactos");//similar al resultset
		
		
		filtro = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		filtro.addTextChangedListener(this);

		filtro.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, ls));

		

		
		if(datos.moveToFirst()){
			do{
				ls.add(datos.getString(2)+" "+datos.getString(1)+" "+datos.getString(3));
			}while(datos.moveToNext());
		}
		
		
		
		TableLayout tabla=(TableLayout) findViewById(R.id.contenedor);
		TableRow raw=new TableRow(this);
		//EditText edt=new EditText(this);
		TextView edt=new TextView(this);
		//edt.setTextColor(Color.WHITE);
		raw.addView(edt);		
		tabla.addView(raw);
		if(datos.moveToFirst()){
			do{				
				TableRow row=new TableRow(this);				
				txt=new TextView(this);
				txt.setTextColor(Color.WHITE);
				txt.setText(datos.getString(2)+" "+datos.getString(1));  			
				 
				final String idContacto=datos.getString(0);
				
				final ImageButton act=new ImageButton(this);
				act.setImageResource(android.R.drawable.ic_menu_edit);
				act.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						Intent intento =new Intent(act.getContext(), CuatroActivity.class);
						intento.putExtra("id", idContacto);
						startActivity(intento);
						finish();
					}
				});
				
				
				filtro.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
							long arg3) {
						// TODO Auto-generated method stub				
						Intent intento = new Intent(filtro.getContext(),InfoActivity.class);
						
						intento.putExtra("nombre", filtro.getText().toString());						
						//Intent intento =new Intent(act.getContext(), CuatroActivity.class);
						//intento.putExtra("id", idContacto);
						//startActivity(intento);
						//finish();
						startActivity(intento);
					}

				});
				
				row.addView(act);
				
				final ImageButton del=new ImageButton(this);
				del.setImageResource(android.R.drawable.ic_menu_delete);
				del.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						ConexionBD con=new ConexionBD(del.getContext());
						con.eliminar("contactos", "id=?", new String []{idContacto});
						Toast.makeText(del.getContext(), "Contacto eliminado", Toast.LENGTH_SHORT).show();
						startActivity(new Intent(del.getContext(), SecondActivity.class));
						finish();
					}
				});
				row.addView(del);				
				row.addView(txt);				
				tabla.addView(row);
			}while(datos.moveToNext());		
			
		}
		
	}
	
	public void agregar(View v){
		startActivity(new Intent(this, SecondActivity.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		txt.setText(filtro.getText());		
	}

	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	public void afterTextChanged(Editable s) {

	}

}
