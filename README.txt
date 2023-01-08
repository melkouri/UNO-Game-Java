Mini-project in Computer Science: UNO Game
●	Development in Java using OOP – Programming of a GUI.

Authors: EL KOURI Malak, MASCARO Lauriane, TAKI Moinesha, BETTAN Etienne
Group: 44

This document aims to describe the Projet Uno archive corresponding to a UNO game that can be played by 4 players. It is important to read all of this document to ensure that you can run our program without any problems.

/!\ The wild card color choice must be called choixCouleur NOIR.png and not choixCouleur NOIR.gif (rename if the problem occurs)
/!\ Due to a problem we encountered, the image files for the cards are in the same folder as the classes. If they were in a subfolder of the archive, they did not appear in the game on certain computers.

Part I: Installation and launch

Unzip the archive and then open the Uno.java file in Geany, and then run it. If there are any problems, open all files with the .java extension and compile them.
Part II: Menu
After launching Uno.java, a FenetreMenu will appear. You can then start or quit the game. If you start, the NomJoueurs.java window opens. Each player enters their username in a box, and be sure to click "Save" before clicking "Start".

Part III: Game
After clicking "Start", FenetreJeu opens. The player's game is displayed at the bottom, the draw and discard piles are at the top left, and the interface for the player to take actions is on the right. Players take turns playing. To play, a player can take the following actions:

Draw: click on the facedown card
Play: enter the number of the card (indicated above) in the white box provided, and then click "Play"
If the player plays a card that cannot be placed on the discard card, an error message appears. They can then play another card or draw.
To end their turn, the player must click "Next Player". A window will open, allowing you to hide the opponent's game. When the next player is ready to play, they can click "Pass to Next Player" and play as indicated previously.

Part IV: End
When a player no longer has cards, the game ends. FenetreFin.java opens and displays the name of the winner and their score.

Part V: Inventory of the archive

Source code: Uno.java // distributes the cards and launches the first window

JFrame:

-FenetreMenu.java // start or quit the game
-NomJoueurs.java // allows players to choose their username before starting the game
-FenetreJeu.java // complete game play
-FenetreFin.java // displays the winner and score at the end of the game

Images:
- unobackground1.png
- uno_dos.jpg
- fondFenetreJeu1.png
- [cardValue] [COULEUR].png // Normal Cards
- [cardType] [COULEUR].png // Special Cards

Class:
-Carte.java
-Joueur.java

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Mini-projet d'Informatique : Jeu de UNO

Auteurs :EL KOURI Malak, MASCARO Lauriane, TAKI Moinesha, BETTAN Etienne
Groupe : 44

Ce document a pour objectif de décrire l'archive Projet Uno correspondant à un jeu de Uno jouable à 4 joueurs. Il est important de lire tout ce document pour garantir que vous pourrez faire fonctionner notre programme sans encombre. 

/!\ La carte joker choix de couleur doit s'appeler choixCouleur NOIR.png et non choixCouleur NOIR.gif (la renommer si le problème survient)
/!\ A cause d'un problème que nous avons rencontré, les fichiers images des cartes sont dans le même dossier que les classes. En effet, si elles étaient dans un sous dossier de l'archive, elles n'apparaissaient pas dans le jeu sur certains ordinateurs.

Partie I : Installation et lancement

- Dézipper l'archive puis ouvrir le fichier Uno.java dans Geany, puis l'exécuter. En cas de problème ouvrez tous les fichiers ayant pour extension .java et compilez-les.

Partie II : Menu
Après avoir lancé Uno.java, une FenetreMenu s'affiche. On peut alors démarrer ou quitter le jeu. Si on démarre, la fenêtre NomJoueurs.java s'ouvre. Chaque joueur inscrit son pseudo dans une case, puis pensez bien à cliquer sur "Enregistrer" avant de cliquer sur "Commencer"

Partie III : Jeu
Après avoir cliqué sur "Commencer", FenetreJeu s'ouvre. Le jeu du joueur est affiché en bas, la pioche et la défausse sont en haut à gauche, l'interface permettant au joueur d'effectuer des actions est à droite. Les joueurs jouent tour par tour. Pour jouer, un joueur peut effectuer les actions suivantes :
    - Piocher : cliquer sur la carte face retournée
    - Jouer : inscrire le numéro de la carte (indiqué au dessus) dans la case blanche prévue à cet effet, puis cliquer sur "Jouer"
    - Si le joueur joue une carte qui ne peut être placée sur la carte de la défausse, un message d'erreur s'affiche. Il peut alors jouer une autre carte ou piocher. 
     

Pour valider son tour, le joueur doit cliquer sur "Joueur suivant". Une fenêtre s'ouvre, permettant de masquer le jeu de l'adversaire. Quand le joueur suivant est prêt à jouer il peut alors cliquer sur "Passer au joueur suivant", et jouer comme indiqué précedemment.

Partie IV : Fin
Lorsqu'un joueur n'a plus de cartes, la partie se termine. FenetreFin.java s'ouvre et affiche le nom du gagnant ainsi que son score

Partie V : Inventaire de l'archive

- Code source : Uno.java // permet de distribuer les cartes et lancer la première fenêtre

- JFrame :
    - FenetreMenu.java // lancer ou quitter le jeu
    - NomJoueurs.java // permet aux joueurs de choisir leur pseudo avant de démarrer la partie
    - FenetreJeu.java // Le déroulement complet du jeu
    - FenetreFin.java // Affiche le nom du gagnant et son score
 
 - Objet :
    - Carte.java // créé un objet Carte
    - Joueur.java // créé un objet Joueur

- Images 
    - unobackground1.png // le fond d'écran de FenetreMenu, NomJoueurs et FenetreFin
    - uno_dos.jpg // visuel d'une carte de Uno retournée -> pioche
    - fondFenetreJeu1.png // le fond d'écran de FenetreJeu
    - [valeur] [COULEUR].png // les visuels des différentes cartes normales du jeu
    - [type] [COULEUR].png // les visuels des différentes cartes spéciales du jeu 
