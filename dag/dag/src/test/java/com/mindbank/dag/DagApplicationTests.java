package com.mindbank.dag;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DagApplicationTests {

	

	@Test
	void testSingleVertex() {
		DagService dag = new DagService();
		Vertex v1 = new Vertex(1);

		assertEquals(0, dag.findLongestPath(v1), "Longest path in a single vertex graph should be 0");
	}

	@Test
	void testTwoConnectedVertices() {
		DagService dag = new DagService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);

		dag.addEdge(new Edge(v1, v2));

		assertEquals(1, dag.findLongestPath(v1), "Longest path from v1 to v2 should be 1");
		assertEquals(0, dag.findLongestPath(v2), "Longest path from v2 (no outgoing edges) should be 0");
	}

	@Test
	void testThreeVerticesLinearPath() {
		DagService dag = new DagService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);

		dag.addEdge(new Edge(v1, v2));
		dag.addEdge(new Edge(v2, v3));

		assertEquals(2, dag.findLongestPath(v1), "Longest path from v1 to v3 through v2 should be 2");
	}

	@Test
	void testMultiplePaths() {
		DagService dag = new DagService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);

		dag.addEdge(new Edge(v1, v2));
		dag.addEdge(new Edge(v1, v3));
		dag.addEdge(new Edge(v2, v4));
		dag.addEdge(new Edge(v3, v4));

		assertEquals(2, dag.findLongestPath(v1), "Longest path from v1 to v4 should be 2");
		assertEquals(1, dag.findLongestPath(v2), "Longest path from v2 to v4 should be 1");
	}

	@Test
	void testDisconnectedGraph() {
		DagService dag = new DagService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);

		dag.addEdge(new Edge(v1, v2));

		assertEquals(0, dag.findLongestPath(v3), "Longest path from a disconnected vertex v3 should be 0");
	}

	@Test
	void testComplexGraph() {
		DagService dag = new DagService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);

		dag.addEdge(new Edge(v1, v2));
		dag.addEdge(new Edge(v2, v3));
		dag.addEdge(new Edge(v3, v4));
		dag.addEdge(new Edge(v1, v5));
		dag.addEdge(new Edge(v5, v6));
		dag.addEdge(new Edge(v6, v4));

		assertEquals(3, dag.findLongestPath(v1), "Longest path from v1 to v4 through v2 or v5 should be 3");
		assertEquals(2, dag.findLongestPath(v2), "Longest path from v2 to v4 should be 2");

	}

	@Test
	void testNoEdgesGraph() {
		DagService dag = new DagService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);

		assertEquals(0, dag.findLongestPath(v1), "Longest path in a graph with no edges should be 0");
		assertEquals(0, dag.findLongestPath(v2), "Longest path in a graph with no edges should be 0");
		assertEquals(0, dag.findLongestPath(v3), "Longest path in a graph with no edges should be 0");
	}

	@Test
	void testMultipleLongestPaths() {
		DagService dag = new DagService();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);

		dag.addEdge(new Edge(v1, v2));
		dag.addEdge(new Edge(v1, v3));
		dag.addEdge(new Edge(v2, v4));
		dag.addEdge(new Edge(v3, v4));
		dag.addEdge(new Edge(v4, v5));

		assertEquals(3, dag.findLongestPath(v1), "Longest path from v1 to v5 should be 3");
	}

}
