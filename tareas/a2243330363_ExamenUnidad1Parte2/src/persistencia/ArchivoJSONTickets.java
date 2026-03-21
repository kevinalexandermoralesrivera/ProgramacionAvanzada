package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Ticket;

import java.io.FileWriter;
import java.util.ArrayList;

public class ArchivoJSONTickets {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // GUARDAR TICKET INDIVIDUAL
    public void guardarTicket(Ticket t){

        try(FileWriter writer = new FileWriter("ticket_" + t.getFolio() + ".json")){

            gson.toJson(t, writer);

        }catch(Exception e){
            System.out.println("Error al guardar ticket");
        }
    }

    // HISTORIAL
    public void guardarHistorial(ArrayList<Ticket> lista){

        try(FileWriter writer = new FileWriter("tickets.json")){

            gson.toJson(lista, writer);

        }catch(Exception e){
            System.out.println("Error historial");
        }
    }
}