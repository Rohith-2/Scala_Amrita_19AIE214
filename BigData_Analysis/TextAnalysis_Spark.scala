val wikiRdd = sc.textFile("wikisample.txt")
wikiRdd.toDF.show
val wordRdd = wikiRdd.flatMap{l=> l.split("\\s+")}
val wordPairRdd = wordRdd.map(w => (w.toLowerCase(),1)) //convertig to tuple
val wordRedPairRdd = wordPairRdd.reduceByKey(_+_)
wordRedPairRdd.toDF.show
val cat = sc.textFile("wikisample.txt").flatMap(_.split("\\s+")).map(_.replaceAll("[^A-Za-z\\s]*","")).map((_,1)).reduceByKey(_+_)
