package com.example.antoine.projetaddingbuttonsprogrammaticaly;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mainRelativeLayout;
    static int numBoutton = 1;

    SharedPreferences boutons;
    String filename;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainRelativeLayout = (RelativeLayout) findViewById(R.id.main_relative_layout);





      /*  //Sauvegarder les préférences, notamment le nombre de boutons
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("myInt", numBoutton);
        editor.commit();

        boutons =  getSharedPreferences(filename,0);
        int datareturned = boutons.getInt("myInt",0);
        Toast.makeText(MainActivity.this, "NbBoutons" + datareturned, Toast.LENGTH_SHORT).show();
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       /* int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

        */

        switch (item.getItemId()) {
            case R.id.action_ajouter:
                //ajouter le code du bouton

               // mainRelativeLayout = (RelativeLayout) findViewById(R.id.main_relative_layout);
                int belowID = R.id.main_relative_layout;
                /*RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                Toast.makeText(this, "Bouton Ajouter cliqué", Toast.LENGTH_SHORT).show();
                Button b = new Button(this);
                b.setId(numBoutton);

                //Récupérer le nom du fichier sans l'extension mp3
                b.setText("Test bouton n° " + numBoutton);

                mainRelativeLayout.addView(b,params);

                */

                Button b = new Button(this);

                //TODO: Ajouter la méthode permettant de créer le nouveau layout
                    if (numBoutton % 2 != 0) {
                        //Aligner à gauche
                        //addSubLayout(belowID);


                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

                        mainRelativeLayout.setLayoutParams(params);
                        b.setText("Bouton n°" + numBoutton);
                        mainRelativeLayout.addView(b);
                        numBoutton++;

                    } else {
                        //Aligner à droite
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        b.setLayoutParams(params);
                        b.setText("Bouton n°" + numBoutton);
                        mainRelativeLayout.addView(b);
                        numBoutton++;
                    }

                break;
            default:
                break;
        }
        return true;


        }


    //TODO: Méthode pour ajouter un nouveau layout afin que les boutons ne se superposent plus.
    /*public void addSubLayout(int belowId){
        int newID = View.generateViewId();

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, belowId);

        ContentFrameLayout layout = (ContentFrameLayout) findViewById(R.id.main_relative_layout);
        layout.addView(b,lp);



    } */


}

