package Graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph<T> implements GraphInterface{

    public ArrayList<Vertex<T>> vertices;

    public DirectedGraph(){
        vertices = new ArrayList<>();
    }

    @Override
    public void addVertices(Vertex v) {
        vertices.add(v);
    }

    public void addEdge(Vertex from, Vertex to){
        from.addEdge(to);
    }

    @Override
    public void removeVertices(Vertex v) {
        vertices.remove(v);
        vertices.forEach(curr -> curr.removeEdge(v));
    }

    @Override
    public void removeEdge(Vertex from, Vertex to) {
        from.removeEdge(to);
    }

    public int getWeight(Vertex from, Vertex to){
        return from.getWeight(to);
    }

    public static void main(String[] args) {
        DirectedGraph<Integer> graph = new DirectedGraph();

        Vertex<Integer> test = new Vertex<>(1);
        Vertex<String> test1 = new Vertex<>("love");

        graph.addVertices(test);
        graph.addVertices(test1);

        graph.addEdge(test, test1);
        graph.removeVertices(test1);
        graph.addVertices(test);
        graph.addEdge(test, test);

        System.out.println(graph.vertices);
        System.out.println(graph.vertices.get(0).edgeList);
        System.out.println(graph.vertices.get(1).edgeList);

    }
}
