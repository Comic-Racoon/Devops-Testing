# Docker Authentication and Image Management

## Subtopic 1: Authenticating into Registries
- **Pulling from a Public Registry**: No authentication needed.
  - Example: `docker pull ubuntu`
- **Pulling from a Private Registry**: Requires authentication.
  - Without authentication, results in "Access Denied" error.
- **Pushing to a Registry**: Requires authentication.
  - Necessary for both public and private registries.

### Authentication Steps
- **Command**: `docker login`
  - Specify username and password for the registry.
  - Example for Docker Hub: Create an account on Docker Hub and use those credentials.
  - For a private registry, use the same command with the registry's address.
- **Post Authentication**: Push operations will push local images to the remote registry.

## Subtopic 2: Managing Images
- **Creating a Copy of an Image**: Cannot rename an image, but can retag it.
- **Retagging an Image**:
  - Command: `docker image tag [old-image-name] [new-image-name]`
  - Creates a link to an image ID with a new name.
  - Example:
    ```sh
    docker image tag httpd:alpine myregistry.local/httpd:alpine
    ```
  - **Image List**: Shows new image with the new tag but same image ID, indicating they are linked.

### Storage Considerations
- **Actual Storage**:
  - The space shown in `docker image list` is not the actual space consumed.
  - Space is only consumed once for images with the same ID.
- **Retagging Example**:
  - Pull an image from Docker Hub.
  - Retag it for a private registry:
    ```sh
    docker image tag httpd:alpine gcr.io/myregistry/httpd:alpine
    ```
  - Push the retagged image to the private registry after authentication.

## Subtopic 3: Inspecting Docker Disk Usage
- **Command**: `docker system df`
  - Displays the actual size of different Docker objects:
    - Images
    - Containers
    - Volumes
    - Build cache
  - **Output Example**:
    - Lists a total of images and their sizes.
    - Example: 112 MB, 165 MB, 64 MB totaling around 341 MB.
  - **Reclaimable Space**: Indicates storage used by images that can be deleted to free up space.
  - **Active Field**: Shows count of images being used by containers.
    - If active count is zero, no containers are using those images.
    - Deleting unused images can reclaim storage space.

## Subtopic 4: Cleaning Up Docker System
- **Removing Unused Images**: 
  - Check the `reclaimable` field from `docker system df` output.
  - Delete images not used by any containers to free up space.
  - Useful for system cleanup and freeing up disk space.

# Next Steps
- Proceed to demo for Docker installation and authentication.
