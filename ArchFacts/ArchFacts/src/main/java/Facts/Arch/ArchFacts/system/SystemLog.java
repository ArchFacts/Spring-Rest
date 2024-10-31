package Facts.Arch.ArchFacts.system;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class SystemLog {
    @Schema(description = "Campo que representa o usuário",example = "Júlia")
    private String usuario;
    @Schema(description = "Campo que representa o método",example = "GET")
    private String metodo;
    @Schema(description = "Campo que representa a URI",example = "/logs")
    private String uri;
    @Schema(description = "Campo que representa o status do método",example = "404")
    private String statusCode;
    @Schema(description = "Campo que representa o tempo de resposta",example = "1864ms")
    private String tempoResposta;
    @Schema(description = "Campo que representa o horário e a data do LOG",example = "2023-10-02 09:40:00")
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
