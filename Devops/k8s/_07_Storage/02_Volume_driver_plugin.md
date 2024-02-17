Notes on Storage Drivers and Volume Handling

    Storage Drivers
        Manage storage on images and containers.
        Integral for Docker's functionality.
        Enable efficient storage utilization and performance.

    Volumes
        Necessary for persistent storage.
        Handled by volume driver plugins, not storage drivers.
        Default volume driver plugin: local.
        Creates volumes on Docker host under var/lib/docker/volumes.

    Volume Driver Plugins
        Offer various options for volume creation.
        Examples: Azure file storage, Convoy, DigitalOcean Block Storage, Flocker, Google Compute Persistent Disks, Cluster FS, NetApp, REX-Ray, Portworx, VMware vSphere storage.
        Support different storage providers.

    Example: REX-Ray
        Supports provisioning storage on various platforms: AWS EBS, S3, EMC Isilon, ScaleIO, Google Persistent Disk, OpenStack Cinder.
        Allows choosing specific volume drivers for containers.
        Enables attaching volumes from cloud providers like AWS EBS.
        Ensures data safety in the cloud even after container exits.