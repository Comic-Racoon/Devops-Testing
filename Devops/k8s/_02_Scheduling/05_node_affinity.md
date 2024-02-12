    Primary Purpose of Node Affinity:
        Ensure pods are hosted on specific nodes (e.g., large data processing pod on node one).

    Node Selector vs. Node Affinity:
        Node selectors provide basic pod placement control.
        Node affinity offers advanced capabilities for specifying pod placement.

    Node Affinity Syntax:
        Under spec, define affinity and node affinity.
        Specify conditions using key, operator, and value pairs.
        Operators include in, not in, exists.

        ```
        affinity:
        nodeAffinity:
            requiredDuringSchedulingIgnoredDuringExecution:
            nodeSelectorTerms:
            - matchExpressions:
                - key: <--node-label-->
                operator: In
                values:
                - <--node-label-value-->'true'
        ```


    Affinity Types:
        Required during scheduling: Mandates pod placement based on rules.
        Preferred during scheduling: Scheduler can ignore affinity rules if necessary.

    Lifecycle Considerations:
        During scheduling: Pod creation phase.
        During execution: Pod running phase.

    Behavior During Scheduling:
        Required: Pod must match affinity rules; else, it won't be scheduled.
        Preferred: Scheduler can overlook affinity rules if needed.

    Behavior During Execution:
        Ignored: Changes in affinity rules won't affect running pods.
        Future types may evict pods not meeting affinity rules during execution.

    Use Cases:
        Required during scheduling for critical pod placements.
        Preferred during scheduling for less critical placements.

    Future Development:
        New affinity types planned for stricter enforcement during execution phase.
        