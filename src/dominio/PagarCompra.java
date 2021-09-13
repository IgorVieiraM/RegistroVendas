package dominio;

public enum PagarCompra {

    PAGAMENTO_DEBITO("Débito"),
    PAGAMENTO_CREDITO("Crédito"),
    PAGAMENTO_PIX("Pix"),
    PAGAMENTO_DINHEIRO("Dinheiro"),
    PAGAMENTO_DESCONTO("Venda com desconto"),
    PAGAMENTO_AVULSO("Venda avulsa")
    ;
    private final String tipo;

    PagarCompra(String tipo) {
        this.tipo = tipo;

    }

    public String getTipo() {
        return tipo;
    }
}
