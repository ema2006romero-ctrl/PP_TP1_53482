package ejercicio3tp1;

public class Estudiante {
    private String legajo;
    private String nombre;

    public Estudiante(String legajo, String nombre){
        this.legajo = legajo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    @Override
    public String toString(){
        return "Estudiante {legajo = " + legajo + " , nombre = " + nombre + "}";
    }
}
