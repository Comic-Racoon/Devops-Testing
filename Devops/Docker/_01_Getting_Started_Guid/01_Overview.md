### What is a Container?

A container is a sandboxed process running on a host machine that isolated from all other processes running on that host machine  

To Summarize:-
* Is a runnable instance of an image. You can ***Start, Stop, move, delete*** using Docker API or CLI
* Can be run on local machine, vm , or deployed on cloud
* Is Portable (can be run on any OS)
* Is isolated form another container and runs on its own software , binaries and configurations etc.

### What is an Image?

A running container uses an isolated filesystem. 
This isolated filesystem is provided by an image and image must contains everything needed to run an application all dependencies, configurations, scripts, binaries, etc. 
Image also contains other cnfigurations for the container, such as env var, a defaule command to run and other meta-data