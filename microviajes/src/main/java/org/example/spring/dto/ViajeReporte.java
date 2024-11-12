package org.example.spring.dto;

public class ViajeReporte {

    private long idMonopatin;
    private double kmRecorridos;
    private long tiempoDeUso;

    public ViajeReporte(long idMonopatin, double kmRecorridos, long tiempoDeUso) {
        this.idMonopatin = idMonopatin;
        this.kmRecorridos = kmRecorridos;
        this.tiempoDeUso = tiempoDeUso;
    }

    // Getters y setters
    public long getIdMonopatin() {
        return idMonopatin;
    }

    public void setIdMonopatin(long idMonopatin) {
        this.idMonopatin = idMonopatin;
    }

    public double getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(double kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public long getTiempoDeUso() {
        return tiempoDeUso;
    }

    public void setTiempoDeUso(long tiempoDeUso) {
        this.tiempoDeUso = tiempoDeUso;
    }
}
