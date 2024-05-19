# Docker Image Naming Convention

## Understanding Image Names

- **Repository Name**: The first part of the image name represents the repository name. For example, in `httpd`, `httpd` is the repository name.
- **User/Organization Name**: The second part denotes the user or organization name on Docker Hub. If not provided, it assumes the same name as the repository.
  - Example: `httpd/httpd` indicates the `httpd` repository under the `httpd` organization on Docker Hub.

## Image Registry

- **Default Registry**: Docker images are pulled from Docker Hub by default.
  - Registry URL: `docker.io`
  - Docker Hub serves as the default registry where images are stored and retrieved.

- **Private Registries**: Images can also be stored in private registries like Google's container registry (`gcr.io`).
  - Example: `gcr.io/httpd/httpd`

By understanding the image naming convention and registry locations, users can effectively pull and manage Docker images from various sources.
