package Clases;

import jakarta.persistence.*;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "equipo")
    private String equipo;

    @Column(name = "partido")
    private String partido;

    @Column(name = "ronda")
    private int ronda;

    @Column(name = "posesion")
    private int posesion;

    @Column(name = "goles")
    private int goles;

    @Column(name = "corners")
    private int corners;

    @Column(name = "fueras_juego")
    private int fuerasDeJuego;

    @Column(name = "pases_profundidad")
    private int pasesEnProfundidad;

    @Column(name = "ocasiones")
    private int ocasiones;

    @Column(name = "tiros_totales")
    private int tirosTotales;

    @Column(name = "tiros_puerta")
    private int tirosPuerta;

    @Column(name = "tiros_palo")
    private int tirosPalo;

    @Column(name = "tiros_fuera")
    private int tirosFuera;

    @Column(name = "tiros_bloqueados")
    private int tirosBloqueados;

    @Column(name = "entradas")
    private int entradas;

    @Column(name = "faltas")
    private int faltas;

    @Column(name = "tarjetas_amarillas")
    private int tarjetasAmarillas;

    public Result() {
    }

    public Result(String equipo, String partido, int ronda, int posesion, int goles, int corners, int fuerasDeJuego, int pasesEnProfundidad, int ocasiones, int tirosTotales, int tirosPuerta, int tirosPalo, int tirosFuera, int tirosBloqueados, int entradas, int faltas, int tarjetasAmarillas) {
        this.equipo = equipo;
        this.partido = partido;
        this.ronda = ronda;
        this.posesion = posesion;
        this.goles = goles;
        this.corners = corners;
        this.fuerasDeJuego = fuerasDeJuego;
        this.pasesEnProfundidad = pasesEnProfundidad;
        this.ocasiones = ocasiones;
        this.tirosTotales = tirosTotales;
        this.tirosPuerta = tirosPuerta;
        this.tirosPalo = tirosPalo;
        this.tirosFuera = tirosFuera;
        this.tirosBloqueados = tirosBloqueados;
        this.entradas = entradas;
        this.faltas = faltas;
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "id=" + id +
                ", equipo='" + equipo + '\'' +
                ", partido='" + partido + '\'' +
                ", ronda='" + ronda + '\'' +
                ", posesion=" + posesion +
                ", goles=" + goles +
                ", corners=" + corners +
                ", fuerasDeJuego=" + fuerasDeJuego +
                ", pasesEnProfundidad=" + pasesEnProfundidad +
                ", ocasiones=" + ocasiones +
                ", tirosTotales=" + tirosTotales +
                ", tirosPuerta=" + tirosPuerta +
                ", tirosPalo=" + tirosPalo +
                ", tirosFuera=" + tirosFuera +
                ", tirosBloqueados=" + tirosBloqueados +
                ", entradas=" + entradas +
                ", faltas=" + faltas +
                ", tarjetasAmarillas=" + tarjetasAmarillas +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getPosesion() {
        return posesion;
    }

    public void setPosesion(int posesion) {
        this.posesion = posesion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getCorners() {
        return corners;
    }

    public void setCorners(int corners) {
        this.corners = corners;
    }

    public int getFuerasDeJuego() {
        return fuerasDeJuego;
    }

    public void setFuerasDeJuego(int fuerasDeJuego) {
        this.fuerasDeJuego = fuerasDeJuego;
    }

    public int getPasesEnProfundidad() {
        return pasesEnProfundidad;
    }

    public void setPasesEnProfundidad(int pasesEnProfundidad) {
        this.pasesEnProfundidad = pasesEnProfundidad;
    }

    public int getOcasiones() {
        return ocasiones;
    }

    public void setOcasiones(int ocasiones) {
        this.ocasiones = ocasiones;
    }

    public int getTirosTotales() {
        return tirosTotales;
    }

    public void setTirosTotales(int tirosTotales) {
        this.tirosTotales = tirosTotales;
    }

    public int getTirosPuerta() {
        return tirosPuerta;
    }

    public void setTirosPuerta(int tirosPuerta) {
        this.tirosPuerta = tirosPuerta;
    }

    public int getTirosPalo() {
        return tirosPalo;
    }

    public void setTirosPalo(int tirosPalo) {
        this.tirosPalo = tirosPalo;
    }

    public int getTirosFuera() {
        return tirosFuera;
    }

    public void setTirosFuera(int tirosFuera) {
        this.tirosFuera = tirosFuera;
    }

    public int getTirosBloqueados() {
        return tirosBloqueados;
    }

    public void setTirosBloqueados(int tirosBloqueados) {
        this.tirosBloqueados = tirosBloqueados;
    }

    public int getEntradas() {
        return entradas;
    }

    public void setEntradas(int entradas) {
        this.entradas = entradas;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }
}
