## 查询  

#### 思路
![](img/Pasted%20image%2020230318001937.png)
查询全体学生的姓名及其出生年份。  
```sql  
select sname, year(getdate())-age as birthday from S  
##year()获取时间参数中的年份  
##getdate()获取当前时间  
```  
  
![](img/Pasted%20image%2020221226175525.png)  
![](img/Pasted%20image%2020221226182019.png)  
#### distinct去重  
加载查询属性前面  
```sql  
select distinct sno from SC where grade < 60  
```  
  
#### in集合包含  
```sql  
##查询计算机科学系(CS),数学系(MA)和信息系(IS)学生的姓名和性别。  
select sname,ssex from student   
where sdept in('CS','MA','IS');  
##当in中需要多个值就用圆括号括起来  
```  
  
#### like字符匹配模糊查询  
通配符  
%:0-多个字符,比如:例a%b->acb,ab,acccccb都符合  
\_:只能一个字符,比如:例a_b->acb,aeb,aab符合    
\[\]:方框表示在范围内的任意一个数
```sql
[a-d]表示a到d中其中一个字母
[0-9]表示从0到9的任意一个数都可以
[012]表示0,1,2这三个数中任意一个都可以
```
当要查的就是上面两个符号时用escape转义'\\'->DB%=>like 'DB\\%' escape'\\'   
![](img/Pasted%20image%2020230316233540.png)
```sql  
##查询所有姓“刘”的学生的姓名、学号和性别  
select sno,sname,ssex from student where  
sname like '刘%';   
##查询姓“李”且全名最多为3个汉字的学生的姓名  
where sname like '李__' or sname like '李_' ##后面的sanme不能省  
```  
  
escape转义可以用其他符号,比如0  
![](img/Pasted%20image%2020221228205924.png)  
  
  
#### orderby  
从 SC表中输出学习“C1”号课程的成绩在前3名的学生的学号和成绩  
```sql  
select top 3 sno,grade from SC where cno = 'C1'  
order by grade desc  
##查询最高的几个就是倒序,用DESC  
```  
  
top的使用  
top n前几个  
top n percent前百分比  
top加在属性前面  
  
#### 聚合函数  
![](img/Pasted%20image%2020221228212006.png)  
只有count(\*)不忽略空值 <font color=#66CC99 style=" font-weight:bold;">count(属性列)会忽略空值!!!</font>  
其他聚合函数都忽略空值  
![](img/Pasted%20image%2020230316232018.png)
```sql  
select count(*) as '学生人数' from student   
```  
2、查询S表中所有学生的平均年龄，最大年龄，最小年龄以及年龄的和  
```sql  
select avg(age),max(age),min(age),sum(age)  
from S  
```  
  
#### groupby  
对数据分组,然后聚合函数会对每个分组有效  
查询结果<font color=#66CC99 style=" font-weight:bold;">涉及到聚合函数才用groupby</font>  
即<font color=#66CC99 style=" font-weight:bold;">当聚合函数需要得到多个结果时,就用groupby</font>  
因为聚合函数本身只能得到一个结果  
  
查询每个院系的学生人数  
```sql  
select sdept,count(*) from student  
group by sdept;  
##这个count(*)聚合函数是对分组后的数据进行作用的  
```  
  
#### having  
只有在使用groupby时才会用having  
where是在groupby<font color=#66CC99 style=" font-weight:bold;">之前执行</font>的  
<font color=#66CC99 style=" font-weight:bold;">having是对分组聚合后的数据进行处理</font>  
  
查询每个院系女生人数。只显示女生人数超过100人的院系名和女生人数  
```sql  
select sdept,count(sno) as '女生人数' from student  
where sex = '女'  
group by sdept  
having count(sno) > 100  
```  
查询选修了4门以上课程的学生的学号。  
```sql  
select sno from sc  
group by sno  
having count(*) > 4 ##where在groupby之前执行  
##因此此处不能用where,必须用having  
```  
  
#### 联合查询  
没考过  
  
  
#### 多表查询  
1、查询计算机系女生的考试成绩，要求显示学号，姓名，课程号和考试成绩  
```sql  
select sname,s.sno .....  
join sc on s.sno = sc.sno  
where sex = '女' and sdept = '计算机系'  
```  
  
2、查询计算机系男生的选学课程名，要求显示学号，姓名，选学课程名  
```sql  
select s.sno,sname,c.cname from s  
join sc on s.sno = sc.sno  
join c on c.cno = sc.cno  
where sdept = '计算机系' and sex = '男'  
```  
多表连接还可以用where条件代替join  
from S,SC where sc.sno = s.sno and 条件  

#### 子查询
![](img/Pasted%20image%2020230316231107.png)

