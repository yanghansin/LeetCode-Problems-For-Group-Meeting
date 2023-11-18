"""
    Author: Nahai Gu
    Date: 12/09/2023
    LeetCode 146. LRU Cache
"""


class CacheNode:
    def __init__(self, key, value) -> None:
        """ Initialize a CacheNode.

        Args:
            key (int): Key used in LRUCache (LRU_map).
            value (int): Value corresponding to key (value of a CacheNode).
        """
        self.key = key
        self.value = value
        self.next = None
        self.prev = None


class LRUCache:
    def __init__(self, capacity) -> None:
        """
        Initialize LRUCache. Key in LRU_map is the same as the
        corresponding node's value.

        Args:
            capacity (int): Number of nodes without head and tail.
        """
        # Number of nodes in the list
        self.number_of_nodes = 0
        # Capacity of LRUCache
        self.capacity = capacity
        # Head node of linked list
        self.head = CacheNode(None, None)
        # Tail node of linked list
        self.tail = CacheNode(None, None)
        # Initialize double-linked list
        self.head.next = self.tail
        self.tail.prev = self.head
        # Initialize the map
        self.LRU_map = dict()

    def get(self, key) -> int:
        """
        Return the value of the node correspondint to a specified
        key in the LRU_map. The accessed node will be moved to the
        first position (right after head) in the LRUCache. The LRU
        node will always be at the last position (right before tail).

        Args:
            key (int): Key used in LRUCache (LRU_map).

        Returns:
            int: -1 if key not found, value of the
                 corresponding CacheNode otherwise.
        """
        result = 0
        if (key not in self.LRU_map):
            # Return -1 if the i_th node is not found
            result = -1
        elif (self.LRU_map[key].prev.prev is None):
            # No need to move the accessed node since it's the 1st node
            result = self.LRU_map[key].value
        else:
            result = self.LRU_map[key].value
            # Link nodes before and after accessed node
            self.LRU_map[key].prev.next = self.LRU_map[key].next
            self.LRU_map[key].next.prev = self.LRU_map[key].prev
            # Link accessed node and the fist node (node right after head)
            self.LRU_map[key].next = self.head.next
            self.head.next.prev = self.LRU_map[key]
            # Link accessed node and head node
            self.head.next = self.LRU_map[key]
            self.LRU_map[key].prev = self.head
        return result

    def put(self, key, value) -> None:
        """
        Put a (key, value) pair in the LRUCache. Newly added node or
        updated node will always be moved to the first position (right
        after head) in the LRUCache. The LRU node will always be at the
        last position (right before tail).

        Args:
            key (int): Key added or updated.
            value (int): Value added or updated.
        """
        if (key not in self.LRU_map):
            new_node = CacheNode(key, value)
            # Link new node and the fist node (node after head node)
            new_node.next = self.head.next
            self.head.next.prev = new_node
            # Link new node and head node
            self.head.next = new_node
            new_node.prev = self.head
            # Add new node to the LRU_map
            self.LRU_map[key] = new_node
            if (self.number_of_nodes < self.capacity):
                # Increment total number of nodes
                self.number_of_nodes += 1
            else:
                # Key popped
                key_popped = self.tail.prev.key
                # Delete LRU node from LRU_map
                self.LRU_map.pop(key_popped)
                # Pop last node in the list
                self.tail.prev.prev.next = self.tail
                self.tail.prev = self.tail.prev.prev
        else:
            # Update existing node's value
            self.LRU_map[key].value = value
            # Link nodes before and after updated node
            self.LRU_map[key].prev.next = self.LRU_map[key].next
            self.LRU_map[key].next.prev = self.LRU_map[key].prev
            # Link updated node and the fist node (node after head node)
            self.LRU_map[key].next = self.head.next
            self.head.next.prev = self.LRU_map[key]
            # Link updated node and head node
            self.head.next = self.LRU_map[key]
            self.LRU_map[key].prev = self.head

    def printCache(self) -> None:
        """
        Print existing key-value pair in cache.
        """
        temp = self.head.next
        print("Current cache: {", end="")
        while (temp.next is not None):
            print(f"[{temp.key},{temp.value}]", end="")
            temp = temp.next
        print("}")


if __name__ == "__main__":
    # Test case
    obj = LRUCache(2)
    obj.printCache()

    assert obj.put(1, 1) is None, "ErrorOccured"
    obj.put(1, 1)
    print("Add: (1, 1)")
    obj.printCache()

    assert obj.put(2, 2) is None, "ErrorOccured"
    obj.put(2, 2)
    print("Add: (2, 2)")
    obj.printCache()

    assert obj.get(1) == 1, "ErrorOccured"
    obj.get(1)
    print("Get(1): Return ", obj.get(1))
    obj.printCache()

    assert obj.put(3, 3) is None, "ErrorOccured"
    obj.put(3, 3)
    print("Add: (3, 3)")
    obj.printCache()

    assert obj.get(2) == -1, "ErrorOccured"
    obj.get(2)
    print("Get(2): Return ", obj.get(2))
    obj.printCache()

    assert obj.put(4, 4) is None, "ErrorOccured"
    obj.put(4, 4)
    print("Add: (4, 4)")
    obj.printCache()

    assert obj.get(1) == -1, "ErrorOccured"
    obj.get(1)
    print("Get(1): Return ", obj.get(1))
    obj.printCache()

    assert obj.get(3) == 3, "ErrorOccured"
    obj.get(3)
    print("Get(3): Return ", obj.get(3))
    obj.printCache()

    assert obj.get(4) == 4, "ErrorOccured"
    obj.get(4)
    print("Get(4): Return ", obj.get(4))
    obj.printCache()
