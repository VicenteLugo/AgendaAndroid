package edu.utez.agenda1;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
final TextView txt=(TextView)findViewById(R.id.textView1);
        
        Thread hilo=new Thread(new Runnable(){

    		@Override
    		public void run() {
    			try {
    				Thread.sleep(5000);
    				startActivity(new Intent(txt.getContext(), PrincipalActivity.class));
    				finish();
    			} catch (InterruptedException e) {					
    				e.printStackTrace();
    		}
    			
    	}
        	
        	});
        
        hilo.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
}
