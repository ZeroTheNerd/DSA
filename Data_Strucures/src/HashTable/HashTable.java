package HashTable;


// Hash Representation - Using seperate chaining with Linked List
// "{
//    "key"= "bolts",
//    "value"= 400,
//    "next"= null
//  }"

import java.sql.Array;
import java.util.*;

public class HashTable {
    public int size = 7;
    private Node[] dataMap;

    public class Node {
        int value;
        private String key;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println(" {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for(int i = 0; i < keyChars.length; i++) {
            int asciiVal = keyChars[i];
            //Multiply by prime number for more randomness
            hash = (hash + asciiVal * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            //Same thing as -- temp = head
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while(temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys() {
        ArrayList<String> keys = new ArrayList<>();
        for(int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }

    public boolean itemInCommon(int[] arr1, int[] arr2) {
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();
        for(int i : arr1) {
            myHashMap.put(i, true);
        }

        for(int j : arr2) {
            if (myHashMap.get(j) != null) return true;
        }
        return false;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Integer> numCount = new HashMap<>();
        for(int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;

    }

    public Character firstNonRepeatingChar(String string) {
        Map<Character, Integer> letCounts = new HashMap<>();
        for(char c : string.toCharArray()) {
            letCounts.put(c, letCounts.getOrDefault(c, 0) + 1);
        }

        for(char c : string.toCharArray()) {
            if(letCounts.get(c) == 1) return c;
        }
        return null;

    }

    public List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for(String s : strings) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String canonical = new String(chars);
            if(anagramGroups.containsKey(canonical)) {
                anagramGroups.get(canonical).add(s);
            } else {
                List<String> groups = new ArrayList<>();
                groups.add(s);
                anagramGroups.put(canonical, groups);
            }

        }
        return new ArrayList<>(anagramGroups.values());
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if(numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(num, i);
        }
        return new int[]{};

    }

    public int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, -1);
        int curSum = 0;
        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if(myMap.containsKey(curSum - target)) {
                return new int[] {myMap.get(curSum - target) + 1, i};
            }

            myMap.put(curSum, i);
        }
        return new int[]{};
    }

    public List<Integer> removeDuplicates(List<Integer> myList) {
        Set<Integer> mySet = new HashSet<>();
        for(int num : myList) {
            mySet.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : mySet) {
            list.add(num);
        }

        return list;

    }


    public static boolean hasUniqueChars(String s) {
        Set<Character> mySet = new HashSet<>();
        for (char c : s.toCharArray()) {
            mySet.add(c);
        }
        if (mySet.size() != s.toCharArray().length) {
            return false;
        }
        return true;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> mySet = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        for(int num : arr1) {
            mySet.add(num);
        }
        for(int i = 0; i < arr2.length; i++) {
            int complement = target - arr2[i];
            if(mySet.contains(complement)) {
                int[] arr = {arr2[i], complement};
                list.add(arr);
            }
        }
        return list;
    }

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        int length = 0;
        for (int num : nums) {
            mySet.add(num);
        }

        for (int num : nums) {
            if (!mySet.contains(num - 1)) {
                int curNum = num;
                int curSteak = 1;
                while (mySet.contains(curNum + 1)) {
                    curSteak++;
                    curNum++;
                }

                length = Math.max(curSteak, length);
            }
        }
        return length;
    }
}
