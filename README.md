# Dijkstra-
实验四 编程实现路由算法
实验目的：
 运用各种编程语言实现基于 Dijkstra 算法的路由软件。 
实验意义：
通过本实验，使学生能够对路由原理和路由算法有进一步的理解和掌握。
实验背景：
Dijkstra 算法描述如下： 
设： 
c(i,j): 结点 i 至结点 j 之间链路的代价，若 i,j 不直接相连，则为无穷大。 
D(v): 当前从源结点至目的结点 V 之间路由的代价。 
p(v): 从源结点至目的结点 V 之间路由中 V 之前的结点 
N: 已经知道最优路径的结点集合 
1 Initialization: 
2 N = {A} 
3 for all nodes v 
4 if v adjacent to A 
5 then D(v) = c(A,v) 
6 else D(v) = infty 
7 
8 Loop 9 find w not in N such that D(w) is a minimum 
10 add w to N 
11 update D(v) for all v adjacent to w and not in N: 
12 D(v) = min( D(v), D(w) + c(w,v) ) 
13 /* new cost to v is either old cost to v or known 
14 shortest path cost to w plus cost from w to v */ 
15 until all nodes in N 
实验步骤： 
1， 选择合适的编程语言编程实现基于 Dijkstra 算法的路由软件。 
输入不同的网络拓扑和链路代价测试和验证自己的路由软件。
