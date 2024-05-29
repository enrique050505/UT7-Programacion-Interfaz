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


	}

	public static void eliminarPokemon(){
        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
            	 MongoDatabase database = mongoClient.getDatabase("ProyectoUT7");
                 MongoCollection<Document> coleccionPokemons = database.getCollection("Pokemons");
                 
                 
                 //DELETE                
                 coleccionPokemons.deleteOne(Filters.eq("name", "Golderos"));
                 System.out.println("Pokemon eliminado");
                         
                 Document foundPokemon1 = coleccionPokemons.find(Filters.eq("name", "Golderos")).first();
                 if (foundPokemon1 != null) {
                  System.out.println("Pokemon encontrado: " + foundPokemon1.getString("name"));
                 }else {
                  System.out.println("Pokemon no encontrado");
                 }
                 
             } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
    public static void añadirPokemon(){
   
   
        String connectionString = "mongodb+srv://enriquemartinalbodo:enrique050505@cluster1.6qj4ajz.mongodb.net/?retryWrites=true&w=majority&appName=Cluster1";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
            	 MongoDatabase database = mongoClient.getDatabase("ProyectoUT7");
            	 MongoCollection<Document> coleccionPokemons = database.getCollection("Pokemons");
            	 
                 
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }

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
    
}//FIN CLASS