Background
    Initially, Kubernetes relied solely on Docker as its container runtime engine.
    All Docker-related code was embedded within Kubernetes source code.
    Emergence of alternative container runtimes like RKT and CRI-O necessitated a change.
    Kubernetes needed to support various container runtimes without being tied to its source code.

Container Runtime Interface (CRI)
    Standard defining communication between Kubernetes and container runtimes.
    Allows Kubernetes to interface with different container runtimes.
    New container runtimes can adhere to CRI standards to seamlessly integrate with Kubernetes.
    Reduces dependency on Kubernetes source code for compatibility.

Container Networking Interface (CNI)
    Similar concept in networking domain.
    Introduced to extend support for different networking solutions.
    Networking vendors can develop plugins based on CNI standards to work with Kubernetes.

Container Storage Interface (CSI)
    Developed to support multiple storage solutions in Kubernetes.
    Allows creation of custom drivers for various storage solutions.
    Enables integration of storage solutions like Portworx, Amazon EBS, Azure Disk, etc.
    Not specific to Kubernetes; designed as a universal standard.
    Allows any container orchestration tool to work with supported storage vendors via plugins.

CSI Architecture
    Defines a set of Remote Procedure Calls (RPCs) to be implemented by storage drivers.
    Orchestrator (e.g., Kubernetes) calls these RPCs to interact with storage drivers.
    Examples: create volume, delete volume.
    Specification outlines parameters, expected responses, and error handling.

Adoption
    Currently adopted by Kubernetes, Cloud Foundry, and Mesos.
    Promotes interoperability between container orchestration tools and storage vendors.

