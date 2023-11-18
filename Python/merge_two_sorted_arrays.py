""" Author: Nahai Gu
    Date: 12/16/2023
    LeetCode 21. Merge Two Sorted Lists (input as arrays)
"""


class Solution:

    @staticmethod
    def merge_two_sorted_arrays(a, b) -> list:
        """
        Merge two sorted lists (arrays) 'a' and 'b' into a new
        sorted list (array).

        Args:
            a (list): The first sorted list (array).
            b (list): The second sorted list (array).

        Returns:
            list: The merged sorted list (array).
        """
        if (len(a) == 0):
            return b
        if (len(b) == 0):
            return a
        result = []
        index_a = 0
        index_b = 0
        while (index_a < len(a) and index_b < len(b)):
            if a[index_a] <= b[index_b]:
                result.append(a[index_a])
                index_a += 1
            else:
                result.append(b[index_b])
                index_b += 1
        while (index_a < len(a)):
            result.append(a[index_a])
            index_a += 1
        while (index_b < len(b)):
            result.append(b[index_b])
            index_b += 1
        return result


if __name__ == "__main__":

    # Test case 1
    a = [0, 2, 3, 5, 7, 22]
    b = []
    result = Solution.merge_two_sorted_arrays(a, b)
    assert result == [0, 2, 3, 5, 7, 22], "ErrorOccured"
    print(result)

    # Test case 2
    a = []
    b = [1, 3, 4, 6, 7, 9, 109]
    result = Solution.merge_two_sorted_arrays(a, b)
    assert result == [1, 3, 4, 6, 7, 9, 109], "ErrorOccured"
    print(result)

    # Test case 3
    a = [0, 2, 3, 5, 7, 22]
    b = [1, 3, 4, 6, 7, 9, 109]
    result = Solution.merge_two_sorted_arrays(a, b)
    assert result == [0, 1, 2, 3, 3, 4, 5, 6, 7, 7, 9, 22, 109], "ErrorOccured"
    print(result)
