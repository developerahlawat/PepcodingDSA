package com.pepcoding.dsa.prepNotes.graphs;

public class BFS02 {
	/*
Breadth-First Search (BFS) and Depth-First Search (DFS) are fundamental graph traversal algorithms 
with different characteristics and use cases. 
Choosing between BFS and DFS depends on the specific requirements of the problem you are trying to solve. 
Here are some guidelines on when to use each:

----Breadth-First Search (BFS)----


Characteristics:

BFS explores the graph layer by layer, visiting all nodes at the present depth level before 
moving on to nodes at the next depth level.
It uses a queue data structure.


When to Use BFS:

Shortest Path in Unweighted Graphs:

BFS is ideal for finding the shortest path from a source node to a target node in an unweighted graph. 
It guarantees the shortest path due to its level-wise exploration.
Finding Connected Components:

BFS can be used to find and explore all the nodes in a connected component of an undirected graph.
Cycle Detection in Undirected Graphs:

BFS can detect cycles in an undirected graph by checking for back edges.
Level Order Traversal:

BFS is used in scenarios where you need to process nodes level by level, such as level order traversal in trees.
Finding All Nodes Within 'K' Distance:

BFS can be used to find all nodes that are within a certain distance 'K' from a given node.
Example: Finding the shortest path in an unweighted grid:

// Assuming graph is represented as an adjacency list
Queue<Integer> queue = new LinkedList<>();
boolean[] visited = new boolean[graph.length];
queue.add(startNode);
visited[startNode] = true;

while (!queue.isEmpty()) {
    int node = queue.poll();
    // Process the node
    for (int neighbor : graph[node]) {
        if (!visited[neighbor]) {
            queue.add(neighbor);
            visited[neighbor] = true;
        }
    }
}


*********Breadth-First Search (BFS)********
Time Complexity:

Adjacency List Representation: O(V+E)
Adjacency Matrix Representation:O(V2)

Explanation:

In the adjacency list representation, each vertex and each edge is processed once.
V is the number of vertices.
E is the number of edges.

In the adjacency matrix representation, checking for the presence of an edge takes 
O(1) time, but we need to check all possible edges, resulting in O(V2) time.
	 
	 
 */

}
