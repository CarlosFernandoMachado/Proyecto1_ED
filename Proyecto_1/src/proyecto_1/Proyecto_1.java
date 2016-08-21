/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Proyecto_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public static FSAList leerarchivo() {
        FSAList alumnos = new FSAList();
        Scanner sc = null;
        try {
            sc = new Scanner("Alumnos.txt");
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                alumnos.add(new Alumno(sc.next(), sc.nextInt(), sc.next()));
            }
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
