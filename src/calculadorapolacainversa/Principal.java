/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorapolacainversa;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author estudiantes
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stringInicial = sc.nextLine();
        System.out.println(stringInicial);
        String[] datos = stringInicial.split(" ");
        System.out.println(Arrays.toString(datos));
        //Calcula cuantos numeros hay en el array para preparar el double[]
        int k=0;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i].matches("[0-9]+")){
                k++;
            }
        }
        //Crea el array de numeros
        double[] numeros = new double[k];
        k=0;
        for (int i = 0; i < datos.length; i++) {
            if(datos[i].matches("[0-9]+")){
                numeros[k]=Integer.valueOf(datos[i]);
                k++;
            }
            switch(datos[i]){
                case "+":
                    numeros[k-2]=numeros[k-2]+numeros[k-1];
                    numeros[k-1]=0;
                    k--;
                    System.out.println(numeros[k-1]);
                    break;
                case "-":
                    numeros[k-2]=numeros[k-2]-numeros[k-1];
                    numeros[k-1]=0;
                    k--;
                    System.out.println(numeros[k-1]);
                    break;
                case "*":
                    numeros[k-2]=numeros[k-2]*numeros[k-1];
                    numeros[k-1]=0;
                    k--;
                    System.out.println(numeros[k-1]);
                    break;
                case "/":
                    numeros[k-2]=numeros[k-2]/numeros[k-1];
                    numeros[k-1]=0;
                    k--;
                    System.out.println(numeros[k-1]);
                    break;
                default:
                    break;
            }         
        }
        System.out.println(numeros[0]);
    }
}
