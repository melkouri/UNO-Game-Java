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