package com.pepcoding.dsa.prepNotes.graphs;

public class MST06 {
	/*
******Minimum Spanning Tree*******
An MST, or Minimum Spanning Tree, is a spanning tree of a connected, undirected graph that has the minimum 
possible total edge weight compared to all other spanning trees of the graph. Here are the key characteristics
 and properties of an MST:

Key Concepts:

1.Spanning Tree:

A spanning tree is a subgraph that includes all the vertices of the original graph and is a tree 
(i.e., it has no cycles).
For a graph with V vertices, a spanning tree will have V−1 edges.

2.Minimum Spanning Tree (MST):

Among all possible spanning trees of a graph, the MST is the one with the minimum total edge weight.
The MST connects all the vertices together with the least total edge cost.

--Properties of an MST:

Unique for Distinct Edge Weights: If all the edge weights are distinct, the graph will have a unique MST.

Same Number of Edges: An MST will always have V−1 edges if the graph has V vertices.

No Cycles: Since it is a tree, it contains no cycles.

Connected: All vertices in the graph are connected.

--Applications of MST:
Network Design: Designing efficient and cost-effective network infrastructure 
(e.g., computer networks, telecommunications networks).

Approximation Algorithms: Used in algorithms for NP-hard problems like the Traveling Salesman Problem (TSP).

Cluster Analysis: Used in clustering algorithms in machine learning and data analysis.

--Algorithms to Find an MST:
The two most popular algorithms to find the MST of a graph are Prim's Algorithm and Kruskal's Algorithm.

1.Prim's Algorithm:

Starts from an arbitrary vertex and grows the MST one edge at a time by adding the smallest edge that 
connects a vertex in the MST to a vertex outside the MST.

Efficient with priority queues and adjacency lists.

2.Kruskal's Algorithm:

Starts with all vertices as individual sets and repeatedly adds the smallest edge that connects two different sets
until all vertices are in one set (i.e., the MST).
Efficient with union-find data structures.


	 */

}
