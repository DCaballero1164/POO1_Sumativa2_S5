package cl.salmontt.ui;

import cl.salmontt.data.GestorDatos;
import cl.salmontt.model.CentroCultivo;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal de la aplicación SalmonttApp.
 * <p>
 * Esta clase orquesta la lógica del programa, incluyendo la creación de
 * datos iniciales, la escritura de estos datos en el archivo CSV a través
 * del {@code GestorDatos}, la lectura posterior y el filtrado de la información.
 * </p>
 * @author [Daniel Caballero Salas]
 * @version 1.0
 */
public class Main {
    private Main(){} // <- solo para arreglar el formato de Javadoc
    public static void main(String[] args) {
        /**
         * Metodo principal que se ejecuta al iniciar la aplicación.
         * <p>
         * Se encarga de:
         * 1. Inicializar una lista de {@code CentroCultivo} con datos de prueba.
         * 2. Llamar a {@code GestorDatos} para guardar la lista en un archivo CSV.
         * 3. Llamar a {@code GestorDatos} para cargar los datos desde el archivo.
         * 4. Mostrar todos los centros
         * 5. Filtrar y mostrar los centros con una producción superior a 1000 toneladas.
         * </p>
         * @param args Argumentos de la línea de comandos (no utilizados en este caso).
         */

        //Se rear una lista vacia que guardará los centros de cultivo
        List<CentroCultivo> ListadoCentros = new ArrayList<>();

        //En la lista agregar cada producto con el contructor de la clase CentroCultivo
        ListadoCentros.add(new CentroCultivo("Isla Huar","Calbuco",1200));
        ListadoCentros.add(new CentroCultivo("Isla Puluqui","Calbuco",700));
        ListadoCentros.add(new CentroCultivo("Canal Tenglo","Puerto Montt",1350));
        ListadoCentros.add(new CentroCultivo("Bahía Ilque","Puerto Varas",1620));
        ListadoCentros.add(new CentroCultivo("Canal Dalcahue","Dalcahue",880));

        //Se crea el archivo con el nombre:
        String nombreArchivo = "centros.csv";

        //Se llama al metodo agregarDatos en GestorDatos
        GestorDatos gd = new GestorDatos();

        //Se scriben en el archivo .CSV los datos ingresados en ListadCentros
        gd.agregarDatos(ListadoCentros, nombreArchivo);

        //------------------------------------------------------------------

        //Cargar datos desde archivo .CSV

        //Lista que almacena los centros obtenidos de GestorDatos como objeto
        ArrayList<CentroCultivo> centros = gd.cargarCentros();

        //Se extraen los datos
        System.out.println("\n...::: Todos los centros :::...");
        centros.forEach(System.out::println);

        // Filtro para toneladas > 1000

        //Lista que almacena los centros con produccion mayor a 1000 toneladas
        //List<CentroCultivo> mayoresA1000 = new ArrayList<>();

        //Se muestran los resultados filtrados
        System.out.println("\n...::: Centros con producción > 1000 toneladas :::...");
        centros.stream()
                .filter(centro -> centro.getToneladas() > 1000)
                .forEach(System.out::println);
        //Se recorren los centros
        //centros.forEach(System.out::println);
        //    if (c.getToneladas() > 1000) {

        //Se agregan al ArrayList mayoresA1000
        //        mayoresA1000.add(c);




    }

}