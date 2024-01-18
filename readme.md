# 滑动窗口

滑动窗口的题大部分都可以套用模板：
[SlidingWindowFramework.java](src%2Fcom%2Fgodtong%2Fslidingwindow%2FSlidingWindowFramework.java)

## 76. 最小覆盖子串

[p76](src%2Fcom%2Fgodtong%2Fslidingwindow%2Fp76)

## 438. 找到字符串中所有字母异位词

[p438](src%2Fcom%2Fgodtong%2Fp438)

这道题和*76. 最小覆盖子串*大部分内容都一样，主要就是while循环条件不一样。

76题：所有有效字符都找到了，才会收缩窗口。

本题窗口内的字符数大于，要查找的字符：p，窗口左边就会缩小。及时收缩窗口是为了保证没有多余的字符被记录。

valid变量保存的是有效字符数。valid == need.size()，就说明了窗口中，对应的字符数量和要查找的字符：p相同！

## 567. 字符串的排列

[p567](src%2Fcom%2Fgodtong%2Fslidingwindow%2Fp567)

这道题和438题差不多
