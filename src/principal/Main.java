package principal;

import dominio.PagarCompra;
import dominio.Venda;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {

        NumberFormat formatter = new DecimalFormat("0.00 ");

        Venda venda = new Venda();

        int quantidade = venda.verificarQuantidadeDeItens();

        venda.setVenda(quantidade);

        venda.addprodutos();

       String pag = (JOptionPane.showInputDialog(null,"Digite:\n" + "( 1 ) Para Pagamento no Debito" +
                "\n( 2 ) Para pagamento no crédito" + "\n( 3 ) Para pagamento via Pix" +
                "\n( 4 ) Para pagamento no dinheiro" + "\n( 5 ) Para pagamento com desconto" +
                "\n( 6 ) Para pagamento avulso"));

       if (pag.equals("1")) {
            venda.setPagarCompra(PagarCompra.PAGAMENTO_DEBITO);
        }
        else if (pag.equals("2")) {
            venda.setPagarCompra(PagarCompra.PAGAMENTO_CREDITO);
        }
        else if (pag.equals("3")) {
            venda.setPagarCompra(PagarCompra.PAGAMENTO_PIX);
        }
        else if (pag.equals("4")) {
            venda.setPagarCompra(PagarCompra.PAGAMENTO_DINHEIRO);
        }
        else if (pag.equals("5")) {
            venda.setPagarCompra(PagarCompra.PAGAMENTO_DESCONTO);
        }
        else if (pag.equals("6")) {
            venda.setPagarCompra(PagarCompra.PAGAMENTO_AVULSO);
        }
        else{
            venda.setPagarCompra(PagarCompra.PAGAMENTO_AVULSO);
        }

        double teste = venda.pagandoCompra();

       JOptionPane.showMessageDialog(null,"Modalidade: " + venda.getTipoVenda() + "\nO valor dos produtos sem desconto e de R$:" +
                formatter.format(venda.somarProdutos()) + "\nO desconto concedido e de R$:" + formatter.format(venda.getValorDesconto()) +
                "\nO valor dos encargos e de R$: " + formatter.format(venda.getValorAcrescimo()) +
                "\nO valor final da venda e de R$: " + formatter.format(teste));
    }

}
