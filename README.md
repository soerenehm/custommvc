## Spring Boot MVC Application deployable in Kubernetes 

Thymeleaf template is filled by jpa entities saved in h2 database at startup.

Following dependencies are used: 

### Application
- Web
- JPA
- H2
- Lombok
- Thymeleaf

For H2 Webconsole see [application.properties](src/main/resources/application.properties)

### Metrics
- Activator [http://localhost:8080/actuator](http://localhost:8080/actuator)
- HAL Browser [http://localhost:8080/browser/index.html#/actuator](http://localhost:8080/browser/index.html#/actuator)

### Development
- Devtools

## Swagger
- Swagger API [http://localhost:8080/v2/api-docs](http://localhost:8080/v2/api-docs)

 
## Creating a Docker image

In directory docker build a docker image and push it to public repository DockerHub.  

```
make
make push 
```

## Kubernetes Setup.

Start local kubernetes cluster provided by minikube. 

```
minikube start
```

In directory k8s create deployment and service in kubernetes cluster.      


```
make 
```

Kubernetes service is exposed by specifying `NodePort` in service.yml to access it outside the cluster.   



 