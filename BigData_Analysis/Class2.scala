val nseRdd = sc.textFile("nsesample.txt") 
val nseSchemaRdd = nseRdd.map{l=>
    val str0 = l.split('|')
    val (ds,ts,id,stck,pr,vol)=(str0(0).toInt,str0(1),str0(2).toInt,str0(3),str0(4).toFloat,str0(5).toFloat)
    (ds,ts,id,stck,pr,vol)}
val stckReduceRdd = nseSchemaRdd.map{case (ds,ts,id,stck,pr,vol) => 
    (stck, List((pr, id))  )}.reduceByKey(_ ++ _)

stckReduceRdd.toDF.show
stckReduceRdd.map{case(stck, list) => (stck,list.length)}.toDF("Stock","Number of Trades").show

val tcsList = stckReduceRdd.lookup("TCS")(0).sortBy(_._2)

var file = new java.io.PrintStream("tcsList.csv")
tcsList.foreach{file.println(_)}
file.close

val infyList = stckReduceRdd.lookup("INFY")(0).sortBy(_._2)
val tcsRdd = sc.parallelize(tcsList).zipWithIndex.map(p => (p._2,p._1))
val infyRdd = sc.parallelize(infyList).zipWithIndex.map(p => (p._2,p._1))

val tcsInfyRdd = tcsRdd join infyRdd

val tcsInfyRdd = (tcsRdd join infyRdd).map{case(i,((tcspr,x),(infypr,y))) =>(tcspr,infypr)}

var file = new java.io.PrintStream("tcsInfyList.csv")
tcsInfyRdd.collect.foreach{file.println(_)}
file.close