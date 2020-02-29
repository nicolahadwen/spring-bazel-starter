#!/usr/bin/env bash
./scripts/docker-build.sh
docker push hadwen/web:0.0.0
kubectl apply -f ./deployment.yaml
