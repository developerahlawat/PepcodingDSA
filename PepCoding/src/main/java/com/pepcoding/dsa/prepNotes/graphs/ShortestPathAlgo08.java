package com.pepcoding.dsa.prepNotes.graphs;

public class ShortestPathAlgo08 {
	/*
*****1.Dijkstra's algorithm****** 
It a fundamental algorithm for finding the shortest paths from a source vertex to all other vertices 
in a graph with non-negative edge weights. It is widely used in network routing protocols, geographical
mapping systems, and various optimization problems.

Key Concepts of Dijkstra's Algorithm:
Shortest Path Tree: The algorithm builds a shortest path tree from the source vertex, 
ensuring that the shortest path to each vertex is determined.
Greedy Approach: It repeatedly selects the vertex with the smallest known distance, 
explores its neighbors, and updates their distances if a shorter path is found.

Steps of Dijkstra's Algorithm:

Initialization:

Set the distance to the source vertex to 0.
Set the distance to all other vertices to infinity (or a very large number).
Mark all vertices as unvisited.
Create a priority queue (or a min-heap) to hold vertices by their current known distances.

Algorithm Execution:
While there are unvisited vertices:
Extract the vertex with the smallest distance from the priority queue (initially the source vertex).
For the current vertex, consider all its unvisited neighbors.
For each neighbor, calculate the tentative distance from the source to that neighbor through the current vertex.
If the tentative distance is less than the currently known distance, update the distance and 
add the neighbor to the priority queue (or update its position if it’s already in the queue).
Mark the current vertex as visited.
The process continues until all vertices are visited, and the shortest path to each vertex is determined.

Time Complexity:
Adjacency Matrix Representation: O(V2)
Adjacency List Representation with Binary Heap: O((V+E)log V) --inserting or decreasing key in priority queue log V.
Adjacency List Representation with Fibonacci Heap: O(Vlog V+E)


	 */

}
