## Deployment
kubectl create -f deployment.yml

kubectl describe deployment/custommvc-deployment  
kubectl describe pod -l app=custommvc-service

## Service
kubectl create -f service.yml

kubectl describe service custommvc-service

minikube service custommvc-service

minikube ip  
curl http://192.168.99.100:NodePort
