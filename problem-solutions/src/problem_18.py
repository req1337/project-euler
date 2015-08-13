"""
Problem 18 - Maximum path sum I

By starting at the top of the triangle below and moving to adjacent
numbers on the row below, the maximum total from top to bottom is 23.

    3
   7 4
  2 4 6
 8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.
"""


class BinaryTree:
    """
      Data model used to represent the triangle
    """

    def __init__(self, value):
        self.max = 0
        self.left = None
        self.right = None
        self.value = int(value)

    def setLeft(self, value):
        self.left = BinaryTree(value)

    def setRight(self, value):
        self.right = BinaryTree(value)

    def isLeaf(self):
        if self.left is None and self.right is None:
            return True
        return False

    def maxPathSum(self, sum):
        sum += self.value
        # If node a leaf node or has already been visited from a path with a greater sum
        if self.isLeaf() or sum < self.max:
            return sum
        else:
            self.max = sum
            return max(self.left.maxPathSum(sum), self.right.maxPathSum(sum))


def load_data(path):
    """
      Load triangle into a list of lists where each outer list represents a row in the triangle
    """
    with open(path) as f:
        lines = f.read()
    return [l.split() for l in lines.split('\n')]


def construct_binary_tree(data):
    """
      TODO: Simplify
      Build a binary tree representation of the rectangle
    """
    root = BinaryTree(data[0][0])
    nodes = [root]
    for i in range(0, len(data) - 1):
        child_nodes, last_right_node = [], None
        for j in range(0, len(nodes)):
            # For all left child nodes except the outer left node on each level
            # The left child node is shared with the right child node of the adjacent node to the left
            if j == 0:
                nodes[j].setLeft(data[i + 1][j])
                child_nodes.append(nodes[j].left)
            else:
                nodes[j].left = last_right_node
            nodes[j].setRight(data[i + 1][j + 1])
            last_right_node = nodes[j].right
            child_nodes.append(nodes[j].right)
        nodes = child_nodes
    return root


def run():
    data = load_data('triangle.txt')
    print('Constructing tree...')
    root = construct_binary_tree(data)
    print('Calculating max path sum...')
    print(root.maxPathSum(0))

if __name__ == "__main__":
    run()
