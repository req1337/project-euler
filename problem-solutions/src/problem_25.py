import time


def fibonacci(l):
    current = 2; prev = 1; i = 0
    while len(str(current)) < l:
        temp = current
        current += prev
        prev = temp
        i += 1
    return current

start = time.time()

solution = fibonacci(1000)

print(solution, "found in:", time.time() - start, "seconds")
