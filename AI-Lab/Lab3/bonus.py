class Graph:
    def __init__(self):
        self.vertices = {}

    def add_vertex(self, name):
        if name not in self.vertices:
            self.vertices[name] = []

    def add_edge(self, source, destination, distance):
        self.vertices[source].append((destination, distance))
        self.vertices[destination].append((source, distance))


# Creating the Romania map graph
romania_map = Graph()

# Adding cities
cities = [
    "Arad", "Zerind", "Oradea", "Sibiu", "Timisoara", "Lugoj",
    "Mehadia", "Drobeta", "Craiova", "Rimnicu Vilcea", "Fagaras",
    "Pitesti", "Bucharest", "Giurgiu", "Urziceni", "Hirsova",
    "Eforie", "Vaslui", "Iasi", "Neamt"
]

for city in cities:
    romania_map.add_vertex(city)

# Adding roads
roads = [
    ("Arad", "Zerind", 75),
    ("Arad", "Timisoara", 118),
    ("Arad", "Sibiu", 140),
    ("Zerind", "Oradea", 71),
    ("Oradea", "Sibiu", 151),
    ("Timisoara", "Lugoj", 111),
    ("Lugoj", "Mehadia", 70),
    ("Mehadia", "Drobeta", 75),
    ("Drobeta", "Craiova", 120),
    ("Sibiu", "Rimnicu Vilcea", 80),
    ("Sibiu", "Fagaras", 99),
    ("Rimnicu Vilcea", "Craiova", 146),
    ("Rimnicu Vilcea", "Pitesti", 97),
    ("Fagaras", "Bucharest", 211),
    ("Pitesti", "Bucharest", 101),
    ("Craiova", "Pitesti", 138),
    ("Bucharest", "Giurgiu", 90),
    ("Bucharest", "Urziceni", 85),
    ("Urziceni", "Hirsova", 98),
    ("Hirsova", "Eforie", 86),
    ("Urziceni", "Vaslui", 142),
    ("Vaslui", "Iasi", 92),
    ("Iasi", "Neamt", 87)
]

for road in roads:
    romania_map.add_edge(road[0], road[1], road[2])

def best_first_search(graph, start, goal):
    visited = set()
    queue = [(0, start, [])]

    while queue:
        cost, current, path = queue.pop(0)
        if current == goal:
            return path + [current]
        if current not in visited:
            visited.add(current)
            for neighbor, distance in graph.vertices[current]:
                if neighbor not in visited:
                    queue.append((distance, neighbor, path + [current]))
            queue.sort(key=lambda x: x[0])

    return None

# Applying BestFS from Arad to Bucharest
start_city = "Arad"
goal_city = "Bucharest"
path = best_first_search(romania_map, start_city, goal_city)

if path:
    print("Best path from", start_city, "to", goal_city, ":", path)
else:
    print("No path found from", start_city, "to", goal_city)
