package pl.jonasz

import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("my_app")
      .master("local[*]")
      .config("spark.driver.bindAddress","127.0.0.1")
      .getOrCreate()
  val df = spark.read
    .option("header", value = true)
    .option("inferSchema", value = true)
    .csv("data/AAPL.csv")

    df.show()
    df.printSchema()
  }
}