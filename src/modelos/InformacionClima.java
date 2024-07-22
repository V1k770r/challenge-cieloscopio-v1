package modelos;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.lang.*;

public class InformacionClima {

    private String nombre;
    private Map<String, String> principal;
    private LocalDateTime fechaDeSolicitud;
    private double temperaturaActual;
    private double temperaturaMinima;
    private double temperaturaMaxima;



    private List<Map<String,String>> condicionClimatica;

    private final DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm");

    public InformacionClima(){
    }

//    public InformacionClima(String nombre, LocalDateTime fechaDeSolicitud, double temperaturaActual, double temperaturaMinima, double temperaturaMaxima, String condicionClimatica) {
//        this.nombre = nombre;
//
//        this.fechaDeSolicitud = fechaDeSolicitud;
//        this.temperaturaActual = temperaturaActual;
//        this.temperaturaMinima = temperaturaMinima;
//        this.temperaturaMaxima = temperaturaMaxima;
//        this.condicionClimatica = condicionClimatica;
//    }

    public InformacionClima(String nombre, Map<String, String> principal,
                            LocalDateTime fechaDeSolicitud, double temperaturaActual,
                            double temperaturaMinima, double temperaturaMaxima,
                            List<Map<String,String>> condicionClimatica) {
        this.nombre = nombre;
        this.principal = principal;
        this.fechaDeSolicitud = fechaDeSolicitud;
        this.temperaturaActual = temperaturaActual;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.condicionClimatica = condicionClimatica;
    }

    public InformacionClima(InformacionClimaOpenWee informacionClimaOpenWee) {
        this.nombre = informacionClimaOpenWee.name();
        this.principal = informacionClimaOpenWee.main();
        this.fechaDeSolicitud = LocalDateTime.now();
        this.temperaturaActual = informacionClimaOpenWee.temp();
        this.temperaturaMinima = informacionClimaOpenWee.temp();
        this.temperaturaMaxima = informacionClimaOpenWee.temp();
        this.condicionClimatica = informacionClimaOpenWee.weather();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, String> getPrincipal() {
        return principal;
    }

    public void setPrincipal(Map<String, String> principal) {
        this.principal = principal;
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

    public List<Map<String, String>> getCondicionClimatica() {
        return condicionClimatica;
    }

    public void setCondicionClimatica(List<Map<String, String>> condicionClimatica) {
        this.condicionClimatica = condicionClimatica;
    }



    @Override
    public String toString() {

        return  '\n' + "-----------------------------------" +
                '\n' +
                "Respuesta:" + '\n' +
                '\n' +
                "Ciudad: " + nombre.toUpperCase() + '\n' +
                "Fecha: " + fechaDeSolicitud.format(formatterDay) + '\n' +
                "Horario: " + fechaDeSolicitud.format(formatterHour) + '\n' +
                '\n' +
                "Temperatura Actual: " + principal.get("temp") + '\n' +
                "Condicion Climatica: " + condicionClimatica.get(0).get("description").toUpperCase() + '\n' +
                "Temperatura Minima: " + principal.get("temp_min") + '\n' +
                "Temperatura Maxima: " + principal.get("temp_max") + '\n' +
                "-------------------------------------------";
    }
}
