##### 支持数据库运行的文件

支持数据库运行的文件有（主数据文件.mdf)，(辅助数据文件.ndf）和（日志文件.ldf)，
其中必不可少的文件是（主数据文件.mdf）和(日志文件.ldf);
2、在支持数据库运行的各种文件中，
个数可以是0或多个的是（辅助数据文件.ndf）文件;
个数可以是1或多个的是（日志文件.ldf）文件;
个数只能是1个且不可增减的是（主数据文件.mdf)文件。

#### 创建数据库
![](img/Pasted%20image%2020221224200849.png)
![](img/Pasted%20image%2020221224201008.png)
primary可省略(组名,类似于操作系统的组)

以默认方式创建数据库LV
```sql
create database LV;
```
2、定义数据库LV，其主数据文件逻辑名LV，存在D: \Data文件夹中;
事务日志文件逻辑名LV_log，存在和主数据文件相同目录下
```sql
create database LV on (name=LV,filename="D:\Data\LV.mdf")
log on (name=LV_log,filename="D:\Data\LV_log.ldf")
```
![](img/Pasted%20image%2020221224203529.png)
```sql
create database students on primary
    (name=students,filename="F:\Data\students.mdf",size=1,
    Filegrowth=3),
    (name=students_datal,filename="F:\Data\students_datal.ndf",
    size=5MB,maxsize=10,filegrowth=1MB)
    log on
    (name=students_log,size=2MB,filegrowth=10%,maxsize=6MB,
    filename="F:\Data\students_log.ldf")
```
MB单位可省略
name逻辑名不需要加单位,必须在filename之前写
filename地址名

#### 删除数据库
```sql
drop database LV #删除数据库LV
```

#### 修改数据库
##### 修改
在原有文件上修改
![](img/Pasted%20image%2020221224214645.png)
例,为教学管理数据库JXGL增加容量,原来的数据库文件JXGL. mdf的初始分配空间为3MB(默认值),现在将增至10MB。
```sql
alter database JXGL 
modify file
(name=JXGL,size=10)    ##文件逻辑名不加后缀,物理名才加
```

##### 增加
增加了一个文件
![](img/Pasted%20image%2020221224220354.png)
例5.5为教学管理数据库JXGL<font color=#66CC99 style=" font-weight:bold;">增加</font>辅助数据<font color=#66CC99 style=" font-weight:bold;">文件</font>JXGL_1.NDF,存在D: \Data,初始大小为5MB,最大长度为30MB,按照5%增长。
```sql
alter database JXGL 
add file
(name=JXGL_1,filename='D: \Data\JXGL_1.ndf',size=5,
maxsize=30,filegrowth=5%)
```
![](img/Pasted%20image%2020221224220454.png)

##### 删除
![](img/Pasted%20image%2020221224220603.png)
删除教学管理数据库JXGL中的辅助数据文件JXGL_1.ndf。
```sql
alter database JXGL
remove file JXGL_1    #文件逻辑名不加后缀
```

总结:二级命令主要是:modify file ,add file,add log file,remove file

#### 创建表
主键多个就放在表级约束
多个表末尾不要忘记加  "  ;  "
![](img/Pasted%20image%2020221226155036.png)
![](img/Pasted%20image%2020221226155220.png)
#### 删除表
```sql
drop table 表名
```

#### 修改表
##### 修改列
修改表中列的数据类型
```sql
alter table 表名
alter column 列名 <数据类型> <约束>  ##数据类型和约束需要改哪个
##就写哪个
ALTER TABLE S
ALTER COLUMN SEX CHAR(1)##将sex列数据类型修改为char
```

##### 增加列
```sql
alter table 表名
add 列名 数据类型 约束  ##add语句不需要加column
```

##### 删除列
```sql
alter table 表名
drop column 列名
```
修改列名:
因为没有修改列名的语句
可以先删后加
```sql
##在学生表S中,将AGE列名改为BIRTHDAY,数据类型为DATE
alter table S
drop column AGE;
alter table S
add BIRTHDAT DATE;
```

##### 增加删除约束
```sql
alter table 表名
add constraint 约束名 约束内容
##删除约束
alter table 表名
drop constraint 约束名
```

#### 查询
查询全体学生的姓名及其出生年份。
```sql
select sname, year(getdate())-age as birthday from S
##year()获取时间参数中的年份
##getdate()获取当前时间
```

![](img/Pasted%20image%2020221226175525.png)
![](img/Pasted%20image%2020221226182019.png)
##### distinct去重
加载查询属性前面
```sql
select distinct sno from SC where grade < 60
```

##### in集合包含
```sql
##查询计算机科学系(CS),数学系(MA)和信息系(IS)学生的姓名和性别。
select sname,ssex from student 
where sdept in('CS','MA','IS');
##当in中需要多个值就用圆括号括起来
```

##### like字符匹配
通配符
%:0-多个字符,比如:例a%b->acb,ab,acccccb都符合
\_:任意单个字符,比如:例a_b->acb,aeb,aab符合
当要查的就是上面两个符号时用escape转义'\\'->DB%=>like 'DB\\%' escape'\\' 
```sql
##查询所有姓“刘”的学生的姓名、学号和性别
select sno,sname,ssex from student where
sname like '刘%'; 
##查询姓“李”且全名最多为3个汉字的学生的姓名
where sname like '李__' or sname like '李_' ##后面的sanme不能省
```


