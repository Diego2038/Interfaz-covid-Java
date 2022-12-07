/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1interactiva;

/**
 *
 * @author Juan Diego Gil Trujillo 1747240 - 3743
 */
public class Persona {
    private String nombre;
    private String id;
    private int edad;
    private String ocupacion;
    private String cormobilidad;
    
    private String fase;
    private String fechaVacunacion;

    
    /*
    * Constructor parametrizado
    */
    public Persona(String nombre,String id,int edad,String ocupacion,String cormobilidad){
        this.nombre = nombre;
        this.id = id;
        this.edad= edad;
        this.ocupacion = ocupacion;
        this.cormobilidad = cormobilidad;
        
        this.fase = definirFase();
        this.fechaVacunacion = definirFechaVacunacion(this.fase);
    }
    
   /*
   * definirFechaVacunacion: Método que define la fecha de vacunación
   * según el valor ingresado
   * Ingreso: Un String con un valor determinado
   * Retorna: Un String con la fecha determinada
   */
    public String definirFechaVacunacion(String f){
        String fec = "";
        if(f == "1") fec = "Febrero 17 de 2021";
        else if(f == "2") fec = "Marzo 6 de 2021";
        else if(f == "3") fec = "Marzo 24 de 2021";
        else if(f == "4") fec = "Abril 17 de 2021";
        else if(f == "5") fec = "Mayo 8 de 2021";
        return fec;
        
    }
    
   /*
   * definirFechaVacunacion: Método que define la fase a la que pertenece, según los
   * valores de sus otros atributos
   * Ingreso: N/A
   * Retorna: Un String con la fase determinada
   */
    public String definirFase(){
        String fasee;
        if(this.edad >= 80 || this.ocupacion == "Personal de salud con contacto directo"){
            fasee = "1";
            return fasee;
        }else if(this.edad >= 60 || this.ocupacion == "Persona de salud sin contacto directo"){
            fasee = "2";
            return fasee;
        }else if((this.edad >=16 && this.edad<=59 && this.cormobilidad == "Si") || 
                this.ocupacion == "Personal relacionado con el servicio educativo" ||
                this.ocupacion == "Militar" || this.ocupacion == "Policía"){
            fasee = "3";
            return fasee;
        }else if(this.ocupacion == "Bombero" || this.ocupacion == "Socorrista" ||
                this.ocupacion == "Piloto" || this.ocupacion == "Auxiliar de vuelo" ||
                this.ocupacion == "Habitante de calle"){
            fasee = "4";
            return fasee;
        }else{
            return "5";
        }
    }
    
   /*
   * informacionCiudadano: Método que se encarga de obtener todos los valores de los atributos de 
   * del objeto Persona
   * Ingreso: N/A
   * Retorna: Un String con dicha información
   */
    public String informacionCiudadano(){
        String info =
                "Nombre: " + this.nombre +
                "\nDocumento de identificación: " + this.id +
                "\nEdad: " + this.edad+
                "\nOcupación: " + this.ocupacion +
                "\nCormobilidad: " + this.cormobilidad +
                "\nFase a la que pertenece: " + this.fase +
                "\nFecha de su vacunación: " + this.fechaVacunacion;
        return info;
    } 
    
   /*
   * getFase: Método que se encarga de obtener el atributo fase
   * Ingreso: N/A
   * Retorna: el atributo fase
   */
    public String getFase() {
        return fase;
    }
}

