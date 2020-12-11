if ! command -v COMMAND &> /dev/null
then
  brew install minikube
  brew upgrade minikube
fi
minikube delete
minikube start --vm=true
kubectl get po -A
minikube addons enable ingress
