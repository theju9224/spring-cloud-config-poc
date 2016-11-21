Spring Cloud Config POC
=========================

This demo assumes you know how to run Docker
Nothing special if you already have Docker installed

Running Config Server & Config Client with docker-compose
---------------------
    $ git clone https://github.com/buraksarp/spring-cloud-config-poc.git
    $ cd spring-cloud-config-poc
    $ docker-compose up -d

Building the Config Server Container
----------------------

    $ cd config-server
    $ docker build -t sarp/config-server .

Running the Config Server Container
---------------------
To run this container:

    $ docker run -ti sarp/config-server

Building the Config Client Container
----------------------

    $ cd config-client
    $ docker build -t sarp/config-client .

Running the Config Client Container
---------------------
To run this container:

    $ docker run -ti sarp/config-client


