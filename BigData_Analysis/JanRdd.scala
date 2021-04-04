object JanRDD{
val nseJan01Rdd = sc.textFile("/Users/rohith/git/19AIE214-BDA/BigData_Analysis/Jan/20150101.trd")
//val nseJanRdd = sc.textFile("/Users/rohith/git/19AIE214-BDA/BigData_Analysis/Jan/*.trd")
nseJan01Rdd.count
nseJan01Rdd.toDF.show(false)
val freqJan01Rdd = nseJan01Rdd.map{l=>
    val str = l.split('|')
    (str(3),1) }
freqJan01Rdd.reduceByKey(_+_).sortBy(_._1).toDF.show(100)
}