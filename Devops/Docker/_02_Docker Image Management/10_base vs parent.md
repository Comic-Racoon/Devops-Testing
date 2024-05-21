# Introduction to Parent Images

A Dockerfile typically starts with a directive specifying the base image upon which the custom application image will be built. This base image is referred to as the parent image.

## Understanding Parent-Child Relationship

The parent image is the foundation upon which custom images are built. For instance, if a Dockerfile begins with `FROM httpd`, then `httpd` is the parent image.

## Exploring Base Images

The hierarchy of images can be traced from the custom image back to its base image. Each image builds upon its parent image until reaching the base image, often created from scratch.

## Examples of Base Images

Common base images include `debian`, `ubuntu`, and `scratch`. For instance, the MongoDB image is built from `ubuntu`, which is built from `scratch`.

## Understanding Scratch Image

The `scratch` image represents a blank slate with nothing inside. Docker reserves the name "scratch" for this purpose, and users cannot create their own scratch images.

## Building Minimal Operating System Images

Minimal versions of operating systems are containerized using the `scratch` image as the starting point. Users can build their own minimal images from scratch if necessary.
