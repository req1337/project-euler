import time
from itertools import permutations

start = time.time()

for i, p in enumerate(permutations(range(10), 10)):
    if i == 999999:
        solution = p

print(solution, "found in:", time.time() - start, "seconds")





