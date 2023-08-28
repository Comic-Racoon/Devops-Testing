## Heap 

# Heap and it's Identification

KeyWords 
- k k^th 
- smallest or larest 
- you will also notice that heap sums will get solved with sorting with complex nlogn , this nlogn will come to nlogk if you use heap correctly

* Heap are of two typer 
- min-heap
- max-heap 

if k given is smallest then we will make max heap
if k given is largest then we will nake mi heap 

we do this because -
    if k given is smallest --> we need smallest elemet, we can get smallest element if we remove all max/larger elements max heap will bring all larger elements to top , so that we can pop them out and get close to answer 
    vice versa for the other

# Initialize heap 

Max Heap :

Priority_queue <int> max_heap;

Min Heap : 

priority_queue <int , vector < int >, greater < int > > min_heap ;

if you want to put multiple pair in heap substitute <int> by pair<int,int> or what ever pair how you want`