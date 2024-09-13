# Dynamic-Cache-System
**Overview**
The Dynamic Cache System is an implementation of a multi-level cache that allows users to add cache levels with different policies such as LRU (Least Recently Used) and LFU (Least Frequently Used). The system supports inserting, retrieving, and promoting key-value pairs across cache levels and automatically handles eviction based on the specified cache policy.

This project allows users to manually interact with the cache system via the console, where they can input commands to:

Add new cache levels with specified capacity and policy.
Insert key-value pairs into the cache.
Retrieve values from the cache.
Display the current state of all cache levels.
**Approach**
1.Cache Policies: Two cache replacement policies are implemented: LRU (Least Recently Used) and LFU (Least Frequently Used).
LRUCache uses LinkedHashMap to maintain insertion order and remove the least recently accessed entry when the cache exceeds its capacity.
LFUCache uses a frequency count to keep track of how often each item is accessed, evicting the least frequently accessed item when the cache is full.
2.Multi-Level Cache: The MultilevelCache class allows multiple cache levels to be added, each with its own capacity and policy.
Keys retrieved from lower cache levels are promoted to the top level.
When an insertion exceeds the capacity of a cache level, the eviction policy (LRU or LFU) is applied automatically.
3.Command Input: Commands can be manually entered by the user via the console.
The system reads commands like addCacheLevel, put, get, and display to interact with the cache system.
4.Error Handling: Basic error handling is in place to handle invalid commands or input formats.
**Key Decisions**
1.Extensibility:
The system is designed to allow for future extension. New caching policies can easily be added by implementing the CachePolicy interface.
2.Console Interaction:
The cache system takes user input interactively via the console. This provides flexibility for users to manually add cache levels, insert or retrieve values, and inspect the cache state.
3.Cache Promotion:
When a key is retrieved from a lower cache level, it is automatically promoted to the top-level cache, which enhances performance by keeping frequently accessed data in the top-level cache.
**How to Run the Application**
Clone the Repository: Clone the repository to your local machine.

Navigate to the Source Directory:

cd DynamicCacheSystem/src

Compile the Code: Ensure that you have the Java Development Kit (JDK) installed. Compile all Java files:

javac *.java

Run the Program: After compiling, run the Main class to start the interactive console:

java Main

Input Commands: The program will prompt you with >. You can enter the following types of commands:

Add Cache Level:
Add a new cache level with a specified capacity and policy (either LRU or LFU).

addCacheLevel(3, 'LRU')
addCacheLevel(2, 'LFU')

Insert Key-Value Pair:
Insert a key-value pair into the top-level cache. If the cache level is full, the policy will decide which entry to evict.

put("A", "1")
put("B", "2")

Retrieve Value:
Retrieve a value from the cache by key. The key is promoted to the top level if found in a lower cache level.

get("A")

Display Cache:
Display the contents of all cache levels.

display

Exit the Program: Type exit to stop the application:

exit

**Example Usage**
vbnet
Copy code
> addCacheLevel(3, 'LRU')
Added cache level with capacity 3 and policy LRU
> addCacheLevel(2, 'LFU')
Added cache level with capacity 2 and policy LFU
> put("A", "1")
Inserted key A with value 1
> put("B", "2")
Inserted key B with value 2
> put("C", "3")
Inserted key C with value 3
> get("A")
Value for key A: 1
> put("D", "4")
Inserted key D with value 4
> get("C")
Value for key C: 3
> display
L1 Cache: {A=1, D=4, C=3}
L2 Cache: {B=2}
> exit
Exiting Dynamic Cache System. Goodbye!
**Future Improvements**
Support for more cache policies, such as MRU (Most Recently Used).
Add file-based input for batch operations to allow commands from a file instead of manual input.
Implement a persistence layer to store and load cache state between sessions.
**Conclusion**
This Dynamic Cache System demonstrates a flexible, multi-level caching mechanism with policies like LRU and LFU. The project can be further extended with additional features and cache policies to suit various caching requirements.

