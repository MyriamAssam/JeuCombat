## Description de l'application

Objectif initial

Créer une page d’achat permettant d’acquérir des couleurs pour le char et la balle. Les couleurs sous le score du joueur devaient être verrouillées par un cadenas. Si le joueur n’a pas assez de points, un message d’erreur devait s’afficher. Actions prévues : Sélectionner, Retirer, Acheter une couleur.

Parcours et vues

Vue d’accueil + Vue d’achat (2 pages comme demandé).

Depuis l’accueil : bouton Acheter la couleur → ouvre la vue d’achat.

Dans la vue d’achat : bouton Quitter l’achat → retour à l’accueil.

Fonctionnalités réalisées

Fragment de couleurs : liste de rectangles nommés, couleur de fond correspondante, scroll quand il y en a beaucoup.

Chargement dynamique : bouton qui ajoute des couleurs au fragment.

Sélection de couleur : bouton Sélection qui applique la couleur à la balle (événement EvtchangerCouleurBalle).

Retrait : bouton Retirer qui supprime la couleur du fragment.

Affichage/masquage :

bouton Image (I) pour cacher/afficher l’image du char,

bouton Balle (B) pour cacher/afficher la balle.

Animation : balle en mouvement vertical (haut ↔ bas).

UI : présence d’un labelScore (non alimenté), d’un label de couleur, d’une image de char, d’icônes cadenas devant les couleurs, barre de défilement.

Événements de navigation : EvtAfficherAchat (depuis l’accueil) et EvtAfficherAcceuil (retour).

Modèle et variables

Modèle Achat : idAchat, prix, couleurSelection, id, nom, codeHex, tankCache, balleCache.

Variables ajoutées :

tankCache (bool) : souhaité à true quand l’image du char est cachée,

balleCache (bool) : souhaité à true quand la balle est cachée,

couleurSelection : nom de la couleur sélectionnée.

Note : ces variables ne se mettent pas à jour comme prévu; les modifications effectives du modèle proviennent surtout de Retirer/Charger (ajout/suppression de couleurs).

Écarts par rapport au cahier des charges

Seule la balle change de couleur (le char est une image statique).

Cadenas affichés sur toutes les couleurs, pas seulement celles inaccessibles selon le score.

Score non affiché et pas de bouton “Acheter” fonctionnel.

Pas de message quand le joueur n’a pas assez de points.

Pas de retrait de couleur appliquée à la balle.

Pas de nom du joueur affiché.

Pas de double liste (balle vs char).

Détails complémentaires

Contrôles : 6 boutons dans vueAchat (Charger/Sélection/Retirer/Quitter/Image/Balle) + 1 bouton dans vueAccueil (Acheter).

Tâches dans AfficherAchat : afficherVueAchat, prochaineImagePartie, changerCouleurBalle.

FPS non affiché.

Couleurs UI (fond, en-tête, boutons) décidées en groupe.

Certaines couleurs non fonctionnelles ont été retirées.

Conclusion

Le prototype respecte la navigation demandée (2 pages) et démontre le chargement, l’affichage et la sélection de couleurs avec animation de la balle et options d’affichage. Faute de temps, la logique d’achat conditionné par le score, la gestion des cadenas, la mise à jour du modèle (tankCache, balleCache, couleurSelection) et le changement de couleur du char n’ont pas été finalisés. Malgré ces limites, l’ensemble illustre clairement le flux d’achat, la sélection visuelle et la structure du projet.
