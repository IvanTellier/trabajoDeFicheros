/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajodeficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author proye
 */
public class TrabajoDeFicheros {

 
    public static void menu() throws IOException{
        Scanner sc = new Scanner(System.in);
        //declaramos un boolean que nos permitira cerrar la app mas tarde
        boolean salir = false;
        //Guardaremos la opcion del usuario
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. CP");
            System.out.println("2. Añadir Info");
            System.out.println("3. Copiar Info");
            System.out.println("4. Borrar Info");
            System.out.println("5. Salir");
 
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sc.nextInt();
 
                switch (opcion) {
                    case 1:
                        buscador();
                        break;
                    case 2:
                        añadirInfo();
                        break;
                    case 3:
                        copia();
                        break;
                    case 4:
                        suprimir();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }
 
    }
    
    public static void buscador() throws FileNotFoundException, IOException{
        System.out.println("Imtroduce el digito por el que empiece su CP deseado:");
        BufferedReader br = new BufferedReader(new FileReader("Restaurants.csv"));
        String linea = br.readLine();
        Scanner sc = new Scanner(System.in);
        String cod = sc.nextLine();
        
	//Mientras existan líneas para leer
	while (linea != null){
            //Separamos los datos en un array indicando que queremos señalizar por ,
            String[] datos = linea.split(",");
            if (datos[datos.length - 1].startsWith(cod))
                System.out.println(Arrays.toString(datos)); //Mostramos restaurante		
                //Leemos siguiente línea,mientras no sea null repetimos el bucle
                linea = br.readLine();
                }
	br.close();
        System.out.println();
    }
    
    public static void añadirInfo() throws IOException{
        // Le pedimos al usuario que introduzca el nombre del archivo que quiere modificar 
        System.out.println("Imtroduce el nombre del archivo a modificar:");
        
        Scanner sc = new Scanner(System.in);
        String info = sc.nextLine();
        
        //Le indicamos el orden en el que tiene que introducir la info
        try(FileWriter fw = new FileWriter (info,true)){
            System.out.println("Imtroduce los siguientes datos: Restaurant,Address,City,State,Zipcode");
            info = sc.nextLine();
            fw.write(info);
        }    
    }
    public static void copia(){
    
    }
    public static void suprimir(){
        File fichero = new File("Restaurants.csv");
        //borramos el fichero
        if (fichero.delete()){   
        System.out.println("El fichero ha sido borrado correctamente");
        }
        //si no existe el fichero, no lo puede borrar 
        else{
        System.out.println("El fichero no existe");
        }
    }
    
 public static void main(String[] args) throws IOException{
     menu();
 }
}
