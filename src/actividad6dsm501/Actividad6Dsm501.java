
package actividad6dsm501;


public class Actividad6Dsm501 {

 
    public static void main(String[] args) {
       Conexion conec= new Conexion();
        conec.mostrar();
        //conec.insertar("Aplicaciones");
        System.out.println("otra vez el mostrar");
       // conec.actualizar("Desarrollo movil", "integradora");
       conec.eliminar("Aplicaciones");
        conec.mostrar();
        
    }
    
}
