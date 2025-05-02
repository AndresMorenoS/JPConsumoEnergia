package uniminuto.edu.co.controller;

import uniminuto.edu.co.models.*;
import uniminuto.edu.co.views.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.InputMismatchException;
import java.time.YearMonth;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Random;
public class ConsumptionE {

    private Console console;
    private List<Client> clients;
    private List<Consumption> consumptions;

    public ConsumptionE(Console console) {
        this.console = console;
        this.clients = new ArrayList<>();
        this.consumptions = new ArrayList<>();
    }

    //Crear cliente

    public void CrearCliente(){
        console.printMessage("Crear nuevo cliente");
        try{
            console.printMessage("Ingrese el ID del cliente");
            String clientId = console.readString();
            if (mBuscarClientePorId(clientId).isPresent()) {
                console.printMessage("Ya existe un cliente con ese ID");
                return;
            }
            console.printMessage("Ingrese el nombre del cliente");
            String nombre = console.readString();
            console.printMessage("Ingrese el correo del cliente");
            String email = console.readString();
            console.printMessage("Ingrese la direccion del cliente");
            String direccion = console.readString();
            Identifiers tipoDocumento = docselect();
            if (tipoDocumento == null){
                return;
            }

            console.printMessage("Datos del primer contador");
            console.printMessage("Ingrese ID del contador");
            String contadorId = console.readString();
            console.printMessage("Ingrese la direccion del contador");
            String contadorDireccion = console.readString();
            console.printMessage("Ingrese ciudad del contador");
            String contadorCiudad = console.readString();


            //Crear primer contador
            Counter primerContador = new Counter(contadorId, contadorDireccion, contadorCiudad, null);

            //Crear Cliente
            Client nuevoCliente = new Client(clientId, nombre, email, direccion, tipoDocumento, primerContador);

            //Agregar cliene a la lista
            this.clients.add(nuevoCliente);
            console.printMessage("Cliente creado exitosamente.");
        } catch (Exception e){
            console.printMessage("Error al crear cliente: " + e.getMessage());
        }
    }

// Auxiliar para seleccionar identidad
    private Identifiers docselect() {
        console.printMessage("Seleccione el tipo de documento");
        int i = 1;
        for (Identifiers id : Identifiers.values()){
            console.printMessage(i + "." + id);
            i++;
        }
        try {
            int opcion = console.readInt();
            if (opcion > 0 && opcion <= Identifiers.values().length){
                return Identifiers.values()[opcion - 1]; //Retorna el enum seleccionado
            } else {
                console.printMessage("Opcion invalida.");
                return  null;
            }
        } catch (NumberFormatException e){
            console.printMessage("Error, por facor ingrese un numero valido");
            return  null;
        } catch (InputMismatchException e){
            console.printMessage("Error, entrada invalida");
            return null;
        }
    }

    // Metodo auxiliar para buscar cliente
    public Optional<Client> mBuscarClientePorId(String id){
        for (Client cliente : this.clients){
            if (cliente.getId().equalsIgnoreCase(id)){
                return Optional.of(cliente);
            }
        }
        return Optional.empty(); // Cliente no existe
    }



    // EDITAR CLIENTE

    public  void editarCliente(){
        console.printMessage("Editar Cliente");
        console.printMessage("Ingrese el ID del cliente del cual desea modificar sus datos");
        String idCliente = console.readString();

        //Usa el metodo auxiliar para buscar al cliente
        Optional<Client> optionalClient = mBuscarClientePorId(idCliente);

        //Verifica si fue encontrado
        if (optionalClient.isPresent()){
            //Obtiene el objeto client si se encuentra
            Client clientAEditar = optionalClient.get();
            console.printMessage("Cliente encontrado: " + clientAEditar.getName() + " (ID) " + clientAEditar.getId() + ")");
            console.printMessage("Ingrese los nuevos datos, si no quiere cambiar nada, deje en blanco.");

            try{
                // Nuevo nombre
                console.printMessage("Nuevo nombre [" + clientAEditar.getName() + "]");
                String nuevoNombre = console.readString();
                if (!nuevoNombre.isBlank()){
                    clientAEditar.setName(nuevoNombre);
                    console.printMessage("Nombre actualizado");
                }

                // Nuevo Correo
                console.printMessage("Nuevo correo [" + clientAEditar.getEmail() + "]");
                String nuevoEmail = console.readString();
                if (!nuevoEmail.isBlank()){
                    clientAEditar.setEmail(nuevoEmail);
                    console.printMessage("Correo actualizado");
                }

                // Nueva direccion
                console.printMessage("Nueva direccion [" + clientAEditar.getAddress() + "]");
                String nuevaDireccion = console.readString();
                if (!nuevaDireccion.isBlank()){
                    clientAEditar.setAddress(nuevaDireccion);
                    console.printMessage("Direccion actualizada");
                }
                console.printMessage("Cliente ACTUALIZADO");
            }  catch (Exception e){
                console.printMessage("Error al actualizar" + e.getMessage());
            }
        } else {
            //Si no encontro cliente
            console.printMessage("No se encontro cliente, verifique el ID" + idCliente + ".");
        }
    }



