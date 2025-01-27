class TreeNode:
    def __init__(self, value):
        self.value = value
        self.children = []
        self.parent= None

    def add_child(self, child_node):
        child_node.parent = self  # Set parent when adding child
        self.children.append(child_node)

# Create the tree structure
root_node = TreeNode("library")

# Create the child nodes
school_node = TreeNode("school")
hospital_node = TreeNode("hospital")
news_agent_node = TreeNode("news agent")
park_node = TreeNode("park")
church_node = TreeNode("church")
university_node = TreeNode("university")
factory_node = TreeNode("factory")

# Build the tree
root_node.add_child(school_node)
root_node.add_child(hospital_node)
school_node.add_child(factory_node)
hospital_node.add_child(park_node)
hospital_node.add_child(news_agent_node)
news_agent_node.add_child(church_node)
news_agent_node.add_child(university_node)

# Display the tree as a tree-like structure with nodes and path indicators
def display_tree_with_paths(node, level=0, path=[]):
    if node is None:
        return

    path_indicator = "|-- " if level > 0 else ""
    print("    " * level + path_indicator + str(node.value))

    for i, child in enumerate(node.children):
        is_last_child = i == len(node.children) - 1
        new_path = path + [is_last_child]
        display_tree_with_paths(child, level + 1, new_path)

display_tree_with_paths(root_node)

