/*
    NOMBRE DEL PROYECTO: Motor_EmisionApp
 */
package motor_emisionapp;

/**
    @author Quishpe Urrutia Job Nicolas
 */

// Clase Motor_Emision
class Motor_Emision {
    
    // Atributos
    private String potencia_motor;
    private double cantidad_emision;
    
    // Constructores
    public Motor_Emision(String potencia_motor) {
        this (potencia_motor, 0); // Sobrecarga
    }
    public Motor_Emision(String potencia_motor, double cantidad_emision) {
        this.potencia_motor = potencia_motor; 
        // Si la cantidad de emisiones es menor que cero, lo ponemos a cero
        if(cantidad_emision < 0) {
            this.cantidad_emision = 0;
        } else {
            this.cantidad_emision = cantidad_emision;
        }
    } 
    
    // Métodos
    public void setPotencia_motor(String potencia_motor) { // set, modifica o almacena valor variable
        this.potencia_motor = potencia_motor;
    }
    public String getPotencia_motor() { // get, muestra o extrae el valor del dato
        return potencia_motor;
    }
    
    public void setCantidad_emision(double cantidad_emision) {
        this.cantidad_emision = cantidad_emision;
    }
    public double getCantidad_emision() {
        return cantidad_emision;
    }
    
    /*Medir emisiones contaminantes,
      solo si es positiva la cantidad de emisión.*/
    public void Medir_Emision(double cantidad_emision) {
        if(cantidad_emision > 0) {
            this.cantidad_emision += cantidad_emision;
        } // cantidad_emisión += cantidad_emisión + cantidad_emisión
    }
    
    /* Valide la emisión contaminante del motor,
        si se quedara en negativo, la cantidad de emisiones quedara en 0.*/
    public void Validar_Emision(double cantidad_emision) {
        if(cantidad_emision < 0) {
            this.cantidad_emision = cantidad_emision;
        } else {
            this.cantidad_emision -= cantidad_emision;
        } // cantidad_emisión -= cantidad_emisión - cantidad_emisión
    }
   
    /* Devuelve el estado del objeto
    @return
    */
    @Override
    public String toString() {
        return "La emisión contaminante " + potencia_motor+ " tiene " +cantidad_emision+
                " % emisión expulsada por el motor";
    }   
}

// Clase Ejecutable
public class Motor_EmisionApp {
    public static void main(String[] args) {
        Motor_Emision motor_1 = new Motor_Emision("Hidrocarburos");
        Motor_Emision motor_2 = new Motor_Emision("Monóxido de Carbono", 65.5);
        
        // Medir emisión del motor
        motor_1.Medir_Emision(25);
        motor_2.Medir_Emision(40);
        
        // Validar emisión del motor
        motor_1.Validar_Emision(30);
        motor_2.Validar_Emision(45);
        
        // Presentación de la emisión del motor.
        System.out.println(motor_1);  // 0 emisiones del motor
        System.out.println(motor_2);  // 60.5 emisiones del motor
    }
}
