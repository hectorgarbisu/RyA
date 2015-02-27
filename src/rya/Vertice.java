package rya;

import java.util.ArrayList;
import java.util.Arrays;

public class Vertice {
    private int valor;
    private ArrayList<Arista> aristas;    

    public Vertice(int valor, ArrayList aristas) {
        this.valor = valor;
        this.aristas = aristas;
    }
    public Vertice(int valor, Arista[] aristas){
        this(valor, new ArrayList<>(Arrays.asList(aristas)));
    }
    public Vertice(int valor){
        this(valor, new ArrayList<>());
    }
    
    public void addArista(Arista arista){
        if(!aristas.contains(arista)) aristas.add(arista);
    }
    public void removeArista(Arista arista){
        if(aristas.contains(arista)) aristas.remove(arista);
    }
    
    public int getValor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    
    public ArrayList<Arista> getAristas(){
        return aristas;
    }
    public void setArista(ArrayList<Arista> aristas){
        this.aristas = aristas;
    }
    
    public ArrayList<Vertice> getVertices(){
        ArrayList<Vertice> vertices = new ArrayList<>();
        for (Arista arista : aristas) {
            if(!vertices.contains(arista.getU())) vertices.add(arista.getU());
            else if(!vertices.contains(arista.getV())) vertices.add(arista.getV());
        }
        vertices.remove(valor);
        return vertices;
    }
    public int getPesoTotal(){
        int pesoTotal = 0;
        for (Arista arista : aristas) {
            pesoTotal += arista.getPeso();
        }
        return pesoTotal;
    }
    public boolean isConnected (Vertice vertice){
        for (Arista arista : aristas) {
            if(arista.getU()==vertice || arista.getV() == vertice) return true;
        }
        return false;
    }
    public boolean isConnected (Arista arista){
        return aristas.contains(arista);
    }
    public void link(Arista arista) {
        if(!aristas.contains(arista)) aristas.add(arista);
    }
    public Grafo getBestPath(Vertice verticeFinal){
     return getBestPath(this, new Grafo(), verticeFinal, Integer.MAX_VALUE);
    }
    
    private Grafo getBestPath(Vertice padre ,Grafo ascendentes, Vertice verticeFinal, int max){
        if(ascendentes.getPesoTotal() >= max) return new Grafo();
        if(ascendentes.contains(this)) return new Grafo();
        ascendentes.add(this);
        if(verticeFinal == this){
            return ascendentes;
        }
        Grafo candidato = new Grafo();
        Grafo mejorCandidato = new Grafo();
        //ORDENAR ARISTAS
        Vertice vertice;
        for (Arista arista : this.getAristas()) {
            if(arista.getU()==this) vertice = arista.getV();
            else vertice = arista.getU();
            System.out.println(ascendentes + " " + vertice);
            candidato = vertice.getBestPath(this, new Grafo(ascendentes), verticeFinal, max);
            mejorCandidato = candidato.mejorRuta(mejorCandidato);
            if(mejorCandidato.getPesoTotal()>0)max=mejorCandidato.getPesoTotal();
        }
        return mejorCandidato;
    }
    
    
    @Override
    public String toString(){
        return "" + valor;
    }

}