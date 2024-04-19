package plc_mms.dto;

import java.io.Serializable;

public class DatosPlcTu_DTO implements Serializable  {
    String id_plctu;
    String propietario;
    String tipoIden;
    String numIden;
    String direccion;
    String estrato;
    String fechaRegistro;
    String lecturaActual;
    String lecturaAnterior;
    int consumo;

    public DatosPlcTu_DTO(String propietario, String id_plctu, String tipoIden, String numIden, String direccion, String estrato, String lecturaActual, int consumo, String lecturaAnterior, String fechaRegistro) {
        this.propietario = propietario;
        this.id_plctu = id_plctu;
        this.tipoIden = tipoIden;
        this.numIden = numIden;
        this.direccion = direccion;
        this.estrato = estrato;
        this.lecturaActual = lecturaActual;
        this.consumo = consumo;
        this.lecturaAnterior = lecturaAnterior;
        this.fechaRegistro = fechaRegistro;
    }

    public String getId_plctu() {
        return id_plctu;
    }

    public void setId_plctu(String id_plctu) {
        this.id_plctu = id_plctu;
    }

    public String getTipoIden() {
        return tipoIden;
    }

    public void setTipoIden(String tipoIden) {
        this.tipoIden = tipoIden;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getNumIden() {
        return numIden;
    }

    public void setNumIden(String numIden) {
        this.numIden = numIden;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getLecturaActual() {
        return lecturaActual;
    }

    public void setLecturaActual(String lecturaActual) {
        this.lecturaActual = lecturaActual;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public String getLecturaAnterior() {
        return lecturaAnterior;
    }

    public void setLecturaAnterior(String lecturaAnterior) {
        this.lecturaAnterior = lecturaAnterior;
    }
}
