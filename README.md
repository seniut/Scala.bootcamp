# Basics
A poker deck contains 52 cards - each card has a suit which is one of clubs, diamonds, hearts, or spades (denoted c, d, h, and s in the input data).

Each card also has a value which is one of 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace (denoted 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A).

For scoring purposes, the suits are unordered while the values are ordered as given above, with 2 being the lowest and ace the highest value.

A poker hand consists of 5 cards dealt from the deck. Poker hands are ranked by the following partial order from lowest to highest.

#### High Card
Hands which do not fit any higher category are ranked by the value of their highest card. If the highest cards have the same value, the hands are ranked by the next highest, and so on.

#### Pair
2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.

#### Two Pair
The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.

#### Three of a Kind
Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.

#### Straight
Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card. 

#### Flush
Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.

#### Full House
3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.

#### Four of a kind
4 cards with the same value. Ranked by the value of the 4 cards.

#### Straight flush
5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.

Your job is to rank pairs of poker hands and to indicate which, if either, has a higher rank.

# Instraction
Enter card on bord and hands in the following format:

<5 board cards> <hand 1> <hand 2> <...> <hand N>

"hand x" is 2 or 4 cards

"card" is a 2 character string with the first character representing the Values and the second character representing the Suits

Suits: C=Clubs, H=Hearts, S=Spades, D=Diamonds

Values: 2,3,4,5,6,7,8,9,T,J,Q,K,A

# Example of input
4cKs4h8s7s Ad4s Ac4d As9s KhKd 5d6d

OR

4cKs4h8s7s Ad4sTd2s Ac4d5c6c As9s7d8d KhKdAsTs 5d6d9c8c

Application would work only for valid passed card. Validation mechanism is included.

Also, the App works for evaluating Texas Hold'em and OMAHA Hands.

# Output
The output is to be written to standard output using the format:

* <hand block 1> <hand block 2> <...> <hand block n>
* <hand block 1> is the hand block with the weakest value
* <hand block 2> is the hand block with the second weakest value
* <hand block n> is the hand block with the strongest value.
Example:
Ad4s, Ac4d, 5d6d, As9s, KhKd

OR

Ac4d5c6c, 5d6d9c8c, Ad4sTd2s, As9s7d8d, KhKdAsTs

#Wasn't implemented: 
* In case there are multiple hands with the same value on the same board they should be ordered alphabetically and separated by "=" signs,

#Building
For build and run App need to use SBT:
* In directory with "build.sbt" file run command: 

sbt
* in sbt console run command:
 
compile
* then in sbt console run command:

run

 