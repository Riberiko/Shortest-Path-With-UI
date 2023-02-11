package Graph;

public interface GraphInterface {

    public void addVertices(Vertex v);

    public void addEdge(Vertex from, Vertex to);

    public void removeVertices(Vertex v);

    public void removeEdge(Vertex from, Vertex to);
}
