
package actividad6dsm501;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
 DB baseDatos;
 DBCollection coleccion;
 BasicDBObject document = new BasicDBObject();


public Conexion(){
    try {
  Mongo mongo= new Mongo("localhost", 27017);
  baseDatos= mongo.getDB("Actividad6");
  coleccion =baseDatos.getCollection("actividad");
     System.out.println("Conexion establecida");
 }
 catch(UnknownHostException ex){
 
     Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
 
 
 }
}
public boolean insertar(String actividad){
    document.put("actividad",actividad);
    coleccion.insert(document);
    return true;
}
        
        
public void mostrar(){
    DBCursor cursor = coleccion.find();
    while(cursor.hasNext()){
        System.out.println(cursor.next());
        
    }
}
public boolean actualizar(String actividadVieja, String actividadNueva){
document.put("activiad",actividadVieja);
BasicDBObject documentNuevo= new BasicDBObject();
documentNuevo.put("actividad",actividadNueva);
coleccion.findAndModify(document,documentNuevo);
 return true;
     }
public boolean eliminar(String actividad){
document.put("actividad", actividad);
coleccion.remove(document);
return true;
} 
}