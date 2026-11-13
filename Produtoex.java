package AULA.DEVDOJO.POO;


public class Produtoex {
     private String nome;
     private double preco;
     private int estoque;

    public Produtoex(String nome , double preco , int estoque ){
        this.nome = nome;
        this.setPreco(preco);
        this.estoque = estoque;
    }
    public double getpreco(){
        return preco;
    }
    public void Vender(int QuantidadeDesejada){
        int CalculoUnidadeRestante = estoque - QuantidadeDesejada;

        if (estoque >= QuantidadeDesejada){

            estoque -= QuantidadeDesejada;

            System.out.println("o valor total da venda foi : " + (preco * QuantidadeDesejada));

            System.out.println("no estoque resta  " + CalculoUnidadeRestante+ "  Unidades do jogo ");

        } else {
            System.out.println("estoque insuficiente ");
        }
    }
    public void setPreco(double preco){
        if (preco < 0 ){
            throw new IllegalArgumentException("o preco não pode ser negativo ");
        }
        this.preco = preco;
    }
    public  static void main(String[] args){
        Produtoex produto1 = new Produtoex("jogo-gta6", 450.0 , 50);
        produto1.Vender(40);
        //testando regra de negocio para produto negativo
        System.out.println("--------------------");
        Produtoex produto2 = new Produtoex("banana" , 60 , 30);
        produto2.Vender(40);


    }
}
