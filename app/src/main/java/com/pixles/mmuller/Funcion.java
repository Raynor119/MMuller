package com.pixles.mmuller;

import java.util.*;

public class Funcion {


    public static double f(String f, double V) {
        int k = 0;
        String array_f[] = new String[100];
        double fx[] = new double[100];
        double Resultado = 0;
        array_f[0] = "";

        for (int i = 0; i < f.length(); i++) {

            if (!("+".equals(Character.toString((f.charAt(i))))
                    || "-".equals(Character.toString((f.charAt(i)))))) {
                array_f[k] = array_f[k] + Character.toString((f.charAt(i)));
            } else {

                if (i != 0) {
                    k = k + 1;
                    array_f[k] = "";
                }
                array_f[k] = array_f[k] + Character.toString((f.charAt(i)));

            }
        }

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < array_f[i].length(); j++) {
                try {

                    if ("x".equals(Character.toString(array_f[i].charAt(j)))
                            && exponencial(i, j, array_f[i])) {
                        double temp_f;
                        String temp_S = "";
                        for (int n = (j + 2); n < array_f[i].length(); n++) {
                            temp_S = temp_S + Character.toString(array_f[i].charAt(n));
                        }
                        temp_f = Double.parseDouble(temp_S);
                        fx[i] = Math.pow(V, temp_f);

                        if (j != 0) {
                            temp_S = "";
                            for (int m = 0; m < j; m++) {
                                temp_S = temp_S + Character
                                        .toString(array_f[i].charAt(m));
                            }
                            temp_f = Double.parseDouble(temp_S);
                            fx[i] = temp_f * fx[i];
                        }

                    }

                    if ("x".equals(Character.toString(array_f[i].charAt(j))) && j != 0
                            && !(exponencial(i, j, array_f[i]))) {

                        double temp_f;
                        String temp_S = "";
                        for (int l = 0; l < j; l++) {
                            temp_S = temp_S + Character.toString(array_f[i].charAt(l));
                        }
                        temp_f = Double.parseDouble(temp_S);
                        fx[i] = temp_f * V;

                    }

                    if (!(BuscaX(i, j, array_f[i]))) {

                        double temp_f = Double.parseDouble(array_f[i]);
                        fx[i] = temp_f;
                    }

                } catch (Exception s) {

                }

            }
            Resultado = Resultado + fx[i];
        }

        return Resultado;
    }

    public static boolean exponencial(int i, int j, String valor_S) {
        for (int p = j; p < valor_S.length(); p++) {
            if ("^".equals(Character.toString(valor_S.charAt(p)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean BuscaX(int i, int j, String valor_S) {
        for (int p = j; p < valor_S.length(); p++) {
            if ("x".equals(Character.toString(valor_S.charAt(p)))) {
                return true;
            }
        }
        return false;
    }
}
