/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class librosDTO {

     private int IdLibro;
    private String isbm;
    private String Titulo;
    private int Estadolibro;

    @Override
    public String toString() {
        return "librosDTO{" + "IdLibro=" + IdLibro + ", isbm=" + isbm + ", "
                + "Titulo=" + Titulo + ", Estadolibro=" + Estadolibro + '}';
    }
    
    public int getIdLibro() {
        return IdLibro;
    }

    public void setIdLibro(int IdLibro) {
        this.IdLibro = IdLibro;
    }

    public String getIsbm() {
        return isbm;
    }

    public void setIsbm(String isbm) {
        this.isbm = isbm;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public int getEstadolibro() {
        return Estadolibro;
    }

    public void setEstadolibro(int Estadolibro) {
        this.Estadolibro = Estadolibro;
    }
}
