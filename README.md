# Algorithm Analysis and Design - Assignment 1
#### Nicholas Sidharta - 2106752294

### Description
This repository is a compilation of Java codes that implements the experimental "Simple and Fast BlockQuicksort using Lomuto’s Partitioning Scheme" made by Martin Aum¨uller and Nikolaj Hass and Merge Sort Algorithm. The codes are made to compare the performance of the two algorithms in terms of runtime. The codes are tested with 3 different types of array length, the small set which contains 2^9 or 512 numbers, the medium set which contains 2^13 or 8192 numbers, and finally the big one which contains a whopping 2^16 or 65536 numbers. For each set of array length, the codes are tested with 3 different types of array, the random array, the sorted array, and the reverse sorted array.

### Contents
1. MergeSort.java = The implementation of Merge Sort Algorithm
2. TwoPivotBlockQuickSort.java = The implementation of Two Pivot Block Quick Sort Algorithm
3. ArrayGeneration.java = The implementation of array generation for testing datasets
4. SortBenchmark.java = The implementation of benchmarking runtime process between the two algorithms measured in miliseconds.
5. sorted_{number}.txt = The sorted array of {number} numbers
6. random_{number}.txt = The random array of {number} numbers
7. reverse_{number}.txt = The reverse sorted array of {number} numbers

### How to Run
1. Clone this repository
2. Open the terminal and go to the directory where the repository is cloned
3. Compile the codes using the following command
```
javac *.java
```
4. (Optionally) Generate the datasets using the following command
```
java ArrayGeneration
```
4. Run the benchmark process using the following command
```
java SortBenchmark
```

### Credits
Thank you to Martin Aum¨uller and Nikolaj Hass for the paper and the pseudocode as well as the idea of the two pivot block quick sort algorithm.

### Disclaimer
This repository isn't meant to be somekind of research paper, this is mainly used for educational purposes. The codes are made to be as close as possible to the pseudocode provided by the paper. Any kind of Feedback however is welcomed and appreciated.