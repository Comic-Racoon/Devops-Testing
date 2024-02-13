To monitor resource consumption on Kubernetes, including node-level metrics, performance metrics, and pod-level metrics, you'll need a monitoring solution. Here's an overview of the process:

Metrics to Monitor:
    Node-level metrics:
        Number of nodes in the cluster
        Node health status
        CPU, memory, network, and disk utilization
    Pod-level metrics:
        Number of pods
        CPU and memory consumption per pod

Monitoring Solutions:
    Kubernetes doesn't have a built-in full-featured monitoring solution.
    Open-source solutions:
        Metrics Server
        Prometheus
        Elastic Stack
    Proprietary solutions:
        Datadog
        Dynatrace

Metrics Server:
    Slimmed-down version of Heapster, now deprecated.
    Retrieves metrics from nodes and pods, aggregates them, and stores them in memory.
    Doesn't store metrics on disk, limiting historical performance data.

Metrics Generation:
    Kubernetes runs an agent on each node called kubelet.
    kubelet contains cAdvisor (Container Advisor), responsible for retrieving performance metrics from pods.
    cAdvisor exposes metrics through kubelet API for Metrics Server.

Deployment:
    For minikube: Enable Metrics Server addon.
    For other environments:
        Clone Metrics Server deployment files from GitHub repository.
        Deploy components using kubectl create command.

Viewing Metrics:
    After deployment, allow Metrics Server time to collect and process data.
    View cluster performance:
        kubectl top node: Shows CPU and memory consumption per node.
        kubectl top pod: Shows performance metrics of pods.

Example Output:
    Running ```kubectl top node``` reveals CPU and memory consumption for each node, such as 8% CPU usage on the master node.

Commands:
    For minikube: minikube addons enable metrics-server.
    For deployment: Clone and deploy Metrics Server files, then monitor using kubectl top node and kubectl top pod.