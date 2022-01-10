Cake Manager Micro Service (fictitious)
=======================================

Requirements:
* By accessing the root of the server (/) it should be possible to list the cakes currently in the system. This must be presented in an acceptable format for a human to read.

* It must be possible for a human to add a new cake to the server.

* By accessing an alternative endpoint (/cakes) with an appropriate client it must be possible to download a list of
the cakes currently in the system as JSON data.

* The /cakes endpoint must also allow new cakes to be created.


Build and Run application using docker
======================================

To build application execute the following command:
`mvn clean install`

To build a docker image execute the following command:
`docker build -t waracle/cake-manager .`

To run the docker image execute the following command:
docker run -p 8282:8282 -t waracle/cake-manager

and access the following URL:

`http://localhost:8282/cake-mgr`


Swagger Open API docs
=====================

To access Swagger API docs use below URL
`http://localhost:8282/v3/api-docs`

To access Swagger UI use below URL
`http://localhost:8282/swagger-ui.html`
