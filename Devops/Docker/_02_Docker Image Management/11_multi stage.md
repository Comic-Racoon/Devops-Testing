# Introduction to Multi-Stage Builds

## Multi-Stage Builds
- Multi-stage builds simplify the build process by combining multiple steps into a single Dockerfile.
- It helps optimize Dockerfiles and keeps them easy to read and maintain.

## Traditional Build Process
- Initially, the application was built directly on the development server using local dependencies, which could lead to inconsistencies and maintenance challenges.

## Single Dockerfile Approach
- A better approach is to containerize the build process itself using Docker.
- Two Dockerfiles are used: one for building the application and another for creating a production-ready image.

## Two-Step Build Process
- First, a Dockerfile named Docker.builder is used to generate a clean build of the application.
- Second, the build is used to create a production-ready image.

## Extracting Build Output
- A script is used to extract the dist directory from the first image and make it available locally for the second build.
- This involves creating a temporary container from the build image, copying the dist directory, and then removing the container.

## Implementing Multi-Stage Builds
- With multi-stage builds, Docker first builds the first image with the first set of instructions and then proceeds to build the second image with a second set of instructions.
- The final image is tagged with the tag specified in the command.

## Copying Build Output
- The COPY instruction on the second image is modified to copy the dist directory from the first image using the `from` option.
- The `from` option can take numbers or names as parameters to specify the source image.

## Summary of Multi-Stage Builds
- Multi-stage builds optimize Dockerfiles, making them easier to maintain.
- They help keep the size of images low and avoid the need for maintaining multiple Dockerfiles or creating intermediate images.