    // Crear contador o registrador
    public void crearContador(){
        console.printMessage("Crear nuevo contador");
        console.printMessage("Ingrese el ID del cliente al que desea agregar el contador");
        String idCliente = console.readString();

        //Busca el cliente
        Optional<Client> optionalCliente = mBuscarClientePorId(idCliente);
        if (optionalCliente.isPresent()){
            Client clienteExistente = optionalCliente.get();
            console.printMessage("Cliente encontrado: " + clienteExistente.getName());

            try {
                console.printMessage("Ingrese el ID para el nuevo contador");
                String nuevoContadorId = console.readString();
                console.printMessage("Ingrese la nueva direccion del contador");
                String nuevoContadorDireccion = console.readString();
                console.printMessage("Ingrese la nueva ciudad del contador");
                String nuevoContadorCiudad = console.readString();

                // Objeto Counter
                Counter nuevoContador = new Counter(nuevoContadorId, nuevoContadorDireccion, nuevoContadorCiudad, null);

                // Agregar el contador a la lista del cliente
                clienteExistente.getCounters().add(nuevoContador);
                console.printMessage("Contador agregado al cliente " + clienteExistente.getName());
            } catch (Exception e) {
                console.printMessage("Error al crear contador: " + e.getMessage());
            }
        } else {
            //Cliente no encontrado
            console.printMessage("Error: No se encontro ningun cliente con ese ID" + idCliente);
        }

    }

    // Editar registrador
    public void  editarContador(){
        console.printMessage("Editar contador");
        console.printMessage("Ingrese el ID del cliente dueño del contador");
        String idCliente = console.readString();

        //Busca el cliente
        Optional<Client> optionalCliente = mBuscarClientePorId(idCliente);
        if (optionalCliente.isPresent()){
            Client clienteEncontrado = optionalCliente.get();
            console.printMessage("Cliente encontrado: " + clienteEncontrado.getName());
            console.printMessage("Ingrese el ID del contador que desea modificar");
            String idContador = console.readString();

            Optional<Counter> optionalCounter = Optional.empty();
            for (Counter c : clienteEncontrado.getCounters()){
                if (c.getId().equalsIgnoreCase(idContador)){
                    optionalCounter = Optional.of(c);
                    break;
                }
            }
            if (optionalCounter.isPresent()){
                Counter contadorAEditar = optionalCounter.get();
                console.printMessage("Contador encontrado ID:  " + contadorAEditar.getId());
                console.printMessage("Ingrese los nuevos datos, deje en blanco si no desea cambiar nada");

                try {
                    console.printMessage("Nueva direccion [" + contadorAEditar.getAddress() + "]");
                    String nuevaDireccion = console.readString();
                    if (!nuevaDireccion.isBlank()){
                        contadorAEditar.setAddress(nuevaDireccion);
                        console.printMessage("Direccion actualizada");
                    }
                    console.printMessage("Nueva cuidad [" + contadorAEditar.getCity() + "]");
                    String nuevaCiudad = console.readString();
                    if (!nuevaCiudad.isBlank()){
                        contadorAEditar.setCity(nuevaCiudad);
                        console.printMessage("Ciudad actualizada");
                    }
                    console.printMessage("Contador actualizado");
                } catch (Exception e){
                    console.printMessage("Error al actualizar contador: " + e.getMessage());
                }
            } else {
                console.printMessage("No se encontro el ID del contador" + idContador + "Para el cliente" + clienteEncontrado.getName());
            }
        } else {
            console.printMessage("No se encontro el ID del cliente" + idCliente);
        }
    }


 //






    /*
    La aplicación o software desarrollado debe realizar los siguientes procesos:
1. Crear cliente
2. Editar cliente (Cambiar atributos excepto el número único de identificación.)
3. Crear registrador o contador
4. Editar registrador (Cambiar sus atributos excepto su número de identificación)
5. Cargar de forma automática los consumos de todos los clientes en un mes –
año respectivo.
     */



}
