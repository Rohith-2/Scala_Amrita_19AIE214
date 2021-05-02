val wikiRdd = sc.textFile("wikisample.txt")
val wordRdd = wikiRdd.flatMap(_.split("\\s+")).map(_.replaceAll("[^A-Za-z0-9\\s]*","").toLowerCase())

val unigram = wordRdd.map((_,1)).reduceByKey(_+_).sortBy(-_._2)
unigram.toDF("Words","Freq").show()
/*
unigram: org.apache.spark.rdd.RDD[(String, Int)] = MapPartitionsRDD[752] at sortBy at Q2.scala:25
+------+------+
| Words|  Freq|
+------+------+
|   the|477818|
|    of|228398|
|   and|195340|
|    in|173612|
|    to|140312|
|     a|137489|
|    is| 72324|
|   was| 60984|
|    as| 56400|
|   for| 52400|
|  with| 49656|
|    on| 43394|
|    by| 42572|
|  that| 41475|
|  high| 39470|
|    at| 33535|
|  from| 33103|
|   are| 31404|
|    it| 30237|
|school| 26312|
+------+------+
only showing top 20 rows
*/

val uni_words_count = unigram.keys.count
//uni_words_count: Long = 196082
val uni_total_words_count = unigram.values.reduce(_+_)
//uni_total_words_count: Int = 6394724

val high_count = unigram.filter(_._1 == "high")
high_count.toDF("Word","Freq").show()
/*
high_count: org.apache.spark.rdd.RDD[(String, Int)] = MapPartitionsRDD[758] at filter at Q2.scala:25
+----+-----+
|Word| Freq|
+----+-----+
|high|39470|
+----+-----+
*/
val Bigram = wikiRdd.map{ 
    _.split("//s+").map{ substrings =>
        substrings.trim.split(' ').
        map{_.replaceAll("[^A-Za-z0-9\\s]*", "").toLowerCase()}.sliding(2)
    }.flatMap{identity}.map{_.mkString(" ")}.
    groupBy{identity}.mapValues{_.size}

}.flatMap{identity}.reduceByKey(_+_).sortBy(-_._2)

Bigram.toDF("Bigram","Freq").show(false)

/*
Bigram: org.apache.spark.rdd.RDD[(String, Int)] = MapPartitionsRDD[769] at sortBy at Q2.scala:32
+-----------+-----+                                                             
|Bigram     |Freq |
+-----------+-----+
|of the     |65102|
|in the     |46774|
|to the     |23883|
|and the    |16660|
|on the     |14647|
|high school|12603|
|by the     |11222|
|for the    |10665|
|at the     |10377|
|with the   |10061|
|from the   |9411 |
|as a       |9231 |
|as the     |8565 |
|to be      |7564 |
|is a       |7532 |
|of a       |7123 |
|is the     |6963 |
|it is      |6837 |
|the highest|6713 |
|in a       |6684 |
+-----------+-----+
only showing top 20 rows
*/
val total = Bigram.values.reduce(_+_)
//total: Int = 6329400                                                            

val count_high = Bigram.filter(_._1 == "high school").values.collect()(0) + Bigram.filter(_._1 == "high profile").values.collect()(0)
//count_high: Int = 12761                                                         

val freq_highschool = Bigram.filter(_._1 == "high school").values.collect()(0) / total.toFloat
val freq_highprofile = Bigram.filter(_._1 == "high profile").values.collect()(0) / total.toFloat
/*
freq_highschool: Float = 0.001991184                                            
freq_highprofile: Float = 2.4962872E-5  
*/
val sent = wikiRdd.flatMap(_.split('.')).map(_.split("\\s+")).map(_.map(_.toLowerCase())).map(x => (x.contains("god")&x.contains("mountain")))
val sent_with_mountain_god = sent.filter(_ == true).count

val mountain_count = unigram.filter(_._1 == "mountian")
//sent_with_mountain_god: Long = 2

println("Top 10 words : ")
unigram.toDF("Words","Freq").show(10)
/*
mountain_count: org.apache.spark.rdd.RDD[(String, Int)] = MapPartitionsRDD[787] at filter at Q2.scala:25
Top 10 words : 
+-----+------+
|Words|  Freq|
+-----+------+
|  the|477818|
|   of|228398|
|  and|195340|
|   in|173612|
|   to|140312|
|    a|137489|
|   is| 72324|
|  was| 60984|
|   as| 56400|
|  for| 52400|
+-----+------+
only showing top 10 rows
*/
val unigram_mod1 = unigram.sortBy(_._2)

println("Last 10 words : ")
unigram_mod1.toDF("Words","Freq").show(10)
/*
unigram_mod1: org.apache.spark.rdd.RDD[(String, Int)] = MapPartitionsRDD[795] at sortBy at Q2.scala:25
Last 10 words : 
+---------------+----+
|          Words|Freq|
+---------------+----+
|            mjs|   1|
|       bodongpa|   1|
|   sundayschool|   1|
|          sympy|   1|
|     strippable|   1|
|australianbuilt|   1|
|          3000c|   1|
|           bagn|   1|
|          kwong|   1|
|        ibestad|   1|
+---------------+----+
only showing top 10 rows
*/
val sent_has = wikiRdd.flatMap(_.split('.')).map(_.split("\\s+")).map(_.map(_.toLowerCase().matches(".*\\d.*")))
val count_of_number_lines = sent_has.map{x => 
	if (x.length != 0){x.reduce(_||_)}
	else{
		false
	}
}.filter(_ == true).count
//count_of_number_lines: Long = 117507     