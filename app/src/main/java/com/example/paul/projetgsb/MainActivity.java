package com.example.paul.projetgsb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private EditText editGlycemie;
    private EditText editPrenom;
    private EditText editNom;
    private Button btnAjouter;
    private Button btnSignaler;
    private Button btnAfficher;
    private RadioButton RdbProt1;
    private RadioButton RdbProt2;
    private TextView tVAfficherRes;
    private TextView txtPrenom;
    private TextView TxtNom;
    private MaladesBDD BDDMalade;


    public MainActivity() {
    }
    private static final int MYSECONDACTIVITY_REQUESTCODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editGlycemie = (EditText) findViewById(R.id.editGlycemie);
        editPrenom = (EditText) findViewById(R.id.editPrenom);
        editNom = (EditText) findViewById(R.id.editNom);
        btnAjouter = (Button) findViewById(R.id.btnAjouter);
        btnSignaler = (Button) findViewById(R.id.btnSignaler);
        btnAfficher = (Button) findViewById(R.id.btnAfficher);
        RdbProt1 = (RadioButton) findViewById(R.id.rdbProt1);
        RdbProt2 = (RadioButton) findViewById(R.id.rdbProt2);
        tVAfficherRes = (TextView) findViewById(R.id.tVAfficherRes);
        txtPrenom = (TextView) findViewById(R.id.txtPrenom);
        TxtNom = (TextView) findViewById(R.id.TxtNom);
        BDDMalade = new MaladesBDD(MainActivity.this);
        BDDMalade.open();

        btnAfficher.setOnClickListener(clickListenerBtnAfficher);
        btnSignaler.setOnClickListener(clickListenerbtnSignaler);
        btnAjouter.setOnClickListener(clickListenerbtnAjouter);

    }


    private View.OnClickListener clickListenerBtnAfficher = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MapProtocoles m = new MapProtocoles();
            m.initialiser();
            if (!(RdbProt1.isChecked()) && !(RdbProt2.isChecked())) {
                Toast.makeText(MainActivity.this, "Vous n'avez pas choisi de protocole !", Toast.LENGTH_LONG).show();
            } else if (editGlycemie.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Vous n'avez pas saisi la glycémie !", Toast.LENGTH_LONG).show();
            } else if (RdbProt1.isChecked()) {
                Protocole p = m.getProtocole(1);
                double g = Double.parseDouble(editGlycemie.getText().toString());
                int i = p.insuline(g);
                tVAfficherRes.setText(String.valueOf(i));
            } else if (RdbProt2.isChecked()) {
                Protocole p = m.getProtocole(2);
                double g = Double.parseDouble(editGlycemie.getText().toString());
                int i = p.insuline(g);
                tVAfficherRes.setText(String.valueOf(i));
            }

            if (Double.parseDouble(editGlycemie.getText().toString()) >= 2) {
                editNom.setVisibility(View.VISIBLE);
                editPrenom.setVisibility(View.VISIBLE);
                txtPrenom.setVisibility(View.VISIBLE);
                TxtNom.setVisibility(View.VISIBLE);
                btnAjouter.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Vous devez ajouter le malade !", Toast.LENGTH_LONG).show();
            }
        }
    };
    private View.OnClickListener clickListenerbtnAjouter = new View.OnClickListener() {

        Malade malade;

        public void onClick(View v) {
            String prenom = editPrenom.getText().toString();
            String nom = editNom.getText().toString();
            Double glycemie = Double.parseDouble(tVAfficherRes.getText().toString());
            if (prenom.isEmpty() || nom.isEmpty())
                Toast.makeText(MainActivity.this, "Vous devez remplir tous les champs !", Toast.LENGTH_LONG);
            else {
                malade = new Malade(prenom, nom, glycemie);
                long ret = BDDMalade.ajoutMalade(malade);
                if (ret != -1)
                    Toast.makeText(MainActivity.this, "Ajout effectué", Toast.LENGTH_LONG);
                else
                    Toast.makeText(MainActivity.this, "Ajout non effectué", Toast.LENGTH_LONG);
            }
        }

    };
    private View.OnClickListener clickListenerbtnSignaler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent it = new Intent(MainActivity.this,  Main2Activity.class);
            startActivityForResult(it,  MYSECONDACTIVITY_REQUESTCODE);
        };
};
}