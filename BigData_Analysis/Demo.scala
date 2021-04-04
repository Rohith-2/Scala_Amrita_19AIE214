import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
object Demo {
  def main (args:Array[String]):Unit={
    val conf = new SparkConf().setMaster("local[*]").setAppName("First")
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder.master("local[*]").appName("First").getOrCreate()
    import spark.implicits._
    
    val nseJan01Rdd = sc.textFile("/Users/rohith/git/19AIE214-BDA/BigData_Analysis/Jan/20150101.trd")
    println(nseJan01Rdd.toDF.show(false))
  }
}