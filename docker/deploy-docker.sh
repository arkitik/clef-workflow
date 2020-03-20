mvn clean install
cp clef-workflow-api/clef-workflow-api-deployment/clef-workflow-api-deployment-app/target/app-spring-boot.jar ./docker

docker build \
  -t queeio/clef-workflow:latest \
  -f docker/Dockerfile \
  docker
docker push queeio/clef-workflow:latest
