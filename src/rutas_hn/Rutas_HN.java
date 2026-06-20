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
    static Ruta[] rutas = new Ruta[20];
    static Bus[] buses = new Bus[5];
    static final String USUARIO_ADMIN = "admin";
    static final String CLAVE_ADMIN = "1234";

    public static void main(String[] args) {
        cargarDatos();
        int opcion = 0;

        do {
            limpiarPantalla();
            mostrarMenuGeneral();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    verCatalogoYDetalles();
                    break;
                case 2:
                    limpiarPantalla();
                    buscarPorInicio();
                    break;
                case 3:
                    limpiarPantalla();
                    buscarPorDestino();
                    break;
                case 4:
                    limpiarPantalla();
                    buscarPorNombre();
                    break;
                case 5:
                    limpiarPantalla();
                    buscarPorUbicacion();
                    break;
                case 6:
                    limpiarPantalla();
                    iniciarSesionAdministrador();
                    break;
                case 7:
                    System.out.println("Gracias por usar Rutas HN.");
                    break;
                default:
                    System.out.println("Opcion invalida. Seleccione un numero del 1 al 7.");
            }
        } while (opcion != 7);
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
        System.out.println("6. Administrador");
        System.out.println("7. Salir");
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
            limpiarPantalla();
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
            limpiarPantalla();
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
            limpiarPantalla();
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
            limpiarPantalla();
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
            limpiarPantalla();
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
                limpiarPantalla();
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
     * Solicita las credenciales del administrador. El usuario tiene un maximo
     * de tres intentos antes de regresar al menu general.
     */
    public static void iniciarSesionAdministrador() {
        int intentos = 0;
        boolean accesoPermitido = false;

        while (intentos < 3 && !accesoPermitido) {
            System.out.println("\n========== ACCESO ADMINISTRADOR ==========");
            System.out.print("Usuario: ");
            String usuario = scan.nextLine();
            System.out.print("Contrasenia: ");
            String clave = scan.nextLine();

            if (usuario.equals(USUARIO_ADMIN)
                    && clave.equals(CLAVE_ADMIN)) {
                accesoPermitido = true;
                System.out.println("Acceso concedido.");
            } else {
                intentos++;
                System.out.println("Usuario o contrasenia incorrectos.");
                System.out.printf("Intentos disponibles: %d%n", 3 - intentos);
            }
        }//Fin de Ciclo While

        if (accesoPermitido) {
            menuAdministrador();
        } else {
            System.out.println("Se agotaron los intentos permitidos.");
            pausarPantalla();
        }
    }//Fin de Funcion iniciarSesionAdministrador

    /**
     * Muestra las operaciones que puede realizar el administrador.
     */
    public static void menuAdministrador() {
        int opcion = 0;

        do {
            limpiarPantalla();
            System.out.println("\n================================");
            System.out.println("      MENU ADMINISTRADOR");
            System.out.println("================================");
            System.out.println("1. Listar rutas");
            System.out.println("2. Crear una ruta");
            System.out.println("3. Modificar una ruta");
            System.out.println("4. Eliminar una ruta");
            System.out.println("5. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    listarRutasAdministrador();
                    pausarPantalla();
                    break;
                case 2:
                    limpiarPantalla();
                    crearRuta();
                    pausarPantalla();
                    break;
                case 3:
                    limpiarPantalla();
                    modificarRuta();
                    pausarPantalla();
                    break;
                case 4:
                    limpiarPantalla();
                    eliminarRuta();
                    pausarPantalla();
                    break;
                case 5:
                    System.out.println("Sesion de administrador cerrada.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    pausarPantalla();
            }
        } while (opcion != 5);
    }//Fin de Funcion menuAdministrador

    /**
     * Muestra las rutas con el numero utilizado para modificarlas o eliminarlas.
     */
    public static void listarRutasAdministrador() {
        System.out.println("\n========== RUTAS REGISTRADAS ==========");

        for (int i = 0; i < rutas.length; i++) {
            if (rutas[i] != null) {
                System.out.printf("%d. %s - %s a %s%n",
                        i + 1,
                        rutas[i].nombre,
                        rutas[i].origen,
                        rutas[i].destino);
            }
        }//Fin de Ciclo For
    }//Fin de Funcion listarRutasAdministrador

    /**
     * Captura todos los datos y registra una ruta en el primer espacio libre.
     */
    public static void crearRuta() {
        int posicionLibre = buscarPosicionLibre();

        if (posicionLibre == -1) {
            System.out.println("No hay espacio disponible para registrar otra ruta.");
            return;
        }

        System.out.println("\n========== CREAR RUTA ==========");
        System.out.print("Nombre de la ruta: ");
        String nombre = scan.nextLine();

        if (buscarIndicePorNombre(nombre) != -1) {
            System.out.println("Ya existe una ruta registrada con ese nombre.");
            return;
        }

        System.out.print("Punto de inicio: ");
        String origen = scan.nextLine();
        System.out.print("Punto de destino: ");
        String destino = scan.nextLine();
        String[] paradas = capturarParadas();
        double distancia = leerDoublePositivo("Distancia en kilometros: ");
        int tiempo = leerEnteroPositivo("Tiempo estimado en minutos: ");

        rutas[posicionLibre] = new Ruta(nombre, origen, destino,
                paradas, distancia, tiempo);

        System.out.println("Ruta creada correctamente.");
    }//Fin de Funcion crearRuta

    /**
     * Sustituye la informacion de una ruta seleccionada por el administrador.
     */
    public static void modificarRuta() {
        listarRutasAdministrador();
        System.out.print("\nSeleccione el numero de la ruta a modificar: ");
        int posicion = leerOpcion() - 1;

        if (posicion < 0 || posicion >= rutas.length
                || rutas[posicion] == null) {
            System.out.println("La ruta seleccionada no existe.");
            return;
        }

        System.out.println("\nDatos actuales:");
        mostrarDetalles(rutas[posicion]);
        System.out.println("\nIngrese los nuevos datos:");
        System.out.print("Nombre de la ruta: ");
        String nombre = scan.nextLine();

        int posicionNombre = buscarIndicePorNombre(nombre);

        if (posicionNombre != -1 && posicionNombre != posicion) {
            System.out.println("Ya existe otra ruta registrada con ese nombre.");
            return;
        }

        System.out.print("Punto de inicio: ");
        String origen = scan.nextLine();
        System.out.print("Punto de destino: ");
        String destino = scan.nextLine();
        String[] paradas = capturarParadas();
        double distancia = leerDoublePositivo("Distancia en kilometros: ");
        int tiempo = leerEnteroPositivo("Tiempo estimado en minutos: ");

        rutas[posicion] = new Ruta(nombre, origen, destino,
                paradas, distancia, tiempo);

        System.out.println("Ruta modificada correctamente.");
    }//Fin de Funcion modificarRuta

    /**
     * Elimina una ruta despues de solicitar confirmacion.
     */
    public static void eliminarRuta() {
        listarRutasAdministrador();
        System.out.print("\nSeleccione el numero de la ruta a eliminar: ");
        int posicion = leerOpcion() - 1;

        if (posicion < 0 || posicion >= rutas.length
                || rutas[posicion] == null) {
            System.out.println("La ruta seleccionada no existe.");
            return;
        }

        System.out.printf("Desea eliminar %s?%n", rutas[posicion].nombre);
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Seleccione una opcion: ");
        int confirmacion = leerOpcion();

        if (confirmacion == 1) {
            for (int i = posicion; i < rutas.length - 1; i++) {
                rutas[i] = rutas[i + 1];
            }//Fin de Ciclo For

            rutas[rutas.length - 1] = null;
            System.out.println("Ruta eliminada correctamente.");
        } else {
            System.out.println("La ruta no fue eliminada.");
        }
    }//Fin de Funcion eliminarRuta

    /**
     * Captura las paradas intermedias que pertenecen a una ruta.
     */
    public static String[] capturarParadas() {
        int cantidad = 0;

        do {
            cantidad = leerEnteroPositivo(
                    "Cantidad de paradas intermedias (maximo 10): ");

            if (cantidad > 10) {
                System.out.println("Solo se permiten hasta 10 paradas.");
            }
        } while (cantidad > 10);

        String[] paradas = new String[cantidad];

        for (int i = 0; i < paradas.length; i++) {
            System.out.printf("Nombre de la parada %d: ", i + 1);
            paradas[i] = scan.nextLine();
        }//Fin de Ciclo For

        return paradas;
    }//Fin de Funcion capturarParadas

    /**
     * Busca el primer espacio disponible dentro del arreglo de rutas.
     */
    public static int buscarPosicionLibre() {
        for (int i = 0; i < rutas.length; i++) {
            if (rutas[i] == null) {
                return i;
            }
        }//Fin de Ciclo For

        return -1;
    }//Fin de Funcion buscarPosicionLibre

    /**
     * Busca una ruta por su nombre y devuelve su posicion.
     */
    public static int buscarIndicePorNombre(String nombre) {
        for (int i = 0; i < rutas.length; i++) {
            if (rutas[i] != null
                    && rutas[i].nombre.equalsIgnoreCase(nombre)) {
                return i;
            }
        }//Fin de Ciclo For

        return -1;
    }//Fin de Funcion buscarIndicePorNombre

    /**
     * Lee un numero entero mayor que cero.
     */
    public static int leerEnteroPositivo(String mensaje) {
        int numero = 0;

        do {
            System.out.print(mensaje);
            numero = leerOpcion();

            if (numero <= 0) {
                System.out.println("Debe ingresar un numero mayor que cero.");
            }
        } while (numero <= 0);

        return numero;
    }//Fin de Funcion leerEnteroPositivo

    /**
     * Lee un numero decimal mayor que cero.
     */
    public static double leerDoublePositivo(String mensaje) {
        double numero = 0;
        boolean datoValido = false;

        do {
            System.out.print(mensaje);
            String captura = scan.nextLine();

            try {
                numero = Double.parseDouble(captura);
                datoValido = numero > 0;
            } catch (NumberFormatException error) {
                datoValido = false;
            }

            if (!datoValido) {
                System.out.println("Debe ingresar un numero mayor que cero.");
            }
        } while (!datoValido);

        return numero;
    }//Fin de Funcion leerDoublePositivo

    /**
     * Espera una confirmacion para continuar a la siguiente pantalla.
     */
    public static void pausarPantalla() {
        System.out.println("\nPresione ENTER para continuar...");
        scan.nextLine();
    }//Fin de Funcion pausarPantalla

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

    /**
     * Limpia visualmente la consola para que cada menu aparezca separado.
     * Se utilizan saltos de linea para que funcione en la consola de NetBeans.
     */
    public static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }//Fin de Ciclo For
    }//Fin de Funcion limpiarPantalla

}//Fin de Class
