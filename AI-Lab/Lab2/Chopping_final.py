class TreeNode:
    def __init__(self, value):
        self.value = value
        self.children = []
        self.parent =None

    def add_child(self, child_node):
        child_node.parent = self  # Set parent when adding child
        self.children.append(child_node)

    def __repr__(self, level=0):
        ret = "\t" * level + repr(self.value) + "\n"
        for child in self.children:
            ret += child.__repr__(level + 1)
        return ret

    @staticmethod
    def create_node(value):
        return TreeNode(value)

    def remove_child_by_value(self, value):
        for child in self.children:
            if child.value == value:
                self.children.remove(child)
                return True
        return False

    def find_node_by_value(self, value):
        if self.value == value:
            return self

        for child in self.children:
            result = child.find_node_by_value(value)
            if result:
                return result

        return None

    def find_node_by_value(self, value):
        if self.value == value:
            return self

        for child in self.children:
            result = child.find_node_by_value(value)
            if result:
                return result

        return None

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

# Build the tree and add new nodes
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

#===============================================================================
# Find and remove the "news agent" node from the tree (chopping)
node_to_remove = root_node.find_node_by_value("news agent")

if node_to_remove:
    parent_node = node_to_remove.parent
    parent_node.remove_child_by_value("news agent")

    print("\nTree after removing 'news agent':")
    display_tree_with_paths(root_node)
else:
    print("\n'news agent' not found in the tree.")
# Create a separate subtree
subtree_root = TreeNode("subtree_root")
subtree_root.add_child(TreeNode("campustree"))
subtree_root.add_child(TreeNode("subtree_child2"))

# Find the node to which you want to attach the subtree
attach_to_node = root_node.find_node_by_value("park")
# Attach the subtree to the specified node
if attach_to_node:
    for child in subtree_root.children:
        attach_to_node.add_child(child)

    print("\nTree after attaching the subtree:")
    display_tree_with_paths(root_node)
else:
    print("\n'news agent' not found in the tree.")
