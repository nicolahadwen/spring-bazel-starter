#!/usr/bin/env bash
mvn package && docker build --build-arg JAR_FILE=target/HadwenWeb*.jar -t hadwen/web:0.0.00 .
docker push hadwen/web:0.0.00
kubectl --record deployment.apps/hadwenwebdeployment set image deployment.apps/hadwenwebdeployment hadwenweb=hadwen/web:0.0.0
