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
public class MultasDTO {

     private int idMulta;
    private int Prestamoid;
    private String FechaMulta;
    private String ValorToltal;
    private String Fechapago;
    private String Estado;

    @Override
    public String toString() {
        return "MultasDTO{" + "idMulta=" + idMulta + ", Prestamoid=" + 
                Prestamoid + ", FechaMulta=" + FechaMulta + ", ValorToltal=" + 
                ValorToltal + ", Fechapago=" + Fechapago + ", Estado=" + Estado + '}';
    }
    
    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    public int getPrestamoid() {
        return Prestamoid;
    }

    public void setPrestamoid(int Prestamoid) {
        this.Prestamoid = Prestamoid;
    }

    public String getFechaMulta() {
        return FechaMulta;
    }

    public void setFechaMulta(String FechaMulta) {
        this.FechaMulta = FechaMulta;
    }

    public String getValorToltal() {
        return ValorToltal;
    }

    public void setValorToltal(String ValorToltal) {
        this.ValorToltal = ValorToltal;
    }

    public String getFechapago() {
        return Fechapago;
    }

    public void setFechapago(String Fechapago) {
        this.Fechapago = Fechapago;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
   
    
}
