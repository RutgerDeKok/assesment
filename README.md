Dummy micro services project

Car-lease Platform API build with Spring-Boot 3.3.5 micro services

Services:
1) service-registry         -       supplies all client services with each others locations
2) customer-service         -       service that maintains customer data and lease contract data and has a method to calculate lease rates (business layer)
3) car-service              -       service that maintains data for all teh different car types (business layer)
4) config-server            -       service that holds the config files (yaml) of the other services
5) api-gateway              -       service that shields forwards all incoming api calls to the designated business layer services 
6) authentication-service   -       service that maintains app user data. Users can sign up, and sign in. The api gateway validates all request through this service with JWTs

The services are configures to be used with Zipkin
The business layer and api-gateway services are configured for Open-API

