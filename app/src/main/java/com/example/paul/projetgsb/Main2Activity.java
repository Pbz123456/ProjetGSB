package com.example.paul.projetgsb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
private ListView lstMalade;
    private Button btnEnvoyer;
    private MaladesBDD malade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lstMalade = (ListView) findViewById(R.id.LstMalade);
        btnEnvoyer = (Button) findViewById(R.id.btnEnvoyer);
        Bundle b = getIntent().getExtras();

        btnEnvoyer.setOnClickListener(clickListenerbtnEnvoyer);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main2Activity.this, android.R.layout.simple_list_item_1);
        malade = new MaladesBDD(Main2Activity.this);
        malade.open();
        ArrayList<Malade> lesMalades = malade.getTousLesMalades();
        if(lesMalades.size()!=0){
            for(Malade m:lesMalades){
                adapter.add("Nom : "+m.getNom()+" - Prénom : "+m.getPrenom()+" - Glycémie : "+m.getGlycemie());
            }
        }
        lstMalade.setAdapter(adapter);
    }
    private View.OnClickListener clickListenerbtnEnvoyer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String body="";
        for (Malade m : malade.getTousLesMalades())
        {
            body+=m.getNom()+"-"+m.getPrenom()+"-"+m.getGlycemie();
        }
            Intent returnIt = new Intent(Intent.ACTION_SEND);
            String[] tos = { "paullam@hotmail.fr"  };
            String[] ccs = { "paullambis@hotmail.com"  };
            returnIt.putExtra(Intent.EXTRA_EMAIL, tos);
            returnIt.putExtra(Intent.EXTRA_CC,  ccs);
            returnIt.putExtra(Intent.EXTRA_TEXT ,  body);
            returnIt.putExtra(Intent.EXTRA_SUBJECT ,  "subject");
            returnIt.setType("message/rfc882");
            Intent.createChooser(returnIt,  "Choose Email Client");

        }
    };
}






























