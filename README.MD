# Project to reproduce [Missing oauth2-redirect.html Support in Ktor Swagger UI Plugin issue](https://youtrack.jetbrains.com/issue/KTOR-7892/Missing-oauth2-redirect.html-Support-in-Ktor-Swagger-UI-Plugin)

## Prerequisite
- JDK 21
- Docker

## Steps to reproduce the issue:
1. Go to keycloak dir and launch docker compose. It will launch a preconfigured keycloak server.
`cd keycloak && docker-compose up`
2. Launch Ktor server.
`./gradlew run`
3. Open swagger ui http://localhost:8080/swagger/ui
4. Click on the "Authorize" button and enter the client_id `myclient` then click on the "Authorize" button in the popup.
5. Enter the credentials: `myuser` for username and `change_me` for password.
6. You should have `HTTP ERROR 404`

## Workaround
I have provided a workaround for those affected before the issue is fixed
1. Change in `src/main/resources/application.yaml` with `workaround: true`
2. Restart the Ktor server
3. Reload the swagger page
4. Click on the "Authorize" button and enter the client_id `myclient` the click on the "Authorize" button 
5. You should be authenticated
