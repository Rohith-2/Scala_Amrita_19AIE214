val nseRdd = sc.textFile("nsesample.txt") 
val nseSchemaRdd = nseRdd.map{l=>
    val str0 = l.split('|')
    val (ds,ts,id,stck,pr,vol)=(str0(0).toInt,str0(1),str0(2).toInt,str0(3),str0(4).toFloat,str0(5).toFloat)
    (ds,ts,id,stck,pr,vol)}

nseSchemaRdd.toDF("Date","Time","id","Stock","Price","Vol").show()
/*
nseSchemaRdd: org.apache.spark.rdd.RDD[(Int, String, Int, String, Float, Float)] = MapPartitionsRDD[682] at map at Q4.scala:25
+--------+-----+-------+----------+-------+-------+
|    Date| Time|     id|     Stock|  Price|    Vol|
+--------+-----+-------+----------+-------+-------+
|20140701|09:07|4336224|  AXISBANK| 1928.0|  768.0|
|20140701|09:07|   1064|BHARTIARTL| 337.25| 2625.0|
|20140701|09:07|    642|      BHEL|  251.9| 4312.0|
|20140701|09:07|   3459|   HCLTECH| 1495.0|  838.0|
|20140701|09:07|   2972|      HDFC| 990.25|  880.0|
|20140701|09:07|   3121|  HINDALCO|  167.2|46978.0|
|20140701|09:07|2600758| ICICIBANK|1420.55| 1113.0|
|20140701|09:07|2601408|      IDEA|  133.1| 3360.0|
|20140701|09:07|2600340|      INFY| 3245.0|  513.0|
|20140701|09:07|2600578|       ITC|  327.6| 9406.0|
|20140701|09:07|2602073|        LT| 1712.0| 1391.0|
|20140701|09:07|2602835|    MARUTI| 2453.8|  315.0|
|20140701|09:07|4335840|      ONGC|  429.0| 8920.0|
|20140701|09:07|4336599| POWERGRID|  140.0| 9231.0|
|20140701|09:07|4336134|  RELIANCE| 1017.2| 5277.0|
|20140701|09:07|4337085|      SBIN| 2699.0| 1057.0|
|20140701|09:07|4337271| SUNPHARMA| 686.55| 1657.0|
|20140701|09:07|4337482|TATAMOTORS|  432.8| 2332.0|
|20140701|09:07|4338209|       TCS| 2418.9|  657.0|
|20140701|09:07|2602904|   YESBANK|  543.7| 4864.0|
+--------+-----+-------+----------+-------+-------+
only showing top 20 rows
*/

var date = 20140701

val num_trad_Jul_1 = nseSchemaRdd.filter(_._1 == date).count
//num_trad_Jul_1: Long = 7703

val num_com = nseSchemaRdd.filter(_._1 == date).map(x=>x._4).distinct().count
//num_com: Long = 20

val num_trade_bt_9_10 = nseSchemaRdd.filter(_._2.split(':')(0) == "09").count
//num_trade_bt_9_10: Long = 2760

val KVp = nseSchemaRdd.map(x => (x._4,(x._5,x._6))).reduceByKey((x,y)=>(x._1+y._1,x._2+y._2)).map(l => (l._1,l._2._1/l._2._2))
KVp.count
//res60: Long = 20

KVp.toDF("Company","Price").show()
/*
KVp: org.apache.spark.rdd.RDD[(String, Float)] = MapPartitionsRDD[695] at map at Q4.scala:25
+----------+-----------+
|   Company|      Price|
+----------+-----------+
|       TCS|  1.6935452|
|      INFY|  1.6958706|
|        LT| 0.46985382|
|    MARUTI|  1.0162028|
|  HINDALCO|0.004922691|
|TATAMOTORS|0.025674148|
|      SBIN| 0.76065844|
|       ITC| 0.01744589|
|   HCLTECH|  0.5966683|
| ICICIBANK| 0.21275887|
| POWERGRID|0.006293068|
|      ONGC|0.029927634|
|  AXISBANK|  0.8672583|
|      HDFC| 0.22919473|
|      BHEL|0.015354721|
|  RELIANCE|  0.1583563|
|BHARTIARTL| 0.04836545|
|   YESBANK| 0.05937187|
|      IDEA|0.006425382|
| SUNPHARMA| 0.12365219|
+----------+-----------+
*/

val num_days = nseSchemaRdd.map(_._1).distinct.count.toInt
//num_days: Int = 3

for(i<- 0 until num_days){

var day_modified = nseSchemaRdd.filter(_._1 == date).map(x=>(x._2.split(':')(0),(x._5,x._6,1))).reduceByKey((x,y)=>(x._1+y._1,x._2+y._2,x._3+y._3)).map(x => (x._1,x._2._1/x._2._3 , x._2._2)).sortBy(_._1)

println("Date : "+date.toString.substring(6,8)+"/"+date.toString.substring(4,6)+"/"+date.toString.substring(0,4))

var file = date.toString.substring(6,8)+"_"+date.toString.substring(4,6)+"_"+date.toString.substring(0,4)

date+=1
day_modified.toDF("Hour","Avg Price","Total Volume").show(false)
println("Exporting "+(i+1)+"/"+num_days)
day_modified.saveAsTextFile(file)
println("Exported..")
println(" ")
}
/*
Date : 01/07/2014
+----+---------+------------+
|Hour|Avg Price|Total Volume|
+----+---------+------------+
|09  |1141.9519|2.0161176E7 |
|10  |1142.1617|1.1876386E7 |
|11  |1150.6204|8235269.0   |
|12  |1145.8376|8264323.0   |
|13  |1145.2273|8388763.0   |
|14  |1146.7056|1.1461912E7 |
|15  |1111.5363|1.2031596E7 |
+----+---------+------------+

Exporting 1/3
Exported..
 
Date : 02/07/2014
+----+---------+------------+
|Hour|Avg Price|Total Volume|
+----+---------+------------+
|09  |1152.0974|1.6008942E7 |
|10  |1155.4465|1.2055746E7 |
|11  |1160.5166|8317887.0   |
|12  |1154.8484|8471638.0   |
|13  |1156.2   |9923698.0   |
|14  |1156.1263|1.1082862E7 |
|15  |1130.4727|1.5314167E7 |
+----+---------+------------+

Exporting 2/3
Exported..
 
Date : 03/07/2014
+----+---------+------------+
|Hour|Avg Price|Total Volume|
+----+---------+------------+
|09  |1158.9916|1.4552694E7 |
|10  |1158.3129|8909720.0   |
|11  |1158.6658|1.0794019E7 |
|12  |1158.3597|7877229.0   |
|13  |1146.532 |516233.0    |
+----+---------+------------+

Exporting 3/3
Exported..

*/
