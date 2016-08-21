/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

/**
 *
 * @author carlos
 */
public class Alumno {
    private String nombre;
    private int cuenta;
    private String carrera;
    private VSAList notas = new VSAList();

    public Alumno(String nombre, int cuenta, String carrera) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuenta() {
        return cuenta;
    }

    public double promedio(){
        if (notas.Size() == 0) {
            return 0.0;
        }
        double promedio = 0;
        for (int i = 0; i < notas.Size(); i++) {
            if (notas.get(i) instanceof Double) {
                promedio += ((Double)(notas.get(i)));
            }
        }
        promedio /= notas.Size();
        return promedio;
    }
    
    public void NuevaNota(double nota){
        notas.insert(nota,notas.Size());
    }
}
