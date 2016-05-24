"""
Project Euler 54

Poker code is adapted from https://www.udacity.com/course/design-of-computer-programs--cs212
"""

import csv


def read_data():
    """
    Read the poker data and split the hands by players
    """
    poker_hands = []

    with open('resources/p054_poker.txt') as file:
        reader = csv.reader(file, delimiter=' ')
        for row in reader:
            poker_hands.append([row[:5], row[5:]])

    return poker_hands


def best_hand(hands):
    """
    Return the best hand: poker([hand,...]) => hand
    """
    return all_max(hands, key=hand_rank)


def all_max(iterable, key=None):
    """
    all_max accounts for duplicates as well by returning a list thereof to determine ties
    """
    m = max(iterable, key=key)
    return filter(lambda d: d == m, iterable)


def card_ranks(hand):
    """
    Return a list of the ranks, sorted with higher first
    """
    ranks = ["--23456789TJQKA".index(r) for r, s in hand]
    ranks.sort(reverse=True)
    return [5, 4, 3, 2, 1] if ranks == [14, 5, 4, 3, 2] else ranks


def hand_rank(hand):
    """
    Determine the rank of the hand

    - Straight flush: (8,highest)
    - 4 of a kind: (7,rank kind,rank kicker)
    - Full house: (6,threes rank,pair rank)
    - Flush: (5,[10,8,7,5,3])
    - Straight : 4, highest
    - 3 of a kind: (3,rank pair,[7,7,7,5,2])
    - Two pairs: (2,rank highest pair, rank lower pair,[13,11,11,3,3])
    - Kind: (1,kind rank,[11,6,3,2,2])
    - Nothing: (0,7,5,4,3,2)
    """
    ranks = card_ranks(hand)

    # straight flush
    if straight(ranks) and flush(hand):
        return 8, max(ranks)
    # 4 of a kind
    elif kind(4, ranks):
        return 7, kind(4, ranks), kind(1, ranks)
    # full house
    elif kind(3, ranks) and kind(2, ranks):
        return 6, kind(3, ranks), kind(2, ranks)
    # flush
    elif flush(hand):
        return 5, ranks
    # straight
    elif straight(ranks):
        return 4, max(ranks)
    # 3 of a kind
    elif kind(3, ranks):
        return 3, kind(3, ranks), ranks
    # 2 pair
    elif two_pair(ranks):
        return 2, two_pair(ranks)[0], two_pair(ranks)[1], ranks
    # kind
    elif kind(2, ranks):
        return 1, kind(2, ranks), ranks
    # high card
    else:
        return 0, ranks


def straight(ranks):
    """
    Return True if the ordered ranks form a 5-card straight
    """
    return 5 * ranks[0] == sum(ranks) + 10 and len(ranks) == 5


def flush(hand):
    """
    Return True if all the cards have the same suit
    """
    suits = [s for r, s in hand]
    return len(set(suits)) == 1


def kind(n, ranks):
    """
    Return the first rank that this hand has exactly n of.
    Return None if there is no n-of-a-kind in the hand.
    """
    for rank in ranks:
        if ranks.count(rank) == n:
            return rank
    return None


def two_pair(ranks):
    """
    If there are two pair, return the two ranks as a
    tuple: (highest, lowest); otherwise return None.
    """
    h = kind(2, ranks)
    l = kind(2, list(reversed(ranks)))
    return (h, l) if h > l else None


# Read poker data into two hands
hands = read_data()

print(len([h[0] for h in hands if best_hand(h)[0] == h[0]]))
