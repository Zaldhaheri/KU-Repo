import networkx as nx
import matplotlib as plt

edge_list = [(1,2),(2,2),(3,5),(5,4),(1,4)]

G = nx.Graph()
G.add_edges_from(edge_list)
plt.show(G)