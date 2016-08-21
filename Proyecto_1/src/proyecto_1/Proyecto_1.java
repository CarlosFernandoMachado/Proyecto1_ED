/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
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
        Scanner sc = new Scanner(System.in);
        FSAList alumnos = leerarchivo();
        Random rndm = new Random();
        int nota, posicion;
        String resp;
        boolean seguir = true, validar = false;
        while (seguir) {
            posicion = rndm.nextInt(alumnos.Size());
            System.out.println(posicion);
            Alumno temp = ((Alumno) (alumnos.get(posicion)));
            System.out.println(temp.getNombre() + " fue la persona seleccionada aleatoriamente\nDesea ponerle una nota? si/no");
            resp = sc.next();
            if ("Si".equals(resp) || "sI".equals(resp) || "SI".equals(resp) || "si".equals(resp)) {
                while (validar == false) {
                    System.out.println("Ingrese una nota entre 0-100");
                    nota = sc.nextInt();
                    if (nota <= 100 && nota >= 0) {
                        validar = true;
                        temp.NuevaNota(nota);
                    }
                }
                validar = false;
                System.out.println("Desea buscar otra persona aleatoriamente? si/no");
                resp = sc.next();
                if ("No".equals(resp) || "nO".equals(resp) || "NO".equals(resp) || "no".equals(resp)) {
                    seguir = false;
                }
            } else {
                System.out.println("Desea buscar otra persona aleatoriamente? si/no");
                resp = sc.next();
                if ("No".equals(resp) || "nO".equals(resp) || "NO".equals(resp) || "no".equals(resp)) {
                    seguir = false;
                }
            }
        }
        escribirarchivo(alumnos);
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
                for (int i = 0; i < temp.length; i += 3) {
                    alumnos.add(new Alumno(temp[i], Integer.parseInt(temp[i + 1]), temp[i + 2]));
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
    
    public static void escribirarchivo(FSAList alumnos) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("Promedio.csv");
            fw.append("Numero de cuenta,Promedio");
            fw.append("\n");
            for (int i = 0; i < alumnos.Size(); i++) {
                fw.append(Integer.toString(((Alumno) (alumnos.get(i))).getCuenta()));
                fw.append(",");
                fw.append(Double.toString(((Alumno) (alumnos.get(i))).promedio()));
                fw.append("\n");
            }
        } catch (Exception e) {
        }
        try {
            fw.flush();
            fw.close();
        } catch (Exception e) {
        }
    }
}
