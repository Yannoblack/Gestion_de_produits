# API de Gestion d'Inventaire de Produits

Ce projet est une API RESTful développée avec Spring Boot pour la gestion d'un inventaire de produits. Elle permet d'effectuer des opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) sur les produits, de suivre leur quantité en stock et leur prix.

## Description Détaillée

L'application fournit une interface backend pour gérer un catalogue de produits. Chaque produit est caractérisé par un nom unique, un prix et une quantité en stock. L'API est conçue pour être utilisée par des applications clientes (par exemple, une interface web d'administration, une application mobile de point de vente, etc.) nécessitant un accès et une manipulation des données d'inventaire.

Les fonctionnalités principales incluent :
*   L'ajout de nouveaux produits à l'inventaire.
*   La consultation de la liste de tous les produits ou d'un produit spécifique par son identifiant.
*   La mise à jour des informations d'un produit existant (nom, prix, quantité en stock).
*   La suppression de produits de l'inventaire.
*   La validation des données pour assurer la cohérence (par exemple, le nom et la quantité ne peuvent pas être vides, le prix doit être positif).

## Fonctionnalités

*   Gestion complète des Produits (CRUD).
*   Suivi des quantités en stock.
*   Validation des données d'entrée.
*   Documentation API interactive avec Swagger (OpenAPI) (si inclus).

## Technologies Utilisées (Exemple, à adapter)

*   **Java** (préciser la version, ex: Java 17 ou 21)
*   **Spring Boot** (préciser la version, ex: 3.x.x)
    *   Spring Web (pour les API REST)
    *   Spring Data JPA (pour la persistance des données)
    *   Spring Validation (pour la validation des données)
*   **Base de données** (préciser, ex: PostgreSQL, MySQL, H2)
*   **Maven** (Gestionnaire de dépendances et de build)
*   **Lombok** (Pour réduire le code boilerplate)
*   **SpringDoc OpenAPI (Swagger)** (si inclus, pour la documentation de l'API)

## Prérequis

*   JDK (version correspondante à celle du projet) installé.
*   Maven installé.
*   Une instance de la base de données configurée et en cours d'exécution (si vous n'utilisez pas une base de données en mémoire comme H2 pour le développement).

## Installation et Configuration

1.  **Cloner le dépôt :**

2.  **Configuration de la base de données (si nécessaire) :**
    Si vous utilisez une base de données externe (comme PostgreSQL, MySQL), mettez à jour les informations de connexion dans le fichier `src/main/resources/application.properties` ou `application.yml`.
    Exemple pour `application.properties` avec PostgreSQL :


L'application devrait démarrer sur le port 8080 par défaut.

# Endpoints de l'API (Exemple)


Les principaux endpoints sont généralement disponibles sous un préfixe comme /api/produits.
•POST /api/produits : Créer un nouveau produit.
•GET /api/produits : Récupérer la liste de tous les produits.
•GET /api/produits/{id} : Récupérer un produit spécifique par son ID.
•PUT /api/produits/{id} : Mettre à jour un produit existant.
•DELETE /api/produits/{id} : Supprimer un produit.


Consultez la documentation Swagger UI (si disponible) pour des détails complets.

# Étapes pour Tester l'API

Vous pouvez tester l'API en utilisant des outils comme Postman, curl, ou directement via Swagger UI si vous l'avez intégré.





##1. Tester avec Swagger UI (si intégré)
• Une fois l'application lancée, ouvrez votre navigateur et allez à l'adresse : http://localhost:8080/swagger-ui.html (ou l'URL configurée pour Swagger).
• Vous verrez la liste des contrôleurs et leurs endpoints.
• Pour créer un produit :

	##1. Trouvez l'endpoint POST /api/produits.
	##2. Cliquez sur "Try it out".
	##3. Remplissez le corps de la requête JSON avec les détails du produit. Exemple :



**4.Cliquez sur "Execute". Vérifiez la réponse (généralement un code 201 Created et le produit créé).

• Pour lister tous les produits :
	1.Trouvez l'endpoint GET /api/produits.
	2.Cliquez sur "Try it out", puis "Execute". Vérifiez la liste des produits retournée.
•Pour obtenir un produit par ID :
	1.Notez l'ID d'un produit existant (par exemple, celui créé à l'étape précédente).
	2.Trouvez l'endpoint GET /api/produits/{id}.
	3.Cliquez sur "Try it out", entrez l'ID du produit dans le champ id, puis cliquez sur "Execute".
•Pour mettre à jour un produit :
	1.Trouvez l'endpoint PUT /api/produits/{id}.
	2.Cliquez sur "Try it out", entrez l'ID du produit à mettre à jour.
	3.Modifiez le corps de la requête JSON avec les nouvelles valeurs. Exemple :
## Lancer l'Application
Exécutez la commande suivante à la racine du projet :
	4.Cliquez sur "Execute".
•Pour supprimer un produit :
	1.Trouvez l'endpoint DELETE /api/produits/{id}.
	2.Cliquez sur "Try it out", entrez l'ID du produit à supprimer, puis cliquez sur "Execute". Vérifiez la réponse (généralement un code 204 No Content).


	2. Tester avec curl (Exemple)

Assurez-vous que l'application est en cours d'exécution.
•Créer un produit : ```bash curl -X POST -H "Content-Type: application/json" -d '{"nom":"Produit Curl", "prix":15.75, "quantiteEnStock":100}' http://localhost:8080/api/produitsKotlin Ou exécutez le fichier JAR généré (après `mvn clean install`) :

•Lister tous les produits :
Kotlin
(Adaptez le nom du fichier JAR si nécessaire).

L'application devrait démarrer sur le port `8080` par défaut.

## Endpoints de l'API (Exemple)

Les principaux endpoints sont généralement disponibles sous un préfixe comme `/api/produits`.

*   `POST /api/produits` : Créer un nouveau produit.
*   `GET /api/produits` : Récupérer la liste de tous les produits.
*   `GET /api/produits/{id}` : Récupérer un produit spécifique par son ID.
*   `PUT /api/produits/{id}` : Mettre à jour un produit existant.
*   `DELETE /api/produits/{id}` : Supprimer un produit.

Consultez la documentation Swagger UI (si disponible) pour des détails complets.

## Étapes pour Tester l'API

Vous pouvez tester l'API en utilisant des outils comme Postman, `curl`, ou directement via Swagger UI si vous l'avez intégré.

### 1. Tester avec Swagger UI (si intégré)

*   Une fois l'application lancée, ouvrez votre navigateur et allez à l'adresse : `http://localhost:8080/swagger-ui.html` (ou l'URL configurée pour Swagger).
*   Vous verrez la liste des contrôleurs et leurs endpoints.


*   **Pour créer un produit :**
    1.  Trouvez l'endpoint `POST /api/produits`.
    2.  Cliquez sur "Try it out".
    3.  Remplissez le corps de la requête JSON avec les détails du produit. Exemple :
•Obtenir un produit par ID (remplacez {id} par un ID réel) :
Kotlin    
    4.  Cliquez sur "Execute". Vérifiez la réponse (généralement un code 201 Created et le produit créé).


*   **Pour lister tous les produits :**
    1.  Trouvez l'endpoint `GET /api/produits`.
    2.  Cliquez sur "Try it out", puis "Execute". Vérifiez la liste des produits retournée.
*   **Pour obtenir un produit par ID :**
    1.  Notez l'ID d'un produit existant (par exemple, celui créé à l'étape précédente).
    2.  Trouvez l'endpoint `GET /api/produits/{id}`.
    3.  Cliquez sur "Try it out", entrez l'ID du produit dans le champ `id`, puis cliquez sur "Execute".


*   **Pour mettre à jour un produit :**
    1.  Trouvez l'endpoint `PUT /api/produits/{id}`.
    2.  Cliquez sur "Try it out", entrez l'ID du produit à mettre à jour.
    3.  Modifiez le corps de la requête JSON avec les nouvelles valeurs. Exemple :

•Mettre à jour un produit (remplacez {id} par un ID réel) :
Kotlin    
    4.  Cliquez sur "Execute".

*   **Pour supprimer un produit :**
    1.  Trouvez l'endpoint `DELETE /api/produits/{id}`.
    2.  Cliquez sur "Try it out", entrez l'ID du produit à supprimer, puis cliquez sur "Execute". Vérifiez la réponse (généralement un code 204 No Content).

### 2. Tester avec `curl` (Exemple)

Assurez-vous que l'application est en cours d'exécution.

*   **Créer un produit :**

•Supprimer un produit (remplacez {id} par un ID réel) :    (Notez l'ID retourné dans la réponse)

*   **Lister tous les produits :**
    
    