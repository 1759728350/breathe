对于c语言进行浅显的理解,只是导论级别,单单是编译链接这一块
就有好多需要实际实验区发掘探索的,还有许多c语言的知识点需要进一步挖掘
这个文章只是一个大概理解


### c语言编译执行的过程
![](img/Pasted%20image%2020230217171810.png)
#### 预处理过程干了些什么?
* 对define,include,条件编译指令进行替换
* 去掉注释
其他的预处理指令主要以#开头
<font color=#FFCCCC style=" font-weight:bold;">拓展</font>
![](img/Pasted%20image%2020230217172214.png)

#### 编译过程干了什么?
通过编译原理分析字符串代码,生成.asm/.s的汇编代码文件
<font color=#FFCCCC style=" font-weight:bold;">这涉及到编译原理中的语法树,词法分析</font>

#### 汇编过程干了什么?
将汇编代码生成为机器指令,并进行分区
生成目标文件
#### 链接干了什么?
c语言不同模块,不同文件之间会进行函数访问,变量访问
链接相当于将这些相关,或者入口文件调用到的所有目标文件(.o文件)全给链接到一起

#### 动态链接库与静态链接库是什么?
静态链接就是编译链接时将多个文件打包<font color=#66CC99 style=" font-weight:bold;">聚合到一块</font>,将所有模块[链接](####链接干了什么?)到一起,生成一个exe文件
![](img/Pasted%20image%2020230217182100.png)
动态链接库就是dll文件,在linux中是.so文件,编译链接时并没有将所有库文件聚合到一起,更新只需要改对应的dll文件就行
[详细说明](https://blog.csdn.net/weixin_44821644/article/details/119855059?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_utm_term~default-0-119855059-blog-83578238.pc_relevant_3mothn_strategy_recovery&spm=1001.2101.3001.4242.1&utm_relevant_index=3)
### main.o目标文件的结构
[详细说明](https://blog.csdn.net/weixin_46935110/article/details/126967840?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167662632916782429786447%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=167662632916782429786447&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-126967840-null-null.142^v73^pc_search_v2,201^v4^add_ask,239^v2^insert_chatgpt&utm_term=%E6%B1%87%E7%BC%96%E5%92%8C%E9%93%BE%E6%8E%A5&spm=1018.2226.3001.4187)
[目标文件详解](https://blog.csdn.net/weixin_37620587/article/details/122139918?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167662901916800217099129%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=167662901916800217099129&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-2-122139918-null-null.142^v73^pc_search_v2,201^v4^add_ask,239^v2^insert_chatgpt&utm_term=%E7%9B%AE%E6%A0%87%E6%96%87%E4%BB%B6&spm=1018.2226.3001.4187)
![](img/Pasted%20image%2020230217185634.png)





### malloc函数的使用
```c
char *p;
p = (char*) malloc(100);
if(p == NULL){
    //
    error;
}