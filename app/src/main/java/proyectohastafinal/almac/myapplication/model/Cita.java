package proyectohastafinal.almac.myapplication.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cita implements Comparable < Cita >{

    //ESTADO
    public static final String FINALIZADA = "Finalizada";
    public static final String RESERVADA = "Reservada";
    public static final String APLAZADA = "Aplazada";
    public static final String SOLICITADA = "Solicitada";
    public static final String RECHAZADA = "Rechazada";

    //SERVICIO
    public static final String PELUQUERIA = "Peluquería";
    public static final String UNAS = "Uñas";
    public static final String MAQUILLAJE = "Maquillaje";
    public static final String DEPILACION = "Depilación";
    public static final String MASAJE = "Masaje";

    private String iIdcita;
    private String dia;
    private String fecha;
    private String informacion;
    private String estado;
    private int horainicio;
    private int horafin;
    private String servicio;
    private String nombreSalon;
    private String idEstilista;
    private String idUsuario;
    private String nombreEstilista;
    private String nombreUsuario;
    private int tipo;

    private String cabecera;

    public Cita(String idcita,String estado,String dia,String fecha,int horafin,int horainicio, String informacion, String nombreSalon,String servicio,
                String idEstilista, String nombreEstilista, String idUsuario, String nombreUsuario) {
        this.iIdcita = idcita;
        this.dia = dia;
        this.fecha = fecha;
        this.informacion = informacion;
        this.estado = estado;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.servicio = servicio;
        this.nombreSalon = nombreSalon;
        this.idEstilista = idEstilista;
        this.idUsuario = idUsuario;
        this.nombreEstilista = nombreEstilista;
        this.nombreUsuario = nombreUsuario;
    }

    public Cita() {
    }

    public String getIdcita() {
        return iIdcita;
    }

    public void setIdcita(String idcita) {
        this.iIdcita = idcita;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(int horainicio) {
        this.horainicio = horainicio;
    }

    public int getHorafin() {
        return horafin;
    }

    public void setHorafin(int horafin) {
        this.horafin = horafin;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }

    public String getIdEstilista() {
        return idEstilista;
    }

    public void setIdEstilista(String idEstilista) {
        this.idEstilista = idEstilista;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCabecera() {
        return cabecera;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public String getiIdcita() {
        return iIdcita;
    }

    public void setiIdcita(String iIdcita) {
        this.iIdcita = iIdcita;
    }

    public String getNombreEstilista() {
        return nombreEstilista;
    }

    public void setNombreEstilista(String nombreEstilista) {
        this.nombreEstilista = nombreEstilista;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public int compareTo(Cita o) {

            String[] fecha = this.getFecha().split("-");
            Calendar cal = new GregorianCalendar(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1])-1, Integer.parseInt(fecha[2]), horainicio, 0, 0);
            Date d = cal.getTime();

            String[] fecha2 = o.getFecha().split("-");
            Calendar cal2 = new GregorianCalendar(Integer.parseInt(fecha2[0]), Integer.parseInt(fecha2[1])-1, Integer.parseInt(fecha2[2]), o.getHorainicio(), 0, 0);
            Date d2 = cal2.getTime();

            return d.compareTo(d2);
    }
}
