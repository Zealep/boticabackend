package com.zealep.api.salesbackend.model.dto;

import com.zealep.api.salesbackend.model.entity.Empleado;

public class ResponseLogin {

    private Empleado usuario;
    private String result;

    public ResponseLogin(Empleado usuario, String result) {
        this.usuario = usuario;
        this.result = result;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
