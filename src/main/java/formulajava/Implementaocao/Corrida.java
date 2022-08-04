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
public class Corrida{

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
    
    public void setStatics(){
        Carros.setpAbastece(this.pAbastece);
        Carros.setpQuebra(this.pQuebra);
        Carros.setQtdVoltas(this.qtdVoltas);
        Carros.setFinish(0);
        Carros.setPos(0);
    }

    public void start() throws InterruptedException {
        System.out.println("\n----------------- Corrida comecou -----------------\n");
        setStatics();
            for (Iterator<Carros> iterator = carros.iterator(); iterator.hasNext();) {
                Carros next = iterator.next();
                    next.start();
            }
        
            for (Iterator<Carros> iterator = carros.iterator(); iterator.hasNext();) {
                Carros next = iterator.next();
                    next.join();
            }
        System.out.println("\n----------------- Corrida terminou -----------------\n");
    }
}
