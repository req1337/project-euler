import time
from itertools import combinations_with_replacement


def is_abundant(n):
    s = 0
    for i in range(1, int(n/2)+1):
        if n % i == 0:
            s += i
    return s > n

limit = 28123

start = time.time()

a = [x for x in range(12, limit) if is_abundant(x)]

sums = set()

for a, b in combinations_with_replacement(a, 2):
    if a + b < limit:
        sums.add(a + b)

solution = sum(range(limit)) - sum(sums)

print(solution, "found in:", time.time() - start, "seconds")
