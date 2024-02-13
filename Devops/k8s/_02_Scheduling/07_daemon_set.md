    DaemonSets
        Overview
            Deploy one instance of a pod on each node within a Kubernetes cluster.
            Ensures specified pod presence on every node.
        Automatic Management
            Automatically adds pod replicas to new nodes and removes from deleted nodes.

    Use Cases
        Cluster Monitoring
            Deploy monitoring agents or log collectors on each node for cluster monitoring.
            DaemonSets handle addition and removal of agents with cluster changes.

    Creation Process
        Similarity to ReplicaSets
            Nested pod specification under the template section.
            Selectors linking to pods.
        Definition File Structure
            Includes API version, kind (DaemonSet), metadata, and spec sections.
            
    Scheduling Mechanism
        From Kubernetes version 1.12 onwards
            Uses node affinity rules and default scheduler.
        Prior to 1.12
            Pods were directly scheduled to nodes by setting the node name property.