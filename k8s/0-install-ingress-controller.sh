if ! command -v COMMAND &> /dev/null
then
  echo -e "installs minikube cluster"
  brew install minikube
  echo -e "guarantees minikube uses k8s cluster v 1.19+"
  brew upgrade minikube
fi
minikube delete
echo -e "starts a k8s cluster using VM (minikube ingress addon only works this way)"
minikube start --vm=true
kubectl get po -A
echo -e "installs the nginx ingress controller into kube-system namespace"
minikube addons enable ingress
