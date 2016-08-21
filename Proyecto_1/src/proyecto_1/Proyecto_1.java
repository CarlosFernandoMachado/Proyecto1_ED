/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author carlos
 */
public class Proyecto_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FSAList alumnos = leerarchivo();
    }

    public static FSAList leerarchivo() {
        FSAList alumnos = new FSAList();
        String cadena;
        FileReader f = null;
        BufferedReader b = null;
        try {
            f = new FileReader("Alumnos.txt");
            b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                String temp[] = cadena.split(",");
                for (int i = 0; i < temp.length; i+=3) {
                    alumnos.add(new Alumno(temp[i],Integer.parseInt(temp[i+1]),temp[i+2]));
                }
            }
        } catch (Exception e) {
        }
        try {
            b.close();
        } catch (Exception e) {
        }
        return alumnos;
    }

    public void escribirarchivo(FSAList alumnos) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("Promedio.csv");
            bw = new BufferedWriter(fw);
            for (int i = 0; i < alumnos.Size(); i++) {
                bw.write(((Alumno) (alumnos.get(i))).getCuenta() + "," + ((Alumno) (alumnos.get(i))).promedio());
            }
            bw.flush();
        } catch (Exception e) {
        }
        try {
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
}
