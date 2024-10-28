package Facts.Arch.ArchFacts.System;

import Facts.Arch.ArchFacts.entities.Usuario;

import java.time.LocalDateTime;

public class SystemLog {
    private String usuario;
    private String metodo;
    private String uri;
    private String statusCode;
    private String tempoResposta;
    private LocalDateTime horario;

    public SystemLog() {
    }

    public SystemLog(String usuario, String metodo, String uri, String statusCode, String tempoResposta,
                     LocalDateTime horario) {
        this.usuario = usuario;
        this.metodo = metodo;
        this.uri = uri;
        this.statusCode = statusCode;
        this.tempoResposta = tempoResposta;
        this.horario = horario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTempoResposta() {
        return tempoResposta;
    }

    public void setTempoResposta(String tempoResposta) {
        this.tempoResposta = tempoResposta;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }
}
