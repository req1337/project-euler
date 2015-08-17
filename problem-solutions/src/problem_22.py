"""
Problem 22 - Names scores
"""

from string import ascii_uppercase
from collections import OrderedDict

alphabet = OrderedDict((ch, idx) for idx, ch in enumerate(ascii_uppercase, 1))

with open('Resources/p022_names.txt') as f:
    data = f.readlines()

names = sorted(data[0].replace('"', '').split(','))

s = 0

for i in range(len(names)):
    s += sum([alphabet[l] for l in names[i]])*(i+1)

print(s)

