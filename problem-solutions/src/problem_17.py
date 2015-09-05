"""
Problem 17 - Number letter counts

If the numbers 1 to 5 are written out in words: one, two, three, four, five,
then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two)
contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing
out numbers is in compliance with British usage.
"""

one_to_nine = 3 + 3 + 5 + 4 + 4 + 3 + 5 + 5 + 4
eleven_to_nineteen = 3 + 6 + 6 + 8 + 8 + 7 + 7 + 9 + 8 + 8
twenty_to_ninety_nine = 8 * one_to_nine
one_hundred_to_nine_nine_nine = one_to_nine * 100 + (one_to_nine + eleven_to_nineteen + twenty_to_ninety_nine) * 9 + 7 * 9 + 9 * 99 * 10
one_thousand = 11

sum_letters = one_to_nine * 100
sum_letters += eleven_to_nineteen + twenty_to_ninety_nine + one_hundred_to_nine_nine_nine + one_thousand


print(sum_letters)






