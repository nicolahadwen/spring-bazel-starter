#!/usr/bin/env bash
mvn package && docker build --build-arg JAR_FILE=target/HadwenWeb*.jar -t hadwen/web:latest .
