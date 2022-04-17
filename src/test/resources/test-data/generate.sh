#!/bin/sh

rm -rf depth1
rm -rf depth2
rm -rf depth2withleetcode

# depth 1
mkdir depth1 && cd depth1
mkdir boj && cd boj
touch 1005.java
touch 10250.java
touch 11021.java
touch 11022.java
touch 1260.java
touch 1011.java
cd ../..

# depth 2
mkdir depth2 && cd depth2
mkdir boj && cd boj
touch 1005.java
touch 10250.java
touch 11021.java
mkdir 문자열 && cd 문자열
touch 11022.java
touch 1260.java
touch 1011.java
cd ../../..

# depth 2 with leetcode
mkdir depth2withleetcode && cd depth2withleetcode
mkdir boj && cd boj
touch 1005.java
touch 10250.java
touch 11021.java
mkdir 문자열 && cd 문자열
touch 11022.java
touch 1260.java
touch 1011.java
cd ../..
mkdir leetcode && cd leetcode
touch increasing-order-search-tree.go
mkdir easy
touch palindrome-number.go