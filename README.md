# Projet Microservices

### Développeurs :

- Massar ABBAS - [massar.abbas@uphf.fr](mailto:massar.abbas@uphf.fr) - 22105551
- Elliott ATTENBOROUGH - [elliott.attenborough@uphf.fr](mailto:elliott.attenborough@uphf.fr) - <n° étudiant à mettre>
- Pauline BONNET - [pauline.bonnet@uphf.fr](mailto:pauline.bonnet@uphf.fr)
- Lukaz VOLANT - [lukaz.volant@uphf.fr](mailto:lukaz.volant@uphf.fr)

## 1. Exécution du projet

### a. Construire les images docker des projets Java

Afin de construire les images docker du projet, lancez la commande suivante :

````shell
docker build --no-cache -t myapp:latest -f .\Dockerfile .
docker build --no-cache -t myapp2:latest -f .\Dockerfile2 .
docker build --no-cache -t myapp3:latest -f .\Dockerfile3 .
docker build --no-cache -t myapp4:latest -f .\Dockerfile4 .
docker build --no-cache -t myapp5:latest -f .\Dockerfile5 .
docker build --no-cache -t myapp6:latest -f .\Dockerfile6 .
docker build --no-cache -t myapp7:latest -f .\Dockerfile7 .
````


### b. Lancer les conteneurs Docker

Avant de lancer l'application, pour démarrer mongodb, l'API gateway, le serveur de configuration, Eureka et les microservices, lancez le container docker avec la commande suivante :



```shell
docker-compose up
```
Les multiservices prendront environ 1-2 minutes pour finir de se lancer.

### c. Ajout de données via Postman

Allez sur Postman et envoyez une requête à ```http://localhost:8081/produits/create_list``` avec le body ci-dessous.

```json
[
    {
        "nom": "Tarte à la framboise",
        "description": "y a pas mal de framboise",
        "prix": 29.02
    },
    {
        "nom": "Tarte citron meringuée",
        "description": "y a pas mal de citron et de meringue",
        "prix": 15.50
    },
    {
        "nom": "Tarte à la pomme",
        "description": "y a pas mal de pommes",
        "prix": 12.99
    },
    {
        "nom": "Tarte à la pistache",
        "description": "y a pas mal de pistache",
        "prix": 30
    },
    {
        "nom": "Tarte à la pêche",
        "description": "y a pas mal de pêche",
        "prix": 25.80
    }
]
```
### c. Problèmes avec CORS

Malgré le bon fonctionnement de nos microservices, une fois intégrés à Docker, le Client ne peut plus faire de requêtes aux microservices via l'API gateway. Nous avons tenté de multiples techniques afin d'autoriser les requêtes mais rien ne semblait fonctionner.