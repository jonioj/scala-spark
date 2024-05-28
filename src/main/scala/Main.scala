package pl.jonasz

import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.{DataFrame, SparkSession}

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("my_app")
      .master("local[*]")
      .config("spark.driver.bindAddress","127.0.0.1")
      .getOrCreate()
  val df: DataFrame = spark.read
    .option("header", value = true)
    .option("inferSchema", value = true)
    .csv("data/AAPL.csv")

    //df.show()
    df.printSchema()
    // df.select("Date","Open","Close").show()
    val column = df("Open")
    val newColumn = column + (2.0)
    val columnString = column.cast(StringType)
    df.createTempView("df")
    spark.sql("select mean(High) from df").show()
  }
}