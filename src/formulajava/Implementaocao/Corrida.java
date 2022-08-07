/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulajava.Implementaocao;

import formulajava.Class.Carros;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author joaov
 */
public class Corrida {

    private int qtdCarros;
    private ArrayList<Carros> carros = new ArrayList<Carros>();
    private int qtdVoltas;
    private float pAbastece;
    private float pQuebra;

    public Corrida(int qtdCarros, float pQuebra, float pAbastece, int qtdVoltas) {
        this.qtdCarros = qtdCarros;
        this.qtdVoltas = qtdVoltas;
        this.pAbastece = pAbastece;
        this.pQuebra = pQuebra;
        for (int i = 1; i <= qtdCarros; i++) {
            Carros car = new Carros(i);
            this.carros.add(car);

        }
        setStatics();
    }

    public String[] top3() {
        String[] chegada = new String[3];
        this.carros.forEach(carro -> {
            int pos = carro.getPosChegada();
            switch (pos) {
                case 1:
                    chegada[0] = Integer.toString(carro.getIndice());
                    break;
                case 2:
                    chegada[1] = Integer.toString(carro.getIndice());

                    break;
                case 3:
                    chegada[2] = Integer.toString(carro.getIndice());

                    break;
                default:
            }
        });
        return chegada;
    }

    public void setStatics() {
        Carros.setpAbastece(this.pAbastece);
        Carros.setpQuebra(this.pQuebra);
        Carros.setQtdVoltas(this.qtdVoltas);
        Carros.setFinish(0);
        Carros.setPos(0);
    }

    public String start() throws InterruptedException {

        setStatics();
            for (Iterator<Carros> iterator = carros.iterator(); iterator.hasNext();) {
                Carros next = iterator.next();
                    next.start();
            }
            for (Iterator<Carros> iterator = carros.iterator(); iterator.hasNext();) {
                Carros next = iterator.next();
                    next.join();
            }
        return Carros.getMsg();
    }
}
