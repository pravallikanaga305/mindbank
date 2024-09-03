Does the solution work for larger graphs?
Because memoization greatly reduces the amount of duplicate calculations, the approach does indeed work for larger graphs.

Can you think of any optimizations?
Memorization has been used as the main optimization. Using topological sorting to make sure every vertex is handled just once is another possible optimization.

What’s the computational complexity of your solution?
In terms of time complexity, O(V+E) 
The numbers V and E represent the number of vertices and edges, respectively. This is because there is only one processing of each vertex and edge.
As a result of the memoization map, the space complexity is O(V).

Are there any unusual cases that aren't handled?
The algorithm considers the graph to be a legitimate DAG. Since this technique is meant to operate on acyclic graphs, it would not function properly if the graph included cycles. Furthermore, it is predicated on the graph being connected from the initial vertex.
Graphs without any outgoing edges from the beginning vertex are examples of common edge situations that this effective approach can manage.
