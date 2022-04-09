#!/bin/sh

rm -rf depth1
rm -rf depth2

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