## Description de l'application

Pour ce jeu, je devais faire la page d'achat. On a pensé faire une page ou on peut acheter des couleurs pour les chars et les balles.
Avec le score du joueur, on a voulu bloquer les couleurs qui étaient en dessous du score avec un cadenas. Si le joueur n'a pas assez de
points pour acheter une couleur, il y'aurait un message qui lui dit qui ne peut pas l'acheter. Il y'aurais donc un bouton pour
selectionner la couleur, retirer la couleur et acheter la couleur. Avec la progression du projet, j'ai creer une page d'acceuil et une
page d'achat (2 pages comme demandé). Quand on clique sur Acheter la couleur, la page d'Achat apparait. Dans la page d'achat, quand on
clique dans la page quitter achat, on revient a la page d'acceuil. Ensuite, il fallait faire le fragment de couleur. J'ai donc décider de
faire comme dans les tutoriels et j'ai fait des rectangles avec le nom des couleurs. J'ai ajouter les boutons retier et selection pour
retirer une couleur dans le fragment et selectionner une couleur pour voir dans la balle ou le char. J'ai concu la balle en mouvement.
J'ai aussi fait un bouton qui charge les couleurs dans le fragment. Quand on clique sur le bouton, une couleur s'ajoute avec le nom et le
fond de couleur change avec la couleur. Dans le header, il y a une étiquette (labelScore) qui affiche le score. Il y a aussi une barre de
défilement dans le fragment quand il ya beaucoup de couleur chargés. Pour le projet final, j'ai ajouté une image de char. J'ai aussi fait
que le boutonSelection ajoute la couleur à la balle. J'ai ajouté un bouton pour cacher l'image (I) et la balle (B). quand on reclique, ca
reaffiche les images. Ce qui à changé du debut, c'est que c'est seulement la balle qui change de couleur et non le char (c'est juste une
image). J'ai mis des cadenas, mais dans toutes les couleurs et non dans les couleurs que le joueur ne peut pas acheter et le score n'est
pas affiché. Il n'y a pas de bouton pour acheter la couleur. Il ne peut pas non plus retirer la couleur de la balle. je voulais mettre le
nom du joueur au debut, mais bon vu qu'on a pas decider de faire le jeu au complet pour le projet final je l'ai pas fait. J'ai aussi pas
fait deux choix de couleurs, un pour la balle et un pour le char. J'ai creer des varaibles dans mon modele
tankCache, couleurSelection et balleCache, tankCache est boolean et quand on cache le l'image du char, elle est
mise a true et pour la balle c'est balleCache. Pour couleurSelection, le nom de la couleur selectionnée. Je les
ait fait, car je voulais que quelque chose se modifie dans le modele comme demandé (5 modifications), mais ca
ne marche pas malheuresement. Donc, j'ai juste retirer la couleur et charger la couleur qui font des
modifications dans le modele (ca enleve ou ajoute une couleur). Pour résumer, il y a un boutonCouleur pour
charger la couleur, il y a un boutonQuitterAchat pour quitter la page d'achat. Ensuite, il y a un boutonImage
pour cacher l'image du char et boutonBalle pour cacher la balle. Il ya un labelScore pour le score (meme si il
est pas affiché), une image de char tankImageView. Il ya aussi une balle qui est en mouvement et le fragment
avec les couleurs. Il y a le boutonSelection pour selectionner la couleur et le boutonRetirer pour retier la
couleur. Il y a une image de cadenas avant les couleurs que je n'ai pas reussi a arranger par rapport au prix
et score. Il y a un scrollPane pour voir les autres couleurs quand on en ajoute beaucoup. Pour les
fonctionalités, le boutonRetirer retirer la couleur, le boutonSelection selectonne la couleur (la balle change
de couleur). Le boutonImage cache le char et le boutonBalle la balle. J'ai 6 boutons dans vueAchat et un dans
la vueAcceuil. J'ai deux label, labelCouleur et labelScore. J'ai un scrollbar, une image de char, une balle en
mouvment et des images de cadenas. Les couleurs s’affichent bien avec leurs noms et leur couleurs respectives.
Il y avait des couleurs que j’ai enlevé, car elles ne marchaient pas .Le boutonSelection a un event
EvtchangerCouleurBalle, le boutonAchat de la vueAcceuil a un event EvtAfficherAchat, le boutonQuitterAchat a un
event EvtAfficherAcceuil pour afficher la page d’acceuil que j’ai gardée. Les variables du ModeleAchat sont
idAchat, prix, couleurSelection (meme si ça ne change pas), id, nom, codeHex, tankCache et balleCache (meme si
elles ne fonctionnent pas). La balle est seulement en mouvement de haut en bas. Je n’ai pas affiché le fps de
la balle dans la page. Il ya trois taches dans AfficherAchat, afficherVueAchat pour afficher la vueAchat,
prochaineImagePartie et changerCouleurBalle. Les couleurs du fond, du header et des boutons on étaient dessidés
en groupe. J'ai voulu que les variables que j'ai crées changent (true, true ou le nom
de la couleur), mais ca n'a pas marché.Ce que j’ai abandonnée depuis le début : les deux listes de couleurs une
pour la balle et l’autre pour char, le char ne change pas de couleur c’est juste la balle qui le fait, l’image
du cadenas est affichée dans toutes les couleurs au lieu de couleurs que le joueur ne peut pas acheter. Il n’y
a pas de message d’erreur qui dit que le joueur ne peut pas acheter la couleur. Je n’ai pas mis le nom du
joueur en haut et le score aussi. Je n’ai pas fait de bouton pour retirer la couleur dans la balle. J’ai fait
des boutons pour cacher l’image et la balle. Par manque de temps je n’ai pas pu faire plus. J'aurais voulu que
les variables changent vraiment quand on cache le char ou la balle ou quand on selectionne une couleur. Par
manque de temps je n’ai pas pu faire plus. Encore une sois, quand on clique sur le boutonImage ou boutonBalle,
on cache les images, mais dans le modele les variable ne se mette pas a true, meme chose pour la selectin de la
couleur. J'espere au moins avoir une note acceptable malgré tout.
