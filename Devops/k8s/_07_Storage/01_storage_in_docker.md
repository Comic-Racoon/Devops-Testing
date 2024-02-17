Introduction
    Docker's data storage and file system management.
    Focus on where and how Docker stores data and manages file systems of containers.

Storage Location
    Default location: /var/lib/docker/.
    Contains folders for AUFS containers, image volumes, etc.
    Data related to images and containers stored here.

Layered Architecture
    Docker images built in layered architecture.
    Each Dockerfile instruction creates a new layer.
    Advantages: faster builds, efficient disk space utilization.

Image Layers
    Read-only layers.
    Cannot modify contents directly.
    Shared by all containers using the same image.

Container Layers
    Created when a container is run.
    Writeable layer on top of image layer.
    Stores container-specific data.
    Destroyed with container.

Persisting Data
    Persistent volumes can be added.
    Created using docker volume create.
    Mounted into containers using -v or --mount options.
    Types: volume mounting, bind mounting.

Storage Drivers
    Responsible for enabling layered architecture.
    Common drivers: AUFS, VTRFS, ZFS, device mapper, overlay, overlay2.
    Selection based on underlying OS and performance considerations.

