import random

# Liste des options possibles
options = ["EN01", "EN03"]

# Points pour chaque participant
points = {"EN01": 0, "EN03": 0}

# Tirages multiples
for i in range(1, 101):  # De 1 à 100 inclus
    gagnant = random.choice(options)  # Choix aléatoire
    points_gagnes = 1  # Par défaut, 1 point par victoire
    
    # Attribution de points bonus selon les règles
    if i == 15:
        points_gagnes = 2
    elif i == 25:
        points_gagnes = 3
    elif i == 75:
        points_gagnes = 4
    
    # Ajout des points au gagnant
    points[gagnant] += points_gagnes
    
    # Affichage du gagnant pour ce tirage
    print(f"Tirage {i}: {gagnant} gagne {points_gagnes} point(s).")

# Affichage des points finaux
print("\n=== Résultat Final ===")
for participant, total_points in points.items():
    print(f"{participant} : {total_points} points")
