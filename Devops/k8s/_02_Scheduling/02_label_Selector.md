# Labels and Selector

    Labels and Selectors Overview:
        Standard method to group items.
        Labels: Properties attached to each item.
        Selectors: Help filter items based on labels.

    Use in Kubernetes:
        Various Kubernetes objects like pods, services, replica sets, etc., are treated as different objects.
        Labels and selectors help manage and filter these objects in the cluster.

    Labeling in Kubernetes:
        Attach labels to objects (e.g., pods) based on application, function, etc.
        Specify conditions while selecting objects (e.g., app equals app one).

    Specifying Labels in Kubernetes:
        In pod definition files, under metadata, create a section called labels.
        Add labels in key-value format.
        Use kubectl get pods command with a selector option to select pods with specific labels.

    Example: Replica Sets and Pods:
        Labels and selectors are used internally in Kubernetes objects.
        Replica sets use labels to group pods.
        Define labels both in the pod template and replica set definition.
        Configure the selector field in the replica set to match pod labels.

    Annotations:
        Used for informative purposes, unlike labels and selectors.
        Record details such as tool name, version, contact details, etc.
        Provide additional context or metadata for objects in Kubernetes.

