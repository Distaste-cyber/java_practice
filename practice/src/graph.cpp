#include <iomanip>
#include <iostream>
#include <vector>
using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int n, m;
  char directedChar;
  cout << "Is the graph directed? (y/n): ";
  cin >> directedChar;
  bool directed = (directedChar == 'y' || directedChar == 'Y');

  cout << "Enter number of vertices (n): ";
  cin >> n;
  if (n <= 0) {
    cerr << "Number of vertices must be positive.\n";
    return 1;
  }

  cout << "Enter number of edges (m): ";
  cin >> m;
  if (m < 0) {
    cerr << "Number of edges cannot be negative.\n";
    return 1;
  }

  // Use 1-based indexing for convenience; matrix is (n+1)x(n+1)
  vector<vector<int>> adj(n + 1, vector<int>(n + 1, 0));

  cout << "Enter " << m << " edges (one per line): u v\n";
  for (int i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    if (u < 1 || u > n || v < 1 || v > n) {
      cerr << "Invalid edge: vertices should be between 1 and " << n << ".\n";
      --i; // let user re-enter this edge
      continue;
    }
    adj[u][v] = 1;
    if (!directed)
      adj[v][u] = 1;
  }

  // Print adjacency matrix header
  cout << "\nAdjacency Matrix (" << (directed ? "Directed" : "Undirected")
       << "):\n\n";
  cout << setw(4) << "";
  for (int j = 1; j <= n; ++j)
    cout << setw(3) << j;
  cout << "\n";

  for (int i = 1; i <= n; ++i) {
    cout << setw(3) << i;
    for (int j = 1; j <= n; ++j) {
      cout << setw(3) << adj[i][j];
    }
    cout << "\n";
  }

  // Complexity notes
  cout << "\nSpace complexity: O(n^2) (adjacency matrix of size n x n)\n";
  cout << "Time to build: O(m) to set edges; Time to print: O(n^2)\n";

  return 0;
}
