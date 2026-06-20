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
    static Scanner scan = new Scanner(System.in);
    static Ruta[] rutas = new Ruta[5];
    static Bus[] buses = new Bus[5];

    public static void main(String[] args) {
        cargarDatos();
        int opcion = 0;

        do {
            mostrarMenuGeneral();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    verCatalogoYDetalles();
                    break;
                case 2:
                    buscarPorInicio();
                    break;
                case 3:
                    buscarPorDestino();
                    break;
                case 4:
                    buscarPorNombre();
                    break;
                case 5:
                    buscarPorUbicacion();
                    break;
                case 6:
                    System.out.println("Gracias por usar Rutas HN.");
                    break;
                default:
                    System.out.println("Opcion invalida. Seleccione un numero del 1 al 6.");
            }
        } while (opcion != 6);
    }//Fin de Main

    /**
     * Muestra todas las opciones disponibles para el usuario general.
     */
    public static void mostrarMenuGeneral() {
        System.out.println("\n================================");
        System.out.println("          RUTAS HN");
        System.out.println("================================");
        System.out.println("1. Ver catalogo y detalles de rutas");
        System.out.println("2. Buscar rutas por punto de inicio");
        System.out.println("3. Buscar rutas por punto de destino");
        System.out.println("4. Buscar rutas por nombre");
        System.out.println("5. Buscar rutas por ubicacion");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
    }//Fin de Funcion mostrarMenuGeneral

    /**
     * Lee la opcion del menu y evita que el programa se cierre si el usuario
     * escribe letras en lugar de un numero.
     */
    public static int leerOpcion() {
        int opcionTemporal = 0;
        String captura = scan.nextLine();

        try {
            opcionTemporal = Integer.parseInt(captura);
        } catch (NumberFormatException error) {
            opcionTemporal = 0;
        }

        return opcionTemporal;
    }//Fin de Funcion leerOpcion

    /**
     * Carga la informacion inicial de las rutas y sus paradas intermedias.
     */
    public static void cargarDatos() {
        String[] paradasRuta1 = {"Mercado Central", "Barrio Paz Barahona", "Hospital del Norte"};
        String[] paradasRuta2 = {"Circunvalacion", "Universidad Privada", "Mall Galerias"};
        String[] paradasRuta3 = {"Centro", "Barrio Cabanas", "Hospital Leonardo Martinez"};
        String[] paradasRuta4 = {"Monumento a la Madre", "Rio de Piedras", "Trejo"};
        String[] paradasRuta5 = {"Terminal Metropolitana", "Lopez Arellano", "Chamelecon"};

        rutas[0] = new Ruta("Ruta 1", "Centro", "UNAH-VS",
                paradasRuta1, 12.5, 45);
        rutas[1] = new Ruta("Ruta 2", "Terminal", "Megaplaza",
                paradasRuta2, 10.8, 35);
        rutas[2] = new Ruta("Ruta 3", "Medina", "Hospital Mario Catarino",
                paradasRuta3, 8.4, 30);
        rutas[3] = new Ruta("Ruta 4", "Parque Central", "Universidad Catolica",
                paradasRuta4, 9.7, 40);
        rutas[4] = new Ruta("Ruta 5", "Gran Central Metropolitana", "La Lima",
                paradasRuta5, 18.2, 60);

        buses[0] = new Bus("Bus 101", "Ruta 1");
        buses[1] = new Bus("Bus 102", "Ruta 1");
        buses[2] = new Bus("Bus 201", "Ruta 2");
        buses[3] = new Bus("Bus 301", "Ruta 3");
        buses[4] = new Bus("Bus 401", "Ruta 4");
    }//Fin de Funcion cargarDatos

    /**
     * Busca todas las rutas que comienzan en el lugar ingresado.
     */
    public static void buscarPorInicio() {
        int opcion = 0;

        do {
            System.out.println("\n===== BUSQUEDA POR PUNTO DE INICIO =====");
            System.out.print("Ingrese el punto de inicio: ");
            String inicioBuscado = scan.nextLine();

            boolean encontrado = false;

            for (int i = 0; i < rutas.length; i++) {
                if (rutas[i] != null
                        && rutas[i].origen.equalsIgnoreCase(inicioBuscado)) {
                    mostrarResumenRuta(rutas[i]);
                    encontrado = true;
                }
            }//Fin de Ciclo For

            if (!encontrado) {
                System.out.println("No se encontraron rutas con ese punto de inicio.");
            }

            opcion = menuRepetirBusqueda();
        } while (opcion != 2);
    }//Fin de Funcion buscarPorInicio

    /**
     * Busca todas las rutas que terminan en el destino ingresado.
     */
    public static void buscarPorDestino() {
        int opcion = 0;

        do {
            System.out.println("\n===== BUSQUEDA POR PUNTO DE DESTINO =====");
            System.out.print("Ingrese el punto de destino: ");
            String destinoBuscado = scan.nextLine();

            boolean encontrado = false;

            for (int i = 0; i < rutas.length; i++) {
                if (rutas[i] != null
                        && rutas[i].destino.equalsIgnoreCase(destinoBuscado)) {
                    mostrarResumenRuta(rutas[i]);
                    encontrado = true;
                }
            }//Fin de Ciclo For

            if (!encontrado) {
                System.out.println("No se encontraron rutas hacia ese destino.");
            }

            opcion = menuRepetirBusqueda();
        } while (opcion != 2);
    }//Fin de Funcion buscarPorDestino

    /**
     * Busca una ruta utilizando su nombre.
     */
    public static void buscarPorNombre() {
        int opcion = 0;

        do {
            System.out.println("\n===== BUSQUEDA POR NOMBRE =====");
            System.out.print("Ingrese el nombre de la ruta: ");
            String nombreBuscado = scan.nextLine();

            boolean encontrado = false;

            for (int i = 0; i < rutas.length; i++) {
                if (rutas[i] != null
                        && rutas[i].nombre.equalsIgnoreCase(nombreBuscado)) {
                    mostrarResumenRuta(rutas[i]);
                    encontrado = true;
                }
            }//Fin de Ciclo For

            if (!encontrado) {
                System.out.println("No existe una ruta registrada con ese nombre.");
            }

            opcion = menuRepetirBusqueda();
        } while (opcion != 2);
    }//Fin de Funcion buscarPorNombre

    /**
     * Busca rutas que pasan por un origen, destino o parada intermedia.
     */
    public static void buscarPorUbicacion() {
        int opcion = 0;

        do {
            System.out.println("\n===== RUTAS QUE PASAN POR UNA UBICACION =====");
            System.out.print("Ingrese la ubicacion que desea buscar: ");
            String ubicacionBuscada = scan.nextLine();

            boolean encontrado = false;

            for (int i = 0; i < rutas.length; i++) {
                if (rutas[i] != null
                        && rutaPasaPorUbicacion(rutas[i], ubicacionBuscada)) {
                    mostrarRecorridoRuta(rutas[i], ubicacionBuscada);
                    encontrado = true;
                }
            }//Fin de Ciclo For

            if (!encontrado) {
                System.out.println("Ninguna ruta pasa por la ubicacion ingresada.");
            }

            opcion = menuRepetirBusqueda();
        } while (opcion != 2);
    }//Fin de Funcion buscarPorUbicacion

    /**
     * Comprueba si una ubicacion pertenece al recorrido de una ruta.
     */
    public static boolean rutaPasaPorUbicacion(Ruta ruta, String ubicacion) {
        if (ruta.origen.equalsIgnoreCase(ubicacion)
                || ruta.destino.equalsIgnoreCase(ubicacion)) {
            return true;
        }

        for (int i = 0; i < ruta.paradasIntermedias.length; i++) {
            if (ruta.paradasIntermedias[i].equalsIgnoreCase(ubicacion)) {
                return true;
            }
        }//Fin de Ciclo For

        return false;
    }//Fin de Funcion rutaPasaPorUbicacion

    /**
     * Muestra las rutas disponibles y permite seleccionar una para ver
     * toda su informacion.
     */
    public static void verCatalogoYDetalles() {
        int opcion = 0;

        do {
            System.out.println("\n========== CATALOGO DE RUTAS ==========");

            for (int i = 0; i < rutas.length; i++) {
                if (rutas[i] != null) {
                    System.out.printf("%d. %s - %s a %s%n",
                            i + 1,
                            rutas[i].nombre,
                            rutas[i].origen,
                            rutas[i].destino);
                }
            }//Fin de Ciclo For

            System.out.println("0. Regresar al menu general");
            System.out.print("Ingrese el numero de la ruta que desea ver o ingrese 0 para regresar al menu anterior: ");
            opcion = leerOpcion();

            if (opcion >= 1 && opcion <= rutas.length
                    && rutas[opcion - 1] != null) {
                mostrarDetalles(rutas[opcion - 1]);
                regresarDetalles();
            } else if (opcion != 0) {
                System.out.println("La ruta seleccionada no existe.");
            }
        } while (opcion != 0);
    }//Fin de Funcion verCatalogoYDetalles

    /**
     * Presenta las opciones para repetir una busqueda o volver al menu.
     */
    public static int menuRepetirBusqueda() {
        int opcion = 0;

        do {
            System.out.println("\nOpciones disponibles:");
            System.out.println("1. Realizar otra busqueda");
            System.out.println("2. Regresar al menu general");
            System.out.print("Seleccione una opcion: ");
            opcion = leerOpcion();

            if (opcion != 1 && opcion != 2) {
                System.out.println("Opcion invalida.");
            }
        } while (opcion != 1 && opcion != 2);

        return opcion;
    }//Fin de Funcion menuRepetirBusqueda

    /**
     * Mantiene los detalles en pantalla hasta que el usuario quiera volver
     * al listado de rutas.
     */
    public static void regresarDetalles() {
        int opcion = 0;

        do {
            System.out.println("\nOpciones disponibles:");
            System.out.println("1. Regresar al listado de rutas");
            System.out.print("Seleccione una opcion: ");
            opcion = leerOpcion();

            if (opcion != 1) {
                System.out.println("Opcion invalida.");
            }
        } while (opcion != 1);
    }//Fin de Funcion regresarDetalles

    /**
     * Imprime la informacion resumida de una ruta encontrada.
     */
    public static void mostrarResumenRuta(Ruta ruta) {
        System.out.println("\nRuta encontrada: " + ruta.nombre);
        System.out.println("Inicio: " + ruta.origen);
        System.out.println("Destino: " + ruta.destino);
        System.out.println("---------------------------------------");
    }//Fin de Funcion mostrarResumenRuta

    /**
     * Muestra el recorrido completo de una ruta que pasa por la ubicacion
     * ingresada por el usuario.
     */
    public static void mostrarRecorridoRuta(Ruta ruta, String ubicacionBuscada) {
        System.out.println("\nRuta encontrada: " + ruta.nombre);
        System.out.println("La ruta pasa por: " + ubicacionBuscada);
        System.out.println("Recorrido completo:");
        System.out.println("  Inicio: " + ruta.origen);

        for (int i = 0; i < ruta.paradasIntermedias.length; i++) {
            System.out.printf("  Parada %d: %s%n",
                    i + 1, ruta.paradasIntermedias[i]);
        }//Fin de Ciclo For

        System.out.println("  Destino: " + ruta.destino);
        System.out.println("---------------------------------------");
    }//Fin de Funcion mostrarRecorridoRuta

    /**
     * Imprime todos los datos y las paradas intermedias de una ruta.
     */
    public static void mostrarDetalles(Ruta ruta) {
        System.out.println("\n========== DETALLES DE LA RUTA ==========");
        System.out.println("Nombre: " + ruta.nombre);
        System.out.println("Inicio: " + ruta.origen);
        System.out.println("Destino: " + ruta.destino);
        System.out.println("Paradas intermedias:");

        for (int i = 0; i < ruta.paradasIntermedias.length; i++) {
            System.out.printf("  %d. %s%n", i + 1, ruta.paradasIntermedias[i]);
        }//Fin de Ciclo For

        System.out.printf("Distancia: %.2f kilometros%n", ruta.distancia);
        System.out.printf("Tiempo estimado: %d minutos%n", ruta.tiempoEstimado);
        System.out.println("==========================================");
    }//Fin de Funcion mostrarDetalles

}//Fin de Class
