package dominio;

import javax.swing.JOptionPane;

public class Venda {

    private double[] produtos;
    private double valorAPagar = 0;
    private double valorAcrescimo = 0;
    private double valorDesconto = 0;
    private int quantidade;
    private String tipoVenda;
    PagarCompra pagarCompra ;


    public Venda() {
    }
    public void setVenda(int produto){
        this.produtos = new double[produto];
    }

    public int verificarQuantidadeDeItens(){

            while (true) {
                try {
                    quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade total de itens: "));

                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Digito inválido!", "", JOptionPane.ERROR_MESSAGE);
                    verificarQuantidadeDeItens();
                }
                break;
            }
            return quantidade;
        }

        public void addprodutos(){
            int i;
            for(i = 0; i < this.produtos.length;i++){
                double valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor do " + (i + 1) +"º Produto" ));
                this.produtos[i] = valor;
            }
        }
        public double somarProdutos(){
           double somaProdutos = 0;
            for (double produto: produtos) somaProdutos += produto;
            return somaProdutos;
        }
        public double pagandoCompra(){
            switch (pagarCompra){
                case PAGAMENTO_PIX:
                    valorDesconto = (somarProdutos() * 5 / 100);
                    valorAPagar = somarProdutos() - valorDesconto;
                    valorAcrescimo = 0;
                    tipoVenda = pagarCompra.getTipo();
                    System.out.println("pix");
                    break;

                case PAGAMENTO_DEBITO:
                    valorAcrescimo = (somarProdutos() * 1.04 / 100);
                    valorAPagar = somarProdutos() + valorAcrescimo;
                    valorDesconto = 0;
                    tipoVenda = pagarCompra.getTipo();
                    System.out.println("debito");
                    break;

                case PAGAMENTO_CREDITO:
                    valorAcrescimo = (somarProdutos() * 6 / 100);
                    valorAPagar = somarProdutos() + valorAcrescimo;
                    valorDesconto = 0;
                    tipoVenda = pagarCompra.getTipo();
                    System.out.println("credito");
                    break;

                case PAGAMENTO_DINHEIRO:
                    valorDesconto = (somarProdutos() * 10 / 100);
                    valorAPagar = somarProdutos() - valorDesconto;
                    valorAcrescimo = 0;
                    tipoVenda = pagarCompra.getTipo();
                    System.out.println("dinheiro");
                    break;

                case PAGAMENTO_DESCONTO:
                    double percentualDesconto = Integer.parseInt(JOptionPane.showInputDialog("Digite o percentual " +
                            "de desconto: "));
                    valorAcrescimo = 0;
                    valorDesconto = somarProdutos() * percentualDesconto / 100;
                    valorAPagar = somarProdutos() - valorDesconto;
                    tipoVenda = pagarCompra.getTipo();
                    System.out.println("desconto");
                    break;

                case PAGAMENTO_AVULSO:
                    System.out.println("Avulso");
                    valorAcrescimo = 0;
                    valorDesconto = 0;
                    valorAPagar = somarProdutos();
                    tipoVenda = pagarCompra.getTipo();
                    break;
            }
            return valorAPagar;
        }

        public PagarCompra getPagarCompra() {
            return pagarCompra;
    }
        public void setPagarCompra(PagarCompra pagarCompra) {
            this.pagarCompra = pagarCompra;
    }
        public double getValorAPagar() {
            return valorAPagar;
    }
        public double getValorAcrescimo() {
            return valorAcrescimo;
    }
        public double getValorDesconto() {
            return valorDesconto;
    }
        public String getTipoVenda() {
            return tipoVenda;
    }
}





