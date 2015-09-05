"""
Problem 15 - Lattice paths

Starting in the top left corner of a 2×2 grid, and only being able to move
to the right and down, there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?
"""

GRID_Y_MAX, GRID_X_MAX = 20, 20
NUM_POSSIBLE_MOVES = 2
NUM_MOVES = GRID_X_MAX + GRID_Y_MAX


def comb(N,k):
    if (k > N) or (N < 0) or (k < 0):
        return 0
    N,k = map(int,(N,k))
    top = N
    val = 1
    while (top > (N-k)):
        val *= top
        top -= 1
    n = 1
    while (n < k+1):
        val /= n
        n += 1
    return val


print('Result:', int(comb(GRID_Y_MAX + GRID_X_MAX, GRID_X_MAX)))
