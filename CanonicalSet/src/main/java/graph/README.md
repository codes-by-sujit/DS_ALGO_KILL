Understood. This is your **Graph Mastery Bucket List** — structured exactly like a serious MAANG candidate would prepare it.

Goal:
Once you identify *“This is a graph problem”*, it must fall into one of these buckets. Nothing should feel new.

---

# 🧠 GRAPH – Canonical Level-wise Mastery List

---

# 🔹 LEVEL 1 — Graph Fundamentals (Traversal + Representation)

> If you can’t do these in your sleep, don’t move ahead.

### Patterns Covered

* BFS
* DFS
* Connected Components
* Basic matrix-as-graph
* Flood fill
* Undirected cycle detection

| Pattern                      | LeetCode | Problem                        | When to Choose           |
| ---------------------------- | -------- | ------------------------------ | ------------------------ |
| BFS traversal                | 200      | Number of Islands              | Grid + count components  |
| DFS traversal                | 695      | Max Area of Island             | Grid + size of component |
| Flood Fill                   | 733      | Flood Fill                     | Same color region        |
| Connected components         | 547      | Number of Provinces            | Adjacency matrix         |
| BFS shortest path            | 1091     | Shortest Path in Binary Matrix | Unweighted shortest path |
| Cycle detection (Undirected) | 684      | Redundant Connection           | Extra edge in tree       |
| Graph valid tree             | 261      | Graph Valid Tree               | Check tree properties    |

---

# 🔹 LEVEL 2 — Multi-Source BFS & Layered Thinking

> Whenever distance grows level by level → think BFS layers.

| Pattern            | LeetCode | Problem                 | When to Choose            |
| ------------------ | -------- | ----------------------- | ------------------------- |
| Multi-source BFS   | 994      | Rotting Oranges         | Multiple start points     |
| Distance transform | 542      | 01 Matrix               | Nearest 0                 |
| BFS with state     | 752      | Open the Lock           | State transitions         |
| Word ladder        | 127      | Word Ladder             | Transformation graph      |
| Bi-directional BFS | 127      | Word Ladder (optimized) | Shortest path large graph |
| Walls & Gates      | 286      | Walls and Gates         | Fill nearest distance     |

---

# 🔹 LEVEL 3 — Topological Sort (DAG Thinking)

> If problem says:

* prerequisite
* dependency
* order
* schedule
* build system

→ It’s Topological Sort.

| Pattern             | LeetCode | Problem                 | When to Choose                 |
| ------------------- | -------- | ----------------------- | ------------------------------ |
| Kahn’s BFS topo     | 207      | Course Schedule         | Detect cycle in directed graph |
| Topo ordering       | 210      | Course Schedule II      | Return order                   |
| DFS topo            | 802      | Eventual Safe States    | Reverse graph thinking         |
| Longest path in DAG | 329      | Longest Increasing Path | DAG via matrix                 |
| Alien Dictionary    | 269      | Alien Dictionary        | Build order from constraints   |

---

# 🔹 LEVEL 4 — Shortest Path Algorithms

> Weighted graph → stop using BFS blindly.

---

## 4A — Dijkstra (Positive weights)

| Pattern           | LeetCode | Problem                         | When to Choose         |
| ----------------- | -------- | ------------------------------- | ---------------------- |
| Basic Dijkstra    | 743      | Network Delay Time              | Weighted shortest path |
| Grid Dijkstra     | 1631     | Path With Minimum Effort        | Minimize max edge      |
| Modified Dijkstra | 1514     | Path with Maximum Probability   | Max heap variant       |
| State Dijkstra    | 787      | Cheapest Flights Within K Stops | Stops constraint       |

---

## 4B — Bellman Ford / Negative edges

| Pattern               | LeetCode | Problem                |
| --------------------- | -------- | ---------------------- |
| Bellman Ford          | 787      | Flights (alt approach) |
| Detect negative cycle | classic  | Interview variant      |

---

## 4C — Floyd Warshall (All pair)

| Pattern                | LeetCode | Problem                           |
| ---------------------- | -------- | --------------------------------- |
| All pair shortest path | 1334     | Find City With Smallest Neighbors |

---

# 🔹 LEVEL 5 — Union Find (Disjoint Set)

> When you don’t care about traversal but only connectivity.

| Pattern               | LeetCode | Problem                              | When to Choose |
| --------------------- | -------- | ------------------------------------ | -------------- |
| Basic DSU             | 547      | Number of Provinces                  |                |
| Cycle detection       | 684      | Redundant Connection                 |                |
| Dynamic connectivity  | 305      | Number of Islands II                 |                |
| Equations possible    | 990      | Satisfiability of Equality Equations |                |
| Minimum spanning tree | 1584     | Min Cost to Connect Points           |                |

---

# 🔹 LEVEL 6 — Minimum Spanning Tree (MST)

> When problem says:

* connect all points
* minimum cost to connect
* network infrastructure

| Pattern | LeetCode | Problem                             |
| ------- | -------- | ----------------------------------- |
| Kruskal | 1584     | Min Cost to Connect Points          |
| Prim    | 1135     | Connecting Cities With Minimum Cost |

---

# 🔹 LEVEL 7 — Graph + Backtracking (Advanced DFS)

> State explosion problems.

| Pattern           | LeetCode | Problem                         |
| ----------------- | -------- | ------------------------------- |
| All paths         | 797      | All Paths From Source to Target |
| Hamiltonian style | 980      | Unique Paths III                |
| Word search graph | 79       | Word Search                     |

---

# 🔹 LEVEL 8 — Graph + DP (Hard Category)

> This is where MAANG interviews separate candidates.

| Pattern                 | LeetCode | Problem                          |
| ----------------------- | -------- | -------------------------------- |
| DP on DAG               | 329      | Longest Increasing Path          |
| Bitmask BFS             | 847      | Shortest Path Visiting All Nodes |
| Graph coloring          | 886      | Possible Bipartition             |
| Course schedule variant | 2050     | Parallel Courses III             |
| Topo + DP               | 1857     | Largest Color Value              |

---

# 🔹 LEVEL 9 — Advanced Graph Theory

> Rare but powerful.

| Pattern            | LeetCode | Problem              |
| ------------------ | -------- | -------------------- |
| Tarjan SCC         | 1192     | Critical Connections |
| Bridges            | 1192     | Critical Connections |
| Articulation point | variant  | Interview version    |
| Kosaraju           | classic  | SCC                  |
| Bipartite check    | 785      | Is Graph Bipartite   |

---

# 🧠 30-Second Graph Pattern Decision Framework

When you see a problem:

### Step 1 — Is it Graph?

* Nodes?
* Edges?
* Relationship?
* Grid convertable to graph?

If yes →

---

### Step 2 — Is it weighted?

* ❌ No → BFS / DFS
* ✅ Yes → Dijkstra / Bellman

---

### Step 3 — Is it ordering dependency?

→ Topological sort

---

### Step 4 — Only connectivity?

→ Union Find

---

### Step 5 — Connect everything minimal cost?

→ MST

---

### Step 6 — Strong components / bridges?

→ Tarjan

---

# 📌 Your Graph Mastery Checklist

You are MAANG-ready in Graphs when:

* [ ] Can write BFS/DFS without thinking
* [ ] Can implement Dijkstra from memory
* [ ] Can implement Union Find with path compression
* [ ] Can write Topological sort (both BFS + DFS)
* [ ] Can detect cycle (directed + undirected)
* [ ] Can implement Tarjan once without reference
* [ ] Can recognize DAG and apply DP