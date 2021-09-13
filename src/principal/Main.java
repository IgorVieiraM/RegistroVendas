package principal;

import dominio.Desconto;

import javax.swing.JOptionPane;

public class Main {


    public static void main(String[] args) {


        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade total de itens: "));

        Desconto desconto = new Desconto(quantidade);

        desconto.addprodutos();

        double percentualDesconto = Integer.parseInt(JOptionPane.showInputDialog("Digite o percentual de desconto: "));

        double[] descontos = desconto.aplicarDesconto(percentualDesconto);

        JOptionPane.showMessageDialog(null,"O valor dos produtos sem desconto e de R$" +
                desconto.somarProdutos() + "\nO desconto concedido e de %" + percentualDesconto +
                "\nO valor dos produtos com desconto e de R$" + descontos[1] + "\n" +
                "" +
                "Você esta economizando R$" + descontos[0]);







    }

}
