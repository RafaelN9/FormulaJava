/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulajava.Class;

/**
 *
 * @author joaov
 */
public class Carros {

    private int indice;
    private int volta;
    private int posChegada;

    private static int pos;
    private static float pQuebra;
    private static float pAbastece;
    private static int qtdVoltas;
    private static int finish;

    public Carros(int indice) {
        this.indice = indice;
        this.volta = 0;
        this.posChegada = 0;
    }

    public void acelera() {
        if(this.posChegada != -1){
        if (this.volta == Carros.getQtdVoltas() ) {
            Carros.setPos(Carros.getPos()+1);
            this.posChegada = Carros.getPos();
            Carros.setFinish(Carros.getFinish()+1);
            System.out.println("Carro "+this.indice+" chegou na posicao "+this.posChegada );
            
        } else {
            boolean abastece = pausaAbastecimento();
            boolean quebra = pausaQuebra();
            if (!abastece && !quebra) {
                this.volta++;
                System.out.println("Carro "+this.indice+" acelerou e esta na volta "+this.volta );
            }else{
                if(abastece)
                    System.out.println("Carro "+this.indice+" parou para abastecer na volta "+this.volta);
                if(quebra){
                    System.out.println("Carro "+this.indice+" quebrou na volta "+this.volta );
                }
            }
            
        }
        }
    }

    public boolean pausaAbastecimento() {
        double rand = Math.random() * 100;
        if (rand <= Carros.getpAbastece()) {
            return true;
        }
        return false;
    }

    public boolean pausaQuebra() {
        double rand = Math.random() * 100;
        if (rand <= Carros.getpQuebra()){
            this.posChegada = -1;
            Carros.setFinish(Carros.getFinish()+1);
            return true;
        }
        return false;
    }

    public int getVolta() {
        return volta;
    }

    public void setVolta(int volta) {
        this.volta = volta;
    }

    public static int getQtdVoltas() {
        return qtdVoltas;
    }

    public static void setQtdVoltas(int qtdVoltas) {
        Carros.qtdVoltas = qtdVoltas;
    }

    public static float getpQuebra() {
        return pQuebra;
    }

    public static void setpQuebra(float pQuebra) {
        Carros.pQuebra = pQuebra;
    }

    public static float getpAbastece() {
        return pAbastece;
    }

    public static void setpAbastece(float pAbastece) {
        Carros.pAbastece = pAbastece;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public static int getPos() {
        return pos;
    }

    public static void setPos(int pos) {
        Carros.pos = pos;
    }

    public int getPosChegada() {
        return posChegada;
    }

    public void setPosChegada(int posChegada) {
        this.posChegada = posChegada;
    }

    public static int getFinish() {
        return finish;
    }

    public static void setFinish(int finish) {
        Carros.finish = finish;
    }

}
