package entities;

import java.io.Serializable;
import java.util.Date;

/*
    Serializable permite que o meu obj seja transformado em uma sequencia de Bytes
*/

public class User implements Serializable {

    private static final long serialVersionUID = 1L; //id Serializable

    private Date data_extracao;
    private String id_usuario;
    private String situacao;
    private String central_regulacao_origem;
    private Date data_solicitacao;
    private String sexo;
    private Integer idade;
    private String municipio_residencia;
    private String solicitante;
    private String municipio_solicitante;
    private String codigo_cid;
    private String carater;
    private String tipo_internacao;
    private String tipo_leito;
    private Date data_autorizacao;  
    private Date data_internacao;
    private Date data_alta;
    private String executante;
    private Integer horas_na_fila;



    public User(Date data_extracao, String id_usuario, String situacao, String central_regulacao_origem, Date data_solicitacao, String sexo, Integer idade, String municipio_residencia, String solicitante, String municipio_solicitante, String codigo_cid, String carater, String tipo_internacao, String tipo_leito, Date data_autorizacao, Date data_internacao, Date data_alta, String executante, Integer horas_na_fila) {
        this.data_extracao = data_extracao;
        this.id_usuario = id_usuario;
        this.situacao = situacao;
        this.central_regulacao_origem = central_regulacao_origem;
        this.data_solicitacao = data_solicitacao;
        this.sexo = sexo;
        this.idade = idade;
        this.municipio_residencia = municipio_residencia;
        this.solicitante = solicitante;
        this.municipio_solicitante = municipio_solicitante;
        this.codigo_cid = codigo_cid;
        this.carater = carater;
        this.tipo_internacao = tipo_internacao;
        this.tipo_leito = tipo_leito;
        this.data_autorizacao = data_autorizacao;
        this.data_internacao = data_internacao;
        this.data_alta = data_alta;
        this.executante = executante;
        this.horas_na_fila = horas_na_fila;
    }



    public Date getData_extracao() {
        return this.data_extracao;
    }

    public void setData_extracao(Date data_extracao) {
        this.data_extracao = data_extracao;
    }

    public String getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String isSituacao() {
        return this.situacao;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCentral_regulacao_origem() {
        return this.central_regulacao_origem;
    }

    public void setCentral_regulacao_origem(String central_regulacao_origem) {
        this.central_regulacao_origem = central_regulacao_origem;
    }

    public Date getData_solicitacao() {
        return this.data_solicitacao;
    }

    public void setData_solicitacao(Date data_solicitacao) {
        this.data_solicitacao = data_solicitacao;
    }

    public String isSexo() {
        return this.sexo;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getMunicipio_residencia() {
        return this.municipio_residencia;
    }

    public void setMunicipio_residencia(String municipio_residencia) {
        this.municipio_residencia = municipio_residencia;
    }

    public String getSolicitante() {
        return this.solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getMunicipio_solicitante() {
        return this.municipio_solicitante;
    }

    public void setMunicipio_solicitante(String municipio_solicitante) {
        this.municipio_solicitante = municipio_solicitante;
    }

    public String getCodigo_cid() {
        return this.codigo_cid;
    }

    public void setCodigo_cid(String codigo_cid) {
        this.codigo_cid = codigo_cid;
    }

    public String getCarater() {
        return this.carater;
    }

    public void setCarater(String carater) {
        this.carater = carater;
    }

    public String isTipo_internacao() {
        return this.tipo_internacao;
    }

    public String getTipo_internacao() {
        return this.tipo_internacao;
    }

    public void setTipo_internacao(String tipo_internacao) {
        this.tipo_internacao = tipo_internacao;
    }

    public String getTipo_leito() {
        return this.tipo_leito;
    }

    public void setTipo_leito(String tipo_leito) {
        this.tipo_leito = tipo_leito;
    }

    public Date getData_autorizacao() {
        return this.data_autorizacao;
    }

    public void setData_autorizacao(Date data_autorizacao) {
        this.data_autorizacao = data_autorizacao;
    }

    public Date getData_internacao() {
        return this.data_internacao;
    }

    public void setData_internacao(Date data_internacao) {
        this.data_internacao = data_internacao;
    }

    public Date getData_alta() {
        return this.data_alta;
    }

    public void setData_alta(Date data_alta) {
        this.data_alta = data_alta;
    }

    public String getExecutante() {
        return this.executante;
    }

    public void setExecutante(String executante) {
        this.executante = executante;
    }

    public Integer getHoras_na_fila() {
        return this.horas_na_fila;
    }

    public void setHoras_na_fila(Integer horas_na_fila) {
        this.horas_na_fila = horas_na_fila;
    }


    @Override
    public String toString() {
        return "{" +
            " data_extracao='" + getData_extracao() + "'"+ "\n" +
            ", id_usuario='" + getId_usuario() + "'"+ "\n" +
            ", situacao='" + getSituacao() + "'"+ "\n" +
            ", central_regulacao_origem='" + getCentral_regulacao_origem() + "'"+ "\n" +
            ", data_solicitacao='" + getData_solicitacao() + "'"+ "\n" +
            ", sexo='" + getSexo() + "'"+ "\n" +
            ", idade='" + getIdade() + "'"+ "\n" +
            ", municipio_residencia='" + getMunicipio_residencia() + "'"+ "\n" +
            ", solicitante='" + getSolicitante() + "'"+ "\n" +
            ", municipio_solicitante='" + getMunicipio_solicitante() + "'"+ "\n" +
            ", codigo_cid='" + getCodigo_cid() + "'"+ "\n" +
            ", carater='" + getCarater() + "'"+ "\n" +
            ", tipo_internacao='" + getTipo_internacao() + "'"+ "\n" +
            ", tipo_leito='" + getTipo_leito() + "'"+ "\n" +
            ", data_autorizacao='" + getData_autorizacao() + "'"+ "\n" +
            ", data_internacao='" + getData_internacao() + "'"+ "\n" +
            ", data_alta='" + getData_alta() + "'"+ "\n" +
            ", executante='" + getExecutante() + "'"+ "\n" +
            ", horas_na_fila='" + getHoras_na_fila() + "'" +
            "}\n\n";
    }


}
