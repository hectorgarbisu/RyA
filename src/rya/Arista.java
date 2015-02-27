package rya;
public class Arista {
    private Vertice u;
    private Vertice v;
    private int peso;
    
    public Arista(Vertice u, Vertice v, int peso){
        this.u = u;
        this.v = v;
        this.peso = peso;
        u.link(this);
        v.link(this);
    }
    public Arista(int u, int v, int peso){
        this(new Vertice(u), new Vertice(v), peso);
    }
    public Arista(Vertice[] vertices, int u, int v, int peso){
        this(vertices[u], vertices[v], peso);
    }
    
    
    public Vertice getU(){
        return this.u;
    }    
    public Vertice getV(){
        return this.v;
    }
    public int getPeso(){
        return this.peso;
    }
    
   public void setU(Vertice u){
        this.u = u;
   }
   public void setV(Vertice v){
        this.v = v;
   }
   public void setU(int u){
        this.u.setValor(u);
   }
   public void setV(int v){
        this.v.setValor(v);
   }
   public void setPeso(int peso){
        this.peso = peso;
   }
   public String toString (){
       return u + "-" + v + ":" +peso;
   }
}