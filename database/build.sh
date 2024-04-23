#!/bin/bash

# Function to check OS type
is_windows() {
  case "$(uname -o)" in
    MSYS_NT*|MINGW*|CYGWIN*) return 0;;
    *) return 1;;
  esac
}
  # Linux commands
  DOCKER_BUILD_CMD="docker build"
  DOCKER_COMPOSE_CMD="docker-compose"
  DOCKERFILE_PATH="./"
  COMPOSE_FILE_PATH="./docker-compose.yml"

# Build the image
echo "Building Docker image..."
$DOCKER_BUILD_CMD -t my-social-image $DOCKERFILE_PATH

# Run Docker Compose (detached mode)
echo "Starting Docker Compose..."
$DOCKER_COMPOSE_CMD up -d

echo "Successfully built and launched the application!"
