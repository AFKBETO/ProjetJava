# Projet Java : Jeu de questions Réponses

## Composition de l'équipe
* May Gatibelza
* Maya Gawinowski
* Maxime Larroze-Jardiné
* Quang Viet Nguyen

## Analyse du sujet


## Interfaces, classes et énumérations

### Interfaces :
* Phase.java : cette interface permet de gérer les actions de sélection de joueur et du déroulement de chaque phase.

### Classes :
* Main.java : cette classe est la classe principale du programme.
* Phase1.java : implémentation de l'interface Phase.java pour la première partie du déroulement du jeu.
* Phase2.java : implémentation de l'interface Phase.java pour la deuxième partie du déroulement du jeu.
* Phase3.java : implémentation de l'interface Phase.java pour la troisième et dernière partie du déroulement du jeu.
* Question.java : cette classe contrôle la spécification de l'objet question représenté par un texte, un thème et une numéro permettant son identification.
* Questions.java : cette classe permet de gérer une liste de type objet Question
* QCM.java : classe fille de Question.java, il s'agit d'un objet Question composé de plusieurs plusieurs réponses possibles.
* VF.java : classe fille de Question.java, il s'agit d'un objet Question. Elle est spécifiée par un indicateur de type booléen décidant si la question est vrai ou fausse.
* RC.java : classe fille de Question.java, il s'agit d'un Objet Question composé d'un variable correspondant à la bonne réponse que le joueur devra saisir pour gagner des points.
* Theme.java : cette classe permet la gestion des thèmes. Elle permet la création des 10 thèmes utilisés pendant un partie. Elle permet également de réaliser des actions pour sélectionner ou récupérer un nombre de thème en fonction des besoins et de la phase de jeu. 

### Enumération
Themes.java : cette énumération permet de gérer tous les types de thèmes de manière plus optimisée et organisée.
