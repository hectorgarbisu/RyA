package rya;
public class RyA {
    public static void main(String[] args) {
        int nvertices = 8;
        Vertice[] v = new Vertice[nvertices];
        for (int i = 0; i < nvertices; i++) v[i] = new Vertice(i);
        Arista[] aristas1 = {new Arista(v, 0, 1, 1), new Arista(v, 0, 2, 3), new Arista(v, 0, 3, 2),
            new Arista(v, 1, 4, 5), new Arista(v, 1, 6, 3), new Arista(v, 2, 6, 3),
            new Arista(v, 2, 4, 4), new Arista(v, 5, 2, 3), new Arista(v, 3, 5, 2),
            new Arista(v, 3, 6, 7), new Arista(v, 4, 7, 4), new Arista(v, 5, 7, 1), new Arista(v, 6, 7, 1)};
        Grafo grafo = new Grafo(aristas1);
        System.out.println(grafo);
        Grafo rutacorta = v[0].getBestPath(v[6]);
        System.out.println("blim " + rutacorta);
        System.out.println(grafo.aristaString());
        System.out.println(rutacorta.aristaString());
    }     
}