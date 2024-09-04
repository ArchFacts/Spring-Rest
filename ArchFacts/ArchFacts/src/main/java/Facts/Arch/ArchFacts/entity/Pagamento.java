package Facts.Arch.ArchFacts.entity;

import Facts.Arch.ArchFacts.enums.MetodoPagamento;
import Facts.Arch.ArchFacts.enums.Status;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;

public class Pagamento {
    private UUID id;
    private LocalDate data;
    private Double valorTotal;
    private Integer parcelas;
    private Integer parcelasPagas;
    private Status status;
    private MetodoPagamento metodoPagamento;
    @ManyToOne
    @JoinColumn (name = "fkTask")
    private Task task;
}
