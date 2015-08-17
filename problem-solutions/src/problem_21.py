"""
  Problem 21 - Amicable numbers
"""

import time


def d(n):
    """
    sum of proper divisors of n
    """
    s = 0
    for i in range(1, n):
        if not n % i: s += i
    return s

start = time.time()

print('Calculating sum of all amicable numbers > 10,000')

MAX, s = 10000, 0

for i in range(2, MAX):
        d_i = d(i)
        if d_i > i and d(d_i) == i:
            s += i + d_i

print(s, "found in:", time.time() - start)
