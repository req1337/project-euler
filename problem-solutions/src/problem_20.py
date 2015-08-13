"""
  Problem 20 - Factorial digit sum
"""


def factorial_digit_sum(n):
    return n * factorial_digit_sum(n - 1) if n > 1 else 1

print(factorial_digit_sum(100))
