package com.mindbank.dag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DagApplication {

	public static void main(String[] args) {


		SpringApplication.run(DagApplication.class, args);

		DagService dagService = new DagService();

		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);

		dagService.addEdge(new Edge(v1, v2));
		dagService.addEdge(new Edge(v1, v3));
		dagService.addEdge(new Edge(v3, v4));
		dagService.addEdge(new Edge(v2, v4));
		dagService.addEdge(new Edge(v4, v5));

		System.out.println("Longest path starting from v1: " + dagService.findLongestPath(v1));
	}

}
