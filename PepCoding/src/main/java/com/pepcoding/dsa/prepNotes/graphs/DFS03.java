package com.pepcoding.dsa.prepNotes.graphs;

public class DFS03 {
	/*
	 * 
Depth-First Search (DFS)
Characteristics:

DFS explores as far as possible along each branch before backtracking. It goes deep into the graph's branches.
It uses a stack data structure, which can be implemented using recursion.
When to Use DFS:

Path Finding:

DFS is useful for finding any path between two nodes. 
It doesn't guarantee the shortest path but can be used to find a path if it exists.
Topological Sorting:

DFS is used in topological sorting of directed acyclic graphs (DAGs).
Cycle Detection in Directed Graphs:

DFS can detect cycles in directed graphs by detecting back edges.
Connected Components in Dense Graphs:

DFS is often used to explore all nodes in a dense graph.
Solving Puzzles:

DFS can be used in puzzles where you need to explore all possible configurations, 
such as mazes, Sudoku, and similar problems.


Tree Traversals:

DFS is used for in-order, pre-order, and post-order traversals of a tree.	

 Example: Depth-first traversal of a graph:

	 // Assuming graph is represented as an adjacency list
void dfs(int node, boolean[] visited) {
    visited[node] = true;
    // Process the node
    for (int neighbor : graph[node]) {
        if (!visited[neighbor]) {
            dfs(neighbor, visited);
        }
    }
}



----Summary----
Use BFS when you need the shortest path in an unweighted graph, level order traversal,
 or to find all nodes within a certain distance from a source.
Use DFS when you need to explore all possible paths, find any path between two nodes, 
perform topological sorting, detect cycles in directed graphs, or solve problems that require exhaustive search.
Choosing the right algorithm depends on the specific requirements of your problem, such as whether you need the shortest path, all possible paths, or a specific traversal order.	 

********Depth-First Search (DFS)***********
Time Complexity:

Adjacency List Representation: O(V+E)
Adjacency Matrix Representation: O(V2)
Explanation:

In the adjacency list representation, each vertex is visited once, and all its edges are explored once.
V is the number of vertices.
E is the number of edges.

In the adjacency matrix representation, we need to check for edges between every pair of vertices, resulting in 
O(V2) time.

Summary of Time Complexities
Graph Representation	BFS	DFS
Adjacency List:	O(V+E)	
Adjacency Matrix:O(𝑉2)

Both BFS and DFS have similar time complexities for the same graph representation.
The choice between the two often depends more on the problem requirements rather than 
time complexity considerations alone.	
	

	
*/

}
