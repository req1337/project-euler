"""
Problem 13 - Large sum

Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
"""


def run():
    sum = 0
    with open('./data/problem_13.txt') as f:
        for line in f:
            sum += int(line)
    print(str(sum)[0:10])


if __name__ == "__main__":
    run()