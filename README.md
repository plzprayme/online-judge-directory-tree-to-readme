# 온라인 저지 레포지토리 README Auto fomatter (Github Plugin)
베타 버전입니다. BOJ와 LEETCODE에서 문제를 풀고 PUSH하면 리드미를 자동으로 생성해드립니다.

# 사용법
```
- uses: actions/checkout@v2
- uses: plzprayme/online-judge-directory-tree-to-readme@beta
```

# 디렉토리 생성 규칙
## BOJ 
디렉토리 이름은 `boj`여야 합니다.  
파일의 이름은 문제 번호여야 합니다. `e.g. 1154.java`  

## LEETCODE
디렉토리 이름은 `leetcode`여야 합니다.  
파일의 이름은 leetcode 문제 페이지 url의 마지막 path여야 합니다. `e.g. increasing-order-search-tree.go`  

# 구현 예정 기능
1. 디렉토리 이름 커스텀 가능 하도록 변경
2. 온라인 저지 디렉토리가 아니여도 리드미를 생성하도록 변경
3. 리드미의 디자인을 예쁘게 변경
