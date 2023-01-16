  
### 导数的定义式和增量式  
##### 两种形式  
定义式  
增量式  
![](img/Pasted%20image%2020221015185416.png)  
  
引伸公式  
到<font color=#F09B59 style=" font-weight:bold;">增量式</font>前面系数不同可以作差得出答案  
![](img/Pasted%20image%2020221015185559.png)  
  
##### 定义式算多项式乘积  
![](img/Pasted%20image%2020221015185008.png)  
##### noface增量式解法  
把括号都去掉直接运算  
,谁消失,后面乘谁的导  
下面题中,被消掉的是a,就乘a的导数  
![](img/Pasted%20image%2020221015185140.png)  
  
  
##### 根据导数定义式凑极限  
为什么导数定义式可以用来凑极限呢?  
因为导数的定义式本身就是一个极限表达式  
将要求的极限凑成导数定义式得出的表达式  
就可以替换解得答案  
![](img/Pasted%20image%2020221015184642.png)  
  
### 可导条件  
可导的必要条件:<font color=#F09B59 style=" font-weight:bold;">可导函数必连续</font>  
因此可导的条件是  
* 连续:左极限=右极限=函数值  
* 左侧导数极限=右侧导数极限  
  
那么  
##### 左右侧导怎么求?  
左导数是=lim(x-><font color=#F09B59 style=" font-weight:bold;">x0-</font>)[f(x)-f(x0)]/(x-x0)  
右导数是=lim(x-><font color=#F09B59 style=" font-weight:bold;">x0+</font>)[f(x)-f(x0)]/(x-x0)  
  
##### 左右侧导是否存在?  
算对应左右侧的极限值,极限存在,对应左右侧就可导  
  
  
##### 可导题  
思路  
根据可导的两个条件来求解题  
可导就是在连续的基础上加一个左右极限相等  
解导数的表达式还是很简单的,因为<font color=#F09B59 style=" font-weight:bold;">导数的两种形式本质都是极限</font>  
![](img/Pasted%20image%2020221015195506.png)  
  
例二  
注意sin无穷是有界  
0×有界=0  
两个表达式不一样才用左右导都求  
![](img/Pasted%20image%2020221015200342.png)  
![](img/Pasted%20image%2020221015200417.png)  
  
##### 什么时候不可导?  
* 该点左右侧导不相等  
* 导数为无穷  
求导的过程实质上是算极限  
所以极限不存在也会不可导  
具体见[极限不存在](jg_第一章_极限###极限不存在)  
  
某点的<font color=#F09B59 style=" font-weight:bold;">左右侧导存在的条件是---对应的左右侧极限是否存在</font>  
  
例:  
这个还是比较好理解的  
两个函数交叉点,该点的导数用左侧分段表达式和右侧分段表达式算出来的导数  
必然不相等  
也就说明该点导数不存在  
![](img/Pasted%20image%2020221016150621.png)  
  
例:  
![](img/Pasted%20image%2020221016150349.png)  
  
##### 绝对值可导证明  
![](img/Pasted%20image%2020221015201712.png)  
  
导数为无穷时不可导  
![](img/Pasted%20image%2020221015205257.png)  
  
  
### 导数公式  
logax导数 = $1 \over xlna$  
a^x导数 = $a^{x} lna$  
arctanx导数 = $1 \over 1+x^{2}$  
arcsinx导数 = $1 \over  \sqrt{1-x^{2}}$   
arccos导数 = -$1  \over    \sqrt {1-x^{2}}$  
tanx导数 = $sec^{2}x$  
arccotx导数= -$1 \over 1+x^{2}$  
##### 幂指函数求导  
看到指数想到取对数化简  
![](img/Pasted%20image%2020221016193531.png)  
![](img/Pasted%20image%2020221016193558.png)  
<font color=#F09B59 style=" font-weight:bold;">用对数化简"次方"和乘积</font>  
  
例2:  
![](img/Pasted%20image%2020221016193416.png)  
  
  
##### 复杂根号求导  
也是用对数来化简根号内的乘除  
![](img/Pasted%20image%2020221016200510.png)  
  
##### 隐函数求导  
![](img/Pasted%20image%2020221017011624.png)  
##### 变限积分求导  
  
##### 高阶导数  
  
  
  
### 函数的微分  
##### 微分和导数的区别  
求解时微分比导数多加一个dx   ,x为自变量  
微分代表拿一条直线在趋近于该点的邻域内代替对于函数  
导数是给出这个代替的直线的斜率  
  
##### 导数和极限  
<font color=#FFCCCC style=" font-weight:bold;">导数为什么是拿极限算的?</font>  
因为导数就是拿极限推出来的  
  
随着p点无限接近于q点  
p,q两点的割线就是在q点的切线  
这个切线斜率就是p趋近于q的△y/△x的极限  
![](img/Pasted%20image%2020221017010304.png)  
  
### 函数特性  
##### 单调性讨论  
需要讨论极限不存在  
![](img/Pasted%20image%2020221017012615.png)  
  
##### 极值和最值  
* 极值:在一个领域内,<font color=#66CC99 style=" font-weight:bold;">左右两侧</font>都比他大,强调左右两侧  
因此<font color=#66CC99 style=" font-weight:bold;">最大值不一定是极大值,极大值也不一定是最大值</font>  
* 最值:一个区间内最大,最小的数  
![](img/Pasted%20image%2020221017013432.png)  
  
  
  
##### 凹凸性  
![](img/Pasted%20image%2020221019131616.png)  
  
##### 拐点是什么?  
![](img/Pasted%20image%2020221019131648.png)  
  
例题  
![](img/Pasted%20image%2020221019131748.png)  
![](img/Pasted%20image%2020221019131804.png)  
