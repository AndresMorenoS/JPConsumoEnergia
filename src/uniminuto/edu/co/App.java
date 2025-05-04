package uniminuto.edu.co;

import org.w3c.dom.ls.LSOutput;
import uniminuto.edu.co.controller.ConsumptionE;
import uniminuto.edu.co.views.Console;
import uniminuto.edu.co.models.Consumption;

public class App {
    public static void main(String[] args) {
        // Crear una instancia de la consola para entrada/salida
        Console console = new Console(); //

        // Crear una instancia del controlador principal, pasando la consola
        ConsumptionE controller = new ConsumptionE(console); //

        int opcion = -1;
        while (opcion != 0) {
            console.printMessage("\n--- Menú Principal ---");
            console.printMessage("1. Crear Cliente");
            console.printMessage("2. Editar Cliente");
            console.printMessage("3. Crear Contador");
            console.printMessage("4. Editar Contador");
            console.printMessage("5. Cargar Consumos del Mes");
            console.printMessage("0. Salir");
            console.printMessage("Seleccione una opción:");

            try {
                opcion = console.readInt(); //

                switch (opcion) {
                    case 1:
                        controller.CrearCliente(); //
                        break;
                    case 2:
                        controller.editarCliente(); //
                        break;
                    case 3:
                        controller.crearContador(); //
                        break;
                    case 4:
                        controller.editarContador(); //
                        break;
                    case 5:
                        controller.cargarConsumosMes(); //
                        break;
                    case 0:
                        console.printMessage("Saliendo...");
                        break;
                    default:
                        console.printMessage("Opción no válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                console.printMessage("Error: Por favor ingrese un número válido.");
            } catch (Exception e) {
                console.printMessage("Ocurrió un error inesperado: " + e.getMessage());
            }
        int daysMonth = 30;
        int hoursDay = 24;
        Consumption consumClient = new Consumption(daysMonth ,hoursDay){
        consumClient.setIdCounter("001");
        //Simulate some consumption (day, hour, kWh)
        consumClient.mRecordConsumption(1, 5, 150);
        consumClient.mRecordConsumption(10, 10, 450);
        consumClient.mRecordConsumption(10, 20, 800);

        System.out.printMessage("Consumo Dia 1, 5am: "+ consumClient.mGetConsumptionByqDayandHour(1, 5)+" kwh");
            };
        }
        console.destroy(); //

    }
}