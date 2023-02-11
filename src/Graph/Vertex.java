package Graph;

import java.util.ArrayList;

public class Vertex<T> {
    private T data;

    ArrayList<Vertex> edgeList;
    ArrayList<Integer> weightList;

    boolean isVisited;

    public Vertex(T data){
        this.data = data;
        edgeList = new ArrayList<>();
        weightList = new ArrayList<>();
    }

    public void addEdge(Vertex v){
        addEdge(v, 0);
    }

    public void addEdge(Vertex v, int weight){
        edgeList.add(v);
        weightList.add(weight);
    }

    public void removeEdge(Vertex v){
        int val = edgeList.indexOf(v);
        edgeList.remove(val);
        weightList.remove(val);
    }

    public int getWeight(Vertex to){
        int val = edgeList.indexOf(to);
        return weightList.get(val);
    }

    public String toString(){
        return data.toString();
    }
}
