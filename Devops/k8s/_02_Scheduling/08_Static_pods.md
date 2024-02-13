Overview of kubelet and Control Plane Components:
    kubelet functions as a control plane component in Kubernetes.
        Relies on kube-apiserver for instructions on Pods to load on its Node.
        Decisions made by kube-scheduler, stored in ETCD data store.

Scenario Without Control Plane Components:
    No kube-apiserver, kube-scheduler, controllers, or ETCD cluster.
        No master node.
        No other nodes.
    kubelet operates independently.
        Manages node, running Docker containers.

Creating Pods Without kube-apiserver:
    kubelet reads Pod definition files from designated directory on server.
        Periodically checks directory for files, creates Pods.
        Handles Pod lifecycle (restarts, changes).

***Static Pods***:
    Pods created solely by kubelet.
        No intervention from API server or other Kubernetes components.
    Directory for Pod definition files configurable via pod-manifest-path option.
        Can be set directly or through separate config file.
Cluster Setup and Inspection:
    Inspect pod-manifest-path option in kubelet service file or config file.
        Identify directory path for static Pods.
Viewing Static Pods:
    Use docker ps command.
        No kubectl utility without kube-apiserver.

kubelet Functionality in Cluster:
    Accepts requests from Pod definition files and kube-apiserver.
        Can create static Pods and API server Pods simultaneously.
IS API Server Awareness of Static Pods:
    API server lists static Pods as regular Pods.
        Mirror objects created by kubelet in API server.

Usage of Static Pods:
    Not dependent on Kubernetes control plane.
        Useful for deploying control plane components.
            Simplifies setup, handles crashes automatically.
            
Difference Between Static Pods and DaemonSets:
    DaemonSets ensure one instance of an application on all Nodes.
        Managed by DaemonSet controller through kube-apiserver.
    Static Pods created directly by kubelet, no involvement from kube-apiserver.
        Can deploy Kubernetes control plane components.
        Both ignored when creating replicasets, deployments, or services.