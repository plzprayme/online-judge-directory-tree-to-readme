#!/bin/sh

rm -rf depth1
rm -rf depth2
rm -rf depth2withleetcode
rm -rf sort

# depth 1
mkdir -p depth1 && cd depth1
mkdir -p boj && cd boj
touch 1005.java
touch 10250.java
touch 11021.java
touch 11022.java
touch 1260.java
touch 1011.java
cd ../..

# depth 2
mkdir -p depth2 && cd depth2
mkdir -p boj && cd boj
touch 1005.java
touch 10250.java
touch 11021.java
mkdir -p 문자열 && cd 문자열
touch 11022.java
touch 1260.java
touch 1011.java
cd ../../..

# depth 2 with leetcode
mkdir -p depth2withleetcode && cd depth2withleetcode
mkdir -p boj && cd boj
touch 1005.java
touch 10250.java
touch 11021.java
mkdir -p 문자열 && cd 문자열
touch 11022.java
touch 1260.java
touch 1011.java
cd ../..
mkdir -p leetcode && cd leetcode
touch increasing-order-search-tree.go
mkdir -p easy
touch palindrome-number.go
cd ../..

# other test
mkdir -p other && cd other
mkdir -p dir1 && cd dir1
touch file1.java
touch file2.java
cd ..

mkdir -p dir2 && cd dir2
touch file12.java
touch file13.pdf
cd ../..

# sort test
mkdir -p sort && cd sort
mkdir week_1
mkdir week_2
mkdir week_3
mkdir week_10
mkdir week_11
mkdir week_12
