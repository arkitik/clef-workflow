mvn clean install
cp clef-workflow-api/clef-workflow-api-deployment/clef-workflow-api-deployment-app/target/app-spring-boot.jar ./docker

docker build \
  -t arkitikio/clef-workflow:latest \
  -f docker/Dockerfile \
  docker
docker push arkitikio/clef-workflow:latest
