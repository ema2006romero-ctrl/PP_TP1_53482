package ejercicio3tp1;

import java.time.LocalDate;


public class Inscripcion {

    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private Actividad actividad;

    public Inscripcion(Estudiante estudiante, Actividad actividad) {
        this.estudiante = estudiante;
        this.actividad = actividad;
        this.fecha = LocalDate.now();
        this.estado = "Confirmada";
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Actividad getActividad() {
        return actividad;
    }

    @Override
    public String toString() {
        return "Inscripcion{estudiante=" + estudiante.getNombre()
                + ", actividad=" + actividad.getTitulo()
                + ", fecha=" + fecha
                + ", estado='" + estado + "'}";
    }
}