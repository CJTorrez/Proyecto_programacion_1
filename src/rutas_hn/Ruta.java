/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rutas_hn;

/**
 *
 * @author javier
 */
public class Ruta {
    String nombre;
    String origen;
    String destino;
    String[] paradasIntermedias;
    double distancia;
    int tiempoEstimado;

    public Ruta(String nombre, String origen, String destino,
            String[] paradasIntermedias, double distancia, int tiempoEstimado) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.paradasIntermedias = paradasIntermedias;
        this.distancia = distancia;
        this.tiempoEstimado = tiempoEstimado;
    }
    
}
