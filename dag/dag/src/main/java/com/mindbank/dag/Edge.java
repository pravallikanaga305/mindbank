package com.mindbank.dag;

public class Edge {
    Vertex from;
    Vertex to;

    Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }
}
