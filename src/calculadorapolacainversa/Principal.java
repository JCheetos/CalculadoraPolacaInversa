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
        String stringInicial = sc.nextLine(); //Lee la siguiente linea ingresada como los datos a operar
        System.out.println(stringInicial); //Imprime los datos ingresados
        String[] datos = stringInicial.split(" "); //Divide los datos ingresados por cada espacio ingresado, asignandolos a un espacio de un nuevo vector
        System.out.println(Arrays.toString(datos)); //Imprime el array creado por la funcion anterior
        //Calcula cuantos numeros hay en el array para preparar el double[], contandolos revisando cada espacio del vector
        int k = 0;
        for (String dato : datos) {
            if (dato.matches("[0-9]+")) {
                k++;
            }
        }
        //Crea el array de numeros, donde unicamente estaran los numeros aparte de las operaciones
        double[] numeros = new double[k];
        k = 0; //Se crea una variable que llevara la cuenta del espacio donde se encuentra actualmente el ultimo numero del array de numeros en revision
        for (String dato : datos) { //Se procede a revisar espacio por espacio del vector
            if (dato.matches("[0-9]+")) { //Si se encuentra un numero lo mete al array de numeros
                numeros[k] = Integer.valueOf(dato);
                k++;
            }
            /*Si se encuentra un operador, toma los dos valores numericos anteriores, realiza la operacion
            y devuelve el apuntador de posicion k una posicion hacia atras (Teniendo en cuenta que al hacer
            una operacion desaparece el ultimo numero del vector)*/
            switch (dato) {
                case "+":
                    numeros[k - 2] = numeros[k - 2] + numeros[k - 1];
                    numeros[k - 1] = 0;
                    k--;
                    System.out.println(numeros[k - 1]);
                    break;
                case "-":
                    numeros[k - 2] = numeros[k - 2] - numeros[k - 1];
                    numeros[k - 1] = 0;
                    k--;
                    System.out.println(numeros[k - 1]);
                    break;
                case "*":
                    numeros[k - 2] = numeros[k - 2] * numeros[k - 1];
                    numeros[k - 1] = 0;
                    k--;
                    System.out.println(numeros[k - 1]);
                    break;
                case "/":
                    numeros[k - 2] = numeros[k - 2] / numeros[k - 1];
                    numeros[k - 1] = 0;
                    k--;
                    System.out.println(numeros[k - 1]);
                    break;
                default: //Caera a default si el valor de dicho espacio en el vector es un numero
                    break;
            }
        }
        //Imprime el valor del primer espacio del array de numeros, que, al acabar el proceso, deberia ser el unico numero existente del vector
        if (numeros.length != datos.length-(numeros.length-1)) {
            System.out.println(Arrays.toString(numeros));
        } else {
            System.out.println(numeros[0]);
        }
    }
}
