Docker Volumes
    Containers are transient, data within the container is also transient.
    To persist data, volumes are attached to containers.
    Data processed by containers is stored in volumes, remains even after container deletion.

Kubernetes Volumes
    Pods in Kubernetes are also transient.
    Volumes are attached to pods to persist data.
    Data generated by pods is stored in volumes, remains even after pod deletion.

Implementation in Kubernetes
    Single node Kubernetes cluster example.
    Creation of a pod generating a random number and writing it to a file.
    Volume creation: Configured to use a directory on the host for storage.
    Mounting the volume to a directory inside the container.
    Random number written to the volume, which is a directory on the host.
    File with the random number persists even after pod deletion.

Volume Storage Options
    Host Path: Directly configures storage on the host.
        Suitable for single-node clusters but not recommended for multi-node clusters.
        Not suitable unless external replicated cluster storage solution is configured.
    Other Storage Solutions Supported by Kubernetes:
        NFS, cluster filesystems, Flocker, fiber channel, Ceph FS, ScaleIO.
        Public cloud solutions like AWS EBS, Azure Disk/File, Google Persistent Disk.
    Example: Configuring AWS Elastic Block Store (EBS) volume for storage.