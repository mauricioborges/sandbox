echo -e "Prints diagnostic info"
kubectl get pods -n kube-system -l app.kubernetes.io/name=ingress-nginx
POD_NAMESPACE=kube-system
POD_NAME=$(kubectl get pods -n $POD_NAMESPACE -l app.kubernetes.io/name=ingress-nginx --field-selector=status.phase=Running -o jsonpath='{.items[0].metadata.name}')
kubectl exec -it $POD_NAME -n $POD_NAMESPACE -- /nginx-ingress-controller --version



kubectl create deployment web --image=gcr.io/google-samples/hello-app:1.0
 kubectl expose deployment web --type=NodePort --port=8080
 minikube service web --url

kubectl apply -f  example-ingress.yaml

echo "add the following entries to your /etc/hosts"
echo "$(minikube ip) hello-world.mauricio"
echo "$(minikube ip) hello-world.gabriela"

echo "try curl hello-world.mauricio"
echo "try curl hello-world.gabriela/gabriela"

