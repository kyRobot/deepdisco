## Deep Discover

A webapp to dive deeper into Spotify's user specific 'Discover Weekly' playlist


## Requirements
- Java 8
- Maven
- [A Spotify Developer App](https://developer.spotify.com) with an OAuth2 callback to localhost:8080/login

##How to run

1. Clone the repository.
2. cd to src/main/resources/
3. Rename application.yml.example as application.yml.example
4. Edit application.yml to add your Spotify App's Client ID and Client Secret
5. Execute `mvn spring-boot:run`
6. Browse to http://localhost:8080