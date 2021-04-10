package com.pixles.mmuller;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

import android.widget.EditText;
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
    static String[][] spaceProbes={
            {"1","4.5","5.5","5.0","1.0","-0.50","62.25","69.75","15.0","62.25","48.0","3.976","0.61"},


    };
    EditText xx0,xx1,xx2,Funn,pree;
    static String[] spaceProbeHeaders={"#i","X0","X1","X2","h0","h1","&0","&1","a","b","c","X3","Ea"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TableView<String[]> tableView = (TableView<String[]>) findViewById(R.id.table);

        Funn = (EditText)  findViewById(R.id.funcion);
        xx0 = (EditText)  findViewById(R.id.x0);
        xx1 = (EditText)  findViewById(R.id.x1);
        xx2 = (EditText)  findViewById(R.id.x2);
        pree = (EditText)  findViewById(R.id.pre);
        tableView.setHeaderBackgroundColor(Color.parseColor("#03A9F4"));
        tableView.setScrollBarSize(10);

        tableView.setMinimumHeight(400);

        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,spaceProbeHeaders));
        tableView.setColumnCount(13);
        tableView.setDataAdapter(new SimpleTableDataAdapter(MainActivity.this, spaceProbes));

        tableView.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                Toast.makeText(MainActivity.this, ((String[])clickedData)[1], Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void Mmuller(String Fun,double x0,double x1,double x2, double preci){
        double error =0;
        double x3=0;
        double c=0;
        double b=0;
        double a=0;
        double h0=0;
        double h1=0;
        double I0=0;
        double I1=0;
       // while (error>preci){
            double fx0=Funcion.f(Fun,x0);
            double fx1=Funcion.f(Fun,x1);
            double fx2=Funcion.f(Fun,x2);

            h0=x1-x0;
            h1=x2-x1;

            I0=(fx1-fx0)/(x1-x0);
            I1=(fx2-fx1)/(x2-x1);

            a=(I1-I0)/(h1+h0);
            b=(a*h1)-I1;
            c=fx2;
            double raiz=Math.sqrt((Math.pow(b,2))-4*a*c);
            if((Math.abs(b+raiz))>(Math.abs(b-raiz))){
                x3=x2+((-2*c)/(b+raiz));
            }else{
                x3=x2+((-2*c)/(b-raiz));
            }

            error=Math.abs((x3-x2)/(x3))*100;

            x0=x1;
            x1=x2;
            x2=x3;
            
       // }



    }
}
