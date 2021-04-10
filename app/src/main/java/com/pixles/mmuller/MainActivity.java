package com.pixles.mmuller;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

import android.widget.EditText;
import android.widget.TextView;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    String [][] Datos={
            {"","","","","","","","","","","","",""},


    };
    EditText xx0,xx1,xx2,Funn,pree;
    TableView<String[]> tableView;
    TextView Raiz;
    String raz="";
    static String[] spaceProbeHeaders={"#i","X0","X1","X2","h0","h1","&0","&1","a","b","c","X3","Ea"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableView = (TableView<String[]>) findViewById(R.id.table);

        Funn = (EditText)  findViewById(R.id.funcion);
        xx0 = (EditText)  findViewById(R.id.x0);
        xx1 = (EditText)  findViewById(R.id.x1);
        xx2 = (EditText)  findViewById(R.id.x2);
        pree = (EditText)  findViewById(R.id.pre);
        Raiz=(TextView) findViewById(R.id.raiz);

        tableView.setHeaderBackgroundColor(Color.parseColor("#03A9F4"));
        tableView.setScrollBarSize(10);

        //tableView.setMinimumHeight(300);

        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,spaceProbeHeaders));
        tableView.setColumnCount(13);
        tableView.setDataAdapter(new SimpleTableDataAdapter(MainActivity.this, Datos));

        tableView.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
               // Toast.makeText(MainActivity.this, ((String[])clickedData)[1], Toast.LENGTH_SHORT).show();
            }
        });


        Raiz.setText(""+raz);
        tableView.setHeaderVisible(false);

        if(Funn.getText().toString().equals("") || xx0.getText().toString().equals("") || xx1.getText().toString().equals("") || xx2.getText().toString().equals("") || pree.getText().toString().equals("")){

        }else{
            String fun = Funn.getText().toString();

            Double x0 = Double.parseDouble(xx0.getText().toString());
            Double x1 = Double.parseDouble(xx1.getText().toString());
            Double x2 = Double.parseDouble(xx2.getText().toString());
            Double preci = Double.parseDouble(pree.getText().toString());


            Mmuller(fun, x0, x1, x2, preci);
        }




    }

    public void onclick(View v){

        if(Funn.getText().toString().equals("") || xx0.getText().toString().equals("") || xx1.getText().toString().equals("") || xx2.getText().toString().equals("") || pree.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Llene todos los Campos",Toast.LENGTH_LONG).show();
        }else {

            String fun = Funn.getText().toString();

            Double x0 = Double.parseDouble(xx0.getText().toString());
            Double x1 = Double.parseDouble(xx1.getText().toString());
            Double x2 = Double.parseDouble(xx2.getText().toString());
            Double preci = Double.parseDouble(pree.getText().toString());


            Mmuller(fun, x0, x1, x2, preci);
        }

    }

    public void Mmuller(String Fun,double x0,double x1,double x2, double preci){

        double x00=x0,x11=x1,x22=x2;

        double error =0;
        double x3=0;
        double c=0;
        double b=0;
        double a=0;
        double h0=0;
        double h1=0;
        double I0=0;
        double I1=0;
        int intar=0;
        do {
            double fx0 = Funcion.f(Fun, x0);
            double fx1 = Funcion.f(Fun, x1);
            double fx2 = Funcion.f(Fun, x2);
            //System.out.println("fx0: " + fx0 + " fx1:" + fx1 + " fx2: " + fx2);
            h0 = x1 - x0;
            h1 = x2 - x1;

            I0 = (fx1 - fx0) / (x1 - x0);
            I1 = (fx2 - fx1) / (x2 - x1);

            a = (I1 - I0) / (h1 + h0);
            b = (a * h1) + I1;
            c = fx2;

            double raiz = Math.sqrt((Math.pow(b, 2)) - 4 * a * c);
            if ((Math.abs(b + raiz)) > (Math.abs(b - raiz))) {
                x3 = x2 + ((-2 * c) / (b + raiz));
            } else {
                x3 = x2 + ((-2 * c) / (b - raiz));
            }

            error = Math.abs((x3 - x2) / (x3)) * 100;

            x0 = x1;
            x1 = x2;
            x2 = x3;
            intar++;
        }while(error > preci);

        Datos= new String[intar][13];
        error =0;
         x3=0;
         c=0;
         b=0;
         a=0;
         h0=0;
         h1=0;
         I0=0;
         I1=0;
         x0=x00;
         x1=x11;
         x2=x22;
         int regu=0;
        do {
            double fx0 = Funcion.f(Fun, x0);
            double fx1 = Funcion.f(Fun, x1);
            double fx2 = Funcion.f(Fun, x2);

            h0 = x1 - x0;
            h1 = x2 - x1;

            I0 = (fx1 - fx0) / (x1 - x0);
            I1 = (fx2 - fx1) / (x2 - x1);

            a = (I1 - I0) / (h1 + h0);
            b = (a * h1) + I1;
            c = fx2;


            double raiz = Math.sqrt((Math.pow(b, 2)) - 4 * a * c);
            if ((Math.abs(b + raiz)) > (Math.abs(b - raiz))) {
                x3 = x2 + ((-2 * c) / (b + raiz));
            } else {
                x3 = x2 + ((-2 * c) / (b - raiz));
            }

            error = Math.abs((x3 - x2) / (x3)) * 100;

            Datos[regu][0]=(regu+1)+"";
            Datos[regu][1]=""+x0;
            Datos[regu][2]=""+x1;
            Datos[regu][3]=""+x2;
            Datos[regu][4]=""+h0;
            Datos[regu][5]=""+h1;
            Datos[regu][6]=""+I0;
            Datos[regu][7]=""+I1;
            Datos[regu][8]=""+a;
            Datos[regu][9]=""+b;
            Datos[regu][10]=""+c;
            Datos[regu][11]=""+x3;
            Datos[regu][12]=""+error;

            x0 = x1;
            x1 = x2;
            x2 = x3;
            regu++;
        }while(error > preci);


        tableView.setHeaderVisible(true);
        tableView.setHeaderBackgroundColor(Color.parseColor("#03A9F4"));
        tableView.setScrollBarSize(10);

        //tableView.setMinimumHeight(300);
        //static String[] spaceProbeHeaders={"#i","X0","X1","X2","h0","h1","&0","&1","a","b","c","X3","Ea"};
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,spaceProbeHeaders));
        tableView.setColumnCount(13);
        tableView.setDataAdapter(new SimpleTableDataAdapter(MainActivity.this, Datos));

        tableView.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                String text="#i: "+((String[])clickedData)[0]+"\n"+"X0: "+((String[])clickedData)[1]+"\n"+"X1: "+((String[])clickedData)[2]+"\n"+"X2: "+((String[])clickedData)[3]+"\n"+"h0: "+((String[])clickedData)[4]+"\n"+"h1: "+((String[])clickedData)[5]+"\n"+"&0: "+((String[])clickedData)[6]
                        +"\n"+"&1: "+((String[])clickedData)[7]+"\n"+"a: "+((String[])clickedData)[8]+"\n"+"b: "+((String[])clickedData)[9]+"\n"+"c: "+((String[])clickedData)[10]+"\n"+"X3: "+((String[])clickedData)[11]+"\n"+"Ea: "+((String[])clickedData)[12];
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });

        raz=Datos[intar-1][11];
        Raiz.setText(""+raz);


    }
}
