#!/usr/bin/env bash
./scripts/docker-build.sh
docker push hadwen/web:latest
kubectl apply -f ./deployment.yaml
