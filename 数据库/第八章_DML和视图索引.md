
##### insert  
insert into 表名() values ()  
将以下学生信息插入到表S中，学号001姓名张总，性别男，年龄19，院系计算机系  
```sql  
insert into s (SNO,SNAME,SEX,AGE,SDEPT)   
values ('001','张总','男',19,'计算机系');  
##或  
insert into s  
values ('001','张总',19,'男','计算机系')  
##顺序和个数一样可以省略前面列名  
##当然需要强行凑可以用null  
insert into s  
values ('001','张总',19,null,null)  
##这样也可以省略列名  
```  
  
##### update  
update 表名 set 要改属性 where 哪个属性  
将计算机系学生的年龄增加2岁  
```sql  
update student set age = age+2  
where sdept = '计算机系'  
```  
将学生成绩为空值的成绩改为100分  
注意null的使用  
```sql  
update sc set grade = 100  
where grade is null     //grade = null也可以  
  
##将001号学生的成绩改成nu11  
update sc set grade = null  
where sno = '001'  
```  
  
##### delete  
删除计算机系，数学系和信息系年龄大于等于18岁小于等于20岁的学生记录  
```sql  
delete from S  
where SDEPT in(’计算机系’,’数学系’,’信息系’)  
and (AGE between 18 and 20)  
```  
  
#### 视图  
<font color=#66CC99 style=" font-weight:bold;">视图只需要了解创建部分的代码即可</font>  
独立性:[外模式](第二章_关系模型与独立性#####三级模式分别是什么？有什么名称？)  
安全性:给用户看用户能看的  
视图不是表而是一个查询结果  
  
作用:  
<font color=#66CC99 style=" font-weight:bold;">简化代码</font>,但不能提高数据查询效率  
能提高查询效率的是索引  
![](img/Pasted%20image%2020230317001556.png)  
新的虚标需要改列名时,列名不能省略  
在视图中包含表达式的情况,列名不能省略  
创建视图VW11，显示计算机系学生20年以后的年龄,姓名和学号  
```sql  
create view vw11(年龄,姓名,学号)  
as   
select sage+20,sname,sno from S  
where sdept = '计算机系'  
```  
在视图中包含统计函数,列名不能省略  
创建视图VW22，显示每个院系学生的平均成绩  
```sql  
create view vw22(院系,平均成绩)  
as  
select sdept,avg(grade) from S  
join SC on S.sno = SC.sno  
group by sdept  
  
##select字句不能用orderby  
```  
![](img/Pasted%20image%2020230317000942.png)  
##### 行列子集视图  
满足条件  
* 基于一张基本表  
* 不包含公式列  
* 必须包含原表中的主码  
with check option作用:  
限制对视图更新  
  
增删改对with check option修饰的行列子集视图,修改视图时,必须满足where条件才能增删改成功  
![](img/Pasted%20image%2020221230175635.png)  
基于视图创建视图  
4）基于视图VW44创建视图VW55，显示计算机系18岁和20岁女生的学号.姓名和年龄  
```sql  
create view vw44  ##这个显然不是行列子集视图  
as   
select * from vm55  
where sage = 18 or sage = 20  
```  
  
##### 视图更新  
行列子集视图可以更新  
带表达式,聚合函数的不能更新  
从多个基本表导出的视图也不能更新  
  
所有视图都可以执行查询操作  
但只有行列子集视图才可以更新(增,删,改)  
若视图可以更新。更新以后的结果会影响到基本表中的数据。  

##### 视图删除  
若删除了视图，对创建该视图时基于的基本表没有任何影响;反之，若删除了基本表，则由该基本表导出的视图就不用。  
![](img/Pasted%20image%2020230316214141.png)
  
#### 索引(必考)  
物理设计阶段  
作用:<font color=#66CC99 style=" font-weight:bold;">加快查询速度</font>  
分类:  
一、按数据索引的顺序是否和数据的存储顺序一致分:  
1、聚集索引  
特点:每张表只能建一个聚集索引.默认情况下,在创建primary key时若没有创建聚集索引，聚集索引就会自动建在primary key列上。  
2、非聚集索引  
特点:在建立了聚集索引基础上创建的索引。一张表可以有多个非聚集索引。  
  
二、按建索引列中的数据是否允许重复分   
unique  
1、唯一值索引:创建索引列中的属性值不能重复  
2、非唯一值索引:创建索引列中的属性值可以重复  
  
三、按建索引包含的列的个数分:  
1、简单索引:索引只建立在表中的一列上  
2、复合索引∶索引建立在表中的多列上  
  
创建索引代码考最简单的
```sql
create (唯一索引加unique) index 索引名
on 表名 (列名 (升序用asc),name desc);
```
一般只考选择  
  
![](img/Pasted%20image%2020221230190108.png)  
没说聚集就是非聚集,非聚集nonclustered可省略  
只建在一列上,是简单索引  
所以上面是非聚集唯一简单索引  
![](img/Pasted%20image%2020221230190425.png)  


## Sql定义
结构化查询语言
![](img/Pasted%20image%2020230316213659.png)
![](img/Pasted%20image%2020230316213952.png)