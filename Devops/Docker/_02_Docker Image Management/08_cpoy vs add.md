# Dockerfile Directives: COPY vs ADD

## Overview

In Dockerfile usage, the COPY and ADD directives are frequently compared. Both instructions copy files or directories from the local file system to the container or image file system.

## Features of ADD Directive

The ADD directive offers additional functionalities over COPY:
- It can handle local tar files by extracting them into the image.
- Supports downloading from URLs into specified paths inside the image.

## Best Practice

It's recommended to prioritize COPY over ADD when possible:
- COPY instruction is more straightforward for readers of Dockerfiles.
- ADD instruction's behavior can be confusing, especially with tar files and URLs.

## Efficiency Concerns

Multiple ADD instructions can lead to increased image size due to additional layers.
Using multiple instructions like download, extract, and build can result in more layers and larger images.

## Optimization with RUN Instruction

Suggests consolidating multiple instructions into a single RUN instruction.
This approach helps maintain smaller and leaner images by reducing layers.
