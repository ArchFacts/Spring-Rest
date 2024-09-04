package Facts.Arch.ArchFacts.enums;

public enum MetodoPagamento {
    CARTAO("cartão"),
    BOLETO("boleto"),
    PIX("pix");

    private String metodoPagamento;

    MetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
