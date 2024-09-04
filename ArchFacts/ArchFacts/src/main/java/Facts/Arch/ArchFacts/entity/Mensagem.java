package Facts.Arch.ArchFacts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;
@Entity
public class Mensagem {
    private UUID id;
    private String conteudo;
    private LocalDate dataEnvio;
    @ManyToOne
    @JoinColumn (name = "fkRemetente")
    private Usuario remetente;
    @ManyToOne
    @JoinColumn (name = "fkNegocio") // Destinatário
    private Negocio negocio;

    public Mensagem() {
    }


}
