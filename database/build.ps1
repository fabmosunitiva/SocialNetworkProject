# Define commands for Docker and Docker Compose (assuming they are installed)
$DOCKER_BUILD_CMD = "docker build"
$DOCKER_COMPOSE_CMD = "docker-compose"

# Set paths for Dockerfile and docker-compose.yml (assuming they are in the current directory)
$DOCKERFILE_PATH = ".\"  # Replace with the actual path if needed
$COMPOSE_FILE_PATH = ".docker-compose.yml"  # Replace with the actual path if needed

# Build the image with a tag
Write-Host "Building Docker image..."
& $DOCKER_BUILD_CMD -Tag my-social-image $DOCKERFILE_PATH

# Run Docker Compose (detached mode)
Write-Host "Starting Docker Compose..."
& $DOCKER_COMPOSE_CMD up &  # Background execution with "&" operator

# Optional: View logs from running containers (uncomment if desired)
# Write-Host "Viewing container logs..."
# & $DOCKER_COMPOSE_CMD logs -f

Write-Host "Successfully built and launched the application!"
