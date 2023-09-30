package com.example.nomina;

import java.io.Serializable;

public class nomina implements Serializable {

    private int numRecibo;
    private String nombre;
    private Float horasTrabNormal;
    private Float horasTrabExtras;
    private int puesto;

    public int getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(int numRecibo) {
        this.numRecibo = numRecibo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getHorasTrabNormal() {
        return horasTrabNormal;
    }

    public void setHorasTrabNormal(Float horasTrabNormal) {
        this.horasTrabNormal = horasTrabNormal;
    }

    public Float getHorasTrabExtras() {
        return horasTrabExtras;
    }

    public void setHorasTrabExtras(Float horasTrabExtras) {
        this.horasTrabExtras = horasTrabExtras;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }



public float calcularSubtotal(){
        float subtotal=0;

if(this.puesto==1){
    subtotal=(this.horasTrabNormal*50)+(this.horasTrabExtras*100);
} else if (this.puesto==2) {
    subtotal=(this.horasTrabNormal*70)+(this.horasTrabExtras*140);
} else if (this.puesto==3) {
    subtotal=(this.horasTrabNormal*100)+(this.horasTrabExtras*200);
}

        return subtotal;
}

public float calcularImpuesto(){
        float impuesto=0;

        impuesto=calcularSubtotal()*0.16f;

        return impuesto;
}

public float calcularTotal(){
        float total=0;

        total=calcularSubtotal()-calcularImpuesto();

        return total;
}


}
