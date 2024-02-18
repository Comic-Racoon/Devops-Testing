Notes on Kubernetes DNS Implementation in the Cluster

    Introduction
        In this lecture, we will discuss how Kubernetes implements DNS in the cluster.
        Previous lecture covered addressing services or pods from another pod.

    Addressing Pods with IP Addresses
        Initially, adding entries to etc/hosts files of pods can resolve IPs.
        Not scalable for large clusters with dynamic pod creation and deletion.

    Centralized DNS Solution
        Entries moved to a central DNS server.
        Pods configured to point to DNS server via etc/resolv.conf.
        DNS server IP typically 10.96.0.10.
        New pod creation triggers DNS record update.

    Kubernetes DNS Server
        Kubernetes deploys DNS server (kube-dns/CoreDNS) in the cluster.
        CoreDNS recommended from Kubernetes version 1.12.
        CoreDNS deployed as a pod in Kube system namespace.

    CoreDNS Configuration
        Configured via Corefile located at etc/coredns.
        Plugins configured for various functionalities.
        Kubernetes plugin handles DNS resolution for cluster.
        Top level domain set to cluster.local.
        Pods' IPs converted to dashed format for record creation.

    Integration with Kubernetes
        CoreDNS watches for new pods or services.
        Automatically adds records to its database.
        Pods configured to point to CoreDNS server via service named KubeDNS.
        DNS configurations on pods managed automatically by kubelet.

    DNS Resolution
        Pods and services can be accessed using various formats.
        DNS lookup resolves full domain name.
        resolv.conf includes search entries for service but not for pods.

