/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rutas_hn;

import java.util.Scanner;

/**
 *
 * @author javier
 */
public class Rutas_HN {

    /**
     * @param args the command line arguments
     */
    
     static Ruta[] rutas = new Ruta[5];
     static Bus[] buses = new Bus[5];
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        cargarDatos();
        int opcion;
        
         do {
            System.out.println("\n===== RUTABUS =====");
            System.out.println("1. Consultar rutas");
            System.out.println("2. Buscar ruta por zona");
            System.out.println("3. Buscar ruta por destino");
            System.out.println("4. Ver buses por ruta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    consultarRutas();
                    break;
                case 2:
                    buscarPorZona();
                    break;
                case 3:
                    buscarPorDestino();
                    break;
                case 4:
                    verBusesPorRuta();
                    break;
                case 5:
                    System.out.println("Gracias por usar Rutas HN.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 5);   
    } // fina main
    
    
     public static void cargarDatos() {
        rutas[0] = new Ruta("Ruta 1", "Centro", "UNAH-VS", "Centro", "Centro - Mercado - UNAH-VS");
        rutas[1] = new Ruta("Ruta 2", "Terminal", "Megaplaza", "Circunvalacion", "Terminal - Circunvalacion - Megaplaza");
        rutas[2] = new Ruta("Ruta 3", "Medina", "Hospital Mario Catarino", "Medina", "Medina - Centro - Hospital");

        buses[0] = new Bus("Bus 101", "Ruta 1");
        buses[1] = new Bus("Bus 102", "Ruta 1");
        buses[2] = new Bus("Bus 201", "Ruta 2");
        buses[3] = new Bus("Bus 301", "Ruta 3");
    }
    
     public static void consultarRutas() {
        System.out.println("\n--- RUTAS DISPONIBLES ---");

        for (int i = 0; i < rutas.length; i++) {
            if (rutas[i] != null) {
                System.out.println("Ruta: " + rutas[i].nombre);
                System.out.println("Origen: " + rutas[i].origen);
                System.out.println("Destino: " + rutas[i].destino);
                System.out.println("Zona: " + rutas[i].zona);
                System.out.println("Recorrido: " + rutas[i].recorrido);
                System.out.println("------------------------");
            }
        }
    }
     
     public static void buscarPorZona() {
         Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la zona: ");
        String zona = sc.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < rutas.length; i++) {
            if (rutas[i] != null && rutas[i].zona.equalsIgnoreCase(zona)) {
                System.out.println("Ruta encontrada: " + rutas[i].nombre);
                System.out.println("Recorrido: " + rutas[i].recorrido);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron rutas en esa zona.");
        }
    }
    
     
    public static void buscarPorDestino() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el destino: ");
        String destino = sc.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < rutas.length; i++) {
            if (rutas[i] != null && rutas[i].destino.equalsIgnoreCase(destino)) {
                System.out.println("Ruta encontrada: " + rutas[i].nombre);
                System.out.println("Origen: " + rutas[i].origen);
                System.out.println("Recorrido: " + rutas[i].recorrido);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron rutas hacia ese destino.");
        }
    }
    
    public static void verBusesPorRuta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la ruta: ");
        String ruta = sc.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < buses.length; i++) {
            if (buses[i] != null && buses[i].ruta.equalsIgnoreCase(ruta)) {
                System.out.println("Bus disponible: " + buses[i].numeroBus);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay buses registrados para esa ruta.");
        }
    }
     
    
    
} // final class
