### Purpose of K8s or Why K8s ??

The purpose of Kubernetes is to host your applications in the form of containers in an automated fashion so that you can easily deploy as many instances of your application as required and easily enable communication between different services within your application. So, there are many things involved that work together to make this possible.

### K8s Architecture ??

**Worker Nodes** : Hosts Application in form of container. ( which runs the container )
But somebody needs to load the containers on the ships and not just load, plan how to load, identify the right ships, store information about the ships, monitor and track the location of containers on the ships, manage the whole loading process, et cetera.
**Master Node** : This all is done by master node in k8 cluster. 
The master node is responsible for managing the Kubernetes cluster, storing information regarding the different nodes, planning which containers goes where, monitoring the nodes and containers on them, et cetera. The master node does all of these using a set of components together known as the control playing components.

Master and Worker Nodes Overview:

Master Nodes:
    etcd Cluster:
        Stores information about the cluster.
    Kube Scheduler:
        Responsible for scheduling applications or containers on nodes.
    Controllers:
        Node Controller, Replication Controller, etc.
        Handle various functions within the cluster.

Kube API Server:
    Orchestrates all operations within the cluster.

Worker Nodes:
    Kubelet:
        Listens for instructions from the Kube API server.
        Manages containers on the worker node.
    Kube Proxy:
        Enables communication between services within the cluster.

Summary:
    Master Nodes:
        etcd Cluster, Cube Scheduler, Controllers, Kube API Server.
    Worker Nodes:
        Kubelet, Kube Proxy.

High-Level Overview:
    Master nodes handle cluster information storage, scheduling, and controllers.
    Kube API Server orchestrates operations.
    Worker nodes manage containers through Kubelet and enable communication via Kube Proxy.


## K8s Architecture Components :-

### ETDC:

ETDC Data Store Overview:
    Stores information about the cluster.
    Includes notes, pods, convicts, secrets, accounts, roles, role bindings, etc.
    All data visible through kubectl get command comes from the etcd server.
    Every change made to the cluster, like adding nodes or deploying pods/replica sets, is updated in the etcd server. A change is considered complete only after being updated in the etcd server.

ETDC Deployment and Configuration:
    Deployment varies based on cluster setup.
    
    Notable configuration: 
        Address where etcd listens.
        Default: IP of the server, port 2379.

    Integration with kube API server:
        kube API server must be configured with the etcd's Advertised Client URL to communicate.

High Availability Setup:
    In a high availability environment:
        Multiple master nodes exist.
        Multiple etcd instances are spread across master nodes.
        Ensure etcd instances know about each other.
        Set the right parameters in etcd service configuration.

Initial Cluster Option:
    When configuring etcd for multiple instances, use the "initial cluster" option.
    Specify different instances of the etcd service.

### Kube Api-Server: 
