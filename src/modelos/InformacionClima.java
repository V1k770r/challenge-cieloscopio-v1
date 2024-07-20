package modelos;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class InformacionClima {

    private String nombre;




    private LocalDateTime fechaDeSolicitud;
    private double temperaturaActual;
    private double temperaturaMinima;
    private double temperaturaMaxima;
    private String condicionClimatica;

    DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm");


    public InformacionClima(){
    }

    public InformacionClima(String nombre, LocalDateTime fechaDeSolicitud, double temperaturaActual, double temperaturaMinima, double temperaturaMaxima, String condicionClimatica) {
        this.nombre = nombre;

        this.fechaDeSolicitud = fechaDeSolicitud;
        this.temperaturaActual = temperaturaActual;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.condicionClimatica = condicionClimatica;
    }

    public InformacionClima(InformacionClimaOpenWee informacionClimaOpenWee) {
        this.nombre = informacionClimaOpenWee.name();

        this.fechaDeSolicitud = LocalDateTime.now();

        this.temperaturaActual = informacionClimaOpenWee.temp();
        this.temperaturaMinima = informacionClimaOpenWee.temp();
        this.temperaturaMaxima = informacionClimaOpenWee.temp();
        this.condicionClimatica = informacionClimaOpenWee.description();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }

    public void setFechaDeSolicitud(LocalDateTime fechaDeSolicitud) {
        this.fechaDeSolicitud = fechaDeSolicitud;
    }

    public double getTemperaturaActual() {
        return temperaturaActual;
    }

    public void setTemperaturaActual(double temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public String getCondicionClimatica() {
        return condicionClimatica;
    }

    public void setCondicionClimatica(String condicionClimatica) {
        this.condicionClimatica = condicionClimatica;
    }




    @Override
    public String toString() {

        return  '\n' + "-----------------------------------" +
                '\n' +
                "Respuesta:" + '\n' +
                '\n' +
                "Ciudad: " + nombre + '\n' +
                "Fecha: " + fechaDeSolicitud.format(formatterDay) + '\n' +
                "Horario: " + fechaDeSolicitud.format(formatterHour) + '\n' +
                '\n' +
                "principal: " +     '\n' +
                "Temperatura Actual: " + temperaturaActual + '\n' +
                "Condicion Climatica: " + condicionClimatica + '\n' +
                "Temperatura Minima: " + temperaturaMinima + '\n' +
                "Temperatura Maxima: " + temperaturaMaxima + '\n' +
                "-------------------------------------------";
    }
}
