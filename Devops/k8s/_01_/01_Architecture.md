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

The kube-apiserver is a critical component in a Kubernetes cluster, acting as the API gateway for all operations and management tasks. Here's a summary of how the kube-apiserver orchestrates these activities:

    Request Handling:
        kubectl commands or direct API invocations reach the kube-apiserver.
        The kube-apiserver authenticates and validates these requests.

    Data Retrieval:
        It retrieves data from the etcd cluster, which serves as the central distributed key-value store.

    Pod Creation Workflow:
        In the case of creating a pod, the kube-apiserver handles the entire process:
            Creates a pod object.
            Updates information in the etcd cluster.
            Notifies the user of the pod creation.

    Scheduler Interaction:
        The scheduler, another component in the Kubernetes control plane, monitors the kube-apiserver for changes.
        Identifies new pods without assigned nodes and determines suitable nodes for placement.

    Communication Flow:
        The scheduler communicates node information back to the kube-apiserver.
        kube-apiserver updates the etcd cluster with the new pod-node mapping.

    Worker Node Deployment:
        kube-apiserver informs the kubelet on the worker node about the new pod.
        kubelet creates the pod on the node and instructs the container runtime engine to deploy the application image.

    Status Update and Data Flow:
        After completion, kubelet updates the pod status back to the kube-apiserver.
        kube-apiserver updates the etcd cluster with the latest information.

    Repeatable Pattern:
        This pattern repeats for any change requested in the cluster, with the kube-apiserver orchestrating and coordinating the entire process.

### Kube Controller Manager (kube controller):

    Controller Manager in Kubernetes:
        In Kubernetes, a controller is a process that continuously monitors the state of various components.
        The controller works towards bringing the entire system to the desired functioning state.

    Node Controller:
        Responsible for monitoring the status of nodes in the cluster.
        Uses the Kube API server for communication.
        Tests node status every five seconds to ensure health monitoring.
        If a node becomes unreachable, it marks it as such after 40 seconds.
        Allows a five-minute window for the node to recover; if not, it reallocates PODs to healthy nodes (if part of a replica set).

    Replication Controller:
        Monitors the status of replica sets in the cluster.
        Ensures the desired number of PODs are available within the set.
        Creates a new POD if an existing one dies to maintain the desired replica count.

    Role of Controllers in Kubernetes:
        Controllers, including Node and Replication controllers, implement intelligence in Kubernetes.
        They manage concepts like deployment, services, namespaces, and persistent volumes.
        Controllers act as the brain behind various functionalities in Kubernetes.

    Diverse Controllers:
        Besides Node and Replication controllers, Kubernetes has numerous other controllers.
        Deployment controller, name space controller , end point controller, cron job controller , job controller , pv protection controller , service account dontroller , sateful set controller , pv binder contrller 
        Each controller is designed for specific components or tasks within the Kubernetes ecosystem.

    Critical Role in Kubernetes:
        Controllers serve as the brain behind many operations in Kubernetes.
        They continuously monitor, validate, and take actions to maintain the desired state of the system.

### Kube Schedular 

    Kubernetes Scheduler Functionality:

        The Kubernetes scheduler is responsible for scheduling pods on nodes within the cluster.
        It decides which pod should be placed on which node based on specific criteria.

    Scheduler vs. Kubelet:

        The scheduler determines pod-to-node assignments.
        The kubelet is responsible for creating and placing the pod on the nodes.

    Need for Scheduler:

        In scenarios with multiple ships (nodes) and containers, the scheduler ensures the right container is placed on the right ship.
        Considerations include ship (node) sizes, capacities, and destinations.

    Scheduler Criteria:

        Nodes may have different resource capacities and applications.
        Pods may have diverse resource requirements.

    Scheduler Phases:

        Scheduler works in two phases to identify the best node for a pod.
            Filtering Phase: Eliminates nodes that do not meet the resource requirements of the pod.
            Ranking Phase: Ranks the remaining nodes based on a priority function.

    Priority Function:

        Assigns a score (0 to 10) to nodes based on factors like resource availability after placing the pod.
        Nodes with higher scores are considered better fits.

    Customization and Flexibility:

        Scheduler behavior can be customized.
        Custom schedulers can be written to meet specific requirements.

    Upcoming Topics:

        Resource Requirements and Limits: Considerations for CPU and memory requirements.
        Taints and Tolerations: Mechanisms for node customization.
        Node Selectors: Defining node preferences.
        Affinity Rules: Specifying pod-to-node relationships.

