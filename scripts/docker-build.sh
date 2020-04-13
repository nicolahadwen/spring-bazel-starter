#!/usr/bin/env bash
docker build --build-arg JAR_FILE=./bazel-bin/services/web-service/web-service-executable_deploy.jar -t hadwen/web:latest .
