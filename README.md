# Elikta-s-Game
Welcome to Elikta's game ! A game developped in JAVA during the courses of OpenClassRooms.

## About

This application allows you to fight against an IA on 03 games (games explain below) with 03 different game mode : 
  -Attacker mode : Try to guess the secret sequence of the IA !
  -Defender mode : Make your secret sequence, and let the IA try to guess it !
  -Duel mode : Fight against an IA to discover the secret sequence of a second IA !

## First game : Magical Number

The defender (you or the IA) keep a secret digit in mind, the attacker try to guess it with a limited number of try.

The defender will tell you if your proposal is higher or lower ! 

## Second game : Secret Numbers

The defender (your or the IA) have a secret sequence (lenght and numbers allowed defined in the config.properties file)
The attacker have to find that secret sequence.

The defender will tell you for each proposal, wich number is good, smaller or higher (with a "-+=+" type answer)

## Third game : Mastermind

Attacker mode : As your probably know this game, the IA have a secret sequence  (lenght and numbers allowed defined in the config.properties file), for each proposal you make, the IA will tell you how many correct numbers you have and how many "correct numbers but not in the right spot" you have. You challenge is to find it !

Defender mode : On this version, you'll help the IA a bit, by telling him wich number off his proposal is correct, and wich is not (avoiding JVM memory to crash with special algorythm).


## How to compile

Get the source code from GitHub with a clone of this repository : https://github.com/Andryl99/Elikta-s-Game

Import or copy the projet in your favorite IDE => compile => enjoy !

This app was developped with JAVA 10, please make sure you have the correct update.

## Config the app

You will find a config.properties file in the main folder, open it and change all the properties you want !

  / lifeCount = the number of life allowed to find the answer (advice : if you want to enjoy the IA algorythm in defender mode, it is         adviced to set the lifeCount to 6 minimum)
  
  / nbAllowed = the numbers allowed in game's sequences (!! nbAllowed count the 0 as a number, exemple : nbAllowed = 6 => digit allowed       between 0 and 5 included)
       !!! ATTENTION !!! The app is developped only to support a nbAllowed inferior to 10 !!!ATTENTION!!!
       
  / casesLenght = the lenght allowed for the sequences (1234 is a 4 casesLenght sequence, 12345678 is a 8 casesLenght sequence)
  
  / devMode = special mode showing the attacker sequence at the beginning of the game (mainly used to test the app)

## Please enjoy the app and for any questions or commentary, feel free to contact me !