### Kubelet (worker ship captain):

    Kubelet in Kubernetes:
        The kubelet is likened to the captain on a ship, leading all activities on the node.
        Responsible for handling paperwork to join the cluster and is the primary point of contact with the master node.

    Role of Kubelet:
        Loads and unloads containers on the node based on instructions received from the master node's scheduler.
        Acts as the intermediary between the master node and the container runtime engine.

    Registration with Cluster:
        On the Kubernetes worker node, the kubelet registers the node with the Kubernetes cluster.

    Container Deployment Process:
        When instructed to load a container or pod, the kubelet requests the container runtime engine (e.g., Docker).
        The container runtime engine pulls the required image and runs an instance of the container.

    Continuous Monitoring:
        The kubelet continually monitors the state of the pod and the containers within it.

    Reporting to Kube API Server:
        Sends regular status reports to the kube API server, ensuring timely updates on the state of the ship (node) and its containers.

    Key Responsibilities:
        Container Handling: Loads and unloads containers as per scheduler instructions.
        Communication: Acts as a communication bridge between the master node and the container runtime engine.
        Image Management: Requests container runtime engine to pull required images.
        Monitoring: Monitors the state of pods and containers.
        Reporting: Regularly reports the status of the ship and its containers to the kube API server.

    Essential Node Component:
        The kubelet is an essential component on a Kubernetes worker node, ensuring proper execution and management of containers as directed by the cluster master.

    Integration with Container Runtime Engine:
        Collaborates with the chosen container runtime engine (e.g., Docker) to fulfill container deployment instructions.

    Continuous Feedback Loop:
        Creates a continuous feedback loop by providing real-time updates to the master node about the status of containers and the node itself.

### kube proxy :

    Pod Networking in Kubernetes:
        Every pod within a Kubernetes cluster can communicate with every other pod.
        This is achieved through deploying a pod networking solution that creates an internal virtual network spanning across all nodes.

    Web and Database Applications:
        Example scenario with a web application on the first node and a database application on the second node.
        Web app reaching the database using the pod's IP, but this is not a reliable approach.
        we use k8s services for better communication between applications.
        Services provide a reliable way for the web application to access the database.

    Service Access through Name:
        Web app can now access the database using the service name, e.g., DB.
        Service is assigned an IP address.

    Service Limitations:
        Services cannot join the pod network as they are not containers.
        They are virtual components existing only in Kubernetes memory.

    kube-proxy's Role:
        kube-proxy is a process running on each node in the Kubernetes cluster.
        Its primary role is to handle service exposure and communication.

    kube-proxy Functionality:
        Monitors for new services.
        Creates appropriate rules on each node to forward traffic to the services.
        Utilizes iptables rules for traffic forwarding.

    Service Accessibility Across Cluster:
        Services need to be accessible across the entire cluster, not confined to a specific node.
        kube-proxy ensures this accessibility by configuring iptables rules on each node.

    Example iptables Rule:
        kube-proxy creates an iptables rule on each node.
        Forwards traffic heading to the service's IP (e.g., 10.96.0.12) to the actual pod's IP (e.g., 10.32.0.15).

    kube-proxy Configuration:
        Configuration involves dynamically updating iptables rules based on service creation and changes.
        Ensures seamless and reliable communication between pods through services.

    Significance of kube-proxy:
        Essential for enabling service-based communication within a Kubernetes cluster.
        Facilitates transparent and efficient routing of traffic to backend pods through dynamically managed iptables rules.