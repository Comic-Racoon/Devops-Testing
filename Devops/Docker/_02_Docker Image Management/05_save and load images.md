# Alternative Methods for Retrieving Docker Images in Restricted Environments

In scenarios where internet access is restricted, downloading Docker images directly from Docker Hub can be challenging. Here are alternative methods to retrieve Docker images.

## 1. Pulling and Saving Docker Images

### 1.1. Pulling an Image

- **Command:** `docker image pull <image_name>:<tag>`
- **Example:** `docker image pull alpine:latest`

### 1.2. Saving an Image to a Tar File

- **Command:** `docker image save -o <output_tar_file> <image_name>:<tag>`
- **Example:** `docker image save -o alpine_latest.tar alpine:latest`
- **Description:**
  - Creates a tar file of the specified image.
  - This tar file can be transferred to a restricted environment via USB drive, shared network location, etc.

### 1.3. Loading an Image from a Tar File

- **Command:** `docker image load -i <input_tar_file>`
- **Example:** `docker image load -i alpine_latest.tar`
- **Description:**
  - Loads the image from the tar file into the Docker environment.
  - The loaded image can be verified by listing the local images using `docker image ls`.

## 2. Exporting and Importing Containers as Images

### 2.1. Exporting a Running Container to a Tar File

- **Command:** `docker export <container_name> -o <output_tar_file>`
- **Example:** `docker export my_running_container -o container_backup.tar`
- **Description:**
  - Exports the file system of a running container to a tar file.
  - The tar file is a read-only template of the container’s file system.

### 2.2. Importing a Tar File as an Image

- **Command:** `docker image import <input_tar_file> <new_image_name>:<tag>`
- **Example:** `docker image import container_backup.tar my_new_image:latest`
- **Description:**
  - Imports the tar file as a new Docker image.
  - The newly created image can be used like any other Docker image and listed using `docker image ls`.
