package com.pixles.mmuller;

import java.util.*;
import com.fathzer.soft.javaluator.DoubleEvaluator;


public class Funcion {


    public static double f(String f, double V) {

        String funcion="";

        for(int i=0;i<f.length();i++){
            if((f.charAt(i)+"").equals("ˆ")){
				funcion=funcion+"^";
            }else {
                if((f.charAt(i)+"").equals("x")){
                    funcion=funcion+V;
                }else{
                    funcion=funcion+f.charAt(i);
                }
            }
        }



        DoubleEvaluator evaluator = new DoubleEvaluator();

        // Evaluate an expression
        Double resultado = evaluator.evaluate(funcion);
        // Ouput the result


        return resultado;
    }


}
