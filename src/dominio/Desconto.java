package dominio;

import javax.swing.*;

public class Desconto {

    private double[] produtos;
    private double result;


        public Desconto(int produto){
            this.produtos = new double[produto];
        }

        public void addprodutos(){
            int i;
            for(i = 0; i < this.produtos.length;i++){
                double valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o " + (i + 1) +"º Produto" ));
                this.produtos[i] = valor;
            }

        }
        public double somarProdutos(){
           double somaProdutos = 0;
            for (double produto: produtos){
                somaProdutos += produto;

            }
            return somaProdutos;
        }
        public double[] aplicarDesconto(double desconto){

            double valorProdutos = somarProdutos();
            double valorDoDesconto = valorProdutos * desconto /100;
            double valorComDesconto = valorProdutos - valorDoDesconto;
            double[] result = {valorDoDesconto,valorComDesconto};
            return result;

        }


        }





