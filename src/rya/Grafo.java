package rya;
import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {
    private ArrayList<Vertice> vertices;
    private int pesoTotal = 0;

    public Grafo(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
        this.updatePeso();
    }

    public Grafo(int[] verticesValues){
        this.vertices = new ArrayList<>();
        for (int vertice : verticesValues) {
            this.vertices.add(new Vertice(vertice));
        }
        this.updatePeso();
    }
    
    public Grafo(Arista[] aristas){
        this.vertices = new ArrayList<>();
        for (Arista arista : aristas) {
            if(!vertices.contains(arista.getU())) vertices.add(arista.getU());
            if(!vertices.contains(arista.getV())) vertices.add(arista.getV());
        }
        this.updatePeso();
    }
    public Grafo(int verticeValue){
        this.vertices = new ArrayList<>();
        vertices.add(new Vertice(verticeValue));
        this.updatePeso();
    }
    public Grafo() {
        this(new ArrayList<>());
        this.updatePeso();
    }
    public Grafo(Grafo grafo){
        vertices = new ArrayList<>();
        for (Vertice vertice : grafo.getVertices()) {
            vertices.add(vertice);
        }
    }    
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }
    public ArrayList<Arista> getAristas(){
        ArrayList<Arista> aristas = new ArrayList<>();
        for (Vertice vertice : vertices) {
            for (Arista arista : vertice.getAristas()) {
                if(!vertices.contains(arista.getU()) || !vertices.contains(arista.getV())) continue;
                if(!aristas.contains(arista)) aristas.add(arista);
            }
        }
        return aristas;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public int getPesoTotal() {
        return pesoTotal;
    }
    public void add(Vertice vertice){
//        for (Arista arista : vertice.getAristas()) {
//            if(!this.contains(arista)){
//                arista.getU().link(arista);
//                arista.getV().link(arista);
//                pesoTotal += arista.getPeso();
//            }
//        }    
        vertices.add(vertice);
        updatePeso();
    }
    public boolean contains(Vertice vertice){
        return vertices.contains(vertice);
    }
    public boolean contains(Arista arista){
        for (Vertice vertice : vertices) {
            if(vertice.isConnected(arista)) return true;
        }
        return false;
    }
    public boolean isEmpty(){
        return vertices.isEmpty();
    }
    Grafo mejorRuta(Grafo mejorCandidato) {
        if(mejorCandidato.isEmpty()) return this;
        if(this.isEmpty()) return mejorCandidato;
        if(this.getPesoTotal()>=mejorCandidato.getPesoTotal()) return mejorCandidato;
        System.out.println("La ruta \n" + mejorCandidato + "ha sido sustituida por \n" + this);
        return this;
    }
  
    private void updatePeso(){
        pesoTotal = 0;
        if(vertices.isEmpty()) return;
        for (Arista arista : getAristas()) {
            pesoTotal += arista.getPeso();
        }
    }
    public String toString(){
        String str = "";
        str += this.pesoTotal+ " ";
        for (Vertice vertice : vertices) {
            str += vertice.getValor()+",";
        }
        return str;
    }
    public String aristaString(){
        return getAristas().toString();
    }


}
