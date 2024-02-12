Objective:

    Dedicate data processing workloads requiring higher resources to a specific, larger node in the cluster.

Approaches:

    Node Selectors: Simple and easy method.
    Affinity and Anti-affinity: More advanced method, not covered here.

Using Node Selectors:

    Update pod definition file to include a node selector property in the spec section.
    Specify the desired node's label (e.g., size: large) in the node selector.

    eg :- 
        kubectl label nodes <node name> <label_key>=<label_value>

Understanding Node Labels:

    Nodes are labeled with specific attributes (e.g., size: large).
    Kubernetes scheduler utilizes these labels to match pods with suitable nodes.

Labels and Selectors Recap:

    Labels and selectors have been previously encountered in Kubernetes concepts like services, replica sets, and deployments.
    Nodes must be labeled before applying node selectors to ensure proper pod placement.