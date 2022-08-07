/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulajava.Class;

import formulajava.Interface.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author joaov
 */
public class Carros extends Thread {

    private JLabel carro = new JLabel();
    private int indice;
    private int volta;
    private int posChegada;

    private static String msg;
    private static int pos;
    private static float pQuebra;
    private static float pAbastece;
    private static int qtdVoltas;
    private static int finish;
    private static int passo;

    public Carros(int indice) {
        this.indice = indice;
        this.volta = 0;
        this.posChegada = 0;
        this.carro.setText("Carro " + this.indice);
        this.carro.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        this.carro.setForeground(new java.awt.Color(255, 255, 255));
        this.carro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.carro.setBounds(0, 80 * (this.indice - 1), 80, 80);
        String image = "";
        switch (this.indice % 4) {
            case 0:
                image = "blue";
                break;
            case 1:
                image = "pink";
                break;
            case 2:
                image = "reen";
                break;
            case 3:
                image = "yellow";
                break;
        }
        this.carro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulajava/ImgCarro/"+image+".png")));
        Menu.setCarro(this.carro);
    }

    @Override
    public void run() {
        while (this.posChegada == 0) {
            if (this.posChegada != -1) {
                if (this.volta == Carros.getQtdVoltas()) {
                    Carros.setPos(Carros.getPos() + 1);
                    this.posChegada = Carros.getPos();
                    Carros.setFinish(Carros.getFinish() + 1);
                    Carros.setMsg("Carro " + this.indice + " chegou na posicao " + this.posChegada + "\n");

                } else {
                    boolean abastece = pausaAbastecimento();
                    boolean quebra = pausaQuebra();
                    if (!abastece && !quebra) {
                        this.volta++;
                        Carros.setMsg("Carro " + this.indice + " acelerou e esta na volta " + this.volta + "\n");
                        Menu.OutputCorrida("Carro " + this.indice + " acelerou e esta na volta " + this.volta + "\n");
                        this.carro.setBounds(this.volta * Carros.getPasso(), 80 * (this.indice - 1), 80, 80);
                        Menu.setCarro(this.carro);
                    } else {
                        if (abastece) {
                            Carros.setMsg("Carro " + this.indice + " parou para abastecer na volta " + this.volta + "\n");
                            Thread.yield();
                        }
                        if (quebra) {
                            Carros.setMsg("Carro " + this.indice + " quebrou na volta " + this.volta + "\n");
                        }
                    }

                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Carros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (this.posChegada == 1) {
            Menu.Pos1("" + this.indice);
        }
        if (this.posChegada == 2) {
            Menu.Pos2("" + this.indice);
        }
        if (this.posChegada == 3) {
            Menu.Pos3("" + this.indice);
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
        if (rand <= Carros.getpQuebra()) {
            this.posChegada = -1;
            Carros.setFinish(Carros.getFinish() + 1);
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

    public synchronized static void setPos(int pos) {
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

    public static String getMsg() {
        return msg;
    }

    public static void setMsg(String msg) {
        Carros.msg += msg;
    }

    public static int getPasso() {
        return passo;
    }

    public static void setPasso(int passo) {
        Carros.passo = passo;
    }

}
