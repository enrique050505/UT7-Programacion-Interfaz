package proyecto;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.util.ArrayList;

import javax.swing.JLabel;

import org.bson.Document;

public class ConectorMongo {
	static String connectionString = "mongodb+srv://enriquemartinalbodo:enrique050505@cluster1.6qj4ajz.mongodb.net/?retryWrites=true&w=majority&appName=Cluster1";

	static ServerApi serverApi = ServerApi.builder()
             .version(ServerApiVersion.V1)
             .build();

	static MongoClientSettings settings = MongoClientSettings.builder()
             .applyConnectionString(new ConnectionString(connectionString))
             .serverApi(serverApi)
             .build();
    
	
	public ConectorMongo() {


	}//FIN CONSTRUCTOR

	/*public static void eliminarPokemon(){
        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
            	 MongoDatabase database = mongoClient.getDatabase("ProyectoUT7");
                 MongoCollection<Document> coleccionPokemons = database.getCollection("Pokemons");
                 
                 
                 //DELETE                
                 //coleccionPokemons.deleteOne(Filters.eq("name", "Golderos"));
                 //System.out.println("Pokemon eliminado");
                         
                 /*Document foundPokemon1 = coleccionPokemons.find(Filters.eq("name", "Golderos")).first();
                 if (foundPokemon1 != null) {
                  System.out.println("Pokemon encontrado: " + foundPokemon1.getString("name"));
                 }else {
                  System.out.println("Pokemon no encontrado");
                 }                 
             } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }//FIN ELIMINAR POKEMON
	
    public static void añadirPokemon(){

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
            	 MongoDatabase database = mongoClient.getDatabase("ProyectoUT7");
            	 MongoCollection<Document> coleccionPokemons = database.getCollection("Pokemons");
            	 
                 
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }//FIN AÑADIR POKEMON*/

    public Document mostrarInfo(String nombrePokemon) {

    	Document foundPokemon = null;
    	try (MongoClient mongoClient = MongoClients.create(settings)) {
           try {
        	   	MongoDatabase database = mongoClient.getDatabase("ProyectoUT7");
                MongoCollection<Document> coleccionPokemons = database.getCollection("Pokemons");
         
                foundPokemon = coleccionPokemons.find(Filters.eq("nombre", nombrePokemon)).first();
                if (foundPokemon != null) {
                }else {
                	System.out.println("Pokemon no disponible");
                }
           
               
           } catch (MongoException e) {
               e.printStackTrace();
           }
           
       }
    	return foundPokemon;
    	
    }//FIN BUSCAR INFO POKEMON
    
    public ArrayList<String> obtenerNombresUsuarios(){
    	ArrayList<String> usuarios = new ArrayList<String>();
    	
    	try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
         	   	 MongoDatabase database = mongoClient.getDatabase("ProyectoUT7");
                 MongoCollection<Document> coleccionUsuarios = database.getCollection("Usuarios");
          
                 for(Document usuario : coleccionUsuarios.find()) {
                	 usuarios.add(usuario.getString("nombre"));
                 }
            } catch (MongoException e) {
                e.printStackTrace();
            }
            
        }
     	return usuarios;
    	
    }//OBTENER NOMBRES USUARIOS
    
    public Document obtenerInfoUsuario(String nombre, JLabel lblCantidadMonedas) {
    	Document usuario = null;
    	try (MongoClient mongoClient = MongoClients.create(settings)) {
           try {
        	   	MongoDatabase database = mongoClient.getDatabase("ProyectoUT7");
                MongoCollection<Document> coleccionUsuarios = database.getCollection("Usuarios");
         
                usuario = coleccionUsuarios.find(Filters.eq("nombre", nombre)).first();
                
                if(usuario != null) {
                	lblCantidadMonedas.setText(usuario.getString("monedas"));
                }
           } catch (MongoException e) {
               e.printStackTrace();
           }
           
       }
    	return usuario;
    }//FIN OBTENER INFORMACION USUARIOS

    public boolean actualizarCheckBox(String nombrePokemon) {
    	boolean obtenido=false;
    	try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
         	   	MongoDatabase database = mongoClient.getDatabase("ProyectoUT7");
                MongoCollection<Document> coleccionPokemons = database.getCollection("Pokemons");
          
                coleccionPokemons.updateOne(Filters.eq("nombre", nombrePokemon), Updates.set("PokemonComprado", true));
                
                obtenido=true;
            } catch (MongoException e) {
                e.printStackTrace();
            }
            
        }
		return obtenido;
    }//FIN ACTUALIZAR CHECK BOX
    
    
    
}//FIN CLASS