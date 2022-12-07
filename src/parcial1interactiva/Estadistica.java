/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1interactiva;


import java.util.ArrayList;
/**
 *
 * @author Juan Diego Gil Trujillo 1747240 - 3743
 */
public class Estadistica {
    private ArrayList<Persona> ciudadanosFase1;
    private ArrayList<Persona> ciudadanosFase2;
    private ArrayList<Persona> ciudadanosFase3;
    private ArrayList<Persona> ciudadanosFase4;
    private ArrayList<Persona> ciudadanosFase5;
    
    /*
    * Constructor
    */
    public Estadistica(){
        ciudadanosFase1 = new ArrayList<Persona>();
        ciudadanosFase2 = new ArrayList<Persona>();
        ciudadanosFase3 = new ArrayList<Persona>();
        ciudadanosFase4 = new ArrayList<Persona>();
        ciudadanosFase5 = new ArrayList<Persona>();
    }
    
    /*
   * ingresarCiudadano: Método que se encarga de ingresar a una persona a los
   * ArrayList de Persona según el valor del atributo de su fase
   * Ingreso: Un objeto de la clase Persona
   * Retorna: La inserción en alguno de los 5 ArrayList de Persona
   */
    public void ingresarCiudadano(Persona person){
        if(person.getFase() == "1"){
            ciudadanosFase1.add(person);
        }else if(person.getFase() == "2"){
            ciudadanosFase2.add(person);
        }else if(person.getFase() == "3"){
            ciudadanosFase3.add(person);
        }else if(person.getFase() == "4"){
            ciudadanosFase4.add(person);
        }else{
            ciudadanosFase5.add(person);
        }
    }
    
    /*
   * mostrarCiudadanos: Método que se encarga de obtener todos los valores de los atributos de 
   * todos los objetos Persona de sus cinco ArrayList
   * Ingreso: N/A
   * Retorna: Un String con dicha información
   */
    public String mostrarCiudadanos(){
        String esclavos = "";
        if(!ciudadanosFase1.isEmpty()){
            esclavos = esclavos +"\n" + "----- LISTA DE CIUDADANOS VINCULADOS A LA FASE 1 -----\n";
            String otro = "";
            for(int i=0; i<ciudadanosFase1.size();i++){
                otro = ciudadanosFase1.get(i).informacionCiudadano() + "\n" + "----------\n" + otro ;
            }
            esclavos = esclavos + otro;
        }
        if(!ciudadanosFase2.isEmpty()){
            esclavos = esclavos +"\n" + "----- LISTA DE CIUDADANOS VINCULADOS A LA FASE 2 -----\n";
            String otro = "";
            for(int i=0; i<ciudadanosFase2.size();i++){
                otro = ciudadanosFase2.get(i).informacionCiudadano() + "\n" + "----------\n" + otro ;
            }
            esclavos = esclavos + otro;
        }
        if(!ciudadanosFase3.isEmpty()){
            esclavos = esclavos +"\n" + "----- LISTA DE CIUDADANOS VINCULADOS A LA FASE 3 -----\n";
            String otro = "";
            for(int i=0; i<ciudadanosFase3.size();i++){
                otro =ciudadanosFase3.get(i).informacionCiudadano() + "\n" + "----------\n" + otro ;
            }
            esclavos = esclavos + otro;
        }
        if(!ciudadanosFase4.isEmpty()){
            esclavos = esclavos +"\n" +"----- LISTA DE CIUDADANOS VINCULADOS A LA FASE 4 -----\n";
            String otro = "";
            for(int i=0; i<ciudadanosFase4.size();i++){
                otro = ciudadanosFase4.get(i).informacionCiudadano() + "\n" + "----------\n" + otro ;
            }
            esclavos = esclavos + otro;
        }
        if(!ciudadanosFase5.isEmpty()){
            esclavos = esclavos +"\n" + "----- LISTA DE CIUDADANOS VINCULADOS A LA FASE 5 -----\n";
            String otro = "";
            for(int i=0; i<ciudadanosFase5.size();i++){
                otro = ciudadanosFase5.get(i).informacionCiudadano() + "\n" + "----------\n" + otro ;
            }
            esclavos = esclavos + otro;
        }
        
        return esclavos;
    }
    
}

