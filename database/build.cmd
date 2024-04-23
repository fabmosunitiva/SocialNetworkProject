# Function to check OS type (not necessary in PowerShell)
# Since you're already running PowerShell, there's no need to detect the OS.

# Define commands for Docker and Docker Compose (assuming they are installed)
$DOCKER_BUILD_CMD = "docker build"
$DOCKER_COMPOSE_CMD = "docker-compose"

# Set paths for Dockerfile and docker-compose.yml (assuming they are in the current directory)
$DOCKERFILE_PATH = ".\"
$COMPOSE_FILE_PATH = ".docker-compose.yml"

# Build the image
Write-Host "Building Docker image..."
& $DOCKER_BUILD_CMD -t my-social-image $DOCKERFILE_PATH

# Run Docker Compose (detached mode)
Write-Host "Starting Docker Compose..."
& $DOCKER_COMPOSE_CMD up -d

Write-Host "Successfully built and launched the application!"
